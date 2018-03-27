

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import aa.Pojazd;

public class Wypozyczalnia {

    public static void main(String args[]) {

       Klient zbior1= null;
        ArrayList<Pojazd> mozna=new ArrayList<>();
        int pom = 0;
      try {
          do {
              System.out.println("Menu: \n1 - Dodaj klienta(moze byc tylko 1)\n2 - Wyświetl pojazdy\n3 - Usuń pojazdy\n4 - Wyjscie\n5. Wypozycz pojazd dla klienta\n6. Dodaj pojazdy");

              Scanner scanner = new Scanner(System.in);
              pom = scanner.nextInt();
              int ileaut = 0;
              short rok = 214;
              switch (pom) {
                  case 1:
                      String imie = null, nazwisko = null;
                      try {
                          System.out.println("Podaj imie klienta: ");
                          imie = scanner.nextLine();

                          System.out.println("Podaj nazwisko klienta: ");
                          nazwisko = scanner.nextLine();
                          throw (new InputMismatchException());
                      } catch (InputMismatchException e) {
                          System.err.println("złe dane");
                      }
                      zbior1 = new Klient(imie, nazwisko);
                      break;
                  case 2:

                      Iterator<Pojazd> ite = mozna.iterator();
                      for (int i = 0; i < mozna.size(); i++)

                          ite.next().print();
                      break;
                  case 3:

                      mozna.remove(ileaut - 1);
                      ileaut--;
                      break;

                  case 4:
                      System.out.println("Zamykanie");
                      break;
                  case 6:
                      try { // NewObject obj=null;
                          mozna.add(new NewObject().Create());
                      } catch (MyException e) {
                          e.printStackTrace();
                      }
                      ileaut++;
                      break;
                  case 5:
                      System.out.println("Jaki pojazd?");
                      Iterator<Pojazd> it = mozna.iterator();
                      for (int i = 0; i < mozna.size(); i++)

                          it.next().print();
                      int ktore = scanner.nextInt();
                      ktore = ktore - 1;
                      Pojazd p = mozna.get(ktore);
                      p.czyWypozyczone = true;
                      mozna.remove(ktore);
                      mozna.add(ktore, p);
                      zbior1.lista.add(mozna.get(ktore));
                      break;
                  default:
                      System.out.println("Nie ma takiej opcji");
              }


          } while (pom != 4);
      }
      catch(InputMismatchException e)
      {
          new MyException().wypisz();
      }


    }

}


