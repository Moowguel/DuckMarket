package br.com.fiap.model;

import java.util.Date;

public class Transacao {
    private Long idTransacao;
    private Long idConta;
    private Long idCriptoativo;
    private String tipotransacao;
    private Double qtdTransacao;
    private Double precoUnitario;
    private java.sql.Date dtTransacao;

    public Transacao (){

    }

    public Transacao(Long idTransacao, Long idConta, Long idCriptoativo, String tipotransacao, Double qtdTransacao, Double precoUnitario, java.sql.Date dtTransacao) {
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.idCriptoativo = idCriptoativo;
        this.tipotransacao = tipotransacao;
        this.qtdTransacao = qtdTransacao;
        this.precoUnitario = precoUnitario;
        this.dtTransacao = dtTransacao;
    }

    public Transacao(Long idConta, Long idCriptoativo, String tipotransacao, double qtdTransacao, double precoUnitario) {
        this.idConta = idConta;
        this.idCriptoativo = idCriptoativo;
        this.tipotransacao = tipotransacao;
        this.qtdTransacao = qtdTransacao;
        this.precoUnitario = precoUnitario;
    }


    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdCriptoativo() {
        return idCriptoativo;
    }

    public void setIdCriptoativo(Long idCriptoativo) {
        this.idCriptoativo = idCriptoativo;
    }

    public String getTipotransacao() {
        return tipotransacao;
    }

    public void setTipotransacao(String tipotransacao) {
        this.tipotransacao = tipotransacao;
    }

    public Double getQtdTransacao() {
        return qtdTransacao;
    }

    public void setQtdTransacao(Double qtdTransacao) {
        this.qtdTransacao = qtdTransacao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(java.sql.Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }
}
