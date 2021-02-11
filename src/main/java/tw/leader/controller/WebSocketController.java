package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import tw.leader.vo.ChatRoomRequest;
import tw.leader.vo.ChatRoomResponse;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate template;
	// 客戶端主動傳送訊息到服務端，服務端馬上回應指定的客戶端訊息
	// 類似http無狀態請求，但是有質的區別
	// websocket可以從伺服器指定傳送哪個客戶端，而不像http只能響應請求端

	// 群發
	@MessageMapping("/massRequest")
	// SendTo 傳送至 Broker 下的指定訂閱路徑
	@SendTo("/mass/getResponse")
	public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest) {
		// 方法用於群發測試
		System.out.println("name = " + chatRoomRequest.getName());
		System.out.println("chatValue = " + chatRoomRequest.getChatValue());
		ChatRoomResponse response = new ChatRoomResponse();
		response.setName(chatRoomRequest.getName());
		response.setChatValue(chatRoomRequest.getChatValue());
		return response;
	}

	// 單獨聊天
	@MessageMapping("/aloneRequest")
	public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest) {
		// 方法用於一對一測試
		System.out.println("userId = " + chatRoomRequest.getUserId());
		System.out.println("name = " + chatRoomRequest.getName());
		System.out.println("chatValue = " + chatRoomRequest.getChatValue());
		ChatRoomResponse response = new ChatRoomResponse();
		response.setName(chatRoomRequest.getName());
		response.setChatValue(chatRoomRequest.getChatValue());
		this.template.convertAndSendToUser(chatRoomRequest.getUserId() + "", "/alone/getResponse", response);
		return response;
	}
}
