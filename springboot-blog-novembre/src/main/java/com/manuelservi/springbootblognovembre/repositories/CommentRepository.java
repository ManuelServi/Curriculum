package com.manuelservi.springbootblognovembre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelservi.springbootblognovembre.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
	
}
