package com.nagarro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.SearchDao;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;
@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ticket> searchTicket(String idOrTitle) {
		Session session=this.getSessionFactory().openSession();
		List<Ticket> searchResult=null;
		try{
			int ticketId=-1;
			if(idOrTitle.matches("[0-9][0-9]*")){
				ticketId=Integer.parseInt(idOrTitle);
			}
			Query query = session.createQuery("from Ticket as t where t.id=:id or t.title like :title");
			query.setParameter("id",ticketId );
			query.setParameter("title", idOrTitle);
			searchResult=(List<Ticket>)query.list();
		}catch(NumberFormatException e){
			
		}catch(HibernateException e){
			
		}catch (Exception e) {
			
		}finally{
			session.close();
		}
		return searchResult;
	}
	@Override
	public List<Ticket> searchTicket(User user, String idOrTitle) {
		Session session=this.getSessionFactory().openSession();
		List<Ticket> searchResult=null;
		try{
			int ticketId=-1;
			if(idOrTitle.matches("[0-9][0-9]*")){
				ticketId=Integer.parseInt(idOrTitle);
			}
			String queryString="from Ticket as t where t.id=:id or t.title like :title";
			if(user.getType().equals("Employee")){
				queryString+=" and t.user=:user";
			}
			
			Query query = session.createQuery(queryString);
			query.setParameter("id",ticketId );
			query.setParameter("title", idOrTitle);
			if(user.getType().equals("Employee")){
			query.setParameter("user", user);
			}
			searchResult=(List<Ticket>)query.list();
		}catch(NumberFormatException e){
			
		}catch(HibernateException e){
			
		}catch (Exception e) {
			
		}finally{
			session.close();
		}
		return searchResult;

	}
}
