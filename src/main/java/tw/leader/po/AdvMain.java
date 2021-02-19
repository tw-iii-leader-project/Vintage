package tw.leader.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advMain")
public class AdvMain {

	@Id @Column(name="mainId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MainId;
	
	@Column(name="seat")
	private int Seat;
	
	@Column(name="title")
	private String Title;
	
	@Column(name="content")
	private String Content;
	
	@Column(name="email")
	private String email;
	
	@Column(name="activity")
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
