import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Wypozyczalnia {

    public static void main(String args[]) {

       Klient zbior1= null;
        ArrayList<Pojazd> mozna=new ArrayList<>();
        int pom = 0;
        do {
            System.out.println("Menu: \n1 - Dodaj klienta(moze byc tylko 1)\n2 - Wyświetl pojazdy\n3 - Usuń pojazdy\n4 - Wyjscie\n5. Wypozycz pojazd dla klienta\n6. Dodaj pojazdy" );

            Scanner scanner = new Scanner(System.in);
            pom = scanner.nextInt();
            int ileaut=0;

            switch (pom) {
                case 1:

                    short rok=2014;
                    zbior1= new Klient("sdfsdf","sdf");


                    break;
                case 2:

                    Iterator<Pojazd> ite = mozna.iterator();
                    for(int i=0; i<mozna.size();i++)

                        ite.next().print();
                    break;
                case 3:

                    mozna.remove(ileaut-1);
                    ileaut--;
                    break;

                case 4:
                    System.out.println("Zamykanie");
                    break;
                case 6:
                    System.out.println("Jaki pojazd?\n Motocykl - 1 , Auto - 2 \n");
                    int ch=scanner.nextInt();
                    if( ch==1) {
                        rok=34;
                        mozna.add(new Motocykl("eyt456",rok,454,false,"yamaha",4.6));
                        System.out.println("Motocykl zostal dodany");
                    }
                    else {
                         rok=4353;
                        mozna.add(new Auto("sdfs6",rok,45484,false,"toyota",2.2));
                        System.out.println("Auto zostalo dodane");
                    }
                ileaut++;
                    break;
                case 5:
                    System.out.println("Jaki pojazd?");
                    Iterator<Pojazd> it = mozna.iterator();
                    for(int i=0; i<mozna.size();i++)

                        it.next().print();
                    int ktore=scanner.nextInt();
                    ktore=ktore-1;
                    Pojazd p= mozna.get(ktore);
                    p.czyWypozyczone=true;
                    mozna.remove(ktore);
                    mozna.add(ktore,p);
                    zbior1.lista.add(mozna.get(ktore));
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }



        } while (pom != 4);


    }

}


