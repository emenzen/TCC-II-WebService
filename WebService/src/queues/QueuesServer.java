package queues;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface QueuesServer {
  @WebMethod Response post(@WebParam(name = "queuename") String queuename, @WebParam(name = "message") String message);
}