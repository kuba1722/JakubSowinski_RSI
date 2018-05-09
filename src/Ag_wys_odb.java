import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class Ag_wys_odb extends Agent {

    Random r;
    protected void setup() {
        System.out.println("Hello World! My name is "+getLocalName());
        addBehaviour(new CyclicBehaviour(this) {
        public void action() {
            r = new Random();
            int stan = r.nextInt(2);
            System.out.println(stan);
            if (stan == 0 ) {
                ACLMessage m = new ACLMessage(ACLMessage.CFP);
                m.addReceiver(new AID("Ala", AID.ISLOCALNAME));
                m.setOntology("presence");
                m.setContent("alive");
                send(m);
            }else{
                ACLMessage m = new ACLMessage(ACLMessage.REQUEST);
                m.addReceiver(new AID("Ala", AID.ISLOCALNAME));
                m.setOntology("presence");
                m.setContent("HELP");
                send(m);
            }
            //addBehaviour(new OneShotBehaviour(this) {

                    ACLMessage msg = myAgent.receive();
                    if (msg != null) {
                        System.out.println("Message "+msg.getContent());
                        if (msg.getPerformative() == 7){
                            myAgent.doDelete();
                        }
                    }else {
                        block();
                    }
        }
        });
    }
}
