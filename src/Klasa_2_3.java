import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class Klasa_2_3 extends Agent {
    protected void setup() {
        System.out.println("My name is " + getLocalName());
        ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
        Behaviour a =new Klasa_2_3.FourStepBehaviour();
        Behaviour b =new Klasa_2_3.FourStepBehaviour();
        Behaviour c =new Klasa_2_3.FourStepBehaviour();
        addBehaviour(tbf.wrap(a));
        addBehaviour(tbf.wrap(b));
        addBehaviour(tbf.wrap(c));
    }

    private class FourStepBehaviour extends Behaviour {
        private int step = 1;

        public void action() {
            switch (step) {
                case 1:
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
                        public void action() {
                            System.out.println("pierwszy krok");
                        }
                    });
                    break;
                case 2:
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
                        public void action() {
                            System.out.println("drugi krok");
                        }
                    });
                    break;
                case 3:
                    Behaviour b = new OneShotBehaviour() {
                        @Override
                        public void action() {
                            System.out.println("trzeci krok");
                            removeBehaviour(this);
                        }
                    };
                    myAgent.addBehaviour(b);
                    break;
            }
            step++;
        }

        public boolean done() {
            return step == 4;
        }

    }
}
