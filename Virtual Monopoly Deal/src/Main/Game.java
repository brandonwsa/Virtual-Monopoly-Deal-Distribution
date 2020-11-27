/*
 * This class will house the game logic needed to play the game.
 * 
 */
//TESTING MY BRANCH OUT :)
package Main;

import java.util.List;
import java.util.ArrayList;
import Objects.Player;
import Objects.Bot;
import Objects.Deck;
import Objects.Card;
import GUI.GamePlayScreen;
import GUI.MainMenu;

/**
 * Refactor code as much as possible when adding new additions to keep this class clean and easy to read!
 * @author brand, becccccccaaaaa
 */
public class Game {
    
    private int numberOfPlayers; //used to keep track of how many players(bots) to play against
    private String name; //name of your player.
//    private boolean inPreGameState; //will indicate when the game is in or out of the pregame state setup phase.
                                    //When true, things like, get player name, player count will occur. This eliminates these methods being called each pass through the game's main loop.
    private Player player; //will always be initiliazed.
    private Bot bot_1; //default bot, will always be initialized.
    private Bot bot_2; //will only be declared, unless total number of players playing is 3, then will be initialized.
    private Deck gameDeck;
    private Deck discardDeck; //used to house the cards that are discarded.
    private GamePlayScreen GPS;
    private MainMenu MM;
    private int difficultyLevel;
    private int handSlotPressed;
    private boolean playerTurn;//used to track who's turn it is
    private boolean bot_1Turn;
    private boolean bot_2Turn;
    private boolean winnerFound;
    private int playCount;//used to track the amount of plays within a turn
    private Player winner; //used for when a winner is found to pass name to winner screen

    
    
    /**
     * Constructor.
     */
    public Game(){
        init();
    }
    
    private void init(){
        MM = new MainMenu();
        GPS = new GamePlayScreen();
        MM.setGamePlayScreen(GPS);
        numberOfPlayers = 0;
        difficultyLevel = 0;
  //      inPreGameState = true;
        discardDeck = new Deck();
        handSlotPressed = 0;
        playerTurn = true;
        bot_1Turn = false;
        bot_2Turn = false;
        winnerFound = false;
        playCount = 0;
        
        runGame();
    }
    
    /**
     * Runs the main game logic.
     */
    public void runGame(){
        
        MM.setVisible(true);
        
        try{
            boolean p_first_turn = true;
            //get game setup info, player name, player count.
            while(numberOfPlayers == 0 || difficultyLevel == 0){
                numberOfPlayers = GPS.getNumberOfPlayers();
                difficultyLevel = GPS.getDifficultyLevel();
                name = GPS.getPlayerName();
            //    checkNumberOfPlayers();//gets player count.
            //    checkDifficultyLevel();
            //    checkPlayerName();//gets player name.   
            }
            System.out.println("Name: "+name);
            System.out.println("Diff level: "+difficultyLevel); //for testing
            System.out.println("Number of players: "+numberOfPlayers); //for testing

            //set player name on GPS
        //    GPS.setPlayerName(name);

            //create deck Object
            createDeck();

            //make players and bot objects.
            createPlayersAndBots();

            //sets the players hand in gameplay screen to their cards
            setPlayerHand();

            System.out.println("Entering main game loop"); //for testing

            //main game loop.
      //      int bcount = 0;
            boolean p_dealed = false;
            boolean b_dealed = false;

            while(winnerFound == false){
                if(playerTurn){
                    if(playCount == 0 && p_dealed == false && p_first_turn == true){
                        //deal out 2 cards at beginning of turn
                        drawCard(player);
                        drawCard(player);
                        GPS.hideHandMenu();
                        p_dealed = true;
                        p_first_turn = false;
                    }

                    playerTakeTurn();
                    reset_GPS_button_values();

                    if(playCount >= 3){
                        playerTurn = false;
                        bot_1Turn = true;
                        playCount = 0;
                        p_dealed = false;
                        p_first_turn = true;
                        System.out.println("Taking bot turn...");//for testing
                    }
                }
                else if (bot_1Turn){
                    //deal 2 cards to bot
                    if (playCount == 0 && b_dealed == false){
                        drawCard(bot_1);
                        drawCard(bot_1);
                        b_dealed = true;
                    }

                    botTakeTurn(bot_1);

                    if(playCount >= 3){ 
                        //check if only 2 players or 3.
                        if (numberOfPlayers == 2){
                            playerTurn = true;
                            System.out.println("Taking player turn...");//for testing
                        }
                        else {
                            bot_2Turn = true;
                            System.out.println("Taking bot_2 turn...");//for testing
                        }

                        bot_1Turn = false;
                        playCount = 0;
                        b_dealed = false;
                    }
                }
                else if (bot_2Turn){
                    //deal 2 cards to bot
                    if (playCount == 0 && b_dealed == false){
                        drawCard(bot_2);
                        drawCard(bot_2);
                        b_dealed = true;
                    }

                    botTakeTurn(bot_2);

                    if(playCount >= 3){ 
                        playerTurn = true;
                        bot_2Turn = false;
                        playCount = 0;
                        b_dealed = false;
                        System.out.println("Taking player turn...");//for testing
                    }
                }
                winnerFound = checkForWinner();

            }

            //reset pre game state incase player plays again
        //    PlayScreen.toGamePlayScreen = true;

            //display winner screen
            GPS.displayWinnerScreen(winner.getName(), winner.getTotalMoney(), winner.getCompletedProperties());
            
            while (GPS.getPlayAgain() != true){
                //do nothing, wait for user to click play again or exit game.
                //clears terminal
                System.out.println("");
            }
            
            //reset game if user wants to play again.
            resetGame();
        }
        catch (Exception e){
            System.out.println("Something went wrong: "+e);
        }
        
        
    }
    
    
    
    /**
     * Will get the number of players to play against from PlayScreen.java
     */
  /*  private void checkNumberOfPlayers(){
        if(PlayScreen.toGamePlayScreen == false){
                numberOfPlayers = PlayScreen.numberOfPlayers;
             //   System.out.println(); //for some reason, this println statement is needed here inorder for the loop this method is in to exit properly when it's suppose to........
        }
        else{ //pre game state is over, set to false.
            inPreGameState = false;
        }
        
    } */
    
   /*  private void checkDifficultyLevel(){
        if(PlayScreen.toGamePlayScreen == false){
                difficultyLevel = PlayScreen.difficultyLevel;
             //   System.out.println(); //for some reason, this println statement is needed here inorder for the loop this method is in to exit properly when it's suppose to........
        }
        else { //pre game state is over, set to false.
            inPreGameState = false;
        }
        
    } */
    
    /**
     * Will get the name the user inputted from PlayScreen.
     */
  /*  private void checkPlayerName(){
        
        if(PlayScreen.toGamePlayScreen == false){
            name = PlayScreen.playerName;
        }
        else{ //pre game state is over, set to false.
            inPreGameState = false;
        }
    } */
    
    /**
     * Checks for a winner
     * @return boolean true if found
     */
    private boolean checkForWinner(){
        if (numberOfPlayers == 3){
            if (player.getCompletedProperties() == 3){
                System.out.println("Player IS WINNER!");
                winner = player;
                return true;
            }
            else if (bot_1.getCompletedProperties() == 3){
                System.out.println("Bot_1 IS WINNER!");
                winner = bot_1;
                return true;
            }
            else if (bot_2.getCompletedProperties() == 3){
                System.out.println("Bot_2 IS WINNER!");
                winner = bot_2;
                return true;
            }
        }
        else {
            if (player.getCompletedProperties() == 3){
                System.out.println("Player IS WINNER!");
                winner = player;
                return true;
            }
            else if (bot_1.getCompletedProperties() == 3){
                System.out.println("Bot_1 IS WINNER!");
                winner = bot_1;
                return true;
            }
        }
        
        
        return false;
    }
    
    
    
    /**
     * Will create the player and bot objects. Also sets the name of the player.
     * If numberOfPlayers wasn't set properly to be > 0, then print a message.
     * Also deals each player their 5 starting cards.
     */
    private void createPlayersAndBots(){
        //create player and bots.
        if (numberOfPlayers > 0){
            //make player and set player name.
            player = new Player();
            player.setName(name);
            
           //add 5 cards to player hand
            for(int i = 0; i < 5;i++){
                player.addToHand(gameDeck.getTopCard());
            }
            
            //make bot 1
            bot_1 = new Bot();
            bot_1.setDifficulty(difficultyLevel);
            bot_1.setName("bot_1");
            
            //add 5 cards to Bot_1 hand
            for(int i = 0; i < 5;i++){
                bot_1.addToHand(gameDeck.getTopCard());
            }
            
            //if player selected to play with 3 total players, then make the 2nd bot.
            if (numberOfPlayers == 3){
                bot_2 = new Bot();
                bot_2.setDifficulty(difficultyLevel);
                bot_2.setName("bot_2");
                
                //add 5 cards to Bot_2 hand
                for(int i = 0; i < 5;i++){
                    bot_2.addToHand(gameDeck.getTopCard());
                }
            }
            else{
                GPS.hideThirdPlayer();
            }
        }
        else{ //if numberOfPlayers was some how not > 0 after player selected amount of players. Will happen if player hits "Go" while not selecting number of players from PlayScreen.java
            System.out.println("Error when making player and bots. NumberOfPlayers = "+numberOfPlayers);
        }
    }
    
    /**
     * Creates the game play deck.
     */
    private void createDeck(){
        gameDeck = new Deck();
        gameDeck.fillDeck();
        gameDeck.shuffle();
    //    gameDeck.printCards();
    }
    
    /**
     * gets the card names from the player hand and calls GamePlayScreen to set the images.
     */
    private void setPlayerHand(){
        ArrayList cardImagePaths = new ArrayList();
        Card c;
        List<Card> hand = player.getHand();
        
        try{
            for (int i=0; i<hand.size(); i++){
                c = hand.get(i);
                
                // if proper card in hand
                if (c != null){
                    cardImagePaths.add(c.getImagePath());
           //     System.out.println(cardImagePaths.get(i));
                }
                
            }
            GPS.setPlayerStartingHand(cardImagePaths);
        }
        catch(Exception e){
            System.out.println("Error when setting player hand with card images in GPS. e:"+e);
        }
        
        
    }
    
    
    /**
     * The actions the player can take when taking their turn.
     */
    private void playerTakeTurn(){
        
        //see if player has taken max amount of turns
        if(playCount >=3){
            //switch Players 
            System.out.println("Switch players");
            return;
        }
        
        //checking for draw card button pressed
        if(GPS.getYourCardDeckPressed()==true){ //will remove in future so player cant keep drawing cards. For testing now
        //    drawCard(player); //commentout to remove functionality.
            return;
        }
        //checking to see if end turn early was pressed 
        if(GPS.getEndTurnEarlyPressed()==true){
            endTurnEarly();
             return;
        }
          
        //see if hand slot button was pressed.
       
        handSlotPressed = GPS.checkHandSlotButtonPressed();
        if (handSlotPressed > 0){
            System.out.println("\n Handslot pressed: "+handSlotPressed); //for testing

            //set card to play for player
            List<Card> hand = player.getHand();
            player.setCardToPlay(hand.get(handSlotPressed-1)); //minus one gives correct index.
            System.out.println("Card pressed: "+player.getCardToPlay()); //for testing

            // if the card player wants to play is not null (empty card slot)
            if (player.getCardToPlay() != null){

                //will be 0 if money button pressed, 1 if property button pressed, 2 if discard deck was pressed, and -1 if somehow nothing pressed.
                int slotButtonPressed = waitForSlotButtonPress(hand);


                if (player.getCardToPlay() != null){ //has to recheck for null card incase player chose different card after picking first one.
                    System.out.println("type of slot pressed: "+slotButtonPressed);

                    try{
                        
                        //check card type to play and get card name.
                        Card c = player.getCardToPlay();
                        String cardType = c.getType().toLowerCase();
                        String cardName = c.getName();

                        if(slotButtonPressed==2){ //if discard button pressed
                             discardCard(player);
                             return;
                        }
                        else if ((cardType.equals("property") || cardType.equals("wildcard")) && slotButtonPressed == 1){ //slotButtonPressed == 1 means that a property slot was pressed.
                            playPropertyCard(player);
                            return;
                        }
                        else if ((cardType.equals("money") || cardType.equals("action") || cardType.equals("wild-rent") || cardType.equals("rent")) && slotButtonPressed == 0){//player is playing a card to add to their bank.
                            playMoneyCard(player);
                            return;
                        }
                        else if (cardType.equals("rent") && slotButtonPressed != 1){
                           playRentCard();
                           return;
                        }
                        else if (cardType.equals("wild-rent") && slotButtonPressed != 1){
                           playWildRentCard();
                           return;
                        }
                        else if ((cardType.equals("action") && slotButtonPressed != 1) || cardName.contains("house") || cardName.contains("hotel")){
                           playActionCard();
                           return;
                        }
                        else{ //no valid actions made
                           player.setCardToPlay(null);
                           return; //since no valid play was made.
                        }
                    }
                    catch(Exception e){
                        System.out.println("Can't play this card card. e:"+e);
                        GPS.setYourMoneySlotButtonAction(false);
                    }
                }
            }
        }
        //checking for draw card button pressed
        if(GPS.getYourCardDeckPressed()==true){ //will remove in future so player cant keep drawing cards. For testing now
        //   drawCard(player); //commentout to remove functionality.
           return;
       }
        //checking to see if end turn early was pressed 
        if(GPS.getEndTurnEarlyPressed()==true){
            endTurnEarly();
            return;
       }
        
        
        if(playCount >=3){
            //switch Players 
            System.out.println("Switch players");
            return;
        } 
   }
    
    
    /**
     * The actions the bot will take
     */
    private void botTakeTurn(Bot b){
        //bot picks a random card and sets it as the card to play
        b.setCardToPlay(b.pickACard());
        
        try {
            System.out.println("Bot trying to play: "+b.getCardToPlay().getName()); //for testing
        }
        catch(Exception e){
            System.out.println("Bot has no card to play...");
        }
        
        
        //picks a play to make
        int play = b.pickAPlay();
        
        if (b.getCardToPlay() != null){
            try{          
                //check card type to play and get card name.
                Card c = b.getCardToPlay();
                String cardType = c.getType().toLowerCase();
                String cardName = c.getName();

                if(play == 6){ //if discard button pressed
                    System.out.println("\nBot is discaring card...");
                    discardCard(b);
                    return;
                }
                else if (play == 0){
                    System.out.println("\nBot is ending turn early...");
                    endTurnEarly();
                }
                else if ((cardType.equals("property") || cardType.equals("wildcard"))/* && play == 2*/){ //slotButtonPressed == 1 means that a property slot was pressed.
                    System.out.println("\nBot is adding property...");
                    playPropertyCard(b);
                    return;
                }
                else if ((cardType.equals("money") || cardType.equals("action") || cardType.equals("wild-rent") || cardType.equals("rent"))/* && play == 1*/){//player is playing a card to add to their bank.
                    System.out.println("\nBot is adding money...");
                    playMoneyCard(b);
                    return;
                }
                else if (cardType.equals("rent")/* && play == 4*/){
                    System.out.println("\nBot is play a rent card...");
                   playRentCard();
                   return;
                }
                else if (cardType.equals("wild-rent")/* && play == 5*/){
                   System.out.println("\nBot is playing a wild-rent card...");
                   playWildRentCard();
                   return;
                }
                else if ((cardType.equals("action")/* && play == 3*/) || cardName.contains("house") || cardName.contains("hotel")){
                   System.out.println("\nBot is playing action card...");
                   playActionCard();
                   return;
                }
                else{ //no valid actions made
                   b.setCardToPlay(null);
                   return; //since no valid play was made.
                }
            }
            catch(Exception e){
                System.out.println("Can't play this card card. e:"+e);
                GPS.setYourMoneySlotButtonAction(false);
            }
        }
        else{
            System.out.println("Bot picked null card...");
        }
        
        if (b.handIsEmpty() == true){
            System.out.println("Bot has no more cards in hand...");
            endTurnEarly();
        }
    }
    
    /**
     * Resets buttons values in GPS
     */
    private void reset_GPS_button_values(){
        GPS.setYourMoneySlotButtonAction(false);
        GPS.setYourPropertySlotPressed(0, 0);
        GPS.setYourDiscardDeckPressed(false);
        GPS.setYourCardDeckPressed(false);
        GPS.setEndTurnEarlyPressed(false);
    }
    
    /**
     * Will wait for either a money slot or property slot or discard deck to be pressed.
     * yourPropertySlotPressed will contain number other than 0's for the 2 indexes if a property slot is pressed. The numbers will be that property slots matrix location.
     * @param hand
     * @return 0 if money slot pressed. 1 if property slot pressed, 2 if discard deck pressed
     */
    private int waitForSlotButtonPress(List<Card> hand){
        //get button action results set up.
        int[] yourPropertySlotPressed = GPS.getYourPropertySlotPressed(); //will contain 2 ints, index for row and index for column of where property button was pressed.
        boolean yourMoneySlotPressed = GPS.getYourMoneySlotButtonAction(); //will be true if money slot is pressed. has setter and getting in GPS.
        boolean yourDiscardDeckPressed = GPS.getYourDiscardDeckPressed();
        int tempHandSlotPressed = 0; //used in while loop to see if user clicked different card, without changing value of original handSlotPressed, unless diff card was pressed.

        //have thread sleep, needed for while loop to work
        //I think it lets the system catch up with what is being asked in the loop below.
        //without this, money cards arent played right.
        try{
           Thread.sleep(1000); 
        }
        catch(InterruptedException e){
            System.out.println("Something happened while sleeping. e: "+e);
        }
        
        //loop until user presses either a money slot or property slot or the discard deck, or a different card to play
        while (yourMoneySlotPressed == false && (yourPropertySlotPressed[0] == 0 && yourPropertySlotPressed[1] == 0 && yourDiscardDeckPressed == false)){ //once either money button pressed or a propertyslot button was pressed or discard deck or card deck was pressed, will exit loop.
            yourPropertySlotPressed = GPS.getYourPropertySlotPressed(); //recheck if property slot button was pressed.
            yourMoneySlotPressed = GPS.getYourMoneySlotButtonAction(); //recheck if money slot button was pressed.
            tempHandSlotPressed = GPS.checkHandSlotButtonPressed(); //recheck if player clicked a different card to play.
            yourDiscardDeckPressed = GPS.getYourDiscardDeckPressed();//recheck if discard deck was pressed

            if (tempHandSlotPressed > 0){ //if player did click a different card to play.
                player.setCardToPlay(hand.get(tempHandSlotPressed-1)); //minus one gives correct index.
                System.out.println("Card pressed: "+player.getCardToPlay());
                handSlotPressed = tempHandSlotPressed;
            }

        }
        System.out.println("Money slot pressed: "+yourMoneySlotPressed+"\t Property slot num is: "+yourPropertySlotPressed[0]+" "+yourPropertySlotPressed[1]); //for testing
        
        if (yourMoneySlotPressed == true){
            return 0;
        }
        else if(yourPropertySlotPressed[0] != 0 && yourPropertySlotPressed[1] != 0){
            return 1;
        }
        else if(yourDiscardDeckPressed == true){
            return 2;
        }
        
        return -1;
        
    }
    
    /**
     * Plays the property the player wants to
     * May refactor these in future for bot objects to use these methods as well
     */
    private void playPropertyCard(Player p){
        //capture card to play
        Card c = p.getCardToPlay();
        int[] yourPropertySlotPressed;
        
        //play property card if human
        if (p.isHuman() == true){
            yourPropertySlotPressed = GPS.getYourPropertySlotPressed(); //int array of where the property is located in the matrix of player's properties.
        }
        //if a bot, will find where to place property
        else {
            if (p.getName().equals("bot_1")){
                yourPropertySlotPressed = bot_1.pickPropertySlot(c);
            }
            else {
                yourPropertySlotPressed = bot_2.pickPropertySlot(c);
            }
            
        }
        
        boolean ableToPlay = p.playPropertyCard(yourPropertySlotPressed);

        System.out.println("ableToPlay property = "+ableToPlay);
        
        if (ableToPlay == true){
            //display card in GUI if human
            //remove card image from hand in GUI if human
            if (p.isHuman() == true){
                GPS.displayPlayedPropertyCard(c.getImagePath());
                GPS.removeCardImageFromHand(handSlotPressed);
            }
            //else, bot actions with GUI
            else {
                GPS.displayBotPlayedPropertyCard(c.getImagePath(), yourPropertySlotPressed, p.getName());
            }

            playCount++;
        }
        
        
        //reset back to no property slot as we are done
        GPS.setYourPropertySlotPressed(0, 0);
        
        
    }
    
    /**
     * Plays the money card the player wants to
     * May refactor these in future for bot objects to use these methods as well
     */
    private void playMoneyCard(Player p){
        //capture card to play
        Card c = p.getCardToPlay();
        
        //play money card
        p.playMoneyCard();
        
        //display player money count
        GPS.setYourTotalMoney(p.getTotalMoney(), p.getName());
        
        //display card in GUI
        GPS.displayPlayedMoneyCard(c.getImagePath(), p.getName());
        
        //remove card image from player's hand in GUI if human.
        if (p.isHuman() == true){
            GPS.removeCardImageFromHand(handSlotPressed);
        }
        
        
        playCount++;
    }
    
    /**
     * Plays the rent card player wants to
     * May refactor these in future for bot objects to use these methods as well
     */
    private void playRentCard(){
        playCount++;
    }
    
    /**
     * Plays wild rent card player wants to
     * May refactor these in future for bot objects to use these methods as well
     */
    private void playWildRentCard(){
        playCount++;
    }
    
    /**
     * Plays action card player wants to
     * May refactor these in future for bot objects to use these methods as well
     */
    private void playActionCard(){
        //capture card to play
        Card c = player.getCardToPlay();
        
        //if action card is house or hotel card
        if (c.getName().toLowerCase().contains("house") || c.getName().toLowerCase().contains("hotel")){
            playHouseOrHotelCard(c);
        }
        
        playCount++;
        
    }
    
    /**
     * Plays house or hotel card
     * @param c 
     */
    private void playHouseOrHotelCard(Card c){
        //play house or hotel card
        int[] yourPropertySlotPressed = GPS.getYourPropertySlotPressed(); //int array of where the property is located in the matrix of player's properties.
        boolean ableToPlay = player.playHouseOrHotelCard(yourPropertySlotPressed);

        System.out.println("ableToPlay = "+ableToPlay);

        if (ableToPlay == true){
            //display card in GUI
            GPS.displayPlayedPropertyCard(c.getImagePath());

            //remove card image from hand in GUI
            GPS.removeCardImageFromHand(handSlotPressed);
        }


        //reset back to no property slot as we are done
        GPS.setYourPropertySlotPressed(0, 0);
    }
    
    /**
     * Discards selected card
     * May refactor these in future for bot objects to use these methods as well
     */
    private void discardCard(Player p){
         //capture card to play
        Card c = p.getCardToPlay();
        
        //Add card to discard deck
        p.discardCard(c, discardDeck);
        
        GPS.addCardImageToDiscardDeck(c.getImagePath());
        
        if (p.isHuman() == true){
            //remove card image from hand in GUI
            GPS.removeCardImageFromHand(handSlotPressed);
        }
        
        
        playCount++;
    }
   
    
     /**
     * Adds top card to hand and to GUI
     * May refactor these in future for bot objects to use these methods as well
     */
    private void drawCard(Player p){
        
        //capture card to play
        List<Card> hand = p.getHand();
        for (Card c : hand){
            if (c == null){
                //capture card to draw.
                Card card = gameDeck.getTopCard();
                
                //draw card
                p.drawCard(card);

                //add card to hand in GUI if player's turn
                if (playerTurn == true){
                    GPS.addCardImageToHand(card.getImagePath());
                }
                
                
                //returns out of method once added
                return;
            }
        }
        //if no free hand slot was found, will reach this sys out stmt
        System.out.println("Card was not drawn: player hand is full");
    }

    private void endTurnEarly() {
        playCount = 3;
        System.out.println("Ending turn early...");
    }
    
    public void resetGame(){
        System.out.println("Resetting game...");
        init();
    }
    
    public static void main(String[] args){
        Game g = new Game();
    }
   
}
