package com.nagarro.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.constants.SortType;
import com.nagarro.constants.UserType;
import com.nagarro.model.Attachement;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;
import com.nagarro.service.SearchService;
import com.nagarro.service.TicketService;
import com.nagarro.utill.PriorityComparator;
import com.nagarro.utill.StatusComparator;
import com.nagarro.utill.TicketIdComparator;

@Controller
@RequestMapping("/ticket")
@SessionAttributes("user")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/addticketform", method = RequestMethod.GET)
	public String addTicketForm() {
		return "ticket/addticketform";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTicket(@RequestParam("type") String type,
			@RequestParam("priority") String priority,
			@RequestParam("title") String title,
			@RequestParam("message") String message,
			@RequestParam("attachement") MultipartFile file,
			HttpServletRequest request, Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");

		String resultModel = "";
		if (user != null) {
			Ticket ticket = new Ticket();
			ticket.setUser(user);
			ticket.setType(type);
			ticket.setTitle(title);
			ticket.setPriority(priority);
			ticket.setMessage(message);
			if (!file.isEmpty()) {
				try {
					Attachement attachement = new Attachement();
					attachement.setName(file.getOriginalFilename());
					attachement.setSize((int) file.getSize());
					attachement.setBinaryFile(file.getBytes());
					ticket.setAttachement(attachement);
				} catch (IOException e) {

				}

			}
			resultModel += "ticket/addticketform";
			if (ticketService.addTicket(ticket)) {
				map.put("message", "Ticket Raised Succesfully");
			} else {
				map.put("message", "Unable to add ticket");
			}
		} else {
			resultModel += "commonview/sessionexpire";
		}
		return resultModel;

	}

	@RequestMapping(value = "/allTicketOFEmployee", method = RequestMethod.POST)
	public String allTicketOFEmployee(@RequestParam("sort") String sortBy,
			@RequestParam("type") String type,
			@RequestParam("priority") String priority,
			@RequestParam("status") String status, HttpServletRequest request,
			Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		String resultView = "";
		List<Ticket> allTicket = null;
		if (user != null) {
			allTicket = ticketService.allFilterTicket(user, type, status,priority);
			if (SortType.Priority.getSortType().equals(sortBy)) {
				Collections.sort(allTicket, new PriorityComparator());
			} else if (SortType.Status.getSortType().equals(sortBy)) {
				Collections.sort(allTicket, new StatusComparator());
			} else {
				Collections.sort(allTicket, new TicketIdComparator());
			}
			map.put("allTicket", allTicket);
			if(user.getType().equals(UserType.Admin.getUserType())){
				resultView+="admin/alltickets";
			}else{
				resultView += "employee/alltickets";	
			}
			
		} else {
			resultView += "commonview/sessionexpire";
		}
		return resultView;
	}

	@RequestMapping(value = "/getAttachement", method = RequestMethod.GET)
	public String getAttachement(@RequestParam("id") int id,HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map)
			throws IOException {
		OutputStream os = null;
		String resultView="";
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
		Attachement attachement = ticketService.getAttachementById(id);
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ attachement.getName());
		try {
			os = response.getOutputStream();
			os.write(attachement.getBinaryFile());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			os.flush();
			os.close();
		}
		}else{
			resultView+="commonview/sessionexpire";
		}
		if(user.getType().equals(UserType.Admin.getUserType())){
			resultView+="admin/alltickets";
		}else{
			resultView+="employee/alltickets";
		}
		return resultView;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchTicketByEmployee(
			@RequestParam("pattern") String idOrTitle,
			HttpServletRequest request, Map<String, Object> map) {

		User user = (User) request.getSession().getAttribute("user");
		String resultView = "";
		if (user != null) {
			List<Ticket> searchResult = searchService.searchTicket(user,
					idOrTitle);
			if (searchResult != null) {
				map.put("search", searchResult);
			} else {
				map.put("message", "No record found given ticket id or title");
			}
		} else {
			resultView += "employee/sessionexpiry";
		}
		if(user.getType().equals(UserType.Admin.getUserType())){
			resultView += "admin/searchresult";
		}else{
			resultView += "employee/searchresult";
		}
		return resultView;
	}

	@RequestMapping(value = "/getassign", method = RequestMethod.GET)
	public String getAllRaisedTicket(HttpServletRequest request,
			Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		List<Ticket> allRaisedTicket = null;
		String resultView = "";
		if (user != null && user.getType().equals(UserType.Admin.getUserType())) {
			allRaisedTicket = ticketService.getAllRaisedTicket();
			map.put("raised", allRaisedTicket);
			resultView += "admin/raisedview";
		} else {
			resultView += "commonview/sessionexpire";
		}
		return resultView;
	}
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String assignTicket(
			@RequestParam("id") int ticketId,
			HttpServletRequest request, Map<String, Object> map) {

		User user = (User) request.getSession().getAttribute("user");
		String resultView = "";
		if (user != null && user.getType().equals(UserType.Admin.getUserType())) {
			ticketService.assignTicketById(user, ticketId);
			map.put("message", "Ticket assign sucessfully");
			resultView+="admin/adminview";
		} else {
			resultView += "commonview/sessionexpiry";
		}
		return resultView;
	}

}
