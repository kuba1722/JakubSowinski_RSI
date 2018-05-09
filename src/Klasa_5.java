import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;

import java.util.Scanner;

public class Klasa_5 extends Agent {
    int value = 0;
    protected void setup() {

        Behaviour b = new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("Podaj liczbe");
                Scanner odczyt = new Scanner(System.in);

                value = odczyt.nextInt();

                System.out.println("Liczba "+value);
                if (value < 0){
                myAgent.removeBehaviour(this);}
            }

        };
        addBehaviour(b);

    }
}
