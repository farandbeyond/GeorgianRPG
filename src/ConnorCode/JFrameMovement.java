/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeorgianRPG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Connor
 */
public class JFrameMovement {
    int playerx = 5, playery = 5;
    String[] theMap1 =  {"X","X","X","X","X","X","X","X","X","X","X"};
    String[] theMap2 =  {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap3 =  {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap4 =  {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap5 =  {"X","-","X","X","X","-","X","-","-","-","X"};
    String[] theMap6 =  {"X","-","-","-","X","-","X","-","-","-","X"};
    String[] theMap7 =  {"X","-","-","-","X","X","X","-","-","-","X"};
    String[] theMap8 =  {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap9 =  {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap10 = {"X","-","-","-","-","-","-","-","-","-","X"};
    String[] theMap11 = {"X","X","X","X","X","X","X","X","X","X","X"};
    String[][] theMap = {theMap1,theMap2,theMap3,theMap4,theMap5, theMap6,theMap7,theMap8, theMap9, theMap10, theMap11};



//{theMapBorder,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapBorder};          //new String[11][11]
    boolean[][] theMapWalkable = new boolean[11][11];
    String input;   
    
    JFrameMovement(){
        input = "";
        for(int x = 0;x<theMap.length;x++){
            for(int y = 0;y<theMap[x].length;y++){
                if(
                        theMap[x][y].equalsIgnoreCase("X")
                        
                        ){
                    theMapWalkable[x][y] = false;
                }else{
                    theMapWalkable[x][y] = true;
                }
            }
        }
        
        
    }
    public void playerLocation(){
        theMap[playery][playerx] = "-";
        updatePlayerLocation();
        theMap[playery][playerx] = "@";
        text(playery+ " "+ playerx);
        
    }
    private void updatePlayerLocation(){
        if(input.equalsIgnoreCase("w")&&theMapWalkable[playery-1][playerx]){
            playery-=1;
        }else if(input.equalsIgnoreCase("s")&&theMapWalkable[playery+1][playerx]){
            playery+=1;
        }else if(input.equalsIgnoreCase("a")&&theMapWalkable[playery][playerx-1]){
            playerx-=1;
        }else if(input.equalsIgnoreCase("d")&&theMapWalkable[playery][playerx+1]){
            playerx+=1;
        }else{
            System.out.println("Invalid Input");
        }
    }
    public String readMap(String[][] charMap){
        String mapString = "";
        mapString+="<html>";
        for(int i = 0;i<charMap.length;i++){
            for(int x = 0;x<charMap[i].length;x++){
                mapString+=charMap[i][x];
                //text(charMap[i][x]+"");
            }
            mapString+="\n<br>";
        }
        mapString+="</html>";
        //System.out.print(mapString);
        return mapString;
    }
    
    public static void main(String[] args){
        JFrameMovement game = new JFrameMovement();
        
        Scanner keyboard = new Scanner(System.in);
        JFrame frame = new JFrame("GeorgianRPG");
        JPanel panel = new JPanel(new GridLayout());
        JLabel label = new JLabel();
        
        //label.setFont(new Font("Courier New", Font.ITALIC, 12));
        
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(label,BorderLayout.PAGE_START);
        
        frame.setContentPane(panel);
        frame.setVisible(true);
        //debug
        
        //end of debug
        while(!game.input.equalsIgnoreCase("quit")){
            game.playerLocation();
            label.setText(game.readMap(game.theMap));
            text("Command");
            game.input = keyboard.nextLine();
            
            
        }
    }   
    public static void text(String text){
        System.out.println(text);
    }
    
    /*String input;
    int playerx = 5, playery = 5;
    static String[][] theMap;
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        JFrame frame = new JFrame("GeorgianRPG");
        JPanel panel = new JPanel(new GridLayout());
        JLabel label = new JLabel();
        String[] theMapBorder = {"X","X","X","X","X","X","X","X","X","X","X"};
        String[] theMapEmpty =  {"X","-","-","-","-","-","-","-","-","-","X"};
        theMap = {theMapBorder,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapEmpty,theMapBorder};          //new String[11][11];
        //JLabel label2 = new JLabel(readMap(theMap));
        playerLocation();
        label.setText(readMap(theMap));
        
        
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(label,BorderLayout.PAGE_START);
        frame.setVisible(true);
        do{
            text("Command");
            input = keyboard.nextLine();
            label.setText(readMap(theMap));
            frame.setContentPane(panel);
        //label.setVisible(true);
        //System.out.print(label.getText());
        }while(!input.equalsIgnoreCase("quit"));
    }
    
    public static String readMap(String[][] charMap){
        String mapString = "";
        mapString+="<html>";
        for(int i = 0;i<charMap.length;i++){
            for(int x = 0;x<charMap[i].length;x++){
                mapString+=charMap[i][x];
            }
            mapString+="<br>";
        }
        mapString+="</html>";
        //System.out.print(mapString);
        return mapString;
    }
    public static void playerLocation(){
        
        theMap[playerx][playery] = '@';
    }
    public static void text(String text){
        System.out.println(text);
    }*/
}
