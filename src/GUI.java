import javax.swing.*;

public class GUI extends JFrame {
    public JPanel mainPanel;
    public JTextField textField;
    public JLabel board;
    public JButton solve;

    public GUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

    }

    public static void main(String[] args) {
        JFrame frame = new GUI("Zgadnij słowo");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


}
