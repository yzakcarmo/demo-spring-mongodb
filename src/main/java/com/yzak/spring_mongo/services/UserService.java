package com.yzak.spring_mongo.services;

import com.yzak.spring_mongo.domain.User;
import com.yzak.spring_mongo.dto.UserDTO;
import com.yzak.spring_mongo.repositories.UserRepository;
import com.yzak.spring_mongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
