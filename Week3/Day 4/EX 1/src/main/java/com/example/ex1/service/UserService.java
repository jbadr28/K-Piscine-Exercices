package com.example.ex1.service;

import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User save(User user);


    User getUserByUsername(String username);

    User createUser(String Username);

    User createUserFirstConversation(String userName, Discussion discussion);

}
