package tw.leader.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AdvMainResp extends ErrorResp{

	@JsonProperty(value="mainId")
	private int MainId;
	
	@JsonProperty(value="seat")
	private int Seat;
	
	@JsonProperty(value="title")
	private String Title;
	
	@JsonProperty(value="content")
	private String Content;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="activity")
	private String Activity;

	public int getMainId() {
		return MainId;
	}

	public void setMainId(int mainId) {
		MainId = mainId;
	}

	public int getSeat() {
		return Seat;
	}

	public void setSeat(int seat) {
		Seat = seat;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivity() {
		return Activity;
	}

	public void setActivity(String activity) {
		Activity = activity;
	}
	
	
}
