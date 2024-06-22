package queues;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.jws.WebService;

@WebService(endpointInterface = "queues.QueuesServer") 
public class QueuesServerImpl extends Conexao implements QueuesServer {

    public Response post(String queuename, String message) {
        try {
                conectarBanco();
        } catch (Exception e) {
            return new Response(0, e.getMessage());
          }           
            
        try {
            String sql = "INSERT INTO QueuePending (QueueName, Message) VALUES (?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, queuename);
            stmt.setString(2, message);
            stmt.execute();

            desconectarBanco();
            return new Response(1, "Sucesso");

        } catch (SQLException e) {
            desconectarBanco();
            return new Response(0, e.getMessage());
        }
    }
}