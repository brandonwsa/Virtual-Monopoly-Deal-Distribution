/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author brand
 */
public class Main {
    
    public static void main(String[] args){
        //make game
        Game VirtualMonopolyDeal = new Game();
        boolean playAgain = VirtualMonopolyDeal.runGame();
        
        //sleep before resetting game.
        try{
           System.out.println("Sleeping...");
           Thread.sleep(500); 
        }
        catch(InterruptedException e){
            System.out.println("Something happened while sleeping. e: "+e);
        }
        
        while(true){
            //if player wants to play again, reset game and run it again. Continue this till they system.exit() out.
            if (playAgain == true){
                VirtualMonopolyDeal.resetGame();
                playAgain = VirtualMonopolyDeal.runGame();
                
                try{
                    System.out.println("Sleeping...");
                    Thread.sleep(500); 
                }
                catch(InterruptedException e){
                    System.out.println("Something happened while sleeping. e: "+e);
                }
            }
            else{
                return;
            }
        }
        
    }
    
}
