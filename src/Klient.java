import java.util.ArrayList;

public class Klient implements Print {

    String imie,nazwisko;
    double money=0;
    static int id=0;
    ArrayList<Pojazd> lista=new ArrayList<>();

    public Klient(String imie, String nazwisko, double money) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        id ++;
        this.money=money;
    }

    @Override
    public void print() {
        System.out.println(imie +"\t"+ nazwisko+"\t"+  id+"\t"+ "ile wypozyczen:"+"\t"+ lista.size() +"\n"+money+" tyle dłużny\n");
    }
}



