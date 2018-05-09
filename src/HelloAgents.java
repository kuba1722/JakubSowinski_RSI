import jade.core.Agent;

public class HelloAgents extends Agent {
    public static void main ()
    {
        System.out.println("to jest metoda main" );
    }
    protected void setup()
    {
        System.out.println("Agent - " + getLocalName());
        main();
    }
}
