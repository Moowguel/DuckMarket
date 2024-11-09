package br.com.fiap.View.Pesquisa;

import br.com.fiap.View.Main;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Transacao;

import java.sql.SQLException;
import java.util.Scanner;

public class PesquisaTransacaoView {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){

            try{
                TransacaoDao dao = new TransacaoDao();
                System.out.println("Digite o codigo da Transação que deseja pesquisar: ");
                int codTransacao = scanner.nextInt();
                Transacao transacao = dao.pesquisar(codTransacao);
                System.out.println("ID da Conta: " + transacao.getIdConta());
                System.out.println("Tipo de Transação: "+transacao.getTipotransacao()+" | Data: "+ transacao.getDtTransacao());
                running = false;
                dao.fecharConexao();
                Main.main(null);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Codigo não existe na tabela.");
            }
        }



    }
}
