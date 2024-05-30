import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StatystykiTest {

    @Test
    public void testObliczLiczbeRozwiazanychZadan() {
        GUI gui = new GUI();
        assertEquals(24, gui.obliczLiczbeRozwiazanychZadan());
    }

    @Test
    public void testObliczLiczbePoprawnieRozwiazanychZadan() {
        GUI gui = new GUI();
        // Załóżmy, że pierwsze 10 zadań zostało poprawnie rozwiązanych
        assertEquals(10, gui.obliczLiczbePoprawnieRozwiazanychZadan());
    }

    @Test
    public void testObliczLiczbeNiepoprawnieRozwiazanychZadan() {
        GUI gui = new GUI();
        // Załóżmy, że pierwsze 10 zadań zostało poprawnie rozwiązanych
        assertEquals(14, gui.obliczLiczbeNiepoprawnieRozwiazanychZadan());
    }

    @Test
    public void testObliczProcentPoprawnieRozwiazanych() {
        GUI gui = new GUI();
        // Załóżmy, że pierwsze 10 zadań zostało poprawnie rozwiązanych
        assertEquals(41.67, gui.obliczProcentPoprawnieRozwiazanych(), 0.01);
    }

	@Test
public void testObliczSredniCzasRozwiazywaniaZadan() {
    GUI gui = new GUI();
    // Symulujemy czasy rozwiązania zadań
    int[] czasy = {10, 15, 20, 25, 30}; // Czasy w sekundach dla pięciu zadań
    for (int czas : czasy) {
        MyButton zadanie = new MyButton("Testowe zadanie", 0, "Testowa kategoria", "Łatwy");
        zadanie.setCzasRozwiazania(czas);
    }
    // Spodziewamy się średniego czasu 20 sekund dla tych pięciu zadań
    assertEquals(20, gui.obliczSredniCzasRozwiazywaniaZadan(), 0.01);
}

	
  }
