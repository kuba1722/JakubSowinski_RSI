import aa.Pojazd;
import java.util.ArrayList;

public class Klient implements Print {

    String imie,nazwisko;
    static int id=0;
    ArrayList<Pojazd> lista=new ArrayList<>();

    public Klient(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        id ++;
    }

    @Override
    public void print() {
        System.out.println(imie +"\t"+ nazwisko+"\t"+  id+"\t"+ "ile wypozyczen:"+"\t"+ lista.size() +"\n");
    }
}



