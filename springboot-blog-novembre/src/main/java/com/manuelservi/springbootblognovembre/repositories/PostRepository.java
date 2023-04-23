package com.manuelservi.springbootblognovembre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelservi.springbootblognovembre.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
