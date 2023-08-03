package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "posts", catalog = "experiment")
public class Posts implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1527949636687260294L;
	private Integer id;
	private Usertable user;
	private String postdate;
	private String title;
	private String content;
	private Set<Comments> postComments = new HashSet<Comments>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "postdate", length = 1000)
	public String getPostdate() {
		return this.postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	@Column(name = "title", length = 1000)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 5000)
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

	@OneToMany(mappedBy = "post")
	@Cascade(value = { CascadeType.REMOVE })
	public Set<Comments> getPostComments() {
		return postComments;
	}

	public void setPostComments(Set<Comments> postComments) {
		this.postComments = postComments;
	}

	@Override
	public String toString() {
		return "Posts{" +
				"id=" + id +
				", user=" + user +
				", postdate='" + postdate + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", postComments=" + postComments +
				'}';
	}
}