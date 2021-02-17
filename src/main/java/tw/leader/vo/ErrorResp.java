package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResp {

	@JsonProperty(value="ERROR_CODE")
	private String errorCode;
	
	@JsonProperty(value="MESSAGE")
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
