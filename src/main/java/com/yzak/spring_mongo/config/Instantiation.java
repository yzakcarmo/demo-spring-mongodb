package com.yzak.spring_mongo.config;

import com.yzak.spring_mongo.domain.Post;
import com.yzak.spring_mongo.domain.User;
import com.yzak.spring_mongo.repositories.PostRepository;
import com.yzak.spring_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, alex, LocalDate.parse("2024-04-27"),"Bora pra praia", "Rapaziada, vou viajar pro Caribe.");
        Post post2 = new Post(null, alex, LocalDate.parse("2024-04-27"),"Deu ruim", "Rolou bug de madrugada, me botaram em plantão");
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
