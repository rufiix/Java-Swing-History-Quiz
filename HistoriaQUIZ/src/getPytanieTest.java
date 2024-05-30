import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class getPytanieTest {

    //TEST NR 1:
    @Test
    void test_nr_1() {
        int numer = 0;
        MyButton przyciskZZadaniem = new MyButton("Nieistotne_dla_testu", numer, "Nieistotne_dla_testu", "Nieistotne_dla_testu");
        assertEquals("Kiedy wybuchła pierwsza wojna światowa?", przyciskZZadaniem.getPytanie(numer));

        //ten test polegał na sprawdzeniu, czy do wyświetlenia użytkownikowi brane jest odpowiednie pytanie (o odpowiednim indeksie)
        //funkcja getPytanie utworzona została, by pomóc w teście tej funkcjonalności, zwraca ona bowiem treść pytania
        //o indeksie identycznym, jak ten przekazywany użytkownikowi.
    }

    //TEST NR 2:
    @Test
    void test_nr_2() {
        int numer = 13;
        MyButton przyciskZZadaniem = new MyButton("Nieistotne_dla_testu", numer, "Nieistotne_dla_testu", "Nieistotne_dla_testu");
        assertEquals("Którzy są najwcześniejszymi przodkami rdzennych Amerykanów?", przyciskZZadaniem.getPytanie(numer));

        //ten test przeprowadzany jest dla innego pytania, ale oparty jest na identycznym schemacie
    }

    //TEST NR 3
    @Test
    void test_nr_3() {
        int numer = -1;
        MyButton przyciskZZadaniem = new MyButton("Nieistotne_dla_testu", numer, "Nieistotne_dla_testu", "Nieistotne_dla_testu");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { przyciskZZadaniem.getPytanie(numer); });

        //ten test jest inny niż 2 poprzednie ponieważ sprawdza, co by się stało, gdyby do wyświetlenia został wybrany numer wykraczający
        //poza strefę indeksów tablicy zawierającej treści zadań
    }
}