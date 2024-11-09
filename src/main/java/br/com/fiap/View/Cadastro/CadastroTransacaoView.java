package br.com.fiap.View.Cadastro;

import br.com.fiap.View.Main;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.model.Transacao;

import java.sql.SQLException;
import java.util.Scanner;

public class CadastroTransacaoView {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){

            try {

                System.out.println("======CADASTRO DE TRANSACAO======");
                System.out.println("Bem vindo ao Cadastro de Transcao!");

                System.out.println("Qual id da conta que esta realizando a transacao? ");
                long idConta = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Qual id do criptoativo?");
                long idCripto = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Compra ou Venda?");
                String tipoTransacao = scanner.nextLine();
                System.out.println("Qual a quantidade?");
                double qtdTransacao = scanner.nextDouble();
                System.out.println("Qual o preco?");
                double precoUnitario = scanner.nextDouble();
                TransacaoDao dao = new TransacaoDao();
                Transacao transacao = new Transacao(idConta,idCripto,tipoTransacao, qtdTransacao,precoUnitario);

                dao.cadastrar(transacao);
                running = false;
                dao.fecharConexao();
                System.out.println("Transação Cadastrada!");
                Main.main(null);
            } catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
