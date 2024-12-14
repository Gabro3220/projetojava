package banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Manutencao;

public class ManutencaoBanco {
    private DBConnection connection;

    public ManutencaoBanco() {
        this.connection = new DBConnection();
    }

    public void incluir(Manutencao manutencao) {
        try {
            String sql = "CALL inserir_manutencao(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, manutencao.getIdManutencao());
            statement.setString(2, manutencao.getDataManutencao());
            statement.setString(3, manutencao.getTipoManutencao());
            statement.setDouble(4, manutencao.getCusto());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir manutenção: " + e.getMessage(), e);
        }
    }

    public List<Manutencao> listar() {
        List<Manutencao> manutencoes = new ArrayList<>();
        try {
            String sql = "CALL listar_manutencao();";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Manutencao manutencao = new Manutencao(
                    rs.getString("idManutencao"),
                    rs.getString("dataManutencao"),
                    rs.getString("tipoManutencao"),
                    rs.getDouble("custo"),
                    rs.getString("descricao")
                );
                manutencoes.add(manutencao);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar manutenções: " + e.getMessage(), e);
        }
        return manutencoes;
    }

    public Manutencao consultar(Integer idManutencao) {
        Manutencao manutencao = null;
        try {
            String sql = "CALL consultar_manutencao(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idManutencao);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                manutencao = new Manutencao(
                    rs.getString("idManutencao"),
                    rs.getString("dataManutencao"),
                    rs.getString("tipoManutencao"),
                    rs.getDouble("custo"),
                    rs.getString("descricao")
                );
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar manutenção: " + e.getMessage(), e);
        }
        return manutencao;
    }

    public void atualizar(Manutencao manutencao) {
        try {
            String sql = "CALL atualizar_manutencao(?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, manutencao.getIdManutencao());
            statement.setString(2, manutencao.getDataManutencao());
            statement.setString(3, manutencao.getTipoManutencao());
            statement.setDouble(4, manutencao.getCusto());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar manutenção: " + e.getMessage(), e);
        }
    }

    public void deletar(Integer idManutencao) {
        try {
            String sql = "CALL deletar_manutencao(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idManutencao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar manutenção: " + e.getMessage(), e);
        }
    }
}
