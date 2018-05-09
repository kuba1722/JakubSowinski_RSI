import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import static java.lang.System.out;

public class Ag_pl extends Agent {
    private MessageTemplate template = MessageTemplate.MatchLanguage("Polski");
    protected void setup() {

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                //System.out.println(receive().getLanguage().toString());

                ACLMessage msg = myAgent.receive(template);
                if (msg != null) {
                        out.println("Message from agent " + msg.getSender().getName());
                        out.println("Countent " + msg.getContent());
                }
                else {
                    block();
                }
            }
        } );
    }
}
