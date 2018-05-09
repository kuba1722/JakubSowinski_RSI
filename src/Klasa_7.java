import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_7 extends Agent {
    protected void setup() {
        System.out.println("My name is " + getLocalName());
        addBehaviour(new OneShotBehaviour(this) {
            public void action() {
                System.out.println("Pierwsze");
            }
        });
        addBehaviour(new Klasa_7.FourStepBehaviour());
    }

    private class FourStepBehaviour extends Behaviour {
        private int step = 1;

        public void action() {
            switch (step) {
                case 1:
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
                        public void action() {
                            System.out.println("drugie");
                        }
                    });
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
