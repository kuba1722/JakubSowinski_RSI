import jade.core.Agent;

public class HelloAgent extends Agent
{
    protected void setup()
        {
        Object[] args = getArguments();


            String arg1 = args[0].toString();
            int foo = Integer.parseInt(arg1);
        System.out.println("Podales cyfre "+ foo);
        for (int i = 0; i < foo; i++) {
            System.out.println("Hello World. " );
            System.out.println("My name is " + getLocalName() + "my id " + getAID().getName());
        }

    }
}