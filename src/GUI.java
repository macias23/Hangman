import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public JPanel mainPanel;
    public JTextField textField;
    public JLabel board;
    public GUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typed=textField.getText();
                System.out.println(typed);
                textField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new GUI("Zgadnij słowo");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
