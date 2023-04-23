package com.manuelservi.springbootblognovembre.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuelservi.springbootblognovembre.models.Post;
import com.manuelservi.springbootblognovembre.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	public List<Post> listAll(){
		return repository.findAll();
	}

	public Post store(Post post) {
		return repository.save(post);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Post update(int id, Post newPost) {
		Post post = repository.findById(id).get();
		post.setTitle(newPost.getTitle());
		post.setContent(newPost.getContent());
		return repository.save(post);
	}
}
