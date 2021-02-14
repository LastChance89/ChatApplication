package main.java.com.Socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {
	@Override 
	public void configureMessageBroker(MessageBrokerRegistry config) {
		//This configures to the SENDTO response, as a prefix esentally. 
		config.enableSimpleBroker("/messsage");
		//This prefix's all endpoints with the app. 
		config.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry reg) {
		reg.addEndpoint("/webSocket").withSockJS();
	}
}
