import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class Klasa_2_5 extends Agent {
    protected void setup() {
        System.out.println("My name is " + getLocalName());
        ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
        Behaviour a =new CyclicBehaviour(this) {
            public void action() {
                System.out.println("operacja 1");
            }
        };
        Behaviour b =new CyclicBehaviour(this) {
            public void action() {
                System.out.println("operacja 2");
            }
        };

        addBehaviour(tbf.wrap(a));
        addBehaviour(tbf.wrap(b));

    }
}
