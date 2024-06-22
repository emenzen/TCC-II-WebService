package queues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    protected Connection conexao;

    protected void conectarBanco() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "M@mig@23";
        conexao = DriverManager.getConnection(url, username, password);
    }

    protected void desconectarBanco() {
        try {
            conexao.close();
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
}