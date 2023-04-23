package com.manuelservi.springbootblognovembre.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manuelservi.springbootblognovembre.models.Author;
import com.manuelservi.springbootblognovembre.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	public List<Author> listAll(){
		return repository.findAll();
	}

	public Author store(Author author) {
		return repository.save(author);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Author update(int id, Author newAuthor) {
		Author author = repository.findById(id).get();
		author.setFirstname(newAuthor.getFirstname());
		author.setLastname(newAuthor.getLastname());
		author.setNationality(newAuthor.getNationality());
		return repository.save(author);
	}
	
}
