package banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Fidelidade;

public class FidelidadeBanco {
    private DBConnection connection;

    public FidelidadeBanco() {
        this.connection = new DBConnection();
    }

    public void incluir(Fidelidade fidelidade) {
        try {
            String sql = "CALL inserir_fidelidade(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, fidelidade.getIdFidelidade());
            statement.setInt(2, fidelidade.getPontos());
            statement.setString(3, fidelidade.getNivel());
            statement.setString(4, fidelidade.getDataUltimaAtualizacao());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir fidelidade: " + e.getMessage(), e);
        }
    }

    public List<Fidelidade> listar() {
        List<Fidelidade> fidelidades = new ArrayList<>();
        try {
            String sql = "CALL listar_fidelidades();";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Fidelidade fidelidade = new Fidelidade(
                    rs.getString("idFidelidade"),
                    rs.getInt("pontos"),
                    rs.getString("nivel"),
                    rs.getString("dataUltimaAtualizacao")
                );
                fidelidades.add(fidelidade);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fidelidades: " + e.getMessage(), e);
        }
        return fidelidades;
    }

    public Fidelidade consultar(String idFidelidade) {
        Fidelidade fidelidade = null;
        try {
            String sql = "CALL consultar_fidelidade(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, idFidelidade);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                fidelidade = new Fidelidade(
                    rs.getString("idFidelidade"),
                    rs.getInt("pontos"),
                    rs.getString("nivel"),
                    rs.getString("dataUltimaAtualizacao")
                );
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar fidelidade: " + e.getMessage(), e);
        }
        return fidelidade;
    }

    public void atualizar(Fidelidade fidelidade) {
        try {
            String sql = "CALL atualizar_fidelidade(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, fidelidade.getIdFidelidade());
            statement.setInt(2, fidelidade.getPontos());
            statement.setString(3, fidelidade.getNivel());
            statement.setString(4, fidelidade.getDataUltimaAtualizacao());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar fidelidade: " + e.getMessage(), e);
        }
    }

    public void deletar(String idFidelidade) {
        try {
            String sql = "CALL deletar_fidelidade(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, idFidelidade);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar fidelidade: " + e.getMessage(), e);
        }
    }
}
