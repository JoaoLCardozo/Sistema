package Cliente;

import java.sql.Connection;
import java.sql.SQLException;

import DataBase.ConnectionFactory;

public class ClienteDAO {

    

    public void salvarCliente(Cliente cliente) throws SQLException{
        String INSERT_SQL = "INSERT INTO cliente (nomeRazao, documento, tpDocumento, endereco) VALUES (?,?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection()){
            

//logica do insert


        };
            
    }
    
}
