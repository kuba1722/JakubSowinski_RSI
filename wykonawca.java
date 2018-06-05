import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.FIPAException;

public class wykonawca extends Agent{

    DFAgentDescription dfd;
    ServiceDescription sd;

    protected void setup() {
        super.setup();

        dfd = new DFAgentDescription();
        dfd.setName( getAID() );
        sd  = new ServiceDescription();
        sd.setType( "POTEGA" );
        sd.setName( getLocalName() );
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd );
        }
        catch (FIPAException e) { e.printStackTrace(); }


        MessageTemplate mt = MessageTemplate.MatchPerformative( ACLMessage.REQUEST);
        addBehaviour( new CyclicBehaviour()
        {
            public void action() {
                ACLMessage msg = blockingReceive(mt);

                if(msg!=null){
                    System.out.println("Wykonawca: Odebralem wiadomosc REQUEST:");
                    String message = msg.getContent();
                    System.out.println( "\t" + message);

                    Double number = Double.parseDouble(message);
                    if (message == null){
                        System.out.println("Wykonawca: Bledne dane");
                        AID sender = msg.getSender();
                        System.out.println("Wykonawca: Wysylam wiadomosc INFORM");
                        ACLMessage response = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
                        response.addReceiver(sender);
                        response.setContent("Error - wrong data");
                        send(response);
                    }
                    else if(number != null){
                        System.out.println("Wykonawca: Wczytana liczba: " + (number));
                        number*=number;
                        AID sender = msg.getSender();
                        System.out.println("Wykonawca: Wysylam wiadomosc INFORM: " + Double.toString(number));
                        ACLMessage response = new ACLMessage(ACLMessage.INFORM);
                        response.addReceiver(sender);
                        response.setContent(Double.toString(number));
                        send(response);
                    }
                }
                else{
                    block();
                }
            }
        });
    }
    private Double messageToDouble(String message) {
        Double number = null;

        int length = message.length();
        boolean dot = false;
        int j = 0;
        int dotAt = message.lastIndexOf('.');

        for(int i = 0; i<length; i++) {
            char charAt = message.charAt(i);
            if(charAt > 47 && charAt < 58){
                if(number == null){
                    number = 0.0;
                }
                if(!dot){
                    number += Math.pow(10, dotAt-1) * (charAt - 48);
                }
                else{
                    j++;
                    number += Math.pow(10, -j) * (charAt - 48);
                }
            }
            else if(charAt == 46){
                dot = true;
            }
            else {
                return null;
            }
        }
        return number;
    }
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {e.printStackTrace();}

    }
}
