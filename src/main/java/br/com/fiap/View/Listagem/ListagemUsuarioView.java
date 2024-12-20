package br.com.fiap.View.Listagem;


import br.com.fiap.View.Main;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class ListagemUsuarioView {
    public static void main(String[]args){
        try{
            UsuarioDao dao = new UsuarioDao();
            List<Usuario> usuarios = dao.listar();
            for (Usuario usuario : usuarios){
                System.out.println("ID Usuario: " + usuario.getIdUsuario()  + " | Nome: " + usuario.getNome() + " | Email: " +  usuario.getEmail() + " | Senha: " +  usuario.getSenha() + " | Data de Criação da Conta: " + usuario.getDtCriacaoUsuario());

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
