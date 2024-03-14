package com.example.ex1.service;

import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;

import com.example.ex1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class IUserService implements UserService{

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private IDiscussionService discussionService;
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User createUser(String userName) {
        User existingUser = getUserByUsername(userName);
        if (existingUser != null) {
            throw new RuntimeException("Username already exists: " + userName);
        }
        return save(new User(userName));
    }
    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepo.findUserByUserName(username);
        return user.orElse(null);
    }




    @Override
    public User createUserFirstConversation(String userName,Discussion discussion){
        User user = userRepo.findUserByUserName(userName).orElse(null);
        if(user!=null){
            Conversation conv = new Conversation();
            conv.addDiscussion(discussionService.save(discussion));
            user.addConversation(conv);
            return userRepo.save(user);
        }else{
            throw new RuntimeException("User Does Not Exist!! ,first create a user");
        }
    }

    public Conversation getOneConversation(String userName, Long conversationId){
        User user = userRepo.findUserByUserName(userName).orElse(null);
        if(user!=null){
            for(Conversation conv  : user.getConversations()) {
                if (Objects.equals(conv.getConversationId(), conversationId)) {
                    return conv;
                }
            }
        }else{
            throw new RuntimeException("User Does Not Exist!! ,first create a user");
        }
        throw new RuntimeException("the Conversation Asked for does not belong to the user");
    }
}
