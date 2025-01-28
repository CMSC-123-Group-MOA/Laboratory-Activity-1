import java.io.File;
import java.net.URISyntaxException;

import ui.MainFrame;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        File currpath = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        MainFrame mainframe = new MainFrame(currpath);
        mainframe.start();
    }
}
