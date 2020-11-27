package Objects;
import java.util.List;
import java.util.ArrayList;


public class Player{
    
    protected String name;
 //   protected int ID; //dont think we need
    protected int completedProperties;
    protected int totalMoney;
    protected Card lastCardPlayed;
    protected Card cardToPlay;
    protected List<Card> hand; //wont do anything until first card is added to hand.
    protected List<Card> money; //wont do anything until first money is added. //if this list is null, money = 0 in game.
//    protected List<Card>/*<PropertySlot>*/ properties; //wont do anything until first property is added.
    protected List<Card> discardDeck;//where the cards will be discarded..... do we need this? 
    //might be good to have an totalMoney, will add up all the money the player has. Property slot may be a 2d array
    protected List<PropertySlot> properties; //will be an arraylist that holds propertySlot object
    
    /**
     * Initiates object.
     */
    public Player(){
        init();
        
    }
    
    /**
     * creates object
     */
    protected void init(){
        completedProperties = 0;
        totalMoney = 0;
        hand = new ArrayList<Card>();
        money = new ArrayList<Card>();
        properties = new ArrayList<PropertySlot>();
        
        //make hand and fill it with null values as place holders.
        //When adding cards to the hand, null will be replaced with the card.
        for (int i=0; i<12; i++){
            hand.add(null);
        }
   //     lastCardPlayed = new Card(); //commented out to prevent class from having an error.
   
        //make property slots and add them to the properties arraylist.
        for (int i=0; i<10; i++){
            PropertySlot ps = new PropertySlot(i+1); //passes in property slot number
            properties.add(ps);
        }
   
    }
    
    public List getHand(){
        return hand;
    }
    
    public Card getLastCardPlayed(){
        return lastCardPlayed;
    }
    
    public List getMoney(){
        return money;
    }
    
    //unused
    public List getProperties(){
        return properties;
    }
    
    public int getCompletedProperties(){
        return completedProperties;
    }
    
    public String getName(){
        return name;
    }
    
    public int getTotalMoney(){
        return totalMoney;
    }
    
    public Card getCardToPlay(){
        return cardToPlay;
    }
    
    public void setLastCardPlayed(Card c){
        lastCardPlayed = c;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setCardToPlay(Card c/*int handSlotNum*/){
      //  cardToPlay = hand.get(handSlotNum-1); //minus 1 for correct index in player's list hand.
      cardToPlay = c;
    }
    
    /**
     * Adds a card to the players hand. Will find the first open spot in player hand that is null and replace it with a proper card.
     * @param card 
     */
    public void addToHand(Card card){
        int i = 0;
        
        //iterates through player hand finding first null spot to put card. Returns out once found.
        for (Card c : hand){ 
            if (c == null){
                hand.set(i, card);
                System.out.println("\nCard drawn: "+card.getName());
                return;
            }
            i++;
        }
    }
    
    protected void addMoney(Card card){
        money.add(card);
        totalMoney += card.getValue();
    }
    
    /**
     * Adds property card to propertySlot object based on passed in propertySlotColumn number
     * @param card
     * @param propertySlotColumn 
     */
    protected void addProperty(Card card, int propertySlotColumn){
        
        properties.get(propertySlotColumn-1).addPropertyCard(card); //minus 1 for correct index
        System.out.println("Property added to prop "+properties.get(propertySlotColumn-1));
        System.out.println("Slot "+properties.get(propertySlotColumn-1).getPropertySlotNumber()+" color is: "+properties.get(propertySlotColumn-1).getPropertyColor());
        properties.get(propertySlotColumn-1).printProperties();
        
    }
    
    /**
     * Adds a house to your properties
     * @param card
     * @param propertySlotColumn 
     */
    protected void addHouse(Card card, int propertySlotColumn){
        properties.get(propertySlotColumn-1).addHouseCard(card); //minus 1 for correct index
        System.out.println("House added to prop "+properties.get(propertySlotColumn-1));
        properties.get(propertySlotColumn-1).printProperties();
    }
    
    /**
     * Adds a hotel to your properties
     * @param card
     * @param propertySlotColumn 
     */
    protected void addHotel(Card card, int propertySlotColumn){
        properties.get(propertySlotColumn-1).addHotelCard(card); //minus 1 for correct index
        System.out.println("Hotel added to prop "+properties.get(propertySlotColumn-1));
        properties.get(propertySlotColumn-1).printProperties();
    }
    
    public void addCompletedProperty(){
        completedProperties++;
    }
    
    /**
     * takes card and removes it from player's hand list by setting it to null.
     * @param card 
     */
    protected void removeCardFromHand(Card card){
        int i = 0;
        
        //iterate through hand to find matching card to remove. Returns out once found.
        for (Card c : hand){ 
            if (c == card){
                hand.set(i, null); //set card to null
                return;
            }
            i++;
        }
    }
    
    /**
     * Draws card from deck.
     * @param c
     */
    public void drawCard(Card c){
        addToHand(c);
    }
    
    /**
     * Discards the card the player wants to.
     * @param card
     * @param discard
     */
    public void discardCard(Card card, Deck discard){
        
        //remove the card from the player's hand
        removeCardFromHand(card);
        
        //Add card to discard to discard deck. discards the card the player wants to.
        discard.addCard(card);
        System.out.println(card.getName()+" card was discarded");//included for testing/tracking purposes
    }
    
    /**
     * Plays passed in card.
     * @param card 
     */
    public void playCard(Card card){
        //if card == rentCard
        //  action.playRentCard(card);
    }
    //... add more of these action calls that will call action.
    
    
    /**
     * Plays a property card by adding it to player's properties and removing it from player's hand
     * @param propertySlot 
     * @return true if added. false if not able to add.
     */
    public boolean playPropertyCard(int[] propertySlot){
        Card c = getCardToPlay();
        int propertySlotColumn = propertySlot[0];
        PropertySlot propSlot = properties.get(propertySlotColumn-1); //property slot to add card to
        
        System.out.println("Trying to add "+c.getName()); //for testing
        System.out.println("Property color is: "+c.getPropertyColor()); //for testing
        
        if (c.getType().toLowerCase().equals("property") || c.getType().toLowerCase().equals("wildcard")){
            if (propSlot.canAddPropertyCard() == true){
                if (propSlot.isEmpty() == true){
                    addProperty(c, propertySlotColumn);
                    
                    //adjust rent amount
                    propSlot.setRentAmount();
                    
                    //remove card from player's hand.
                    removeCardFromHand(c);
                    
                    //check if property slot is completed. Will increase completedProperties if so.
                    _checkCompletedProperties(propSlot);
                    
                    return true;
                }
                else if (propSlot.getPropertyColor().toLowerCase().equals("multicolor")){
                    addProperty(c, propertySlotColumn);
                    //set new color for propSlot since wildcard is now deactivated
                    propSlot.setPropertyColor(c.getPropertyColor());
                    
                    //adjust rent amount
                    propSlot.setRentAmount();
                    
                    //remove card from player's hand.
                    removeCardFromHand(c);
                    
                    //check if property slot is completed. Will increase completedProperties if so.
                    _checkCompletedProperties(propSlot);
                    return true;
                } 
                //check for appropiate matching color between played card and propSlot color
                else if (c.getPropertyColor().toLowerCase().contains(propSlot.getPropertyColor())){
                    addProperty(c, propertySlotColumn);
                    
                    //adjust rent amount
                    propSlot.setRentAmount();
                    
                    //remove card from player's hand.
                    removeCardFromHand(c);
                    
                    //check if property slot is completed. Will increase completedProperties if so.
                    _checkCompletedProperties(propSlot);
                    return true;
                } 
                //check if the first card placed in property slot was a 2 color wildcard
                else if (propSlot.getPropertyColor().toLowerCase().contains(c.getPropertyColor())){
                    addProperty(c, propertySlotColumn);
                    //set new color for propSlot since 2 color wildcard is now deactivated, if it was the first property placed.
                    propSlot.setPropertyColor(c.getPropertyColor());
                    
                    //adjust rent amount
                    propSlot.setRentAmount();
                    
                    //remove card from player's hand.
                    removeCardFromHand(c);
                    
                    //check if property slot is completed. Will increase completedProperties if so.
                    _checkCompletedProperties(propSlot);
                    return true;
                }
                //if adding multicolor wildcard after a property is already placed
                else if (c.getPropertyColor().toLowerCase().equals("multicolor")){
                    addProperty(c, propertySlotColumn);
                    
                    //adjust rent amount
                    propSlot.setRentAmount();
                    
                    //remove card from player's hand.
                    removeCardFromHand(c);
                    
                    //check if property slot is completed. Will increase completedProperties if so.
                    _checkCompletedProperties(propSlot);
                    return true;
                }
                else{
                    System.out.println("Can't place property card. Invalid card");
                }
            }
            else{
                System.out.println("Can't add card, property slot is full.");
            }
        }
        else{
            System.out.println("Not a property or wildcard");
        }
        
        return false;
        
   /*     Card c = getCardToPlay();
        int propertySlotColumn = propertySlot[0]; //column of properties property is being added to.
        
        System.out.println(c.getName()); //for testing
        
        System.out.println("Property added to slot: "+propertySlot[0]+" "+propertySlot[1]); //for testing
        System.out.println("Property color is: "+c.getPropertyColor());
        
        //add card to player's properties
        addProperty(c, propertySlotColumn);
        
        //remove card from player's hand.
        removeCardFromHand(c); */
    }
    
    
    public boolean playHouseOrHotelCard(int[] propertySlot){
        Card c = getCardToPlay();
        int propertySlotColumn = propertySlot[0];
        PropertySlot propSlot = properties.get(propertySlotColumn-1); //property slot to add card to
        
        System.out.println("Trying to add "+c.getName()); //for testing
        System.out.println("Property isCompleted: "+propSlot.getIsCompleted()); //for testing
        
        //check to make sure not railroad or utility
        if (!c.getPropertyColor().equals("railroad") && !c.getPropertyColor().equals("utility")){
            //play house card
            if (propSlot.canAddHouse() == true && !c.getName().contains("hotel")){
                addHouse(c, propertySlotColumn);
                
                //adjust rent amount
                propSlot.setRentAmount();
                
                //remove card from player's hand.
                removeCardFromHand(c);

                return true;
            }
            //play hotel card
            else if (propSlot.canAddHotel() == true){
                addHotel(c, propertySlotColumn);
                
                //adjust rent amount
                propSlot.setRentAmount();
                
                //remove card from player's hand.
                removeCardFromHand(c);

                return true;
            }
        }
        else {
            System.out.println("Can't add house or hotel to "+c.getPropertyColor());
        }
        
         
        return false;    
    }
    
    
    public void playMoneyCard(){
        Card c = getCardToPlay();
        
        System.out.println(c.getName()); //for testing
        System.out.println("Added money"); //for tetsing

        //adds card to player's list of money. Also adds the value of the card to player's total money
        addMoney(c);
        
        //remove card from player's hand.
        removeCardFromHand(c);
    }
    
    /**
     * Checks if any properties are completed
     * @param propSlot 
     */
    protected void _checkCompletedProperties(PropertySlot propSlot){
        if (propSlot.getIsCompleted() == true){
            completedProperties++;
        }
            
    }
    
    /**
     * Checks if player is human or bot
     * @return true if human, false if not.
     */
    public boolean isHuman(){
        if (!name.equals("bot_1") && !name.equals("bot_2")){
            return true;
        }
        else{
           return false;
        }  
    }
    
    /**
     * Iterates through hand to see how many null cards. If all null, then hand is empty.
     * @return true if empty
     */
    public boolean handIsEmpty(){
        int i = 0;
        
        for (Card c : hand){
            if (c == null){
                i++;
            }
        }
        
        if (i == 12){
            return true;
        }
        return false;
    }
    
    public void printHand(){
        for (int i=0; i<hand.size(); i++){
            if (hand.get(i) != null){
                System.out.println(hand.get(i).getName());
            }
            
        }
            
    }
    
}