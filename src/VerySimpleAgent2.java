
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class VerySimpleAgent2 extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");

    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
        System.out.println("Operacja 1");
      } 
    });
	
	addBehaviour(new CyclicBehaviour(this) {
      public void action() {
        System.out.println("operacja 2");
      } 
    });
	
	

    } 
 }
