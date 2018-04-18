import jade.core.*;
import jade.domain.AMSEventQueueFeeder;
import jade.lang.acl.ACLMessage;
import jade.security.Credentials;
import jade.security.JADEPrincipal;
import jade.security.JADESecurityException;
import jade.util.leap.List;
import jade.wrapper.StaleProxyException;

/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 This example shows a minimal agent that just prints "Hallo World!"
 and then terminates.
 @author Giovanni Caire - TILAB
 */

public class HelloWorldAgent extends Agent {

    String myAgent = "null";

    protected void setup() {
        myAgent = getLocalName();
        main();
        // Make this agent terminate

    }

    public void main() {
        System.out.println("Hello World! My name is " + myAgent);
    }
}
