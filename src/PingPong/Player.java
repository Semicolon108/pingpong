package PingPong;

import java.awt.*;

public class Player {
    public Integer playerY = 150;
    private final static int playerWidth = 9;
    private final static int playerHeight = 81;
    public int posX;
    public boolean play = false;

    public Player(int x){
        posX = x;
    }

    public void drawPlayer(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(posX, playerY, playerWidth,playerHeight);
    }
    public void moveUp(){
        play = true;
        playerY -= 15;
    }

    public void moveDown(){
        play = true;
        playerY +=15;
    }

    public void freeze(){

    }
}
