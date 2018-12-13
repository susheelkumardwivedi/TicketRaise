package com.nagarro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.CommentDao;
import com.nagarro.model.Comment;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Comment> getAllCommentByTicketId(int ticketId) {
		Session session = this.getSessionFactory().openSession();
		List<Comment> listOfAns = new ArrayList<Comment>();
		try {
			Query query = session.createQuery("from Comment");
			List<Comment> listOfComment = query.list();
			for (Comment comment : listOfComment) {
				if (comment.getTicket().getId() == ticketId) {
					listOfAns.add(comment);
				}
			}
			System.out.println("size" + listOfComment.size());
		} catch (HibernateException e) {
		//	e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAns;
	}

	@Override
	public void addComment(Comment comment) {
		Session session = this.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			session.save(comment);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();

			}
		}catch(Exception e){
			if (transaction != null) {
				transaction.rollback();

			}
		}
		finally {
			session.close();
		}

	}
}
