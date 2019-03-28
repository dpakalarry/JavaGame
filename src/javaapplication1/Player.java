/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JOptionPane;

/**
 *
 * @author Devak Patel and Pavan Hirpara
 * @version 1.2.5
 * 
 */
public class Player {
    private int atk;    //Attack
    private int def;    //Defense
    private int exp;    //Experience
    private int lvl;    //Level
    private int[] inventory;
    private int typ;
    
    private String name;
    /**
    *   @param b boolean that tells whether player is generated at beginning of game 
    */
    public Player(boolean b)                 //true 
    {
        atk = (int)(((Math.random()+1)*5)+ 45);
        def = (int)(((Math.random()+1)*5)+ 35);
        exp = 0;
        lvl = 1;
        inventory = new int[6];
        if(b)
            name = JOptionPane.showInputDialog("What is your name?");
        typ = -1;
        while(!(typ>= 0)){
            Object[] options = {"Normal",
                           "Water",
                           "Fire",
                           "Ground"
            };

            typ = JOptionPane.showOptionDialog(null,
           "What Type would you like to be?",
           "Type",

           JOptionPane.YES_NO_CANCEL_OPTION,
           JOptionPane.QUESTION_MESSAGE,
           null,
           options,
           null);
        }
    }
    public int getTyp(){
            return typ;
    }
    public String getName(){
        return name;
    }
    public int getAtk(){
       return atk;
   } 
    public int getLvl(){
       return lvl;
   }
    public int getDef(){
       return def;
   }

    public int getExp(){
       return exp;
    }

    public int[] getInventory(){
        return inventory;
    }
    public void setName(String s){
        name = s;
    }

    public void addAtk(int atkInc){
        atk+= atkInc;
    }

    public void addDef(int defInc){
        def+= defInc;
    }

    public int addItem()
    {
       int random = (int)(Math.random()*100+1);
       if(random >= 1 && random <=49){
           inventory[0]++;
           return 0;
       }//Adds Health Potion @ 50%
       if(random >= 50 && random <=69){    
           inventory[1]++;  
           return 1;
       }//Adds Small Attack Potion @ 20%
       if(random >= 70 && random <=89){
           inventory[2]++;  
           return 2;
       }//Adds Small Defense Potion @ 20%
       if(random >= 90 && random <=94){
           inventory[3]++; 
           return 3;
       }//Adds Large Attack Potion @ 5%
       if(random >= 95 && random <=99){
           inventory[4]++;  
           return 4;
       }//Adds Large Defense Potion @ 5%
       if(random == 100){
           inventory[5]++;
           return 5;
       }//Adds One Hit Gem @ 1%
       return 0;
    }
     
    /**
        @param i int that gives item code
        @return boolean tells if player has enough of the item
    */
    public boolean useItem(int i){
         if(i >= 0 && i <= 5)
             if(inventory[i]>0){
                 inventory[i]--;
                 return true;      //returns true if there is that certain type of item in inventory
             }
         return false;             //returns false if there is no item
     }
    
    /**
        @param e int send in with number of exp
        @return boolean tells if player levels up
    */
    public int expAdd(int e) {
        if(lvl == 12)
            return -1;
        if ((exp + e)>100){
            lvl++;
            double rng = -3.25*lvl + 45;
            atk = (int)(((Math.random()+1)*5)+rng);
            rng = -1.5*lvl + 35;
            def = (int)(((Math.random()+1)*5)+ rng);
            int i;
            if((int)(Math.random()*2 + 1) == 1)
                i = addItem();
            else 
                i = -2;
            if(lvl == 12)
                exp = 0;
            else
                exp = (exp + e) % 100;
            JOptionPane.showMessageDialog(null,"You Leveled Up!");
            
            return i;          //returns true if level up
        }
            
        if((exp+e)<100){
                    exp+=e;
                }
       return -1;              //return false elsewise
        }
    }
    



