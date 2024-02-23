package com.example.ex1.controllers;


import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;
import com.example.ex1.openai.api.ChatGPTRequest;
import com.example.ex1.openai.api.ChatGPTResponse;
import com.example.ex1.service.ConversationService;
import com.example.ex1.service.DiscussionService;
import com.example.ex1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserController {


    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @Autowired
    private IUserService userService;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/newUser")
    public Object createUser(@RequestParam("userName") String userName) throws Exception {
        User user = userService.findUserbyUserName(userName);
        if (user !=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exist please choose another UserName");
        }
        return userService.save(new User(userName));
    }

    @GetMapping("/oneConversation")
    public Object getOneConversation(@RequestParam("Username") String userName,@RequestParam("conversationId")Long conversationId) throws Exception {
        User user = userService.findUserbyUserName(userName);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or Discussion provided doesnot exist, please create a User");
        }
        for(Conversation conv  : user.getConversations()){
            if (Objects.equals(conv.getConversationID(), conversationId)){
                return conv;
            }
        }
        return "the Conversation Asked for does not belong to the user";
    }

    @GetMapping("/conversations")
    public Object getUserconversations(@RequestParam("userName") String userName) throws Exception {
        User user = userService.findUserbyUserName(userName);
        if (user ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username provided doesnot exist, please create a User");
        }
        return user.getConversations();
    }
    @GetMapping("/prompts")
    public Object chat(@RequestParam("prompt") String prompt,@RequestParam("userName") String userName) throws Exception {
        User user = userService.findUserbyUserName(userName);
        if (user ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username provided doesnot exist, please create a User");
        }
        System.out.println(prompt);

        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
        String response = chatGptResponse.getChoices().get(0).getMessage().getContent();
        Discussion currentDiscussion = new Discussion(prompt,response);

        //get the user conversations
        List<Conversation> userConversations = user.getConversations();
        //check if the the had any conversation
        if(userConversations == null || userConversations.isEmpty()){
            userService.createUserFirstConversation(user,currentDiscussion);
        }else{
            userConversations.getLast().addDiscussion(currentDiscussion);

        }

        userService.save(user);


        return response;

    }

    @GetMapping("/newconversation")
    public Object chat(@RequestParam("prompt") String prompt,@RequestParam("userName")String userName,@RequestParam("newConversation")String newconvers) throws Exception {
        User user = userService.findUserbyUserName(userName);
        if (user ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username provided doesnot exist, please create a User");
        }
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
        String response = chatGptResponse.getChoices().get(0).getMessage().getContent();
        Discussion currentDiscussion = new Discussion(prompt,response);
        userService.createUserFirstConversation(user,currentDiscussion);
        return response;
    }

}
