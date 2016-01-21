import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class CijferlijstPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CijferlijstPanel extends JPanel {
    
    private JLabel label1;
    private JTextField input;
    private JButton ok, print;
    private Cijferlijst cijferlijst;
    
    public CijferlijstPanel() {
        label1 = new JLabel("Voer hier je cijfers in:");
        add(label1);
        
        input = new JTextField(5);
        add(input);
        input.addActionListener(new InputListener());
        
        ok = new JButton("OK");
        add(ok);
        ok.addActionListener(new InputListener());
        
        print = new JButton("Print cijferlijst");
        add(print);
        print.addActionListener(new PrintListener());
        
        cijferlijst = new Cijferlijst();
    }
    
    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cijferlijst.voegtoe(Integer.parseInt(input.getText()));
            input.setText("");
            input.requestFocus();
        }
    }
    
    class PrintListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cijferlijst.print();
            System.out.println("--------------------");
        }
    }
    
}