package main.java.com.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.model.UserMessage;

@RestController
public class CommunicationController {
	
	@MessageMapping("/sendMessage")
	//The Send To is the URL that all subscribers 
	//are listening too. In this case, /messsage
	@SendTo("/messsage")
	public UserMessage sendUserMessage(UserMessage response) {
		return response;
	}

	
}
