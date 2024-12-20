package br.com.fiap.View.Listagem;

import br.com.fiap.View.Main;
import br.com.fiap.dao.CriptoativoDao;
import br.com.fiap.model.Criptoativo;

import java.sql.SQLException;
import java.util.List;

public class ListagemCriptoativoView {
    public static void main(String[] args){
        try{
            CriptoativoDao dao = new CriptoativoDao();
            List<Criptoativo> criptoativos = dao.listar();
            for (Criptoativo criptoativo : criptoativos){
                System.out.println("ID: " + criptoativo.getIdCripto() + " | NOME CRIPTO: " + criptoativo.getNomeCripto() + " | SIMBOLO: " + criptoativo.getSimbolo() + " | DATA DE CRIAÇÃO: " +  criptoativo.getDtcriacaocriptoativo() + " | VARIAÇÃO: " + criptoativo.getVariacao() + " | QUANTIDADE" + criptoativo.getQtdCriptoativo() + " | Preço Unitário" + criptoativo.getPrecoUnitario());

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
