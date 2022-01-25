package com.products_bet.Controllor;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")

public class WebSocketController {

	
	@MessageMapping("/sendMessage")
	@SendTo("/topic/public")
	public String sendMessage() {
		return "hello";
	}

}
