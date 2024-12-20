package br.com.fiap.View.Listagem;


import br.com.fiap.View.Main;
import br.com.fiap.dao.EmpresaDao;
import br.com.fiap.model.Empresa;

import java.sql.SQLException;
import java.util.List;

public class ListagemEmpresaView {
    public static void main(String[] args){
        try{
            EmpresaDao dao = new EmpresaDao();
            List<Empresa> empresas = dao.listar();
            for (Empresa empresa : empresas){
                System.out.println("ID Conta: " + empresa.getIdConta() + " | ID Usuario: " + empresa.getIdUsuario() + " | Nome Conta: " + empresa.getNomeConta() + " | Saldo : " +  empresa.getSaldo() + " | Limite: " + empresa.getLimite() + " | Data de Criação da empresa" + empresa.getDataCriacaoEmpresa());

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
