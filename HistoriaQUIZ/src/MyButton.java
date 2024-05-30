import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MyButton extends JButton {
    private String nazwa_zadania;
    private String kategoria_zadania;
    private String poziom_trudnosci;
    private boolean pom = false;
    private int x;
    private int y;
    int nr;

    private String[] pytania = {
            "Kiedy wybuchła pierwsza wojna światowa?",
            "Kto nazywa się Napoleon z Iranu?",
            "Jaka jest ostatnia dynastia w Chinach?",
            "Kto jest pierwszym prezydentem Stanów Zjednoczonych?",
            "W którym roku zamordowano Johna F. Kennedy'ego?",
            "Który prezydent USA miał dom zwany Ermitażem?",
            "Czyj okres był znany jako Złoty Wiek Rzymu?",
            "Gdzie odbywają się pierwsze letnie igrzyska olimpijskie?",
            "Która dynastia jest najstarszą nadal panującą?",
            "Z jakiego kraju pochodzi cywilizacja Azteków?",
            "Kto należał do słynnych poetów rzymskich?",
            "Kto był pierwszym Amerykaninem, który wygrał pokój Nobla?",
            "Kto eksplorował Nowy Świat?",
            "Którzy są najwcześniejszymi przodkami rdzennych Amerykanów?",
            "Gdzie nadal leży Babilon?",
            "Gdzie jest ojczyzna Joanny d'Arc?",
            "Kiedy Joanna d'Arc została beatyfikowana w słynnej katedrze Notre Dame w Paryżu?",
            "Kto był pierwszym człowiekiem, który chodził po Księżycu?",
            "Podczas którego wydarzenia Korea została podzielona na 2 narody?",
            "Jaka jest inna nazwa Wielkiej Piramidy w Egipcie?",
            "Która jest uważana za pierwszą ludzką technologię?",
            "Kto jest wynalazcą światła elektrycznego?",
            "Cuzco, Machu Pichu to znane miejsce znajdujące się w jakim kraju?",
            "W jakim mieście urodził się Juliusz Cezar?",
            "Kto namalował Śmierć Sokratesa?"
    };


    MyButton(String nazwa,int numer, String kategoria, String trudnosc) {
        setContentAreaFilled(false);
        setOpaque(false);
        setPreferredSize(new Dimension(320, 100));
        setForeground(Color.BLACK);
        setMargin(new Insets(100, 100, 100, 100));
        nazwa_zadania = nazwa;
        kategoria_zadania = kategoria;
        poziom_trudnosci = trudnosc;
        nr = numer;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try { JOptionPane.showMessageDialog(null, "Treść pytania: " + pytania[nr]); }
                catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("Błąd! Nieodpowiedni numer pytania!");
                }
                getPytanie(nr);
            }
        });



        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                pom = true;
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent me) {
                pom = false;
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                super.mouseReleased(me);
            }
        });
    }




    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = 320;
        int height = 100;

        Area area;

        area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 100, 100));
        if(!pom) g2.setColor(Color.decode("#FFDE5A"));
        else g2.setColor(Color.decode("#E6A400"));
        g2.fill(area);
        System.out.println("Lokacja wedlug MyButton: (" + getX() + ", " + getY() + ")");

        area.subtract(new Area(new RoundRectangle2D.Double(3,  + 3, width-6, height-6, 94, 94)));
        g2.setColor(Color.BLACK);
        g2.fill(area);
        Font font = new Font("Open Sans", Font.BOLD, 14);
        FontMetrics metrics = g2.getFontMetrics(font);
        x = (width - metrics.stringWidth(nazwa_zadania)) / 2;
        y = -20  + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setFont(font);
        String stringPom = "NAZWA: " + nazwa_zadania;
        x = (width - metrics.stringWidth(stringPom)) / 2;

        g2.drawString("NAZWA: ", x, y);

        int x_przesuniecie = metrics.stringWidth(stringPom) - metrics.stringWidth(nazwa_zadania);
        x+=x_przesuniecie;

        g2.setColor(Color.decode("#5171FF"));
        g2.drawString(nazwa_zadania, x, y); y+=20;
        g2.setColor(Color.BLACK);

        stringPom = "KATEGORIA: " + kategoria_zadania;
        x = (width - metrics.stringWidth(stringPom)) / 2;

        g2.drawString("KATEGORIA: ", x, y);

        x_przesuniecie = metrics.stringWidth(stringPom) - metrics.stringWidth(kategoria_zadania);
        x+=x_przesuniecie;

        g2.setColor(Color.decode("#5171FF"));
        g2.drawString(kategoria_zadania, x, y); y+=20;
        g2.setColor(Color.BLACK);

        stringPom = "POZIOM TRUDNOŚCI: " + poziom_trudnosci;

        x = (width - metrics.stringWidth(stringPom)) / 2;

        g2.drawString("POZIOM TRUDNOŚCI: ", x, y);

        x_przesuniecie = metrics.stringWidth(stringPom) - metrics.stringWidth(poziom_trudnosci);
        x+=x_przesuniecie;

        g2.setColor(Color.decode("#5171FF"));
        g2.drawString(poziom_trudnosci, x, y);
        g2.setColor(Color.BLACK);

        g2.dispose();
        super.paint(graphics);

    }

    String getPytanie(int numer) {
        return pytania[numer];
    }


}
