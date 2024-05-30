import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ButtonTypeA extends JButton {
    //wlasciwosci przycisku
    private String opis;
    private char rodzajPrzechowywanejWartosci;
    /*
    * '%' -> wartość procentowa
    * '1' -> wartość liczbowa
    * 'T' -> wartość czasowa [s]
    * */

    private int wartosc;

    private boolean pom = false;
    private int x;
    private int y;

    ButtonTypeA(String opis, char rodzajPrzechowywanejWartosci, int wartosc) {
        //ustawianie wartości
        this.opis = opis;
        this.rodzajPrzechowywanejWartosci = rodzajPrzechowywanejWartosci;
        this.wartosc = wartosc;

        setContentAreaFilled(false);
        setOpaque(false);
        setPreferredSize(new Dimension(415, 85));
        setForeground(Color.BLACK);
        setMargin(new Insets(100, 100, 100, 100));
    }




    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = 415;
        int height = 85;

        Area area;

        area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 45, 45));
        if(!pom) g2.setColor(Color.decode("#FFDE5A"));
        else g2.setColor(Color.decode("#E6A400"));
        g2.fill(area);
        System.out.println("Lokacja wedlug MyButton: (" + getX() + ", " + getY() + ")");

        area.subtract(new Area(new RoundRectangle2D.Double(2,  2, width-4, height-4, 41, 41)));
        g2.setColor(Color.BLACK);
        g2.fill(area);

        Font font = new Font("Open Sans", Font.BOLD, 16);
        FontMetrics metrics = g2.getFontMetrics(font);
        g2.setFont(font);

        if(opis.equals("LICZBA POPRAWNIE ROZWIĄZANYCH ZADAŃ"))
        {
            y = ((height - metrics.getHeight()) / 2) + 3;
            x = (width - metrics.stringWidth("LICZBA POPRAWNIE")) / 2 - 48;
            g2.drawString("LICZBA POPRAWNIE", x, y);

            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent() * 2 - 3;
            x = (width - metrics.stringWidth("ROZWIĄZANYCH ZADAŃ")) / 2 - 48;
            g2.drawString("ROZWIĄZANYCH ZADAŃ", x, y);
        }
        else if (opis.equals("LICZBA NIEPOPRAWNIE ROZWIĄZANYCH ZADAŃ"))
        {
            y = ((height - metrics.getHeight()) / 2) + 3;
            x = (width - metrics.stringWidth("LICZBA NIEPOPRAWNIE")) / 2 - 48;
            g2.drawString("LICZBA NIEPOPRAWNIE", x, y);

            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent() * 2 - 3;
            x = (width - metrics.stringWidth("ROZWIĄZANYCH ZADAŃ")) / 2 - 48;
            g2.drawString("ROZWIĄZANYCH ZADAŃ", x, y);
        }
        else if (opis.equals("PROCENT POPRAWNIE ROZWIĄZANYCH ZADAŃ"))
        {
            y = ((height - metrics.getHeight()) / 2) + 3;
            x = (width - metrics.stringWidth("PROCENT POPRAWNIE")) / 2 - 48;
            g2.drawString("PROCENT POPRAWNIE", x, y);

            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent() * 2 - 3;
            x = (width - metrics.stringWidth("ROZWIĄZANYCH ZADAŃ")) / 2 - 48;
            g2.drawString("ROZWIĄZANYCH ZADAŃ", x, y);
        }
        else if (opis.equals("ŚREDNI CZAS ROZWIĄZYWANIA ZADAŃ")) {
            y = ((height - metrics.getHeight()) / 2) + 3;
            x = (width - metrics.stringWidth("ŚREDNI CZAS")) / 2 - 48;
            g2.drawString("ŚREDNI CZAS", x, y);

            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent() * 2 - 3;
            x = (width - metrics.stringWidth("ROZWIĄZYWANIA ZADAŃ")) / 2 - 48;
            g2.drawString("ROZWIĄZYWANIA ZADAŃ", x, y);
        }
        else if (opis.equals("ŚREDNI PROCENTOWY WYNIK TESTU")) {
            y = ((height - metrics.getHeight()) / 2) + 3;
            x = (width - metrics.stringWidth("ŚREDNI PROCENTOWY")) / 2 - 48;
            g2.drawString("ŚREDNI PROCENTOWY", x, y);

            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent() * 2 - 3;
            x = (width - metrics.stringWidth("WYNIK TESTU")) / 2 - 48;
            g2.drawString("WYNIK TESTU", x, y);
        } else {
            x = (width - metrics.stringWidth(opis)) / 2;
            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
            x = (width - metrics.stringWidth(opis)) / 2 - 48;
            g2.drawString(opis, x, y);
        }

        g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(320, 0, 320, 85);

        Area area2;
        area2 = new Area(new RoundRectangle2D.Double(322, 2, width-320-4, height-4, 41, 41));
        g2.setColor(Color.WHITE);
        g2.fill(area2);


        Area area3;
        area3 = new Area(new Rectangle2D.Double(322, 2, 30, height-4));
        g2.fill(area3);

        //ustawianie faktycznej wartości
        String pomWart = rodzajPrzechowywanejWartosci == '%' ? wartosc + "%" : rodzajPrzechowywanejWartosci == '1' ? Integer.toString(wartosc) : wartosc +  " s";
        Font font2 = new Font("Open Sans", Font.BOLD, 24);
        g2.setFont(font2);
        g2.setColor(Color.decode("#5171FF"));
        g2.drawString(pomWart, 322 + (75-metrics.stringWidth(pomWart))/2, ((height - metrics.getHeight()) / 2) + metrics.getAscent() + 2);

        g2.dispose();
        super.paint(graphics);

    }
}
