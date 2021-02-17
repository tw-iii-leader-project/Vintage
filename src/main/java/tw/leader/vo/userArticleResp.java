package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userArticleResp extends ErrorResp{

	@JsonProperty(value="articleId")
	private int articleId;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="description")
	private String description;
	
	@JsonProperty(value="articleContext")
	private String articleContext;

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
