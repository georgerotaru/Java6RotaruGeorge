/*
 * Class launches three processes of Notepad.exe
 */
package multithreading;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class LaunchNotepads launches three processes of Notepad (for Windows)
 * @author George
 */
public class LaunchNotepads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ProcessBuilder pb;
            // Use process builder to start 2 processes multithreading.SayHello with parameter
            pb= new ProcessBuilder("notepad");
            pb.directory(new File("D:\\NetBeans8_2\\test"));
            Process p1 = pb.start();
            Process p2 = pb.start();
            Process p3 = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(LaunchNotepads.class.getName()).log(Level.SEVERE, "An IO exception is here!", ex);
        }
    }
    
}
