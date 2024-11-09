package br.com.fiap.dao;

import br.com.fiap.exception.ENEexception;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Criptoativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CriptoativoDao {

    private Connection conexao;

    public CriptoativoDao () throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Criptoativo criptoativo) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO criptoativo (id_criptoativo, nome_criptoativo, simbolo, criacao_data_criptoativo, variacao, quantidade_criptoativo, precoUnitario) VALUES (SQ_ID_CRIPTOATIVO.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?)");
        stm.setString(1, criptoativo.getNomeCripto());
        stm.setString(2, criptoativo.getSimbolo());
        stm.setDouble(3, criptoativo.getVariacao());
        stm.setDouble(4, criptoativo.getQtdCriptoativo());
        stm.setDouble(5, criptoativo.getPrecoUnitario());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public Criptoativo pesquisar(long codigo) throws SQLException, ENEexception {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM criptoativo WHERE id_criptoativo = ?");
        stm.setLong(1,codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new ENEexception("produto não encontrado");
        return parseCriptoativo(result);
    }

    private Criptoativo parseCriptoativo(ResultSet result) throws SQLException{
        Long id = result.getLong("id_criptoativo");
        String nome = result.getString("nome_criptoativo");
        String simbolo = result.getString("simbolo");
        double variacao = result.getDouble("variacao");
        double quantidadeCripto = result.getDouble("quantidade_criptoativo");
        double precoUnitario = result.getDouble("precounitario");
        return new Criptoativo(id, nome, simbolo,variacao,quantidadeCripto,precoUnitario);
    }

    public List<Criptoativo> listar() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM criptoativo");
        ResultSet result = stm.executeQuery();
        List<Criptoativo> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseCriptoativo(result));
        }
        return lista;
    }

    public void atualizar (Criptoativo criptoativo) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("UPDATE criptoativo SET nome_criptoativo = ?, simbolo = ?, variacao = ?, quantidade_criptoativo = ?, precounitario = ? where id_criptoativo = ?");
        stm.setString(1, criptoativo.getNomeCripto());
        stm.setString(2, criptoativo.getSimbolo());
        stm.setDouble(3,criptoativo.getVariacao());
        stm.setDouble(4, criptoativo.getQtdCriptoativo());
        stm.setDouble(5, criptoativo.getPrecoUnitario());
        stm.setLong(6, criptoativo.getIdCripto());
        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, ENEexception{
        PreparedStatement stm = conexao.prepareStatement("DELETE from criptoativo where id_criptoativo = ?");
        stm.setLong(1,codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new ENEexception("Moeda não encontrada para ser removida!");
    }
}
