import java.lang.reflect.Array;
import java.util.*;
import java.lang.Math.*;

class Auto{
    String rejestracja;
    short rok;
    int przebieg;
    boolean czyWypozyczone;
    String model;
    double silnik;

    Auto(String rej, short r, int prz, boolean czy, String mod, double sil ){

        rejestracja=rej;
        rok=r;
        przebieg=prz;
        czyWypozyczone=czy;
        model=mod;
        silnik=sil;

    }

    void wypisz()
    {
        System.out.println(rejestracja +"\t"+ rok+"\t"+  przebieg+"\t"+ czyWypozyczone+"\t"+ model+"\t"+ silnik +"\n");
    }
}
public class Wypozyczalnia {

    public static void main(String args[]) {

        ArrayList<Auto> zbior1= new ArrayList<Auto>();
        int ileaut=0;
        int pom = 0;
        do {
            System.out.println("Menu: \n1 - Dodaj auto\n2 - Wyświetl auta\n3 - Usuń auto\n4 - Wyjscie");

                Scanner scanner = new Scanner(System.in);
                pom = scanner.nextInt();

                switch (pom) {
                    case 1:

                            short rok=2014;
                           zbior1.add(new Auto("sdfsdf",rok,45484,true,"sdf",2.2));
                           ileaut++;

                        break;
                    case 2:
                        Iterator <Auto> ite = zbior1.iterator();
                        for(int i=0; i<zbior1.size();i++)

                            ite.next().wypisz();

                        break;
                    case 3:

                        zbior1.remove(ileaut-1);
                        ileaut--;
                        break;

                    case 4:
                        System.out.println("Zamykanie");
                        break;

                    default:
                        System.out.println("Nie ma takiej opcji");
                }


                if(ileaut==0)
                {
                    System.out.println("Brak aut, koniec programu!");
                    break;
                }
                else{
                    continue;
                }
        } while (pom != 4);


    }

}