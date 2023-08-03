package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "usertable", catalog = "experiment")
public class Usertable implements java.io.Serializable {

	private static final long serialVersionUID = 4501430463860019793L;
	private Integer id;
	private String username;
	private String password;
	private String sex;
	private String mail;
	private Set<Posts> userPosts = new HashSet<Posts>();
	private Set<Comments> userComments = new HashSet<Comments>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "mail", length = 100)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OrderBy(value = "postdate")
	@Cascade(value = { CascadeType.REMOVE })
	public Set<Posts> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(Set<Posts> userPosts) {
		this.userPosts = userPosts;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OrderBy(value = "date")
	@Cascade(value = { CascadeType.REMOVE })
	public Set<Comments> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<Comments> userComments) {
		this.userComments = userComments;
	}

	@Override
	public String toString() {
		return "Usertable{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", mail='" + mail + '\'' +
				", userPosts=" + userPosts +
				", userComments=" + userComments +
				'}';
	}
}