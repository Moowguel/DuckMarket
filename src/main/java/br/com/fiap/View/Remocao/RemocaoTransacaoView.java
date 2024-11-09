package br.com.fiap.View.Remocao;

import br.com.fiap.View.Main;
import br.com.fiap.dao.TransacaoDao;

import java.util.Scanner;

public class RemocaoTransacaoView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("===================MENU DE EXCLUSAO==================");
                System.out.println("===========ATENCAO, ESSA ACAO E IRREVERSIVEL=========");
                System.out.println("=Digite o id da Transacao que voce deseja excluir!=");
                long id = scanner.nextLong();
                TransacaoDao dao = new TransacaoDao();
                dao.remover(id);
                running = false;
                dao.fecharConexao();
                System.out.println("Transação Removida");
                Main.main(null);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

}
