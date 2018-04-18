import jade.core.Agent;
import jade.core.behaviours.*;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * This example shows the basic usage of JADE behaviours.<br>
 * More in details this agent executes a <code>CyclicBehaviour</code> that shows
 * a printout at each round and a generic behaviour that performs four successive
 * "dummy" operations. The second operation in particular involves adding a
 * <code>OneShotBehaviour</code>. When the generic behaviour completes the
 * agent terminates.
 * @author Giovanni Caire - TILAB
 */
public class SimpleAgent extends Agent {


//    protected void setup() {
//        System.out.println("Agent " + getLocalName() + " started.");
//        Scanner scan=new Scanner(System.in);
//        System.out.println("zaczynam zadanie");
//        addBehaviour(new ThreeStepBehaviour());

//        TickerBehaviour t1= new TickerBehaviour(this,2000) {
//            @Override
//            protected void onTick() {
//                System.out.println("mały tick");
//            }
//            public void stop() {
//                super.stop();
//            }
//        };
//        TickerBehaviour t2=new TickerBehaviour(this,5000) {
//            @Override
//            protected void onTick() {
//                System.out.println("duzy tick");
//            }
//
//        };

//        final int[] step1 = {0};
//
//        addBehaviour(new TickerBehaviour(this,2000) {
//            @Override
//
//            protected void onTick() {
//                step1[0]++;
//                System.out.println(step1[0]+"malytick");
//                if(step1[0]==50)
//                {
//                    this.stop();
//                    this.done();
//                }
//
//            }
//        });
//
//        int[] step2={0};
//
//        addBehaviour(new TickerBehaviour(this,5000) {
//            @Override
//
//            protected void onTick() {
//                step2[0]++;
//                System.out.println(step2[0]+"duzyick");
//                if(step2[0]==10)
//                {
//                    this.stop();
//                    this.done();
//                }
//            }
//        });
      //  addBehaviour(new ThreeStepBehaviour());

        protected void setup() {
            System.out.println("Agent "+getLocalName()+" started.");

            // Add the CyclicBehaviour
            addBehaviour(new OneShotBehaviour(this) {
                public void action() {
                    System.out.println("pierwsze ");
                }
            });

            // Add the generic behaviour
            addBehaviour(new FourStepBehaviour());
        }

        /**
         * Inner class FourStepBehaviour
         */
        private class FourStepBehaviour extends Behaviour {
            private int step = 1;

            public void action() {
                switch (step) {
                    case 1:
                        // Perform operation 1: print out a message
                       addBehaviour(new CyclicBehaviour() {
                           @Override
                           public void action() {
                               System.out.println("Cyclic");
                           }
                       });
                        break;
                    case 2:
                        // Perform operation 2: Add a OneShotBehaviour
                        System.out.println("Operation 2. Adding one-shot behaviour");
                        myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
                            public void action() {
                                System.out.println("One-shot");
                            }
                        });
                        break;

                }
                step++;
            }

            public boolean done() {
                return step == 14;
            }

            public int onEnd() {
                myAgent.doDelete();
                return super.onEnd();
            }
        }    // END of inner class FourS
  }

    /**
     * Inner class FourStepBehaviour
     */
//    private class ThreeStepBehaviour extends Behaviour {
//        public int step=1;
//        public boolean end=false;
//        Scanner scan=new Scanner(System.in);
//        public void action() {
//
//            step=scan.nextInt();
//
//            System.out.println(step);
//            if(step>0)
//                step=1;
//            else step=2;
//            switch (step) {
//                case 1:
//                    //addBehaviour(new ThreeStepBehaviour());
//                    System.out.println("Liczba poprawna");
//                    break;
//                case 2:
//                    end=true;
//                    System.out.println("koncze działanie");
//
//                    break;
//            }
//            }
//                public boolean done () {
//                    return end==true;
//                }
//
//                public int onEnd () {
//                    myAgent.doDelete();
//                    takeDown();
//                    return super.onEnd();
//                }



