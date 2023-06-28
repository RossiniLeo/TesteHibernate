package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comentarioID;
	@ManyToOne
	@JoinColumn(name = "post_post_id")
	private Post post;
	@ManyToOne
	private Usuario usuario;
	private Date dataComentario;
	private String comentario;
	private Date dataAtualizacao;

	public Comentario() {}
	
	public Comentario(Post post, Usuario usuario, Date dataComentario, String comentario, Date dataAtualizacao) {
		setComentarioID(comentarioID);
		setPost(post);
		setUsuario(usuario);
		setDataComentario(dataComentario);
		setComentario(comentario);
		setDataAtualizacao(dataAtualizacao);
	}
	
	public Comentario(Post post, Usuario usuario, String comentario) {
		setPost(post);
		setUsuario(usuario);
		setComentario(comentario);
	}
	
	public Long getComentarioID() {
		return comentarioID;
	}

	public Post getPost() {
		return post;
	}
	
	public Usuario usuario() {
		return usuario;
	}
	
	public Date getDataComentario() {
		return dataComentario;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setComentarioID(Long comentarioID) {
		this.comentarioID = comentarioID;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setDataComentario(Date dataPost) {
		this.dataComentario = dataPost;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
