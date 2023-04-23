package com.manuelservi.springbootblognovembre.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.manuelservi.springbootblognovembre.models.Comment;
import com.manuelservi.springbootblognovembre.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repository;

	public List<Comment> listAll(){
		return repository.findAll();
	}

	public Comment store(Comment post) {
		return repository.save(post);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
	public Comment update(int id, Comment newComment) {
		Comment comment = repository.findById(id).get();
		comment.setUser(newComment.getUser());
		comment.setContent(newComment.getContent());
		return repository.save(comment);
	}
}
