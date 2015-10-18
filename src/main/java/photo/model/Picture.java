package photo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
public class Picture implements Serializable {

	private static final long serialVersionUID = 5614390204241349591L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullURL;
	private String thumbURL;
	
	private Long userId;

	public Picture() {
	}
	
	public Picture(String fullURL, String thumbURL, Long userId) {
		this.fullURL = fullURL;
		this.thumbURL = thumbURL;
		this.userId = userId;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullURL() {
		return fullURL;
	}

	public void setFullURL(String fullURL) {
		this.fullURL = fullURL;
	}

	public String getThumbURL() {
		return thumbURL;
	}

	public void setThumbURL(String thumbURL) {
		this.thumbURL = thumbURL;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullURL == null) ? 0 : fullURL.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((thumbURL == null) ? 0 : thumbURL.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (fullURL == null) {
			if (other.fullURL != null)
				return false;
		} else if (!fullURL.equals(other.fullURL))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (thumbURL == null) {
			if (other.thumbURL != null)
				return false;
		} else if (!thumbURL.equals(other.thumbURL))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
