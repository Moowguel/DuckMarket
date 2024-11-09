package br.com.fiap.View.Remocao;
import br.com.fiap.View.Main;
import br.com.fiap.dao.EmpresaDao;

import java.util.Scanner;

public class RemocaoEmpresaView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("===================MENU DE EXCLUSAO==================");
                System.out.println("===========ATENCAO, ESSA ACAO E IRREVERSIVEL=========");
                System.out.println("=Digite o id da Empresa que voce deseja excluir!=");
                long id = scanner.nextLong();
                EmpresaDao dao = new EmpresaDao();
                dao.remover(id);
                running = false;
                dao.fecharConexao();
                System.out.println("Empresa Removida");
                Main.main(null);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }


    }
}
