package queues;

import javax.xml.ws.Endpoint;

public class QueuesServerPublisher {

  public static void main(String[] args)
  {
	  Object QueuesServerImpl =  new QueuesServerImpl() ;
      Endpoint.publish("http://notebook2:8080/queues", QueuesServerImpl );
  }
}
