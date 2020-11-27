package Objects;
import java.util.Random;
import java.util.ArrayList;

public class Bot extends Player{
    
    private int difficultyLevel;
 //   private Card cardPlayed;
    
    public Bot(){
        super.init();
        
    }
    
    public void setDifficulty(int diffLevel){
        difficultyLevel = diffLevel;
    }
    
    public int getDifficulty(){
        return difficultyLevel;
    }
    
    /**
     * Generates a random number to decide which play the bot should make based off of difficulty level
     * play 0 = end turn early; play 1 = play money; play 2 = play property; play 3 = play action
     * play 4 = play rent; play 5 = play wild-rent; play 6 = discardCard
     * @return int play
     */
    public int pickAPlay(){
        Random rand = new Random();
        
        //pick a play. 6 possible plays. 0-6
        int play = rand.nextInt(7);
        
        return play; //returns a value to represent if action was performed correctly.
    }
    
    /**
     * Picks a random card to play
     * @return Card c
     */
    public Card pickACard(){
        Random rand = new Random();
        
        ArrayList<Card> playableCards = new ArrayList<Card>();
         
        //adds non null cards to a list to pick from.
        for (Card c : hand){
            if (c != null){
                playableCards.add(c);
            }
        }
        
        //picks a random card from list of valid cards that are not null
        if (playableCards.size() != 0){
            Card c = playableCards.get(rand.nextInt(playableCards.size()));
            return c;
        }
        
        //if no valid cards, will be null
        System.out.println("Bot is out of valid card's to play");
        Card c = null;
        
        
        return c;
    }
    
    /**
     * Picks a propertySlot to play a property card in.
     * @param c
     * @return int[] propertyslot
     */
    public int[] pickPropertySlot(Card c){
        int[] propertySlot = new int[2];
        int i = 1; //used to keep track of property slot column
        
        //check to see if property can be added to an existing property
        //will return property that is the first empty slot if not.
        for (PropertySlot propSlot : properties){
            propertySlot[0] = i;
            propertySlot[1] = propSlot.getTotalProperties()+1;
            
            if (propSlot.isEmpty() == true){
                return propertySlot;
            }
            else if (propSlot.getPropertyColor().toLowerCase().equals("multicolor")){
                
                return propertySlot;
            } 
            //check for appropiate matching color between played card and propSlot color
            else if (c.getPropertyColor().toLowerCase().contains(propSlot.getPropertyColor())){
                
                return propertySlot;
            } 
            //check if the first card placed in property slot was a 2 color wildcard
            else if (propSlot.getPropertyColor().toLowerCase().contains(c.getPropertyColor())){
               
                return propertySlot;
            }
            //if adding multicolor wildcard after a property is already placed
            else if (c.getPropertyColor().toLowerCase().equals("multicolor")){
                
                return propertySlot;
            }
     
            i++;
        }
        
        //should never reach here.
        System.out.println("Wasnt able to find propertySlot for bot...");
        
        return propertySlot;
    }
    
}
