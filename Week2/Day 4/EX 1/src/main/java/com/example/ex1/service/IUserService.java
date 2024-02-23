package com.example.ex1.service;

import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;
import com.example.ex1.repositories.ConversationRepo;
import com.example.ex1.repositories.DiscussionRepo;
import com.example.ex1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserService implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DiscussionRepo discussionRepo;

    @Autowired
    private ConversationRepo conversationRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    public User findUserbyUserName(String userName) throws Exception {
        Optional<User> user= userRepo.getUserByUserName(userName);
        return user.orElse(null);
    }

    public User createUserFirstConversation(User user,Discussion discussion){
        Conversation conv = new Conversation();
        conv.addDiscussion(discussionRepo.save(discussion));
        user.addConversation(conv);
        return userRepo.save(user);
    }
}
