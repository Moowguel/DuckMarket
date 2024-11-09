package br.com.fiap.View.Remocao;


import br.com.fiap.View.Main;
import br.com.fiap.dao.UsuarioDao;

import java.util.Scanner;

public class RemocaoUsuarioView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("===================MENU DE EXCLUSAO==================");
                System.out.println("===========ATENCAO, ESSA ACAO E IRREVERSIVEL=========");
                System.out.println("=Digite o id do Usuario que voce deseja excluir!=");
                long id = scanner.nextLong();
                UsuarioDao dao = new UsuarioDao();
                dao.remover(id);
                running = false;
                dao.fecharConexao();
                System.out.println("Usuario Removido");
                Main.main(null);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
