package br.com.fiap.View.Cadastro;

import br.com.fiap.View.Main;
import br.com.fiap.dao.EmpresaDao;
import br.com.fiap.model.Empresa;

import java.sql.SQLException;
import java.util.Scanner;

public class CadastroEmpresaView {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try {

                System.out.println("=======CADASTRO DE Empresa=======");
                System.out.println("Bem vindo ao Cadastro de Empresa!");

                EmpresaDao dao = new EmpresaDao();
                System.out.println("Digite o nome da Empresa: ");
                String nomeConta = scanner.nextLine();
                System.out.println("Digite o saldo da Empresa: ");
                double saldo = scanner.nextDouble();
                System.out.println("Digite o limite da Empresa: ");
                double limite = scanner.nextDouble();
                System.out.println("Digite o id de usuario que essa Empresa está atrelada: ");
                long idUsuario = scanner.nextLong();

                Empresa empresa = new Empresa(idUsuario,nomeConta,saldo,limite);
                dao.cadastrar(empresa);
                running = false;
                dao.fecharConexao();
                System.out.println("Empresa Cadastrada!");
                Main.main(null);
            } catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }


    }
}
