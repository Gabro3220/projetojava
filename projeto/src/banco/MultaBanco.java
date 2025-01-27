package banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Multa;

public class MultaBanco {
    private DBConnection connection;

    public MultaBanco() {
        this.connection = new DBConnection();
    }

    public void incluir(Multa multa) {
        try {
            String sql = "CALL inserir_multa(?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, multa.getIdMulta());
            statement.setString(2, multa.getMotivo());
            statement.setDouble(3, multa.getValorMulta());
            statement.setDate(4, java.sql.Date.valueOf(multa.getDataOcorrencia()));
            statement.setString(5, multa.getStatusMulta());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir multa: " + e.getMessage(), e);
        }
    }

    public List<Multa> listar() {
        List<Multa> multas = new ArrayList<>();
        try {
            String sql = "CALL listar_multas();";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Multa multa = new Multa(
                    rs.getString("idMulta"),
                    rs.getString("motivo"),
                    rs.getDouble("valorMulta"),
                    rs.getDate("dataOcorrencia").toLocalDate(),
                    rs.getString("statusMulta")
                );
                multas.add(multa);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar multas: " + e.getMessage(), e);
        }
        return multas;
    }

    public Multa consultar(Integer idMulta) {
        Multa multa = null;
        try {
            String sql = "CALL consultar_multa(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idMulta);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                multa = new Multa(
                    rs.getString("idMulta"),
                    rs.getString("motivo"),
                    rs.getDouble("valorMulta"),
                    rs.getDate("dataOcorrencia").toLocalDate(),
                    rs.getString("statusMulta")
                );
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar multa: " + e.getMessage(), e);
        }
        return multa;
    }

    public void atualizar(Multa multa) {
        try {
            String sql = "CALL atualizar_multa(?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, multa.getIdMulta());
            statement.setString(2, multa.getMotivo());
            statement.setDouble(3, multa.getValorMulta());
            statement.setDate(4, java.sql.Date.valueOf(multa.getDataOcorrencia()));
            statement.setString(5, multa.getStatusMulta());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar multa: " + e.getMessage(), e);
        }
    }

    public void deletar(Integer idMulta) {
        try {
            String sql = "CALL deletar_multa(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idMulta);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar multa: " + e.getMessage(), e);
        }
    }
}
