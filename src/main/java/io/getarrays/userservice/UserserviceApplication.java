package io.getarrays.userservice;


import io.getarrays.userservice.entity.User;
import io.getarrays.userservice.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class UserserviceApplication {

    @Autowired
    private UserRepo repository;

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class,args);

    }
    @PostConstruct
    public void initUsers(){

        List<User> users = Stream.of(

                new User(101,"javatechie","password","javatechi@gmail.com"),
                new User (102,"User1","pwd1","user1@gmail.com"),
                new User(103,"user2","pwd2","user2@gmail.com"),
                new User (104, "user3","pwd3","user3@gmail.com")
        ).collect(Collectors.toList());

        repository.saveAll(users);




    }


}
