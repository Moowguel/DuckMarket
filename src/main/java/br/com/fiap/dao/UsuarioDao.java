package br.com.fiap.dao;

import br.com.fiap.exception.ENEexception;
import br.com.fiap.factory.ConnectionFactory;

import br.com.fiap.model.Transacao;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection conexao;

    public UsuarioDao () throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usuario) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO usuario (id_usuario, nome, email, senha, criacao_data_usuario) VALUES (SQ_ID_USUARIO.NEXTVAL, ?, ?, ?, SYSDATE)");
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getEmail());
        stm.setString(3, usuario.getSenha());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }
    public Usuario pesquisar(long codigo) throws SQLException, ENEexception {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
        stm.setLong(1,codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new ENEexception("Usuario não encontrado");
        return parseUsuario(result);
    }

    private Usuario parseUsuario(ResultSet result) throws SQLException{
        Long idUsuario = result.getLong("id_usuario");
        String nome = result.getString("nome");
        String email = result.getString("email");
        String senha = result.getString("senha");
        java.sql.Date dtCriacaoUsuario = result.getDate("criacao_data_usuario");

        return new Usuario(idUsuario, nome, email, senha, dtCriacaoUsuario);
    }

    public List<Usuario> listar() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM usuario");
        ResultSet result = stm.executeQuery();
        List<Usuario> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    public void atualizar (Usuario usuario) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? where id_usuario = ?");
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getEmail());
        stm.setString(3, usuario.getSenha());
        stm.setLong(4, usuario.getIdUsuario());
        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, ENEexception{
        PreparedStatement stm = conexao.prepareStatement("DELETE from usuario where id_usuario = ?");
        stm.setLong(1,codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new ENEexception("Transação não encontrada para ser removida!");
    }
}
