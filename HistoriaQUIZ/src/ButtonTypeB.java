import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ButtonTypeB extends JButton {
    //wlasciwosci przycisku

    private int wartosc;

    private boolean pom = false;
    private int x;
    private int y;

    ButtonTypeB(int wartosc) {
        //ustawianie wartości
        this.wartosc = wartosc;

        setContentAreaFilled(false);
        setOpaque(false);
        setPreferredSize(new Dimension(415, 120));
        setForeground(Color.BLACK);
        setMargin(new Insets(100, 100, 100, 100));
    }




    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = 415;
        int height = 120;

        Area area;

        area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 45, 45));
        if(!pom) g2.setColor(Color.decode("#FF914D"));
        else g2.setColor(Color.decode("#FF914D"));
        g2.fill(area);
        System.out.println("Lokacja wedlug MyButton: (" + getX() + ", " + getY() + ")");

        area.subtract(new Area(new RoundRectangle2D.Double(2,  2, width-4, height-4, 41, 41)));
        g2.setColor(Color.BLACK);
        g2.fill(area);

        Font font = new Font("Open Sans", Font.BOLD, 22);
        FontMetrics metrics = g2.getFontMetrics(font);
        g2.setFont(font);


        x = (width - metrics.stringWidth("MIEJSCE W RANKINGU")) / 2;
        y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        x = (width - metrics.stringWidth("MIEJSCE W RANKINGU")) / 2 - 48;
        g2.drawString("MIEJSCE W RANKINGU", x, y);


        g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(320, 0, 320, 170);

        Area area2;
        area2 = new Area(new RoundRectangle2D.Double(322, 2, width-320-4, height-4, 41, 41));
        g2.setColor(Color.WHITE);
        g2.fill(area2);


        Area area3;
        area3 = new Area(new Rectangle2D.Double(322, 2, 30, height-4));
        g2.fill(area3);

        //ustawianie faktycznej wartości
        String pomWart = Integer.toString(wartosc);
        Font font2 = new Font("Open Sans", Font.BOLD, 24);
        g2.setFont(font2);
        g2.setColor(Color.decode("#02BF62"));
        g2.drawString(pomWart, 322 + (87-metrics.stringWidth(pomWart))/2, ((height - metrics.getHeight()) / 2) + metrics.getAscent() + 2);

        g2.dispose();
        super.paint(graphics);

    }
}
