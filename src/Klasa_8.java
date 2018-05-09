import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class Klasa_8 extends Agent {
    protected void setup()
    {
        System.out.println("Staruje");

        // Add the TickerBehaviour (period 1 sec)

        addBehaviour(new TickerBehaviour(this, 2000) {
            protected void onTick() {
                System.out.println("Agent "+myAgent.getLocalName()+": maly tick="+getTickCount()*2);
            }
        });

        addBehaviour(new WakerBehaviour(this, 100000) {
            protected void handleElapsedTimeout() {
                System.out.println("Agent "+myAgent.getLocalName()+": usuwam maly tick");
                myAgent.doDelete();
            }
        });
        Behaviour b = new TickerBehaviour(this, 5000) {
            protected void onTick() {
                System.out.println("Agent "+myAgent.getLocalName()+": duzy tick="+getTickCount()*5);
            }
        };
        addBehaviour(b);
        addBehaviour(new WakerBehaviour(this, 50000) {
            protected void handleElapsedTimeout() {
                System.out.println("Agent "+myAgent.getLocalName()+": usuwam duzy tick");
                removeBehaviour(b);
            }
        });
    }

    protected void takeDown() {
        System.out.println("zaraz sie usune");
    }
}
