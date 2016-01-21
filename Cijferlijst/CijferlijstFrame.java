import javax.swing.*;

/**
 * Write a description of class CijferlijstFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CijferlijstFrame extends JFrame {
    
    public static void main() {
        JFrame frame = new CijferlijstFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setTitle("Cijferlijst");
        frame.setVisible(true);
    }
    
    public CijferlijstFrame() {
        setContentPane(new CijferlijstPanel());
    }
    
}