import java.util.List;

public class ZadaniaManager {
    private List<MyButton> zadania;
    private int liczba_zadan;

    public ZadaniaManager(List<MyButton> zadania) {
        this.zadania = zadania;
        this.liczba_zadan = zadania.size();
    }

    public int obliczLiczbeRozwiazanychZadan() {
        return liczba_zadan;
    }

    public int obliczLiczbePoprawnieRozwiazanychZadan() {
        int count = 0;
        for (MyButton button : zadania) {
            if (button.czyRozwiazanoPoprawnie()) {
                count++;
            }
        }
        return count;
    }

    public int obliczLiczbeNiepoprawnieRozwiazanychZadan() {
        int count = 0;
        for (MyButton button : zadania) {
            if (!button.czyRozwiazanoPoprawnie()) {
                count++;
            }
        }
        return count;
    }

    public double obliczProcentPoprawnieRozwiazanych() {
        if (liczba_zadan == 0) return 0;
        int poprawnieRozwiazane = obliczLiczbePoprawnieRozwiazanychZadan();
        return (double) poprawnieRozwiazane / liczba_zadan * 100;
    }

    public double obliczSredniCzasRozwiazywaniaZadan() {
        double calkowityCzas = 0;
        int calkowitaLiczbaZadan = 0;
        for (MyButton button : zadania) {
            if (button.czyRozwiazano()) {
                calkowityCzas += button.getCzasRozwiazania();
                calkowitaLiczbaZadan++;
            }
        }
        if (calkowitaLiczbaZadan == 0) return 0;
        return calkowityCzas / calkowitaLiczbaZadan;
    }
}
