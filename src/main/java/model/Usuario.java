package Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int userID, String nome, String email, String senha) {
        setUserID(userID);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public int getUserID() {
        return userID;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
