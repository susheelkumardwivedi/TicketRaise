package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Comment;

public interface CommentDao {
	public void addComment(Comment comment);

	public List<Comment> getAllCommentByTicketId(int ticketId);
}
