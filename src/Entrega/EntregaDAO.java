package Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.ConnectionFactory;

public class EntregaDAO {

    private static final String INSERT_SQL =
        "INSERT INTO entrega (id_cliente, data_entrega, status) VALUES (?, ?, ?) RETURNING id_entrega";

    public int salvarEntrega(Entrega entrega) {
        int idEntrega = 0;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
             
            ps.setInt(1, entrega.getIdCliente()); // Assumindo que Entrega tem um método getIdCliente()
            ps.setDate(2, java.sql.Date.valueOf(entrega.getDataEntrega())); // Assumindo que data_entrega é do tipo Date
            ps.setString(3, entrega.getStatus()); // Assumindo que Entrega tem um método getStatus()
             
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEntrega = rs.getInt("id_entrega");
            }
            System.out.println("Entrega salva com sucesso.");

            return idEntrega;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar entrega", e);
        }
    }
}
