package Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postID;

	@ManyToOne
	private Usuario usuario;
	private Date dataPost;
	private String titulo;
	private String corpo;
	private Date dataAtualizacao;

	@OneToMany
	private List<Comentario> comentarios;

	public Post() {}
	
	public Post(Usuario usuario, String titulo, String corpo) {
		setUsuario(usuario);
		setTitulo(titulo);
		setCorpo(corpo);
	}
	
	public Post(Usuario usuario, Date dataPost,String titulo, String corpo, Date dataAtualizacao) {
		setPostID(postID);
		setUsuario(usuario);
		setDataPost(dataPost);
		setTitulo(titulo);
		setCorpo(corpo);
		setDataAtualizacao(dataAtualizacao);
	}

	public Long getPostID() {
		return postID;
	}

	public Usuario usuario() {
		return usuario;
	}

	public Date getDataPost() {
		return dataPost;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCorpo() {
		return corpo;
	}
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setPostID(Long postID) {
		this.postID = postID;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
