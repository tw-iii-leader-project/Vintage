package tw.leader.vo;

public class ChatRoomRequest {

	private String userId;
	private String name;
	private String chatValue;
	private String userPic;

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChatValue() {
		return chatValue;
	}

	public void setChatValue(String chatValue) {
		this.chatValue = chatValue;
	}
}
