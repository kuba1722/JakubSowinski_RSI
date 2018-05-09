import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Random;

public class Klasa_1_2 extends Agent {

    protected void setup() {
        System.out.println("My name is " + getLocalName());
        addBehaviour(new Klasa_1_2.FourStepBehaviour());
    }

    private class FourStepBehaviour extends Behaviour {
         int step = 1;
         int stan = 0;
        Random r;
        public void action() {
            switch (step) {
                case 1:
                            stan = 0;
                            System.out.println("A - " + stan);
                        //    step++;
                    break;
                case 2:
                            r = new Random();
                            stan = r.nextInt(2);
                            System.out.println("B - " + stan);
                            if(stan == 0){
                                step = 3;
                            }
                          //  ++step;
                    break;
                case 3:
                            System.out.println("C - " + stan);
                           // ++step;
                    break;
                case 4:
                            r = new Random();
                            stan = r.nextInt(2);
                            System.out.println("D - " + stan);
                            if(stan == 1){
                                step = 0;
                            }
                           // ++step;
                    break;
                case 5:
                    System.out.println("E - " + stan);
                    // ++step;
                    break;
            }
            step++;
        }

        public boolean done() {
            return step == 6;
        }
//        public int onEnd() {
//            myAgent.doDelete();
//            return super.onEnd();
//        }
    }




//    protected void setup() {
//        System.out.println("My name is " + getLocalName());
//        addBehaviour(new Klasa_1_2.FourStepBehaviour());
//    }
//
//    private class FourStepBehaviour extends Behaviour {
//         int step = 1;
//         int stan = 0;
//        public void action() {
//            switch (step) {
//                case 1:
//                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//                        public void action() {
//                            stan = 0;
//                            System.out.println("A - " + stan);
//                            ++step;
//
//                        }
//                    });
//                    break;
//                case 2:
//                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//                        public void action() {
//                            Random r = new Random();
//                            int stan = r.nextInt(2);
//                            System.out.println("B - " + stan);
//                            if(stan == 0){
//                                step = 3;
//                            }
//                            ++step;
//                        }
//                    });
//                    break;
//                case 3:
//                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//                        public void action() {
//                            System.out.println("C - " + stan);
//                            ++step;
//                        }
//                    });
//                    break;
//                case 4:
//                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//                        public void action() {
//                            Random r = new Random();
//                            int stan = r.nextInt(2);
//                            System.out.println("D - " + stan);
//                            if(stan == 1){
//                                step = 0;
//                            }
//                            ++step;
//                        }
//                    });
//                    break;
//            }
//          //  step++;
//        }
//
//        public boolean done() {
//            return step == 10;
//        }
////        public int onEnd() {
////            myAgent.doDelete();
////            return super.onEnd();
////        }
//    }
}
