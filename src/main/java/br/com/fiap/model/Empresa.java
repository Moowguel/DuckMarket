package br.com.fiap.model;

import java.util.Date;

public class Empresa {
    private Long idConta;
    private Long idUsuario;
    private String nomeConta;
    private Double saldo;
    private Double limite;
    private java.sql.Date dataCriacaoEmpresa;

    public Empresa (){

    }

    public Empresa (long idConta, long idUsuario, String nomeConta, Double saldo, Double limite, java.sql.Date dataCriacaoEmpresa){
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.limite = limite;
        this. dataCriacaoEmpresa = dataCriacaoEmpresa;
    }

    public Empresa(long idUsuario, String nomeConta, double saldo, double limite) {
        this.idUsuario = idUsuario;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Empresa(Long idConta, Long idUsuario, String nomeConta, double saldo, double limite) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Date getDataCriacaoEmpresa() {
        return dataCriacaoEmpresa;
    }

    public void setDataCriacaoEmpresa(java.sql.Date dataCriacaoEmpresa) {
        this.dataCriacaoEmpresa = dataCriacaoEmpresa;
    }
}
