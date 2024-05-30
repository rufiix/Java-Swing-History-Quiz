import javax.swing.*;

//główna funkcja wywołująca cały program

public class Main {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI window = new GUI();
                window.showWindow();
            }
        });
    }
}
