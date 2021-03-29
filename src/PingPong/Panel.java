package PingPong;

import com.sun.media.jfxmedia.events.PlayerEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener, ActionListener {
    private Integer player1Y = 150;
    private Integer player2Y = 150;
    private boolean play = false;
    private Timer time;
    private int ballDirX = -3;
    private int ballDirY = -1;
    private int ballPosX = 288;
    private int ballPosY = 180;
    private Player player1;
    private Player player2;


    public Panel(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        player1 = new Player(18);
        player2 = new Player(555);
        time = new Timer(8, this);
        time.start();
    }

    @Override
    public void paint(Graphics g) {
        play = player1.play;
        g.setColor(Color.BLACK);
        g.fillRect(1,1, 600, 400);

        g.setColor(Color.yellow);
        g.fillRect(300,0,1,450);
        g.setColor(Color.green);
        g.fillOval(ballPosX,ballPosY,18,18);
        player1.drawPlayer((Graphics2D) g);
        player2.drawPlayer((Graphics2D) g);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(player1.play){
            ballPosX += ballDirX;
            ballPosY += ballDirY;
            if(new Rectangle(player1.posX,player1.playerY,9,81).intersects(new Rectangle(ballPosX,ballPosY,18,18))){
                ballDirX = -ballDirX;
                ballDirY = -ballDirY;
            }
        }
        if(player2.play){
            if(new Rectangle(player2.posX,player2.playerY,9,81).intersects(new Rectangle(ballPosX,ballPosY,18,18))) {
                ballDirX = -ballDirX;
                ballDirY = -ballDirY;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(player1.playerY <= 0){
                player1.playerY = 6;
            }else{
                player1.moveUp();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            if(player2.playerY <= 0){
                player2.playerY = 6;
            }else{
                player2.moveUp();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            if(player2.playerY >= 318){
                player2.playerY = 318;
            }else{
                player2.moveDown();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(player1.playerY >= 318){
                player1.playerY = 318;
            }else{
                player1.moveDown();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void moveUp(int player){
        play = true;
        player -= 10;
    }
}
