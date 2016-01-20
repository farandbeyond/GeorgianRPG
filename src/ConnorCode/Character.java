/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeorgianRPG;

/**
 *
 * @author Connor
 */
public class Character {
    private Strength str;
    private Dexterity dex;
    private Constitution con;
    private Intelligence ine;
    private Wisdom wis;
    private Charisma cha;
    private boolean exist;
    private String name;
    
    Character(int arr[], String name){
        exist = true;
        this.name=name;
        str = new Strength(arr[0]);
        dex = new Dexterity(arr[1]);
        con = new Constitution(arr[2]);
        ine = new Intelligence(arr[3]);
        wis = new Wisdom(arr[4]);
        cha = new Charisma(arr[5]);
    }
    public void showStats(){
        text(strGet());
        text(dexGet());
        text(conGet());
        text(ineGet());
        text(wisGet());
        text(chaGet());        
    }
    
    public int strGet(){
        return str.get();
    }
    public int dexGet(){
        return dex.get();
    }
    public int conGet(){
        return con.get();
    }
    public int ineGet(){
        return ine.get();
    }
    public int wisGet(){
        return wis.get();
    }
    public int chaGet(){
        return cha.get();
    }
    public boolean exists(){
        return exist;
    }
    public String nameGet(){
        return name;
    }
    
    private class Strength{
        private int stat;
        Strength(int str){
            stat = str;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    private class Dexterity{
        private int stat;
        Dexterity(int dex){
            stat = dex;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    private class Constitution{
        private int stat;
        Constitution(int con){
            stat = con;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    private class Intelligence{
        private int stat;
        Intelligence(int ine){
            stat = ine;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    private class Wisdom{
        private int stat;
        Wisdom(int wis){
            stat = wis;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    private class Charisma{
        private int stat;
        Charisma(int cha){
            stat = cha;
        }

        public int get(){
            return stat;
        }
        public void level(int increase){
            stat+= increase;
        }
    }
    
    private void text(int text){
        System.out.println(text);
    }
}
