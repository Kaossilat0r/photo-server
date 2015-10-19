package photo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Tag> tags;

	public Picture() {
	}
	
	public Picture(String fullURL, String thumbURL, User user) {
		this.fullURL = fullURL;
		this.thumbURL = thumbURL;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	
}
