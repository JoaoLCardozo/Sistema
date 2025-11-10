package Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.ConnectionFactory;

public class MercadoriaDAO {

    private static final String INSERT_SQL = "INSERT INTO mercadoria (nome, peso, preco, volume, quantidade) VALUES (?,?,?,?,?) RETURNING id_entrega";

    public int salvarMercadoria(Mercadoria mercadoria){
        int idProduto = 0;
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                ps.setString(1, mercadoria.getNome());
                ps.setDouble(2, mercadoria.getPeso());
                ps.setDouble(3, mercadoria.getPreco());
                ps.setDouble(4, mercadoria.getVolume());
                ps.setInt(5, mercadoria.getQuantidade());

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    idProduto = rs.getInt("id_mercadoria");
                }
                
                System.out.println("Mercadoria salva com sucesso.");
                return idProduto;

            } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar endereço", e);
            }
    }
}
