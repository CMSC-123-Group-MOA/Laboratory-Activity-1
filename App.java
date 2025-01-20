import java.awt.BorderLayout;
import javax.swing.JFrame;

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
        JFrame mainFrame = new JFrame();
        init_Frame(mainFrame);
        System.out.println("hello");                
    }
}
