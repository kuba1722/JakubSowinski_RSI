
import jade.core.*;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.wrapper.ContainerController;

import java.time.LocalDate;

/**
 * This example shows the usage of the behaviours that allow scheduling actions
 * at a given point in time: <code>WakerBehaviour</code> and
 * <code>TickerBehaviour</code>.
 * More in details this agent executes a <code>TickerBehaviour</code>
 * that prints the agent name every second and a <code>WakerBehaviour</code> ]
 * that kill the agent after 10 seconds.
 * @author Giovanni Caire - TILAB
 */
public class TimeAgent extends Agent {

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
//        // Add the TickerBehaviour (period 1 sec)
//        addBehaviour(new TickerBehaviour(this, 1000) {
//            protected void onTick() {
//                System.out.println("Agent "+myAgent.getLocalName()+": tick="+getTickCount());
//            }
//        });

        // Add the WakerBehaviour (wakeup-time 10 secs)


        addBehaviour(new WakerBehaviour(this, 2000) {
            protected void handleElapsedTimeout() {
                System.out.println("Agent "+myAgent.getLocalName()+": 2 seconds It's wakeup-time. Bye...");
                AID remoteAMS = new AID("ams@169.254.74.4:1099/JADE", AID.ISGUID);
                remoteAMS.addAddresses("http://169.254.74.4:7778/acc");

                PlatformID destination = new PlatformID(remoteAMS);
                myAgent.doMove(destination);
                //  myAgent.doDelete();
            }
        });
    }
}