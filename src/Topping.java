public class Topping {

    public String navn;
    public int pris = 10;

    public Topping(String navn) {

        this.navn = navn;

    }


    public String getNavn() {
        return navn;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Navn" + navn + "Pris" + pris;
    }


        private String navn;
        private final int pris = 10;
    public Topping(String navn) {
            this.navn = navn;
        }
        public int getpris () {
            return;
            pris;
        }
    }
