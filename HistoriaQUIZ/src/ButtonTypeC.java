import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class ButtonTypeC extends JButton {

    private int helpVar;
    private boolean pom = false;
    private int x;
    private int y;

    ButtonTypeC(GUI window, int helpVar) {
        //ustawianie wartości

        setContentAreaFilled(false);
        setOpaque(false);
        setPreferredSize(new Dimension(415, 85));
        setForeground(Color.BLACK);
        setMargin(new Insets(100, 100, 100, 100));
        this.helpVar = helpVar;

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
                if(helpVar == 1) {
                    Component[] com = window.getScrollpane().getComponents();
                    for (Component component : com) {
                        window.getScrollpane().remove(component);
                        component.invalidate();
                        component.repaint();
                    }
                    window.getScrollpane().invalidate();
                    window.getScrollpane().repaint();
                    System.out.println("STATUS: " + window.getScrollpane().isVisible() + " " + window.getScrollpane().isEnabled());
                    window.pokazZadania();
                } else {
                    Component[] com = window.getScrollpane().getComponents();
                    for (Component component : com) {
                        window.getScrollpane().remove(component);
                        component.invalidate();
                        component.repaint();
                    }
                    window.getScrollpane().invalidate();
                    window.getScrollpane().repaint();
                    System.out.println("STATUS: " + window.getScrollpane().isVisible() + " " + window.getScrollpane().isEnabled());
                    window.pokazStatystyki();
                }

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

        int width = 415;
        int height = 85;

        Area area;

        Color c1 = Color.decode("#FFDE5A");
        Color c2 = Color.decode("#FF914D");

        Color c3 = Color.decode("#BFA643");
        Color c4 = Color.decode("#BF6A37");

        area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 45, 45));

        GradientPaint gp = new GradientPaint(0,0,c1,getWidth(),getHeight(),c2);
        GradientPaint gp1 = new GradientPaint(0,0,c3,getWidth(),getHeight(),c4);

        if(!pom) g2.setPaint(gp);
        else g2.setPaint(gp1);
        g2.fill(area);
        System.out.println("Lokacja wedlug MyButton: (" + getX() + ", " + getY() + ")");

        area.subtract(new Area(new RoundRectangle2D.Double(2,  2, width-4, height-4, 41, 41)));
        g2.setColor(Color.BLACK);
        g2.fill(area);

        Font font = new Font("Open Sans", Font.BOLD, 22);
        FontMetrics metrics = g2.getFontMetrics(font);
        g2.setFont(font);


        if(helpVar == 1)
        {
            x = (width - metrics.stringWidth("POWRÓT")) / 2;
            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
            x = (width - metrics.stringWidth("POWRÓT")) / 2;
            g2.drawString("POWRÓT", x, y);
        } else {
            x = (width - metrics.stringWidth("STATYSTYKI")) / 2;
            y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
            x = (width - metrics.stringWidth("STATYSTYKI")) / 2;
            g2.drawString("STATYSTYKI", x, y);
        }

        g2.dispose();
        super.paint(graphics);

    }

    public void setHelpVar(int val) {
        helpVar = val;
    }
}
