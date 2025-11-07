package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        public static class postgreSQLconnection{
        final String pgUsuario = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/TartarugaCometa";
        final String senha = "1234";

        public Connection connect() {
            Connection connection = null;
            try{    
                connection = DriverManager.getConnection(url, pgUsuario, senha);
                System.out.println("Conexão bem sucedida!");
                connection.close();
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
            return connection;
            }
        }
    public static void main(String[] args) {
        postgreSQLconnection conexao = new postgreSQLconnection();
        Connection connection = conexao.connect();
    }
}
