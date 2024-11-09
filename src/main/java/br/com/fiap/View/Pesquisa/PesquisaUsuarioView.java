package br.com.fiap.View.Pesquisa;

import br.com.fiap.View.Main;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class PesquisaUsuarioView {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                UsuarioDao dao = new UsuarioDao();
                System.out.println("Digite o codigo do Usuario que voce deseja pesquisar: ");
                int codUsuario = scanner.nextInt();
                Usuario usuario = dao.pesquisar(codUsuario);
                System.out.println("ID do Usuario:" + usuario.getIdUsuario());
                System.out.println("Nome: "+usuario.getNome()+"| Email: "+ usuario.getEmail());
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
