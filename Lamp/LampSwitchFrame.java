import javax.swing.*;

/**
 * Write a description of class LampSwitchFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LampSwitchFrame extends JFrame {
    
    public static void main() {
        JFrame frame = new LampSwitchFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setTitle("Lichtschakelaars");
        frame.setVisible(true);
    }
    
    public LampSwitchFrame() {
        setContentPane(new LampSwitchPanel());
    }
    
}