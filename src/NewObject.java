import java.util.InputMismatchException;
import java.util.Scanner;
import aa.Pojazd;
public class NewObject {

    public Pojazd Create() throws MyException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Auto\n2. Motor\n");
        int wybor=scanner.nextInt();


        if (wybor == 1) {

            Auto t=null;
            short rok;
            System.out.println("Podaj rok: ");

            String rej=null;
            try {
                rok=scanner.nextShort();
                rej ="ddsf";



            }
            catch(InputMismatchException e) {
                throw new MyException();
            }
            finally {
                System.out.println("Dodało auto!");
            }
            t= new Auto(rej,rok,24234,true,"dsfs",3.2);
            return t;

        } else if (wybor == 2) {

            Motocykl s =null;
            short rok;
            String rej=null;
            System.out.println("Podaj rok: ");

            try {
                rok=scanner.nextShort();
                rej ="ddsf";



            }
            catch(InputMismatchException e) {
                throw new MyException();
            }
            finally {
                System.out.println("Dodało auto!");
            }
            s=new Motocykl(rej,rok,24234,true,"dsfs",3.2);
            return s;

        }
        else {
            throw new MyException();
        }

    }

}


