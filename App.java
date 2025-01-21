import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    private static void init_Frame(JFrame frame){
        BorderLayout borderLayout = new BorderLayout(); 
        frame.setLayout(borderLayout);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // JFrame mainFrame = new JFrame();
        // init_Frame(mainFrame);

        // JPanel mainPanel = new JPanel();
        // mainPanel.setBackground(Color.black);
        // mainFrame.add(mainPanel, BorderLayout.CENTER);

        // JPanel sidePanel = new JPanel();
        // sidePanel.setBackground(Color.RED);
        // sidePanel.setPreferredSize(new Dimension(300, 300));
        
        // mainFrame.add(sidePanel, BorderLayout.EAST);
             mainFrame mainframe = new mainFrame();
                
    }
}
