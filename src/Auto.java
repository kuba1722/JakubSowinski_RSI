import aa.Pojazd;

public class Auto  extends Pojazd implements Print {


    Auto(String rej, short r, int prz, boolean czy, String mod, double sil ){

        rejestracja=rej;
        rok=r;
        przebieg=prz;
        czyWypozyczone=czy;
        model=mod;
        silnik=sil;

    }

    @Override
    public void print() {
        System.out.println("Auto: "+rejestracja +"\t"+ rok+"\t"+  przebieg+"\t"+ czyWypozyczone+"\t"+ model+"\t"+ silnik +"\n");
    }
}


