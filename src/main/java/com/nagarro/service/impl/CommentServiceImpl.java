package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.CommentDao;
import com.nagarro.model.Comment;
import com.nagarro.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> getAllCommentByTicketId(int ticketId) {
		return commentDao.getAllCommentByTicketId(ticketId);
	}

	@Override
	public void addComment(Comment comment) {

		commentDao.addComment(comment);
	}
}
