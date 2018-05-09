import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_2 extends Agent{
    protected void setup()
    {
        System.out.println("Staruje");

        addBehaviour(new OneShotBehaviour(this) {
            public void action() {
                System.out.println("wykonuje");
            }
        });
    }

    protected void takeDown() {
        System.out.println("zaraz sie usune");
    }
}
