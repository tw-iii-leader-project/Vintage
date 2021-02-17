package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCartMessage {

	@JsonProperty(value="message")
	private String Message;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	
	
	
}
