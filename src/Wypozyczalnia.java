import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;

public class Wypozyczalnia implements Serializable {

    private String test;

    private void setTest(String s) {
        test = s;
    }

    private String getTest() {
        return test;
    }


    public static void main(String args[]) throws MyException, IOException, FileNotFoundException{
        PrintWriter zapis = new PrintWriter("ala.txt");

       Klient zbior1= null;
        ArrayList<Pojazd> mozna=new ArrayList<>();
        int pom = 0;
      try {
          do {
              System.out.println("Menu: \n1 - Dodaj klienta z serializacją i bez\n2 - Wyświetl pojazdy\n3 - Usuń pojazdy\n4 - Wyjscie\n5. Wypozycz pojazd dla klienta\n6. Dodaj pojazdy\n7. Odczyt klienta z pliku\n8. Pobierz dług i wpisz do klienta");

              Scanner scanner = new Scanner(System.in);
              pom = scanner.nextInt();
              int ileaut = 0;
              short rok = 214;
              switch (pom) {
                  case 1:
                      String imie = null, nazwisko = null;

                          System.out.println("Podaj imie klienta: ");
                          imie = scanner.nextLine();
                          imie = scanner.nextLine();
                          System.out.println("Podaj nazwisko klienta: ");
                          nazwisko = scanner.nextLine();
                      zapis.println(imie+"," +nazwisko);
                      zapis.close();
                      zbior1 = new Klient(imie, nazwisko,324234);
                      try {
                          ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("test.ser"));
                          o.writeObject(zbior1.imie);
                          o.close();
                          System.out.println("\n serializacja poprawna!\n");
                      } catch (Exception ex) {
                        System.out.println("bledny zapis");
                      }

                      try {
                          ObjectInputStream o = new ObjectInputStream(new FileInputStream("test.ser"));
                          String obj = (String) o.readObject(); // odczyt obiektu ze strumienia
                          o.close();
                          System.out.println("\n deserializacja poprawna!\n");
                          System.out.println(obj); // wyświetlamy zawartość pliku
                      } catch (Exception ex) {
                          ex.printStackTrace();
                      }
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
                  case 7://odczyt klienta z pliku
                      FileReader fileReader = new FileReader("Klient.txt");
                      BufferedReader bufferedReader = new BufferedReader(fileReader);

                      try {
                          String textLine = bufferedReader.readLine();
                          do {
                              System.out.println(textLine);

                              textLine = bufferedReader.readLine();
                          } while (textLine != null);
                      } finally {
                          bufferedReader.close();
                      }
                      break;

                  case 8: //pobierz i wypisz

                      String nazwaPliku = "Debt.txt";
                      double rating=0;
                      try {
                          BufferedReader br = new BufferedReader(new FileReader(nazwaPliku));
                          String linia = null;
                          while ((linia = br.readLine()) != null) {
                              double liczba = Double.parseDouble(linia.trim());
                              zbior1.money=liczba;
                              rating=liczba;
                          }
                      } catch (Exception e) {
                          System.err.println("Wystapil blad przy wczytywaniu danych");
                          e.printStackTrace();
                      }
                     zbior1.print();
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


