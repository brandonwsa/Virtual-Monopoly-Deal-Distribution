package Objects;

import java.util.ArrayList;

public class PropertySlot{
    private ArrayList<Card> propertiesInSlot = new ArrayList<Card>();
    private int rentAmount;
    private int amountOwned;
    private int propertySlotNumber;
    private String propertyColor;
    private boolean isCompleted = false;
    private boolean hasHouse = false;
    private boolean hasHotel = false;
    private int amountOfFreePropertySlots = 6; //6 total spots. Will change based on card color
    
    /**
     * Constructor
     */
    public PropertySlot(int psNum){
        propertySlotNumber = psNum;
    }
    
    /**
     * Adds a property card to properties list.
     * Subtracts 1 off of amountOfFreePropertySlots
     * amountOfFreePropertySlots will stay 6 until a card other than a wildcard is added
     * @param c
     */
    public void addPropertyCard(Card c){
        propertiesInSlot.add(c);
        
        //set amount of properties that can be played in slot based on color
        //will be 6 if nothing added yet.
        if (amountOfFreePropertySlots == 6){
            String color = c.getPropertyColor();
            
            //find based on colors here
            amountOfFreePropertySlots = _checkPropertyAmount(color);
            
            //if a wildcard was added before deciding how many cards can be placed
            if (propertiesInSlot.size() > 1){
                for (Card card : propertiesInSlot){
                    if (card.getType().equals("property")){
                        amountOfFreePropertySlots = _checkPropertyAmount(color) - propertiesInSlot.size()+1; //plus 1 because will subtract property below in same method
                    }
                }
                
                    
            } 
        }
        
        //if actual property added and not wildcard for first card(s)
        if (amountOfFreePropertySlots != 6){
           amountOfFreePropertySlots--; 
        }
        
        //set property color if first card
        if (propertyColor == null){
            setPropertyColor(c.getPropertyColor());
        }
        
        //if added property completes the set
        if (amountOfFreePropertySlots == 0){
            isCompleted = true;
            System.out.println("Property slot: "+propertySlotNumber+" is completed.");
        }
    }
    
    /**
     * Adds house card to property slot and sets hasHouse to true.
     * @param c 
     */
    public void addHouseCard(Card c){
        propertiesInSlot.add(c);
        hasHouse = true;
    }
    
    /**
     * Adds hotel card to property slot and sets hasHotel to true.
     * @param c 
     */
    public void addHotelCard(Card c){
        propertiesInSlot.add(c);
        hasHotel = true;
    }
    
    public int getRentAmount(){return rentAmount;}
    
    
    public int getPropertySlotNumber(){return propertySlotNumber;}
    
    /**
     * Gets color of propertySlot object.
     * @return propertyColor
     */
    public String getPropertyColor(){
        return propertyColor;
    }
    
    /**
     * Will get status of property slot.
     * @return isCompleted
     */
    public boolean getIsCompleted(){
        return isCompleted;
    }
    
    public int getTotalProperties(){
        return propertiesInSlot.size();
    }
    
    /**
     * Sets the color of the property slot to color passed in.
     * @param color 
     */
    public void setPropertyColor(String color){
        propertyColor = color;
        System.out.println("PropertySlot num"+propertySlotNumber+" color is now "+color);
    }
    
    /**
     * Sets the rent amount for the property slot based on color of properties and how many there are.
     */
    public void setRentAmount(){
        
        int totalProperties = propertiesInSlot.size();
        
        switch (propertyColor) {
            case "brown":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                break;
            case "dark-blue-and-green":
                if (totalProperties == 1){
                    rentAmount = 3;
                }
                break;
            case "dark-blue":
                if (totalProperties == 1){
                    rentAmount = 3;
                }
                else if (totalProperties == 2){
                    rentAmount = 8;
                }
                break;
            case "green":
                if (totalProperties == 1){
                    rentAmount = 2;
                }
                else if (totalProperties == 2){
                    rentAmount = 4;
                }
                else if (totalProperties == 3){
                    rentAmount = 7;
                }
                break;
            case "light-blue-and-brown":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                break;
            case "light-blue":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                else if (totalProperties == 3){
                    rentAmount = 3;
                }
                break;
            case "orange-and-pink":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                break;
            case "orange":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 3;
                }
                else if (totalProperties == 3){
                    rentAmount = 5;
                }
                break;
            case "pink":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                else if (totalProperties == 3){
                    rentAmount = 4;
                }
                break;
            case "railroad-and-green":
                if (totalProperties == 1){
                    rentAmount = 2;
                }
                break;
            case "railroad-and-light-blue":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                break;
            case "railroad-and-utility":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                break;
            case "railroad":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                else if (totalProperties == 3){
                    rentAmount = 3;
                }
                else if (totalProperties == 4){
                    rentAmount = 4;
                }
                break;
            case "red-and-yellow":
                if (totalProperties == 1){
                    rentAmount = 2;
                }
                break;
            case "red":
                if (totalProperties == 1){
                    rentAmount = 2;
                }
                else if (totalProperties == 2){
                    rentAmount = 3;
                }
                else if (totalProperties == 3){
                    rentAmount = 6;
                }
                break;
            case "utility":
                if (totalProperties == 1){
                    rentAmount = 1;
                }
                else if (totalProperties == 2){
                    rentAmount = 2;
                }
                break;
            case "yellow":
                if (totalProperties == 1){
                    rentAmount = 2;
                }
                else if (totalProperties == 2){
                    rentAmount = 4;
                }
                else if (totalProperties == 3){
                    rentAmount = 6;
                }
                break;
            default:
                System.out.println("Unable to get rent amount. Rent now 0");
                rentAmount = 0;
                break;
        }
        
        //if proeprty slot has a hotel
        if (hasHotel == true){
            rentAmount += 4;
            System.out.println("Rent amount for Slot "+propertySlotNumber+" is: "+rentAmount); //for testing
            return; //returns out so doesnt re-add house amount.
        }
        
        //if property slot has a house
        if (hasHouse == true){
            rentAmount += 3;
        }
        
        
        
        System.out.println("Rent amount for Slot "+propertySlotNumber+" is: "+rentAmount); //for testing
        
    }
    
    
    /**
     * Lets us know whether or not another property can be added.
     * @return true if can add property, false if not.
     */
    public boolean canAddPropertyCard(){
        //if there is room to add another property card
        if (amountOfFreePropertySlots > 0){
            return true;
        }
        
        return false;
    }
    
    /**
     * Lets us know whether or not a house card can be added.
     * @return true if can be added, false if not.
     */
    public boolean canAddHouse(){
        if (isCompleted == true && hasHouse == false){
            return true;
        }
        
        return false;
    }
    
    /**
     * Lets us know whether or not a hotel card can be added.
     * @return true if can be added, false if not.
     */
    public boolean canAddHotel(){
        if (isCompleted == true && hasHouse == true && hasHotel == false){
            return true;
        }
        
        return false;
    }
    
    /**
     * Prints properties in the slot
     */
    public void printProperties(){
        System.out.println("Properties in property slot num "+propertySlotNumber+":");
        for (Card c : propertiesInSlot){
            System.out.print(c.getName()+", ");
        }
        System.out.println();
    }
    
    public boolean isEmpty(){
        return propertiesInSlot.isEmpty();
    }
    
    /**
     * Will determine how many actual properties/wildcards can be placed based on color.
     * NOT INCLUDING HOUSES OR HOTELS
     * @param color
     * @return number of properties able to be placed based on color
     */
    private int _checkPropertyAmount(String color){
        
        if (color.equals("brown") || color.equals("dark-blue") || color.equals("utility")){
            return 2;
        }
        else if (color.equals("railroad")){
            return 4;
        }
        else if (color.equals("green") || color.equals("light-blue") || color.equals("orange") || color.equals("pink") || color.equals("red") || color.equals("yellow")){
            return 3;
        }
        
        //if card is wildcard color
        return 6;
    }
    
    public ArrayList<Card> getPropertiesInSlot(){return propertiesInSlot;}
    
    
        

    

}
