import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class zlecajacy extends Agent{
    zlecajacy myAgent;
    Random generator;
    Integer number;

    protected void setup() {
        super.setup();

        myAgent = this;
        generator = new Random();
        number = null;
		/*
		a. Losowa� liczb� ca�kowit� z przedzia�u od 0 do 100.
		b. Co 20 sekund dowiadywa� si� w serwisie ��tych stron, kt�rzy agenci oferuj� serwis typu �POTEGA�.
		c. Je�li zwr�cono jakiegokolwiek agenta jako wynik przeszukiwania serwisu z punktu (b)
		   to wykonuje punkty (d), (e) i (f).
		d. Wysy�a do pierwszego agenta z tablicy wynik�w wiadomo�� typu REQUEST zawieraj�c� wylosowan� liczb�.
		e. Odbiera wiadomo�� typu INFORM i wypisuje jej tre�� na ekranie.
		f. Usuwa si�.
		*/
        addBehaviour(new OneShotBehaviour(this) {
            public void action() {
                System.out.println("Zlecajacy: Losuje liczbe");
                number = (int)(Math.round(generator.nextDouble()*100));
                System.out.println("\t"+number);
            }
        });
        FSMBehaviour fsm = new FSMBehaviour(this) {
            public int onEnd() {
                myAgent.doDelete();
                return super.onEnd();
            }
        };
        addBehaviour(new TickerBehaviour(this, 2000) {
            protected void onTick() {
                System.out.println("Zlecajacy: Sprawdzam uslugi");

                DFAgentDescription dfd = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType( "POTEGA" );
                dfd.addServices(sd);

                SearchConstraints ALL = new SearchConstraints();
                ALL.setMaxResults(new Long(-1));
                try
                {
                    DFAgentDescription[] result = DFService.search(myAgent, dfd, ALL);
                    System.out.println("Zlecajacy: Ilosc wyszukanych uslug: " + result.length);
                    if(result.length>0) {
                        send(result[0].getName());
                        recieve(this);
                    }
                }
                catch (FIPAException fe) { System.out.println("Zlecajacy: Wystapil problem przy wyszukaniu uslugi"); }
            }
        });
    }
    private void send(AID aid) {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(aid);
        msg.setContent(Integer.toString(number));
        send(msg);
        System.out.println("Zlecajacy: Wysylam wiadomosc REQUEST");
    }
    private void recieve(Behaviour b) {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage msg1 = blockingReceive(mt);
        if(msg1!= null) {
            if(msg1.getPerformative() == ACLMessage.INFORM){
                System.out.println("Zlecajacy: Odebralem wiadomosc INFORM");
                System.out.println( "\t" + msg1.getContent());
                myAgent.doDelete();
            }
        }
        else {
            b.block();
        }
    }
    protected void takeDown() {
        System.out.println("Zlecajacy: Koncze dzialanie");
    }
}
