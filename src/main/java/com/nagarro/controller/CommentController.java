package com.nagarro.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarro.model.Comment;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;
import com.nagarro.service.CommentService;
import com.nagarro.service.TicketService;

@Controller
@RequestMapping("/comment")
@SessionAttributes
public class CommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/allcomment", method = RequestMethod.GET)
	public String getAllCommentOfTicket(@RequestParam("id") int ticketId,
			HttpServletRequest request, Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		String resultView = "";
		if (user != null) {
			List<Comment> allComment = commentService
					.getAllCommentByTicketId(ticketId);
			if (allComment == null) {
				map.put("message", "No comment found");
			} else {
				map.put("allComment", allComment);
				map.put("ticket_id", ticketId);
			}
			resultView += "comment/commentviewer";
		} else {
			resultView += "employee/sessionexpire";
		}
		return resultView;
	}

	@RequestMapping(value = "/addcomment", method = RequestMethod.POST)
	public String addComment(@RequestParam("message") String message,
			@RequestParam("ticket_id") int ticketId,
			HttpServletRequest request, Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		String resultView = "";
		if (user != null) {
			Comment comment = new Comment();
			Ticket ticket = ticketService.getTicketById(ticketId);
			comment.setUser(user);
			comment.setMessage(message);
			comment.setTicket(ticket);
			commentService.addComment(comment);
			map.put("message", "comment add sucessfully");
			resultView += "comment/sucess";
		} else {
			resultView += "employee/sessioexpire";
		}
		return resultView;
	}
}
