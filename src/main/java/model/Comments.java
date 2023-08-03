package model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments", catalog = "experiment")
public class Comments implements java.io.Serializable {

	private static final long serialVersionUID = 2031622074335575499L;
	private Integer id;
	private Usertable user;
	private Posts post;
	private String date;
	private String content;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "date", nullable = false, length = 100)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "content", nullable = false, length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "userid")
	public Usertable getUser() {
		return user;
	}

	public void setUser(Usertable user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "postid")
	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comments{" +
				"id=" + id +
				", user=" + user +
				", post=" + post +
				", date='" + date + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}