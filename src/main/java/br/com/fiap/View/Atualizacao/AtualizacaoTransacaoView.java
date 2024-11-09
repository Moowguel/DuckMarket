package br.com.fiap.View.Atualizacao;

import br.com.fiap.View.Main;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Transacao;


import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoTransacaoView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){

            try{
                System.out.println("=======MENU DE ATUALIZACAO=======");
                System.out.println("Bem vindo a Atualizacao de Transacao!");
                System.out.println("Qual id da Transacao que voce gostaria de alterar?");
                long codTra = scanner.nextLong();
                TransacaoDao dao = new TransacaoDao();
                Transacao transacao = dao.pesquisar(codTra);

                System.out.println("Foi uma Compra ou uma Venda?");
                String tipo = scanner.nextLine();
                System.out.println("Qual a Quantidade?");
                double qtd = scanner.nextDouble();
                System.out.println("Qual o Preco?");
                double preco = scanner.nextDouble();

                transacao.setTipotransacao(tipo);
                transacao.setQtdTransacao(qtd);
                transacao.setPrecoUnitario(preco);

                dao.atualizar(transacao);
                running = false;
                System.out.println("Transação Atualizada");
                Main.main(null);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Produto não encontrado");
            }

        }


    }
}
