package br.com.fiap.dao;

import br.com.fiap.exception.ENEexception;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao {

    private Connection conexao;

    public EmpresaDao () throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Empresa empresa) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO empresa (id_conta, id_usuario, nome_conta, saldo, limite, criacao_data_empresa) VALUES (SQ_ID_CONTA.NEXTVAL, ?, ?, ?, ?, SYSDATE)");
        stm.setLong(1, empresa.getIdUsuario());
        stm.setString(2, empresa.getNomeConta());
        stm.setDouble(3, empresa.getSaldo());
        stm.setDouble(4, empresa.getLimite());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public Empresa pesquisar(long codigo) throws SQLException, ENEexception {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM Empresa WHERE id_conta = ?");
        stm.setLong(1,codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new ENEexception("Empresa não encontrada");
        return parseEmpresa(result);
    }

    private Empresa parseEmpresa(ResultSet result) throws SQLException{
        Long idconta = result.getLong("id_conta");
        Long idusuario = result.getLong("id_usuario");
        String nome = result.getString("nome_conta");
        double saldo = result.getDouble("saldo");
        double limite = result.getDouble("limite");
        return new Empresa(idconta,idusuario, nome, saldo, limite);
    }

    public List<Empresa> listar() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM empresa");
        ResultSet result = stm.executeQuery();
        List<Empresa> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseEmpresa(result));
        }
        return lista;
    }

    public void atualizar (Empresa empresa) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("UPDATE empresa SET nome_conta = ?, saldo = ?, limite = ? where id_conta = ?");
        stm.setString(1, empresa.getNomeConta());
        stm.setDouble(2, empresa.getSaldo());
        stm.setDouble(3, empresa.getLimite());
        stm.setLong(4, empresa.getIdUsuario());
        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, ENEexception{
        PreparedStatement stm = conexao.prepareStatement("DELETE from empresa where id_conta = ?");
        stm.setLong(1,codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new ENEexception("Empresa não encontrada para ser removida!");
    }
}
