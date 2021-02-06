package tw.leader.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productPhoto")
public class ProductPhoto {

	@Id @Column(name="pPhotoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pPhotoId;
	
	@Column(name="pImg")
	private String pImg;
	
	@Column(name="pId")
	private int pId;

	public Integer getpPhotoId() {
		return pPhotoId;
	}

	public void setpPhotoId(Integer pPhotoId) {
		this.pPhotoId = pPhotoId;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
}
