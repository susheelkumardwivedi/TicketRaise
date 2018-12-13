package com.nagarro.dao.impl;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.constants.TicketStatus;
import com.nagarro.constants.TicketType;
import com.nagarro.dao.TicketDao;
import com.nagarro.model.Attachement;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;

@Repository("ticketDao")
public class TicketDaoImpl implements TicketDao {
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		boolean result = false;
		try {
			ticket.setStatus(TicketStatus.Raised.getStatusType());
			session.beginTransaction();
			transaction = session.getTransaction();
			session.save(ticket);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	@Override
	public List<Ticket> allTicketOFEmployee(User user) {
		Session session=this.getSessionFactory().openSession();
		List<Ticket> resultTicket=null;
		try{
			Query query = session.createQuery("from Ticket as t where t.user=:user");
			query.setParameter("user", user);
			resultTicket= (List<Ticket>)query.list();
		}finally{
			session.close();
		}
		return resultTicket;
	}
	@Override
	public Attachement getAttachementById(int id) {
		Session session=this.getSessionFactory().openSession();
		Attachement attachement=null;
		try{
			attachement=(Attachement) session.get(Attachement.class, id);
		}catch(HibernateException e){
			
		}finally{
			session.close();
		}
		return attachement;
	}
	@Override
	public Ticket getTicketById(int id) {
		Session session=this.getSessionFactory().openSession();
		Ticket ticket=null;
		try{
			 ticket=(Ticket)session.get(Ticket.class, id);
		}catch(HibernateException e){
			
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return ticket;
	}
	@Override
	public List<Ticket> allFilterTicket(User user, String type, String status,
			String priority) {
		
		Session session=this.getSessionFactory().openSession();
		List<Ticket> resultTicket=null;
		try{
			boolean whereUse=false;
			String queryString="from Ticket as t";
			if(user.getType().equals("Employee")){
				queryString+=" where t.user=:user";
				whereUse=true;
			}
			if(!type.isEmpty()){
				if(!whereUse){
					queryString+=" where and t.type=:type";
					whereUse=true;
				}else{
					queryString+=" and t.type=:type";
				}
				
			}
			if(!status.isEmpty()){
				if(!whereUse){
					queryString+=" where and t.status=:status";
					whereUse=true;
				}else{
					queryString+=" and t.status=:status";
				}
				
			}
			if(!priority.isEmpty()){
				if(!whereUse){
					queryString+=" where and t.priority=:priority";
					whereUse=true;
				}else{
					queryString+=" and t.priority=:priority";
				}
			}
			Query query = session.createQuery(queryString);
			if(!type.isEmpty()){
				query.setParameter("type", type);
			}
			if(!status.isEmpty()){
				query.setParameter("status", status);
			}
			if(!priority.isEmpty()){
				query.setParameter("priority", priority);
			}
			if(user.getType().equals("Employee")){
				query.setParameter("user", user);	
			}
			resultTicket= (List<Ticket>)query.list();
			
		}finally{
			session.close();
		}
		return resultTicket;
	}
	@Override
	public List<Ticket> getAllRaisedTicket() {
		Session session=this.getSessionFactory().openSession();
		List<Ticket> resultTicket=null;
		try{
			Query query = session.createQuery("from Ticket as t where t.status like :status");
			query.setParameter("status", TicketStatus.Raised.getStatusType());
			resultTicket= (List<Ticket>)query.list();
			System.out.println("hah"+resultTicket.size());
		}finally{
			session.close();
		}
		return resultTicket;	
		
	}
	@Override
	public void assignTicketById(User user, int ticketId) {
		Session session=this.getSessionFactory().openSession();
		Transaction transaction=null;
		Ticket ticket=null;
		try{
			 ticket=(Ticket)session.get(Ticket.class,ticketId);
			 ticket.setAssignedTo(user);
			 long millis=System.currentTimeMillis(); 
			 ticket.setDateofAccept(new Date(millis));
			 ticket.setStatus(TicketStatus.InProgress.getStatusType());
			 transaction=session.getTransaction();
			 transaction.begin();
			 session.saveOrUpdate(ticket);
			 transaction.commit();
		}catch(HibernateException e){
			if(transaction!=null){
				transaction.rollback();
			}
		}catch(Exception e){
			
		}finally{
			session.close();
		}

	}
	
}
