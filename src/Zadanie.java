

public class Zadanie {



    static int Function_1(String s1, String s2){

        int count=0;

        for(int i=0; i<s1.length(); i++){

                char signOne = s1.charAt(i);
                char signTwo = s2.charAt(i);
                if(signOne != signTwo) count ++;
        }
       return count;
    }

    static int Function_2(int n, int k) {
        int z = 0;
        final int krolikiNaPoczatku = 2;
        final int tmp = krolikiNaPoczatku + k;
        if(n>=2) {
            if (tmp % 2 == 0) {
                int p;
                p = tmp;
                z = (p / krolikiNaPoczatku * k) + p;
                for (int i = 0; i < n - 2; i++) {
                    p = z;
                    z = (p / krolikiNaPoczatku * k) + p;
                }
            } else {
                int p;
                p = tmp;
                z = ((p - 1) / krolikiNaPoczatku) * k + p;
                for (int i = 0; i < n - 2; i++) {
                    p = z;
                    if (p % 2 == 0) {
                        z = (p / krolikiNaPoczatku * k) + p;
                    } else {

                        z = ((p - 1) / krolikiNaPoczatku) * k + p;
                    }
                }
            }
        }else z=tmp;

      return z;
    }

    static class Iteracja {
        int wszystkieSamce;
        int urodzoneSamce;
        int wszystkieSamice;
        int urodzoneSamice;
    }
    static int Function_3(int n, int k, int m){

        Iteracja[] iteracje = new Iteracja[n+1];
        Iteracja stanWyjsciowy = new Iteracja();
        stanWyjsciowy.wszystkieSamce = 1;
        stanWyjsciowy. wszystkieSamice =1;
        stanWyjsciowy.urodzoneSamce =1;
        stanWyjsciowy.urodzoneSamice =1;
        iteracje [0] = stanWyjsciowy;

        for(int i=1; i<=n; ++i) {
            Iteracja nowaIteracja = new Iteracja();
            Iteracja poprzedniaIteracja = iteracje[i-1];
            int ilePar = Math.min(poprzedniaIteracja.wszystkieSamce, poprzedniaIteracja.wszystkieSamice);
            int urodzoneKroliki = ilePar*k;
            for(int numerUrodzonegoKrolika=0; numerUrodzonegoKrolika<urodzoneKroliki; numerUrodzonegoKrolika++){
                //Math.random();//zwraca losowa liczbe, liczba w zakresie 0-1
                double los = Math.random();
                if(los<0.5){
                    nowaIteracja.urodzoneSamce++;
                }
                else{
                    nowaIteracja.urodzoneSamice++;
                }
            }
            int zdechleSamce =0;
            int zdechleSamice =0;
            int dzienZdechleKroliki= i-m;
            if(dzienZdechleKroliki>=0){
                Iteracja historyczna = iteracje[dzienZdechleKroliki];
                zdechleSamce = historyczna.urodzoneSamce;
                zdechleSamice = historyczna.urodzoneSamice;
            }
            nowaIteracja.wszystkieSamce = poprzedniaIteracja.wszystkieSamce + nowaIteracja.urodzoneSamce - zdechleSamce;
            nowaIteracja.wszystkieSamice = poprzedniaIteracja.wszystkieSamice + nowaIteracja.urodzoneSamice - zdechleSamice;

            iteracje[ i ] = nowaIteracja;
        }
        Iteracja ostatniaIteracja = iteracje[n];
        return ostatniaIteracja.wszystkieSamce + ostatniaIteracja.wszystkieSamice;
    }

    public static void main(String[] args){

        System.out.println(Function_1("ATGGACAATTAA","ATGCACAATTTG"));
        System.out.println(Function_2(3,2));
        System.out.println(Function_3(3,2, 2));





    }
}
