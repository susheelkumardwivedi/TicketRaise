package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Comment;

public interface CommentService {
	public List<Comment> getAllCommentByTicketId(int ticketId);

	public void addComment(Comment comment);
}
