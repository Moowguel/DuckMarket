package br.com.fiap.View.Listagem;


import br.com.fiap.View.Main;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.model.Transacao;

import java.sql.SQLException;
import java.util.List;

public class ListagemTransacaoView {
    public static void main(String[] args){
        try{
            TransacaoDao dao = new TransacaoDao();
            List<Transacao> transacoes = dao.listar();
            for (Transacao transacao : transacoes){
                System.out.println("ID Transacao: " + transacao.getIdTransacao()  + " | ID Conta: " + transacao.getIdConta() + " | ID Criptoativo: " + transacao.getIdCriptoativo() + " | Tipo de Transação: " +  transacao.getTipotransacao() + " | Quantidade da Transação: " + transacao.getQtdTransacao() + " | Preço Unitário: " + transacao.getPrecoUnitario() + " | Data da Transação: " + transacao.getDtTransacao());
                Main.main(null);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
