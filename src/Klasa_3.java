import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Klasa_3 extends Agent {
    protected void setup()
    {
        System.out.println("Staruje");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                System.out.println("pierwszy krok ");
            }
        });
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                System.out.println("drugi krok ");
            }
        });
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                System.out.println("trzeci krok ");
            }
        });
    }

    protected void takeDown() {
        System.out.println("zaraz sie usune");
    }
}
