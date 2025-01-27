package banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Devolucao;

public class DevolucaoBanco {
    private DBConnection connection;

    public DevolucaoBanco() {
        this.connection = new DBConnection();
    }

    // Função para incluir uma devolução
    public void incluir(Devolucao devolucao) {
        try {
            String sql = "CALL inserir_devolucao(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(devolucao.getDataDevolucao())); 
            statement.setString(2, devolucao.getCondicaoVeiculo());
            statement.setDouble(3, devolucao.getTaxaAtraso());
            statement.setBoolean(4, devolucao.getStatusDevolucao());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir devolução: " + e.getMessage(), e);
        }
    }

    // Função para listar todas as devoluções
    public List<Devolucao> listar() {
        List<Devolucao> devolucoes = new ArrayList<>();
        try {
            String sql = "CALL listar_devolucoes();";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Devolucao devolucao = new Devolucao(
                    rs.getDate("dataDevolucao").toLocalDate(),
                    rs.getDouble("taxaAtraso"),
                    rs.getString("statusDevolucao")
                );
                devolucoes.add(devolucao);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar devoluções: " + e.getMessage(), e);
        }
        return devolucoes;
    }

    public Devolucao consultar(int idDevolucao) {
        Devolucao devolucao = null;
        try {
            String sql = "CALL consultar_devolucao(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idDevolucao);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                devolucao = new Devolucao(
                    rs.getDate("dataDevolucao").toLocalDate(), 
                    rs.getString("condicaoVeiculo"),
                    rs.getDouble("taxaAtraso"),
                    rs.getString("statusDevolucao")
                );
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar devolução: " + e.getMessage(), e);
        }
        return devolucao;
    }

    
    public void atualizar(Devolucao devolucao) {
        try {
            String sql = "CALL atualizar_devolucao(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(devolucao.getDataDevolucao()));  
            statement.setString(2, devolucao.getCondicaoVeiculo());
            statement.setDouble(3, devolucao.getTaxaAtraso());
            statement.setBoolean(4, devolucao.getStatusDevolucao());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar devolução: " + e.getMessage(), e);
        }
    }

    public void deletar(int idDevolucao) {
        try {
            String sql = "CALL deletar_devolucao(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idDevolucao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar devolução: " + e.getMessage(), e);
        }
    }
}

