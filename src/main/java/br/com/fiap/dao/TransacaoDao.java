package br.com.fiap.dao;

import br.com.fiap.exception.ENEexception;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {
    private Connection conexao;

    public TransacaoDao () throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Transacao transacao) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO transacao (id_transicao, id_conta, id_criptoativo, tipo_transacao, quantidade_transacao, preco_unitario, criacao_data_transacao) VALUES (SQ_ID_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)");
        stm.setLong(1, transacao.getIdConta());
        stm.setLong(2, transacao.getIdCriptoativo());
        stm.setString(3, transacao.getTipotransacao());
        stm.setDouble(4, transacao.getQtdTransacao());
        stm.setDouble(5, transacao.getPrecoUnitario());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public Transacao pesquisar(long codigo) throws SQLException, ENEexception {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM transacao WHERE id_transicao = ?");
        stm.setLong(1,codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new ENEexception("Transação não encontrada");
        return parseTransacao(result);
    }

    private Transacao parseTransacao(ResultSet result) throws SQLException{
        Long idTransacao = result.getLong("id_transicao");
        Long idConta = result.getLong("id_conta");
        Long idcripto = result.getLong("id_criptoativo");
        String tipo = result.getString("tipo_transacao");
        double precoUnitario = result.getDouble("preco_unitario");
        double quantidade = result.getDouble("quantidade_transacao");
        java.sql.Date dtTransacao = result.getDate("criacao_data_transacao");

        return new Transacao(idTransacao, idConta, idcripto, tipo, precoUnitario, quantidade, dtTransacao);
    }

    public List<Transacao> listar() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM transacao");
        ResultSet result = stm.executeQuery();
        List<Transacao> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseTransacao(result));
        }
        return lista;
    }

    public void atualizar (Transacao transacao) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("UPDATE transacao SET tipo_transacao = ?, quantidade_transacao = ?, preco_unitario = ? where id_transicao = ?");
        stm.setString(1, transacao.getTipotransacao());
        stm.setDouble(2, transacao.getQtdTransacao());
        stm.setDouble(3, transacao.getPrecoUnitario());
        stm.setLong(4, transacao.getIdTransacao());
        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, ENEexception{
        PreparedStatement stm = conexao.prepareStatement("DELETE from transacao where id_transicao = ?");
        stm.setLong(1,codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new ENEexception("Transação não encontrada para ser removida!");
    }
}
