/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeorgianRPG;

import java.util.Scanner;

/**
 *
 * @author Connor
 */
public class GuildManagerPoC {
    Scanner keyboard = new Scanner(System.in);
    private Character[] guild;
    private Character[] party;
    private boolean[] gSlots;
    private boolean[] pSlots;
    private boolean[] inParty;
    
    private int guildRemaining, nextGuildSlot;
    
    // version 1. classes party by STR stat, proof of concept
    /*GuildManagerPoC(){
        guild = new Character[30];
        party = new Character[4];
        gSlots = new boolean[30];
        for(int slots=0;slots<gSlots.length;slots++){
            gSlots[slots]=false;
        }
        
        inParty = new boolean[30];
        for(int slots=0;slots<inParty.length;slots++){
            inParty[slots]=false;
        }
        pSlots = new boolean[4];
        for(int slots=0;slots<pSlots.length;slots++){
            pSlots[slots]=false;
        }
        guildRemaining = guild.length;
        nextGuildSlot = 0;
    }
    
    public void memberAdd(){
        nextGuildSlot=0;
        while(gSlots[nextGuildSlot]){
            nextGuildSlot++;
        }
        int[] charStats = charStats();
        
        guild[nextGuildSlot] = new Character(charStats);
        text("Guild Member "+(nextGuildSlot+1)+" had been registered");
        gSlots[nextGuildSlot]=true;
        
    }
    public int[] charStats(){
        int[] chosenStats = new int[6];
        //for(int i=0;i<6;i++){
            text("What stat do you want?");
            chosenStats[0]=keyboard.nextInt();
        //}
        
        chosenStats[1]=1;
        chosenStats[2]=1;
        chosenStats[3]=1;
        chosenStats[4]=1;
        chosenStats[5]=1;
        
        return chosenStats;
    }
    
    public void memberDelete(){
        for(int i=0;i<guild.length;i++){
            if(gSlots[i]){
                text((i+1)+". "+guild[i].strGet());
            }else{
                text("N/A");
            }
        }
        text("Type the number of the member you wish to remove");
        int del = keyboard.nextInt();
        gSlots[del-1]=false;
        
    }
    public void chooseParty(){
        for(int i=0;i<guild.length;i++){
            if(gSlots[i]){
                text((i+1)+". "+guild[i].strGet());
            }else{
                text("N/A");
            }
        }
        for(int i=0;i<party.length;i++){
            text("Type the number of who you wish to bring along");
            int choose = keyboard.nextInt();
            choose--;
            if(choose<=30&&!inParty[choose]){
                party[i]=guild[choose];
                inParty[choose]=true;
            }else{
                text("character is already in party. will remain blank");
            }
        }
    }
    
    public void showParty(){
        for(int i=0;i<party.length;i++){
            text((i+1)+". "+party[i].strGet());
        }
    }
    private void text(String text){
        System.out.println(text);
    }
    */
    
    //version 2. adds name. classes guild members by name. adds some error catching functions
    GuildManagerPoC(){
        guild = new Character[30];
        party = new Character[4];
        gSlots = new boolean[30];
        for(int slots=0;slots<gSlots.length;slots++){
            gSlots[slots]=false;
        }
        
        inParty = new boolean[30];
        for(int slots=0;slots<inParty.length;slots++){
            inParty[slots]=false;
        }
        pSlots = new boolean[4];
        for(int slots=0;slots<pSlots.length;slots++){
            pSlots[slots]=false;
        }
        guildRemaining = guild.length;
        nextGuildSlot = 0;
    }
    
    
    
    public void memberAdd(){
        nextGuildSlot=0;
        String theirName = "error";
        
        while(gSlots[nextGuildSlot]){
            nextGuildSlot++;
        }
        text("What will they be named?");
        theirName = keyboard.nextLine();
        theirName = keyboard.nextLine();
        int[] charStats = charStats();
        
        
        
        guild[nextGuildSlot] = new Character(charStats, theirName);
        text("Guild Member "+(nextGuildSlot+1)+" had been registered");
        gSlots[nextGuildSlot]=true;
        
    }
    public int[] charStats(){
        int[] chosenStats = new int[6];
        //for(int i=0;i<6;i++){
            text("What stat do you want?");
            chosenStats[0]=keyboard.nextInt();
        //}
        
        chosenStats[1]=1;
        chosenStats[2]=1;
        chosenStats[3]=1;
        chosenStats[4]=1;
        chosenStats[5]=1;
        
        return chosenStats;
    }
    
    public void memberDelete(){
        for(int i=0;i<guild.length;i++){
            if(gSlots[i]){
                text((i+1)+". "+guild[i].nameGet());
            }else{
                text("N/A");
            }
        }
        text("Type the number of the member you wish to remove");
        int del = keyboard.nextInt();
        gSlots[del-1]=false;
        
    }
    public void chooseParty(){
        for(int i=0;i<guild.length;i++){
            if(gSlots[i]){
                text((i+1)+". "+guild[i].nameGet());
            }else{
                text("N/A");
            }
        }
        for(int i=0;i<party.length;i++){
            text("Type the number of who you wish to bring along");
            int choose = keyboard.nextInt();
            choose--;
            if(choose<=30&&!inParty[choose]){
                party[i]=guild[choose];
                inParty[choose]=true;
            }else{
                text("character is already in party. will remain blank");
            }
        }
    }
    public void showParty(){
        for(int i=0;i<party.length;i++){
            text((i+1)+". "+party[i].nameGet());
        }
    }
    
    private void text(String text){
        System.out.println(text);
    }
    public static void main(String[] args){
        GuildManagerPoC guild = new GuildManagerPoC();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberAdd();
        guild.memberDelete();
        guild.chooseParty();
        guild.showParty();
    }
}
