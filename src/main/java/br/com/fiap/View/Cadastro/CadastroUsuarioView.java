package br.com.fiap.View.Cadastro;


import br.com.fiap.View.Main;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class CadastroUsuarioView {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try {

                System.out.println("=======CADASTRO DE USUARIO=======");
                System.out.println("Bem vindo ao Cadastro de Usuario!");

                System.out.println("Qual nome do Usuario?");
                String nome = scanner.nextLine();
                System.out.println("Qual o email?");
                String email = scanner.nextLine();
                System.out.println("qual a senha?");
                String senha = scanner.nextLine();
                UsuarioDao dao = new UsuarioDao();
                Usuario usuario = new Usuario(nome, email, senha);
                dao.cadastrar(usuario);
                running = false;
                dao.fecharConexao();
                System.out.println("Usuario Cadastrado!");
                Main.main(null);
            } catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }

    }

}
