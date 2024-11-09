package br.com.fiap.View.Atualizacao;

import br.com.fiap.View.Main;
import br.com.fiap.dao.CriptoativoDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Criptoativo;

import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoCriptoativoView {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{

                System.out.println("=======MENU DE ATUALIZACAO=======");
                System.out.println("Bem vindo a Atualizacao de Criptoativo!");

                CriptoativoDao dao = new CriptoativoDao();
                System.out.println("Qual id da criptomoeda que voce gostaria de alterar?");
                long codCripto = scanner.nextLong();
                scanner.nextLine();
                Criptoativo criptoativo = dao.pesquisar(codCripto);

                System.out.println("Qual o novo nome?");
                String nome = scanner.nextLine();
                System.out.println("Qual o novo Simbolo?");
                String simb = scanner.nextLine();
                System.out.println("Qual a nova Variacao?");
                double variacao = scanner.nextDouble();
                System.out.println("Qual a nova Quantidade?");
                double qtd = scanner.nextDouble();
                System.out.println("Qual o novo Preco Unitario");
                double preco = scanner.nextDouble();

                criptoativo.setNomeCripto(nome);
                criptoativo.setSimbolo(simb);
                criptoativo.setVariacao(variacao);
                criptoativo.setQtdCriptoativo(qtd);
                criptoativo.setPrecoUnitario(preco);

                running = false;
                dao.atualizar(criptoativo);
                System.out.println("Moeda Atualizada");
                Main.main(null);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Produto não encontrado");
            }
        }

    }
}
