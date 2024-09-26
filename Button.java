import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {

    public static void main(String[] args){
        JFrame frame = new JFrame("Button click example");
        JButton button = new JButton("Click me");

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Button was clicked");
            }
        });

        // add button action listner

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
