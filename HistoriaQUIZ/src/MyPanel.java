import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

//funkcja ta pomogła skonfigurować i graficznie przedstawić górny pasek aplikacji (panel ucznia - informacja)

public class MyPanel extends JPanel {
    int stan = 1;
    private JFrame frame;
    MyPanel(JFrame frame, int stan)
    {
        this.frame = frame;
        this.stan = stan;
    }
    public MyButton getButton(int i, MyPanel temp) {
        Component[] components = temp.getComponents();
        MyButton panelcomponent = null;
        int j = 0;
        for (Component component : components) {
            if (i == j) {
                panelcomponent = (MyButton) component;
            }
            j++;
        }
        return panelcomponent;
    }
    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle r = frame.getBounds();

        int width = r.width;
        int height = 100;

        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 0, 0));
        g2.setColor(Color.decode("#FADDB1"));
        g2.fill(area);

        area = new Area(new RoundRectangle2D.Double(6, 6, width-12, height-12, 0, 0));
        g2.setColor(Color.decode("#FFBD59"));
        g2.fill(area);

        area.subtract(new Area(new RoundRectangle2D.Double(10, 10, width-20, height-20, 0, 0)));
        g2.setColor(Color.BLACK);
        g2.fill(area);
        Font font = new Font("Open Sans", Font.BOLD, 20);
        int x;
        FontMetrics metrics = g2.getFontMetrics(font);
        if(stan == 1) {
            x = (width - metrics.stringWidth("PANEL UCZNIA - LISTA DOSTĘPNYCH ZADAŃ")) / 2;
        } else {
            x = (width - metrics.stringWidth("PANEL UCZNIA - MOJE STATYSTYKI")) / 2;
        }
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();



        g2.setFont(font);
        if(stan == 1) {
            setSize(new Dimension(width, height + 100));

            g2.drawString("PANEL UCZNIA - LISTA DOSTĘPNYCH ZADAŃ", x, y);

            x = (width - metrics.stringWidth("WYBIERZ KONKRETNE ZADANIE, KTÓRE CHCESZ ROZWIĄZAĆ")) / 2;
            y+= 85;

            g2.drawString("WYBIERZ KONKRETNE ZADANIE, KTÓRE CHCESZ ROZWIĄZAĆ", x, y);
        } else {
            setSize(new Dimension(width, height+6));

            g2.drawString("PANEL UCZNIA - MOJE STATYSTYKI", x, y);
        }


        g2.dispose();
        super.paint(graphics);

    }

    void setStan(int val) {
        this.stan = val;
    }
}
