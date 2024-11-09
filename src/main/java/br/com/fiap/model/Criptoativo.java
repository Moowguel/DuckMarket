package br.com.fiap.model;


public class Criptoativo {

    private Long idCripto;
    private String nomeCripto;
    private String simbolo;
    private java.sql.Date dtcriacaocriptoativo;
    private Double variacao;
    private Double qtdCriptoativo;
    private Double precoUnitario;

    public Criptoativo(Long idCripto, String nomeCripto, String simbolo, java.sql.Date dtcriacaocriptoativo, Double variacao, Double qtdCriptoativo, Double precoUnitario){
        this.idCripto = idCripto;
        this.nomeCripto = nomeCripto;
        this.simbolo = simbolo;
        this.dtcriacaocriptoativo = dtcriacaocriptoativo;
        this.variacao = variacao;
        this.qtdCriptoativo = qtdCriptoativo;
        this.precoUnitario = precoUnitario;
    }

    public Criptoativo(){

    }

    public Criptoativo(String nomeCripto, String simbolo, double variacao, double qtdCriptoativo, double precoUnitario) {
        this.nomeCripto = nomeCripto;
        this.simbolo = simbolo;
        this.variacao = variacao;
        this.qtdCriptoativo = qtdCriptoativo;
        this.precoUnitario = precoUnitario;
    }

    public Criptoativo(Long idCripto, String nomeCripto, String simbolo, double variacao, double qtdCriptoativo, double precoUnitario) {
        this.idCripto = idCripto;
        this.nomeCripto = nomeCripto;
        this.simbolo = simbolo;
        this.variacao = variacao;
        this.qtdCriptoativo = qtdCriptoativo;
        this.precoUnitario = precoUnitario;
    }



    public Long getIdCripto() {
        return idCripto;
    }

    public void setIdCripto(Long idCripto) {
        this.idCripto = idCripto;
    }

    public String getNomeCripto() {
        return nomeCripto;
    }

    public void setNomeCripto(String nomeCripto) {
        this.nomeCripto = nomeCripto;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public java.sql.Date getDtcriacaocriptoativo() {
        return dtcriacaocriptoativo;
    }

    public void setDtcriacaocriptoativo(java.sql.Date dtcriacaocriptoativo) {
        this.dtcriacaocriptoativo = dtcriacaocriptoativo;
    }

    public Double getVariacao() {
        return variacao;
    }

    public void setVariacao(Double variacao) {
        this.variacao = variacao;
    }

    public Double getQtdCriptoativo() {
        return qtdCriptoativo;
    }

    public void setQtdCriptoativo(Double qtdCriptoativo) {
        this.qtdCriptoativo = qtdCriptoativo;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
