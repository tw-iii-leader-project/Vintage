package tw.leader.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="userArticle")
@Data
public class userArticle {
	
	@Id @Column(name="articleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="description")
	private String description;
	
	@Column(name="articleContext")
	private String articleContext;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userPicMain")
	private String userPicMain;
	
	@Column(name = "userPic1")
	private String userPic1;
	
	@Column(name = "userPic2")
	private String userPic2;
	
	@Column(name = "userPic3")
	private String userPic3;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticleContext() {
		return articleContext;
	}

	public void setArticleContext(String articleContext) {
		this.articleContext = articleContext;
	}
	
	
}
