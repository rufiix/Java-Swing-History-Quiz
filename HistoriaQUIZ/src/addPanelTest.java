import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class addPanelTest {
    private JFrame frame;
    //TEST NR 1:
    @Test
    void test_nr_1() {
        int numer = 1;
        MyButton tempbutton = new MyButton("nieistotne", numer, "nieistotne", "nieistotne");
        MyPanel testowybuttonPanel = new MyPanel(frame, 1);
        testowybuttonPanel.add(tempbutton, "nieistotne");
        MyButton tempbutton2 = testowybuttonPanel.getButton(0, testowybuttonPanel);
        assertEquals("Kiedy wybuchła pierwsza wojna światowa?", tempbutton2.getPytanie(numer-1));
        //ten test polegał na sprawdzeniu, czy do panelu odpowiednio dodawany jest przycisk
    }

    //TEST NR 2:
    @Test
    void test_nr_2() {
        int numer = 10;
        MyButton tempbutton = new MyButton("nieistotne", numer, "nieistotne", "nieistotne");
        MyPanel testowybuttonPanel = new MyPanel(frame,1);
        testowybuttonPanel.add(tempbutton, "nieistotne");
        MyButton tempbutton2 = testowybuttonPanel.getButton(0, testowybuttonPanel);
        assertEquals("Z jakiego kraju pochodzi cywilizacja Azteków?", tempbutton2.getPytanie(numer-1));
        //jest to ten sam test, tylko przeprowadzony na innym pytaniu
    }

    //TEST NR 3
    @Test
    void test_nr_3() {
        int numer = 25;
        MyButton tempbutton = new MyButton("nieistotne", numer, "nieistotne", "nieistotne");
        MyPanel testowybuttonPanel = new MyPanel(frame,1);
        testowybuttonPanel.add(tempbutton, "nieistotne");
        MyButton tempbutton2 = testowybuttonPanel.getButton(0,testowybuttonPanel);
        assertEquals("Kto namalował Śmierć Sokratesa?", tempbutton2.getPytanie(numer-1));
        //jest to ten sam test, tylko przeprowadzony na innym pytaniu
    }
}