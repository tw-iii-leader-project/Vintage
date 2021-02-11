package tw.leader.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 配置WebSocket
 */
@Configuration
//註解開啟使用STOMP協議來傳輸基於代理(message broker)的訊息,這時控制器支援使用@MessageMapping,就像使用@RequestMapping一樣
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


	@Override
	//註冊STOMP協議的節點(endpoint),並對映指定的url
        public void registerStompEndpoints(StompEndpointRegistry registry) {
        //註冊一個STOMP的endpoint,並指定使用SockJS協議
        registry.addEndpoint("/endpointOyzc").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    //配置訊息代理(Message Broker)
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	 //點對點應配置一個/user訊息代理，廣播式應配置一個/topic訊息代理,群發（mass），單獨聊天（alone）
        registry.enableSimpleBroker("/topic","/user","/mass","/alone");
        //點對點使用的訂閱字首（客戶端訂閱路徑上會體現出來），不設定的話，預設也是/user/
        registry.setUserDestinationPrefix("/user");
//        registry.setApplicationDestinationPrefixes("/indexx");
        

    }

}
