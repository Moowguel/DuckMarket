package br.com.fiap.View.Atualizacao;
import br.com.fiap.View.Main;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoUsuarioView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("=======MENU DE ATUALIZACAO=======");
                System.out.println("Bem vindo a Atualizacao de Criptoativo!");
                System.out.println("Qual id do Usuario que voce gostaria de alterar?");
                long codUser = scanner.nextLong();
                UsuarioDao dao = new UsuarioDao();
                Usuario usuario = dao.pesquisar(codUser);
                System.out.println("Qual o Nome");
                String nome = scanner.nextLine();
                System.out.println("Qual o Email");
                String email = scanner.nextLine();
                System.out.println("Qual a Senha");
                String senha = scanner.nextLine();

                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);

                dao.atualizar(usuario);
                running = false;
                System.out.println("Usuario Atualizado");
                Main.main(null);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Produto não encontrado");
            }
        }

    }
}
