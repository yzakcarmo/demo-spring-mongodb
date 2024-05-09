package com.yzak.spring_mongo.services;

import com.yzak.spring_mongo.domain.Post;
import com.yzak.spring_mongo.repositories.PostRepository;
import com.yzak.spring_mongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post insert(Post obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public Post update(Post obj, String id) {
        Post newObj = findById(id);
        updateData(newObj, obj);

        return repository.save(newObj);
    }

    public void updateData(Post newObj, Post obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setBody(obj.getBody());
        newObj.setId(obj.getId());
    }

    public List<Post> findByTitle(String text) {
        // Usando query methods
        // return repository.findByTitleContainingIgnoreCase(text);

        //Usando @Query
        return repository.findByTitle(text);
    }
}
