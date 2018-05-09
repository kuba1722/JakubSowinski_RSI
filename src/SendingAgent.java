import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.*;

public class SendingAgent extends Agent {

  protected void setup() {
  	System.out.println("Hello World! My name is "+getLocalName());
	
	ACLMessage m = new ACLMessage(ACLMessage.REQUEST);
	m.addReceiver(new AID("x", AID.ISLOCALNAME));
	m.setOntology("presence");
	m.setContent("alive");
	m.setLanguage("Polski");
	send(m);
  } 
}

