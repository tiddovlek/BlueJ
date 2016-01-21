import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class LampSwitchPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LampSwitchPanel extends JPanel implements ActionListener {
    
    private JButton[] lampButton = new JButton[3];
    private Lamp[] lamp = new Lamp[lampButton.length];
    
    public LampSwitchPanel() {
        for (int i = 0; i < lampButton.length; i++) {
            lampButton[i] = new JButton("aan");
            add(lampButton[i]);
            lampButton[i].addActionListener(this);
            lamp[i] = new Lamp((i+1)*100);
            lamp[i].maakZichtbaar();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < lampButton.length; i++) {
            if (e.getSource() == lampButton[i]) {
                if (lampButton[i].getText().equals("aan")) {
                    lamp[i].aan();
                    lampButton[i].setText("uit");
                }
                else {
                    lamp[i].uit();
                    lampButton[i].setText("aan");
                }
            }
        }
    }
    
}