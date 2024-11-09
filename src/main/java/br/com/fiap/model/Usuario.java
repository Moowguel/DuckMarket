package br.com.fiap.model;

import java.util.Date;

public class Usuario {

    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private java.sql.Date dtCriacaoUsuario;

    public Usuario(){

    }

    public Usuario(Long idUsuario, String nome, String email, String senha, java.sql.Date dtCriacaoUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCriacaoUsuario = dtCriacaoUsuario;
    }

    public Usuario (String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDtCriacaoUsuario() {
        return dtCriacaoUsuario;
    }

    public void setDtCriacaoUsuario(java.sql.Date dtCriacaoUsuario) {
        this.dtCriacaoUsuario = dtCriacaoUsuario;
    }
}
