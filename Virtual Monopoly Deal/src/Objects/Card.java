package Objects;

/* Card.Java */
public class Card{
    
    private String name;
    private String type;
    private String imagePath;
    private int value;
//    private final int[] values = {0, 1, 2, 3, 4, 5, 10}; //used to house value of cards.
    private final String[] cardNames = {"$10M-money-card (Custom)", "$1M-money-card1 (Custom)", "$1M-money-card2 (Custom)", "$1M-money-card3 (Custom)", "$1M-money-card4 (Custom)", 
        "$1M-money-card5 (Custom)", "$1M-money-card6 (Custom)", "$2M-money-card1 (Custom)", "$2M-money-card2 (Custom)", "$2M-money-card3 (Custom)", "$2M-money-card4 (Custom)", "$2M-money-card5 (Custom)", 
        "$3M-money-card1 (Custom)", "$3M-money-card2 (Custom)", "$3M-money-card3 (Custom)", "$4M-money-card1 (Custom) (Custom)", "$4M-money-card1 (Custom)", "$4M-money-card2 (Custom)", 
        "$4M-money-card3 (Custom)", "$5M-money-card1 (Custom)", "$5M-money-card2 (Custom)", "all-color-wild-rent-card1 (Custom)", "all-color-wild-rent-card2 (Custom)", "all-color-wild-rent-card3 (Custom)", 
        "blue-and-green-rent-card1 (Custom)", "blue-and-green-rent-card2 (Custom)", "brown-and-light-blue-rent-card1 (Custom)", "brown-and-light-blue-rent-card2 (Custom)", "brown-property-card1 (Custom)", 
        "brown-property-card2 (Custom)", "dark-blue-and-green-wildcard-card (Custom)", "dark-blue-property-card1 (Custom)", "dark-blue-property-card2 (Custom)", "deal-breaker-action-card1 (Custom)", 
        "deal-breaker-action-card2 (Custom)", "debt-collector-action-card1 (Custom)", "debt-collector-action-card2 (Custom)", "debt-collector-action-card3 (Custom)", "double-the-rent-action-card1 (Custom)", 
        "double-the-rent-action-card2 (Custom)", "force-deal-action-card1 (Custom)", "force-deal-action-card2 (Custom)", "force-deal-action-card3 (Custom)", "green-property-card1 (Custom)", 
        "green-property-card2 (Custom)", "green-property-card3 (Custom)", "hotel-action-card1 (Custom)", "hotel-action-card2 (Custom)", "hotel-action-card3 (Custom)", "house-action-card1 (Custom)", 
        "house-action-card2 (Custom)", "house-action-card3 (Custom)", "its-my-birthday-action-card1 (Custom)", "its-my-birthday-action-card2 (Custom)", "its-my-birthday-action-card3 (Custom)", 
        "just-say-no-action-card1 (Custom)", "just-say-no-action-card2 (Custom)", "just-say-no-action-card3 (Custom)", "light-blue-and-brown-wildcard-card (Custom)", "light-blue-property-card1 (Custom)", 
        "light-blue-property-card2 (Custom)", "light-blue-property-card3 (Custom)", "multicolor-wildcard-card1 (Custom)", "multicolor-wildcard-card2 (Custom)", 
        "orange-and-pink-rent-card1 (Custom)", "orange-and-pink-rent-card2 (Custom)", "orange-and-pink-wildcard-card1 (Custom)", "orange-and-pink-wildcard-card2 (Custom)", "orange-property-card1 (Custom)", 
        "orange-property-card2 (Custom)", "orange-property-card3 (Custom)", "pass-go-action-card1 (Custom)", "pass-go-action-card10 (Custom)", "pass-go-action-card2 (Custom)", 
        "pass-go-action-card3 (Custom)", "pass-go-action-card4 (Custom)", "pass-go-action-card5 (Custom)", "pass-go-action-card6 (Custom)", "pass-go-action-card7 (Custom)", "pass-go-action-card8 (Custom)", 
        "pass-go-action-card9 (Custom)", "pink-property-card1 (Custom)", "pink-property-card2 (Custom)", "pink-property-card3 (Custom)", "railroad-and-green-wildcard-card (Custom)", 
        "railroad-and-light-blue-wildcard-card (Custom)", "railroad-and-utility-rent-card1 (Custom)", 
        "railroad-and-utility-rent-card2 (Custom)", "railroad-and-utility-wildcard-card (Custom)", "railroad-property-card1 (Custom)", "railroad-property-card2 (Custom)", "railroad-property-card3 (Custom)", 
        "railroad-property-card4 (Custom)", "red-and-yellow-rent-card1 (Custom)", "red-and-yellow-rent-card2 (Custom)", "red-and-yellow-wildcard-card1 (Custom)", "red-and-yellow-wildcard-card2 (Custom)", 
        "red-property-card1 (Custom)", "red-property-card2 (Custom)", "red-property-card3 (Custom)", "sly-deal-action-card1 (Custom)", "sly-deal-action-card2 (Custom)", "sly-deal-action-card3 (Custom)", 
        "utility-property-card1 (Custom)", "utility-property-card2 (Custom)", "yellow-property-card1 (Custom)", "yellow-property-card2 (Custom)", "yellow-property-card3 (Custom)"}; //used to house image name of cards
    private final String[] cardTypes = {"money", "property", "rent", "wild-rent", "wildcard", "action"}; //used to house the types of cards a card can be.
                                                                                                        //wildcard is wild property card.

      private String propertyColor = "";
//    private String color_1;
//    private String color_2;
    
    /**
     * Constructor
     * @param cardName int value of card name from String[]
     */
    public Card(int cardName){
        name = cardNames[cardName]; //need to configure this method or create constructor to initialize values in card object 
        
        //set card type. Will iterate through all the card types and find out with card is what type based on the card's name.
        for (int i=0; i<cardTypes.length; i++){
            if (name.toLowerCase().contains(cardTypes[i].toLowerCase())){
                type = cardTypes[i];
            } 
        }
        
        //sets card image path
        imagePath = "/images/MonopolyCards/"+name+".png";
        
        //if property card, wildcard, or rent card make it's color
        if (type.equals("property")){
            String n = name;
            String[] splittedName = n.split("-property", 2);
            propertyColor = splittedName[0];
        } 
        //if wildcard (wild property card), make it's color
        else if (type.equals("wildcard")){
            String n = name;
            String[] splittedName = n.split("-wildcard", 2);
            propertyColor = splittedName[0];
        } 
        //if wild-rent card
        else if (type.equals("wild-rent")){
            propertyColor = "all-color";
        } 
        //if rent card
        else if (type.equals("rent")){
            String n = name;
            String[] splittedName = n.split("-rent", 2);
            propertyColor = splittedName[0];
        }
        
        
        //make card's value
        if (name.contains("$10M")){
            value = 10;
        }
        else if (name.contains("$5M") || name.contains("deal-breaker")){
            value = 5;
        }
        else if (name.contains("$4M") || name.contains("dark-blue-and-green-wildcard") || name.contains("dark-blue-property") || name.contains("green-property") || name.contains("hotel") || name.contains("just-say-no") || name.contains("railroad-and-green-wildcard") || name.contains("railroad-and-light-blue-wildcard")){
            value = 4;
        }
        else if (name.contains("$3M") || name.contains("wild-rent") || name.contains("debt-collector") || name.contains("force-deal") || name.contains("house") || name.contains("red-and-yellow-wildcard") || name.contains("red-property") || name.contains("yellow-property") || name.contains("sly-deal")){
            value = 3;
        }
        else if (name.contains("$2M") || name.contains("orange-and-pink-wildcard") || name.contains("orange-property") || name.contains("pink-property") || name.contains("railroad-and-utility-wildcard") || name.contains("utility-property") || name.contains("railroad-property") || name.contains("birthday")){
            value = 2;
        }
        else if (name.contains("$1M") || name.contains("rent") || name.contains("pass-go") || name.contains("light-blue-and-brown-wildcard") || name.contains("light-blue-property")){
            value = 1;
        }
        else {
            value = 0;
        }
       
        
        
        
    }
    
    
    public String getName(){
        return name;
   }
    
    public String getImagePath(){
        return imagePath;
    }
    
    public String getType(){
        return type;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getPropertyColor(){
        return propertyColor;
    }
    
/*    public String getColor_1(){
        return color_1;
    } */
    
 /*   public String getColor_2(){
        return color_2;
    } */
    
    public int getCardNameArraySize(){
        return cardNames.length;
    }
}