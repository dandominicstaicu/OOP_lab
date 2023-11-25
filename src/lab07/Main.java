package lab07;

import java.util.*;

interface Visitable {
    public float accept(Visitor visitor);
}

interface Visitor {
    public float visit(Ciocolata ciocolata);

    public float visit(Suc suc);

    public float visit(Fruct fruct);

    // TODO 2: Adaugati metoda visit() pentru legume
    public float visit(Leguma leguma);
}

class Fruct implements Visitable {
    private float pretKilogram;
    private float greutate;
    private String nume;

    // TODO 1: implementati metoda accept()

    @Override
    public float accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Fruct(float pretKilogram, float greutate, String nume) {
        this.pretKilogram = pretKilogram;
        this.greutate = greutate;
        this.nume = nume;
    }

    // TODO 1: adaugati getteri si setteri pt fiecare camp

    public float getPretKilogram() {
        return pretKilogram;
    }

    public void setPretKilogram(float pretKilogram) {
        this.pretKilogram = pretKilogram;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

class Ciocolata implements Visitable {
    private float pretBucata;
    private int nrBucati;
    private float reducere;
    private String nume;

    // TODO 1: implementati metoda accept()
    @Override
    public float accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Ciocolata(float pretBucata, int nrBucati, float reducere, String nume) {
        this.pretBucata = pretBucata;
        this.nrBucati = nrBucati;
        this.reducere = reducere;
        this.nume = nume;
    }

    // TODO 1: adaugati getteri si setteri pt fiecare camp

    public float getPretBucata() {
        return pretBucata;
    }

    public void setPretBucata(float pretBucata) {
        this.pretBucata = pretBucata;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati) {
        this.nrBucati = nrBucati;
    }

    public float getReducere() {
        return reducere;
    }

    public void setReducere(float reducere) {
        this.reducere = reducere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

class Suc implements Visitable {
    private float pretBucata;
    private int nrBucati;
    private float reducere;
    private String nume;

    // TODO 1: implementati metoda accept()
    @Override
    public float accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Suc(float pretBucata, int nrBucati, float reducere, String nume) {
        this.pretBucata = pretBucata;
        this.nrBucati = nrBucati;
        this.reducere = reducere;
        this.nume = nume;
    }

    // TODO 1: adaugati getteri si setteri pt fiecare camp

    public float getPretBucata() {
        return pretBucata;
    }

    public void setPretBucata(float pretBucata) {
        this.pretBucata = pretBucata;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati) {
        this.nrBucati = nrBucati;
    }

    public float getReducere() {
        return reducere;
    }

    public void setReducere(float reducere) {
        this.reducere = reducere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

class Leguma implements Visitable {
    private float pret;
    private float greutate;
    private int nrBucati;
    private String nume;

    @Override
    public float accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Leguma(float pret, float greutate, int nrBucati, String name) {
        this.pret = pret;
        this.greutate = greutate;
        this.nrBucati = nrBucati;
        this.nume = name;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati) {
        this.nrBucati = nrBucati;
    }
}

class CalculatorPret implements Visitor {

    // TODO 1: implementati metodele din interfata Visitor
    @Override
    public float visit(Ciocolata ciocolata) {
        float pretTotal = ciocolata.getPretBucata() * ciocolata.getNrBucati();

        if (ciocolata.getNrBucati() >= 5) {
            pretTotal -= pretTotal * ciocolata.getReducere(); // Reducerea în funcție de brand
        }

        if ("Milka".equals(ciocolata.getNume())) {
            pretTotal -= 0.50f * ciocolata.getNrBucati(); // Reducere suplimentară pentru Milka
        }

        System.out.println(ciocolata.getNrBucati() + " bucati ciocolata " + ciocolata.getNume() + " costa " + pretTotal + " lei.");

        return pretTotal;
    }

    @Override
    public float visit(Suc suc) {
        float pretTotal = suc.getPretBucata() * suc.getNrBucati();
        int nrBaxuri = suc.getNrBucati() / 10;
        pretTotal -= nrBaxuri * pretTotal * suc.getReducere();

        System.out.println(suc.getNrBucati() + " sticle de " + suc.getNume() + " costa " + pretTotal + " lei.");

        return pretTotal;
    }

    @Override
    public float visit(Fruct fruct) {
        float cost = fruct.getPretKilogram() * fruct.getGreutate();
        System.out.println(fruct.getGreutate() + " kg de " + fruct.getNume() + " costa " + cost + " lei.");
        return cost;
    }


    // TODO 2: implementati visit() pt noua clasa adaugata
    @Override
    public float visit(Leguma leguma) {
        float pretTotal = leguma.getPret() * leguma.getGreutate();
        pretTotal -= pretTotal * ((float) leguma.getNrBucati() / 4.0f) / 100.0f;

        System.out.println(leguma.getGreutate() + " kg de " + leguma.getNume() + " costa " + pretTotal + " lei.");
        return pretTotal;
    }
}

class CalculatorReducere implements Visitor {
    // TODO 2: implementati metodele din interfata Visitor

    @Override
    public float visit(Ciocolata ciocolata) {
        float reducereTotala = 0;

        if (ciocolata.getNrBucati() >= 5) {
            reducereTotala += ciocolata.getPretBucata() * ciocolata.getNrBucati() * ciocolata.getReducere();
        }

        if ("Milka".equals(ciocolata.getNume())) {
            reducereTotala += 0.50f * ciocolata.getNrBucati();
        }

        if (reducereTotala > 0) {
            System.out.println("Am economisit pe ciocolata " + reducereTotala + " lei.");
        }

        return reducereTotala;
    }

    @Override
    public float visit(Suc suc) {
        float total = suc.getPretBucata() * suc.getNrBucati();
        int nrBax = suc.getNrBucati() / 10;
        float reducere = nrBax * total * suc.getReducere();

        if (reducere > 0) {
            System.out.println("Am economisit pe suc " + reducere + " lei.");
        }

        return reducere;
    }

    @Override
    public float visit(Fruct fruct) {
        return 0;
    }

    @Override
    public float visit(Leguma leguma) {
        float pretTotal = leguma.getPret() * leguma.getGreutate();
        float reducere = (leguma.getNrBucati() / 4.0f) / 100.0f;
        float eco = pretTotal * reducere;

        if (reducere > 0) {
            System.out.println("Am economisit pe " + leguma.getNume() + " " + eco + " lei.");
        }
        return eco;
    }

}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();

        List<Visitable> listaCumparaturi = new ArrayList<>();
        listaCumparaturi.add(new Fruct(2.5f, 5f, "banane"));
        listaCumparaturi.add(new Fruct(1.25f, 1.5f, "mere"));
        listaCumparaturi.add(new Ciocolata(7f, 3, 0.3f, "Milka"));
        listaCumparaturi.add(new Ciocolata(3f, 6, 0.15f, "Heidi"));
        listaCumparaturi.add(new Suc(4.75f, 25, 0.05f, "Tymbark"));
        listaCumparaturi.add(new Suc(5f, 10, 0.1f, "Pepsi"));
        // TODO 2: decomentati codul pentru rezolvarea task-ului 2
        List<Visitable> listaCumparaturi2 = new ArrayList<>(listaCumparaturi);
        listaCumparaturi2.add(new Leguma(3.49f, 2.6f, 40, "rosii"));
        listaCumparaturi2.add(new Leguma(2.3f, 1.3f, 20, "morcovi"));
        listaCumparaturi2.add(new Leguma(5.1f, 0.5f, 5, "ciuperci"));


        float total = 0;
        float reducere = 0;

        switch (task) {
            case 1:
                // TODO 1: instantiati obiectul visitor si calculati pretul total
                CalculatorPret calculatorPret = new CalculatorPret();
                for (Visitable item : listaCumparaturi) {
                    float cost = item.accept(calculatorPret);
                    total += cost;

                }


                System.out.println("\nTotal cheltuit: " + total + " lei.");
                break;
            case 2:
                // TODO 2: instantiati obiectul visitor si calculati reducerea totala
                CalculatorPret calculatorPretRed = new CalculatorPret();
                CalculatorReducere calculatorReducere = new CalculatorReducere();
                for (Visitable item : listaCumparaturi2) {
                    total += item.accept(calculatorPretRed);
                    reducere += item.accept(calculatorReducere);
                }

                System.out.println("\nTotal cheltuit: " + total + " lei.");
                System.out.println("Total economisit: " + reducere + " lei.");
                break;
            default:
                System.out.println("Enter a valid task number!");
                break;
        }
    }
}