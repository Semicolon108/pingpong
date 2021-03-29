package PingPong;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Panel panel;

    public Window(){
        super("Ping Pong");
        panel = new Panel();

        add(panel);
    }
}
