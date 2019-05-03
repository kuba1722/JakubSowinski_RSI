public class Motocykl  extends Pojazd implements Print {


    Motocykl(String rej, short r, int prz, boolean czy, String mod, double sil ){

        rejestracja=rej;
        rok=r;
        przebieg=prz;
        czyWypozyczone=czy;
        model=mod;
        silnik=sil;

    }
    public void print() {
        System.out.println("Motor:  " +rejestracja +"\t"+ rok+"\t"+  przebieg+"\t"+ czyWypozyczone+"\t"+ model+"\t"+ silnik +"\n");
    }
}


