package com.example.ex1.controllers;


import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;

import com.example.ex1.service.IUserService;

import com.example.ex1.service.IChatGPTService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserController {



    @Autowired
    private IUserService userService;

    @Autowired
    private IChatGPTService iChatGPTService;



    @PostMapping("/newUser")
    @Operation(summary = "create a user", description = "create a user with the provided userName, the userName must be never used before")
    public User createUser(@RequestParam("userName") String userName) {
        return userService.createUser(userName);
    }
    @GetMapping("/oneConversation")
    @Operation(summary = "get one conversation",description = "the user retreive one of his/her conversations")
    public Conversation getOneConversation(@RequestParam("Username") String userName,@RequestParam("conversationId")Long conversationId) throws Exception {
        return userService.getOneConversation(userName,conversationId);
    }

    @GetMapping("/conversations")
    @Operation(summary = "get one conversation",description = "the user retreive one of his/her conversations")
    public List<Conversation> getUserconversations(@RequestParam("userName") String userName) throws Exception {
        User user = userService.getUserByUsername(userName);
        if (user ==null){
            throw new RuntimeException("Username provided doesnot exist, please create a User");
        }
        return user.getConversations();
        //Mapper user.getClass().getFields()[0].getName()
    }
    @GetMapping("/prompts")
    public String chat(@RequestParam("prompt") String prompt, @RequestParam("userName") String userName) throws Exception {
        User user = userService.getUserByUsername(userName);
        if (user ==null){
            throw new RuntimeException("Username provided doesnot exist, please create a User");
        }
        System.out.println(prompt);


        String response = iChatGPTService.getResponseFromOpenAPI(prompt);
        Discussion currentDiscussion = new Discussion(prompt,response);

        //get the user conversations
        List<Conversation> userConversations = user.getConversations();
        //check if the the had any conversation
        if(userConversations == null || userConversations.isEmpty()){
            userService.createUserFirstConversation(userName,currentDiscussion);
        }else{
            userConversations.getLast().addDiscussion(currentDiscussion);

        }

        userService.save(user);


        return response;

    }

    @GetMapping("/newconversation")
    public String initiateNewConversation(@RequestParam("prompt") String prompt,@RequestParam("userName")String userName) throws Exception {

        String response = iChatGPTService.getResponseFromOpenAPI(prompt);
        Discussion currentDiscussion = new Discussion(prompt,response);
        userService.createUserFirstConversation(userName,currentDiscussion);
        return response;
    }

}
