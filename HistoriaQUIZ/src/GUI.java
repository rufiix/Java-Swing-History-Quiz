import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

//funkcja odpowiedzialna za całokształt interfejsu użytkownika

public class GUI {
    private JFrame window;
    static private JPanel glownyPanel;
    private MyPanel panelStartowy;
    private int liczba_zadan;
    private MyButton [] zadania;
    private ButtonTypeC powrot;
    private JPanel buttonPanel;
    private JScrollPane scrollpane;
    private Rectangle r;

    String [] kategorie = {
            "historia światowa",
            "historia Persji",
            "historia Chin",
            "historia USA",
            "historia nowożytna",
            "historia USA",
            "historia starożytnego Rzymu",
            "historia sportu",
            "historia Japonii",
            "historia prekolumbijska",
            "literatura rzymska",
            "historia pokoju",
            "odkrycia geograficzne",
            "historia Amerykanów",
            "archeologia",
            "historia Francji",
            "historia religii",
            "astronautyka",
            "historia Korei",
            "historia starożytnego Egiptu",
            "historia technologii",
            "wynalazki",
            "historia Peru",
            "historia starożytnego Rzymu",
            "sztuka"
    };

    String[] poziomyTrudnosci = {
            "łatwy", "średni", "trudny"
    };

    private JLabel tekstGorny;
    private int width;
    private int height;


    public GUI() {
        inicjalizuj();
    }

    private void inicjalizuj() {
        //konfiguracja okna aplikacji
        window = new JFrame();

        window.setTitle("Historia QUIZ!");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1250, 772);
        window.getContentPane().setBackground(Color.decode("#FADDB1"));

        //ta linijka centruje okno
        window.setLocationRelativeTo(null);

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(85);

        liczba_zadan = 24;
        zadania = new MyButton[liczba_zadan];

        //konfiguracja górnego paska aplikacji

        panelStartowy = new MyPanel(window, 1);
        panelStartowy.setBackground(Color.decode("#FFBD59"));
        tekstGorny = new JLabel("PANEL UCZNIA - MOJE STATYSTYKI");
        panelStartowy.add(tekstGorny);

        panelStartowy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tekstGorny.setFont(new Font("Open Sans", Font.BOLD, 20));
        tekstGorny.setBorder(new EmptyBorder(10,10,10,10));

        window.add(panelStartowy, BorderLayout.NORTH);

        //konfiguracja głównego panelu (z zadaniami do wyboru)
        glownyPanel = new JPanel();
        glownyPanel.setBorder(new EmptyBorder(10,10,10,10));

        glownyPanel.setBackground(Color.decode("#FADDB1"));

        window.add(glownyPanel, BorderLayout.CENTER);
        buttonPanel = new JPanel();

        glownyPanel.add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBackground(Color.decode("#FADDB1"));

        r = window.getBounds();


        //dodawanie scrollowania
        scrollpane = new JScrollPane(buttonPanel);
        scrollpane.getVerticalScrollBar().setUnitIncrement(16);

        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        window.getContentPane().add(scrollpane);

        pokazZadania();
    }

    public void showWindow() {
        window.setVisible(true);
    }

    public JPanel getScrollpane() {
        return buttonPanel;
    }

    //ta funkcja odpowiedzialna jest za część robioną w poprzednim sprincie (3 i 4)
    public void pokazZadania() {
        buttonPanel.revalidate();
        buttonPanel.repaint();
        scrollpane.getVerticalScrollBar().setValue(0);

        height = liczba_zadan * 105 / 3 + 300;

        panelStartowy.setStan(1);
        panelStartowy.setPreferredSize(new Dimension(1500, 175));
        panelStartowy.setBounds(0, 0, 1500, 200);

        System.out.println("Tesciorek 1 " + width + " " + height);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 1.0;
        c.weightx = 1.0;
        buttonPanel.setPreferredSize(new Dimension(width, height));
        System.out.println("Liczba zadan: " + liczba_zadan);
        int pomX = 0;
        int pomY = 0;
        for(int i = 0; i < liczba_zadan; i++) {
            String poziomTrudnosci = poziomyTrudnosci[(int) (Math.random() * poziomyTrudnosci.length)];
            System.out.println("Pokazalem zadanie" + i + " ");
            zadania[i] = new MyButton("ZADANIE " + (i+1), i, kategorie[i], poziomTrudnosci);
            c.gridx = pomX;
            c.gridy = pomY;
            if(pomX == 2) { pomX = 0; pomY++; }
            else pomX++;
            buttonPanel.add(zadania[i], c);
        }
        pomY+=2;
        pomX = 1;
        c.gridx = pomX;
        c.gridy = pomY;
        ButtonTypeC powrot1 = new ButtonTypeC(this, 2);
        buttonPanel.add(powrot1, c);

        tekstGorny.setText("PANEL UCZNIA - LISTA DOSTĘPNYCH ZADAŃ");
        tekstGorny.setForeground(Color.RED);
        tekstGorny.invalidate();
        tekstGorny.repaint();
        panelStartowy.setStan(1);
        panelStartowy.invalidate();
        panelStartowy.repaint();
        scrollpane.invalidate();
        scrollpane.repaint();
        glownyPanel.invalidate();
        glownyPanel.repaint();
        window.invalidate();
        window.repaint();
        System.out.println("Tesciorek 2");
    }


    //ta funkcja odpowiada za część robioną w sprincie nr 5
    public void pokazStatystyki() {
        buttonPanel.revalidate();
        buttonPanel.repaint();
        scrollpane.getVerticalScrollBar().setValue(0);

        width = r.width;
        height = r.height;

        panelStartowy.setStan(2);
        panelStartowy.setPreferredSize(new Dimension(1500, 92));
        panelStartowy.setBounds(0, 0, 1500, 92);

        buttonPanel.setBackground(Color.decode("#FADDB1"));

        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints cPrzyciski = new GridBagConstraints();

        buttonPanel.setPreferredSize(new Dimension(width, height));

        buttonPanel.setPreferredSize(new Dimension(width-80, height));

        Border margin = new LineBorder(Color.decode("#FADDB1"), 20);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FADDB1"), 20));
        buttonPanel.setBorder(new CompoundBorder(buttonPanel.getBorder(), margin));

        cPrzyciski.weightx = 1.0;
        cPrzyciski.weighty = 1.0;

        //DODAWANIE KOLEJNYCH PRZYCISKÓW
        //Uwaga: jak coś powpisywałem losowe wartości do przycisków.

        cPrzyciski.gridx = 0;
        cPrzyciski.gridy = 0;

        ButtonTypeA liczbaRozwiazanychZadan = new ButtonTypeA("LICZBA ROZWIĄZANYCH ZADAŃ", '1', 113);
        buttonPanel.add(liczbaRozwiazanychZadan, cPrzyciski);


        cPrzyciski.gridx = 0;
        cPrzyciski.gridy = 1;

        ButtonTypeA liczbaPoprawnieRozwiazanychZadan = new ButtonTypeA("LICZBA POPRAWNIE ROZWIĄZANYCH ZADAŃ", '1', 78);
        buttonPanel.add(liczbaPoprawnieRozwiazanychZadan, cPrzyciski);


        cPrzyciski.gridx = 0;
        cPrzyciski.gridy = 2;

        ButtonTypeA liczbaNiepoprawnieRozwiazanychZadan = new ButtonTypeA("LICZBA NIEPOPRAWNIE ROZWIĄZANYCH ZADAŃ", '1', 35);
        buttonPanel.add(liczbaNiepoprawnieRozwiazanychZadan, cPrzyciski);


        cPrzyciski.gridx = 0;
        cPrzyciski.gridy = 3;

        ButtonTypeA procentPoprawnieRozwiazanychZadan = new ButtonTypeA("PROCENT POPRAWNIE ROZWIĄZANYCH ZADAŃ", '%', 69);
        buttonPanel.add(procentPoprawnieRozwiazanychZadan, cPrzyciski);


        cPrzyciski.gridx = 0;
        cPrzyciski.gridy = 4;

        powrot = new ButtonTypeC(this, 1);
        buttonPanel.add(powrot, cPrzyciski);


        cPrzyciski.gridx = 1;
        cPrzyciski.gridy = 0;

        ButtonTypeA sredniCzasRozwiazywaniaZadan = new ButtonTypeA("ŚREDNI CZAS ROZWIĄZYWANIA ZADAŃ", 's', 29);
        buttonPanel.add(sredniCzasRozwiazywaniaZadan, cPrzyciski);


        cPrzyciski.gridx = 1;
        cPrzyciski.gridy = 1;

        ButtonTypeA sredniProcentowyWynikTestu = new ButtonTypeA("ŚREDNI PROCENTOWY WYNIK TESTU", '%', 86);
        buttonPanel.add(sredniProcentowyWynikTestu, cPrzyciski);


        cPrzyciski.gridx = 1;
        cPrzyciski.gridy = 2;

        ButtonTypeB miejsceWRankingu = new ButtonTypeB(12);
        buttonPanel.add(miejsceWRankingu, cPrzyciski);

        //dodatkowe uzupełnienia
        tekstGorny.setText("PANEL UCZNIA - MOJE STATYSTYKI");
        tekstGorny.setForeground(Color.RED);
        tekstGorny.invalidate();
        tekstGorny.repaint();
        panelStartowy.invalidate();
        panelStartowy.repaint();
        scrollpane.invalidate();
        scrollpane.repaint();
        glownyPanel.invalidate();
        glownyPanel.repaint();
        window.invalidate();
        window.repaint();
    }


}
