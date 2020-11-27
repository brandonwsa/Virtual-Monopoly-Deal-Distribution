/*
 * Shows the actual game play, decks, hands, total money, etc. Check doc for more info.
 */
package GUI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author brand
 */
public class GamePlayScreen extends javax.swing.JFrame {
    
    private int[] handSlotButtonPressed = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //used to monitor which hand slot is pressed, index 0 = handslot 1... index 11 = handslot 12
                                                                                //A 1 will be placed where the hand slot button was pressed. So if handslot 1 was pressed, index 0 will be changed to 1.
                                                                                //will need to be reset back to all 0's at end of checking which hand slot button was pressed.
                                                                                //This is a 1x12 matrix array.
    private ArrayList<javax.swing.JButton> handSlots = new ArrayList<javax.swing.JButton>(); //used to house hand slot buttons. Will allow for easier access of handslots using indexes.
 //   private ArrayList<javax.swing.JButton> yourPropertySlots = new ArrayList<javax.swing.JButton>();//used to house your property slot buttons. Will allow us to iterate through slots better using indexes.
    private boolean yourMoneySlotButtonPressed = false;
    private boolean discardDeckPressed =  false;
    private boolean cardDeckPressed = false;
    private boolean endTurnEarlyPressed = false;
    private int numberOfPlayers;
    private int difficultyLevel; 
    //shouldnt need this 2D array anymore, but keeping in case we do.
 //   private int[][] yourPropertySlots = new int[4][10]; //2D array used to store information on whether or not a specified property slot was pressed or not. If one was pressed, a 1 will be
                                                       //temporarily placed in the correct row column association with the property slot button.
    private int[] yourPropertySlotPressed = {0, 0}; //used to store information about what property slot was pressed. Will contain 2 ints, row index and column index of property
    private javax.swing.JButton lastPropertyPressed = null; //will be used to know which property was set last. Used to displayImage of selected property slot.
    private HashMap<String, javax.swing.JButton> player2Properties = new HashMap<>(); //used to store player 2 property buttons
    private HashMap<String, javax.swing.JButton> player3Properties = new HashMap<>(); //used to store player 2 property buttons
    private String playerName;
    private WinnerScreen WS;

    /**
     * Creates new form GamePlayScreen
     */
    public GamePlayScreen() {
        initComponents();
        
        WS = new WinnerScreen();
        
        difficultyLevel = 0;
        numberOfPlayers = 0;
        
        //add handslot buttons to arraylist
        handSlots.add(handSlot_1);
        handSlots.add(handSlot_2);
        handSlots.add(handSlot_3);
        handSlots.add(handSlot_4);
        handSlots.add(handSlot_5);
        handSlots.add(handSlot_6);
        handSlots.add(handSlot_7);
        handSlots.add(handSlot_8);
        handSlots.add(handSlot_9);
        handSlots.add(handSlot_10);
        handSlots.add(handSlot_11);
        handSlots.add(handSlot_12);
        
        //add propertyslot buttons to hashmap for player 2. Key is based off property slot column and row in string form
        player2Properties.put("11", player2PropertySlot_1);
        player2Properties.put("12", player2PropertySlot_1_2);
        player2Properties.put("13", player2PropertySlot_1_3);
        player2Properties.put("14", player2PropertySlot_1_4);
        player2Properties.put("15", player2PropertySlot_1_5);
        player2Properties.put("16", player2PropertySlot_1_6);
        player2Properties.put("21", player2PropertySlot_2);
        player2Properties.put("22", player2PropertySlot_2_2);
        player2Properties.put("23", player2PropertySlot_2_3);
        player2Properties.put("24", player2PropertySlot_2_4);
        player2Properties.put("25", player2PropertySlot_2_5);
        player2Properties.put("26", player2PropertySlot_2_6);
        player2Properties.put("31", player2PropertySlot_3);
        player2Properties.put("32", player2PropertySlot_3_2);
        player2Properties.put("33", player2PropertySlot_3_3);
        player2Properties.put("34", player2PropertySlot_3_4);
        player2Properties.put("35", player2PropertySlot_3_5);
        player2Properties.put("36", player2PropertySlot_3_6);
        player2Properties.put("41", player2PropertySlot_4);
        player2Properties.put("42", player2PropertySlot_4_2);
        player2Properties.put("43", player2PropertySlot_4_3);
        player2Properties.put("44", player2PropertySlot_4_4);
        player2Properties.put("45", player2PropertySlot_4_5);
        player2Properties.put("46", player2PropertySlot_4_6);
        player2Properties.put("51", player2PropertySlot_5);
        player2Properties.put("52", player2PropertySlot_5_2);
        player2Properties.put("53", player2PropertySlot_5_3);
        player2Properties.put("54", player2PropertySlot_5_4);
        player2Properties.put("55", player2PropertySlot_5_5);
        player2Properties.put("56", player2PropertySlot_5_6);
        player2Properties.put("61", player2PropertySlot_6);
        player2Properties.put("62", player2PropertySlot_6_2);
        player2Properties.put("63", player2PropertySlot_6_3);
        player2Properties.put("64", player2PropertySlot_6_4);
        player2Properties.put("65", player2PropertySlot_6_5);
        player2Properties.put("66", player2PropertySlot_6_6);
        player2Properties.put("71", player2PropertySlot_7);
        player2Properties.put("72", player2PropertySlot_7_2);
        player2Properties.put("73", player2PropertySlot_7_3);
        player2Properties.put("74", player2PropertySlot_7_4);
        player2Properties.put("75", player2PropertySlot_7_5);
        player2Properties.put("76", player2PropertySlot_7_6);
        player2Properties.put("81", player2PropertySlot_8);
        player2Properties.put("82", player2PropertySlot_8_2);
        player2Properties.put("83", player2PropertySlot_8_3);
        player2Properties.put("84", player2PropertySlot_8_4);
        player2Properties.put("85", player2PropertySlot_8_5);
        player2Properties.put("86", player2PropertySlot_8_6);
        player2Properties.put("91", player2PropertySlot_9);
        player2Properties.put("92", player2PropertySlot_9_2);
        player2Properties.put("93", player2PropertySlot_9_3);
        player2Properties.put("94", player2PropertySlot_9_4);
        player2Properties.put("95", player2PropertySlot_9_5);
        player2Properties.put("96", player2PropertySlot_9_6);
        player2Properties.put("101", player2PropertySlot_10);
        player2Properties.put("102", player2PropertySlot_10_2);
        player2Properties.put("103", player2PropertySlot_10_3);
        player2Properties.put("104", player2PropertySlot_10_4);
        player2Properties.put("105", player2PropertySlot_10_5);
        player2Properties.put("106", player2PropertySlot_10_6);

        //add propertyslot buttons to hashmap for player 2. Key is based off property slot column and row in string form
        player3Properties.put("11", player3PropertySlot_1);
        player3Properties.put("12", player3PropertySlot_1_2);
        player3Properties.put("13", player3PropertySlot_1_3);
        player3Properties.put("14", player3PropertySlot_1_4);
        player3Properties.put("15", player3PropertySlot_1_5);
        player3Properties.put("16", player3PropertySlot_1_6);
        player3Properties.put("21", player3PropertySlot_2);
        player3Properties.put("22", player3PropertySlot_2_2);
        player3Properties.put("23", player3PropertySlot_2_3);
        player3Properties.put("24", player3PropertySlot_2_4);
        player3Properties.put("25", player3PropertySlot_2_5);
        player3Properties.put("26", player3PropertySlot_2_6);
        player3Properties.put("31", player3PropertySlot_3);
        player3Properties.put("32", player3PropertySlot_3_2);
        player3Properties.put("33", player3PropertySlot_3_3);
        player3Properties.put("34", player3PropertySlot_3_4);
        player3Properties.put("35", player3PropertySlot_3_5);
        player3Properties.put("36", player3PropertySlot_3_6);
        player3Properties.put("41", player3PropertySlot_4);
        player3Properties.put("42", player3PropertySlot_4_2);
        player3Properties.put("43", player3PropertySlot_4_3);
        player3Properties.put("44", player3PropertySlot_4_4);
        player3Properties.put("45", player3PropertySlot_4_5);
        player3Properties.put("46", player3PropertySlot_4_6);
        player3Properties.put("51", player3PropertySlot_5);
        player3Properties.put("52", player3PropertySlot_5_2);
        player3Properties.put("53", player3PropertySlot_5_3);
        player3Properties.put("54", player3PropertySlot_5_4);
        player3Properties.put("55", player3PropertySlot_5_5);
        player3Properties.put("56", player3PropertySlot_5_6);
        player3Properties.put("61", player3PropertySlot_6);
        player3Properties.put("62", player3PropertySlot_6_2);
        player3Properties.put("63", player3PropertySlot_6_3);
        player3Properties.put("64", player3PropertySlot_6_4);
        player3Properties.put("65", player3PropertySlot_6_5);
        player3Properties.put("66", player3PropertySlot_6_6);
        player3Properties.put("71", player3PropertySlot_7);
        player3Properties.put("72", player3PropertySlot_7_2);
        player3Properties.put("73", player3PropertySlot_7_3);
        player3Properties.put("74", player3PropertySlot_7_4);
        player3Properties.put("75", player3PropertySlot_7_5);
        player3Properties.put("76", player3PropertySlot_7_6);
        player3Properties.put("81", player3PropertySlot_8);
        player3Properties.put("82", player3PropertySlot_8_2);
        player3Properties.put("83", player3PropertySlot_8_3);
        player3Properties.put("84", player3PropertySlot_8_4);
        player3Properties.put("85", player3PropertySlot_8_5);
        player3Properties.put("86", player3PropertySlot_8_6);
        player3Properties.put("91", player3PropertySlot_9);
        player3Properties.put("92", player3PropertySlot_9_2);
        player3Properties.put("93", player3PropertySlot_9_3);
        player3Properties.put("94", player3PropertySlot_9_4);
        player3Properties.put("95", player3PropertySlot_9_5);
        player3Properties.put("96", player3PropertySlot_9_6);
        player3Properties.put("101", player3PropertySlot_10);
        player3Properties.put("102", player3PropertySlot_10_2);
        player3Properties.put("103", player3PropertySlot_10_3);
        player3Properties.put("104", player3PropertySlot_10_4);
        player3Properties.put("105", player3PropertySlot_10_5);
        player3Properties.put("106", player3PropertySlot_10_6);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        confirmExitPanel = new javax.swing.JPanel();
        areYouSureLabel = new javax.swing.JLabel();
        yesToExitButton = new javax.swing.JButton();
        noToExitButton = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        exitGameButton = new javax.swing.JButton();
        howToPlayButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        menuLabel = new javax.swing.JLabel();
        yourHandPanel = new javax.swing.JPanel();
        handSlot_1 = new javax.swing.JButton();
        handSlot_2 = new javax.swing.JButton();
        handSlot_3 = new javax.swing.JButton();
        handSlot_4 = new javax.swing.JButton();
        handSlot_5 = new javax.swing.JButton();
        handSlot_6 = new javax.swing.JButton();
        handSlot_7 = new javax.swing.JButton();
        handSlot_8 = new javax.swing.JButton();
        handSlot_9 = new javax.swing.JButton();
        handSlot_10 = new javax.swing.JButton();
        handSlot_11 = new javax.swing.JButton();
        handSlot_12 = new javax.swing.JButton();
        propertiesLabel = new javax.swing.JLabel();
        discardDeckButton = new javax.swing.JButton();
        moneyLabel = new javax.swing.JLabel();
        discardDeckLabel = new javax.swing.JLabel();
        deckButton = new javax.swing.JButton();
        deckLabel = new javax.swing.JLabel();
        viewMenuButton = new javax.swing.JButton();
        endTurnEarlyButton = new javax.swing.JButton();
        viewHandButton = new javax.swing.JButton();
        hideHandButton = new javax.swing.JButton();
        player3PlayArea = new javax.swing.JPanel();
        player3MoneySlot = new javax.swing.JButton();
        player3PropertySlot_1_6 = new javax.swing.JButton();
        player3PropertySlot_1_5 = new javax.swing.JButton();
        player3PropertySlot_1_4 = new javax.swing.JButton();
        player3PropertySlot_1_3 = new javax.swing.JButton();
        player3PropertySlot_1_2 = new javax.swing.JButton();
        player3PropertySlot_1 = new javax.swing.JButton();
        player3PropertySlot_2_6 = new javax.swing.JButton();
        player3PropertySlot_2_5 = new javax.swing.JButton();
        player3PropertySlot_2_4 = new javax.swing.JButton();
        player3PropertySlot_2_3 = new javax.swing.JButton();
        player3PropertySlot_2_2 = new javax.swing.JButton();
        player3PropertySlot_2 = new javax.swing.JButton();
        player3PropertySlot_3_6 = new javax.swing.JButton();
        player3PropertySlot_3_5 = new javax.swing.JButton();
        player3PropertySlot_3_4 = new javax.swing.JButton();
        player3PropertySlot_3_3 = new javax.swing.JButton();
        player3PropertySlot_3_2 = new javax.swing.JButton();
        player3PropertySlot_4_6 = new javax.swing.JButton();
        player3PropertySlot_4_5 = new javax.swing.JButton();
        player3PropertySlot_4_4 = new javax.swing.JButton();
        player3PropertySlot_4_3 = new javax.swing.JButton();
        player3PropertySlot_4_2 = new javax.swing.JButton();
        player3PropertySlot_4 = new javax.swing.JButton();
        player3PropertySlot_3 = new javax.swing.JButton();
        player3PropertySlot_5_6 = new javax.swing.JButton();
        player3PropertySlot_5_5 = new javax.swing.JButton();
        player3PropertySlot_5_4 = new javax.swing.JButton();
        player3PropertySlot_5_3 = new javax.swing.JButton();
        player3PropertySlot_5_2 = new javax.swing.JButton();
        player3PropertySlot_5 = new javax.swing.JButton();
        player3PropertySlot_6_6 = new javax.swing.JButton();
        player3PropertySlot_6_5 = new javax.swing.JButton();
        player3PropertySlot_6_4 = new javax.swing.JButton();
        player3PropertySlot_6_3 = new javax.swing.JButton();
        player3PropertySlot_6_2 = new javax.swing.JButton();
        player3PropertySlot_6 = new javax.swing.JButton();
        player3PropertySlot_7_6 = new javax.swing.JButton();
        player3PropertySlot_7_5 = new javax.swing.JButton();
        player3PropertySlot_7_4 = new javax.swing.JButton();
        player3PropertySlot_7_3 = new javax.swing.JButton();
        player3PropertySlot_7_2 = new javax.swing.JButton();
        player3PropertySlot_7 = new javax.swing.JButton();
        player3PropertySlot_8_6 = new javax.swing.JButton();
        player3PropertySlot_8_5 = new javax.swing.JButton();
        player3PropertySlot_8_4 = new javax.swing.JButton();
        player3PropertySlot_8_3 = new javax.swing.JButton();
        player3PropertySlot_8_2 = new javax.swing.JButton();
        player3PropertySlot_8 = new javax.swing.JButton();
        player3PropertySlot_9_6 = new javax.swing.JButton();
        player3PropertySlot_9_5 = new javax.swing.JButton();
        player3PropertySlot_9_4 = new javax.swing.JButton();
        player3PropertySlot_9_3 = new javax.swing.JButton();
        player3PropertySlot_9_2 = new javax.swing.JButton();
        player3PropertySlot_9 = new javax.swing.JButton();
        player3PropertySlot_10_6 = new javax.swing.JButton();
        player3PropertySlot_10_5 = new javax.swing.JButton();
        player3PropertySlot_10_4 = new javax.swing.JButton();
        player3PropertySlot_10_3 = new javax.swing.JButton();
        player3PropertySlot_10_2 = new javax.swing.JButton();
        player3PropertySlot_10 = new javax.swing.JButton();
        player3Label = new javax.swing.JLabel();
        moneyEmblem1 = new javax.swing.JLabel();
        player3TotalMoney = new javax.swing.JTextField();
        player2PlayArea = new javax.swing.JPanel();
        player2MoneySlot = new javax.swing.JButton();
        player2PropertySlot_1_6 = new javax.swing.JButton();
        player2PropertySlot_1_5 = new javax.swing.JButton();
        player2PropertySlot_1_4 = new javax.swing.JButton();
        player2PropertySlot_1_3 = new javax.swing.JButton();
        player2PropertySlot_1_2 = new javax.swing.JButton();
        player2PropertySlot_1 = new javax.swing.JButton();
        player2PropertySlot_2_6 = new javax.swing.JButton();
        player2PropertySlot_2_5 = new javax.swing.JButton();
        player2PropertySlot_2_4 = new javax.swing.JButton();
        player2PropertySlot_2_3 = new javax.swing.JButton();
        player2PropertySlot_2_2 = new javax.swing.JButton();
        player2PropertySlot_2 = new javax.swing.JButton();
        player2PropertySlot_3_6 = new javax.swing.JButton();
        player2PropertySlot_3_5 = new javax.swing.JButton();
        player2PropertySlot_3_4 = new javax.swing.JButton();
        player2PropertySlot_3_3 = new javax.swing.JButton();
        player2PropertySlot_3_2 = new javax.swing.JButton();
        player2PropertySlot_3 = new javax.swing.JButton();
        player2PropertySlot_4_6 = new javax.swing.JButton();
        player2PropertySlot_4_5 = new javax.swing.JButton();
        player2PropertySlot_4_4 = new javax.swing.JButton();
        player2PropertySlot_4_3 = new javax.swing.JButton();
        player2PropertySlot_4_2 = new javax.swing.JButton();
        player2PropertySlot_4 = new javax.swing.JButton();
        player2PropertySlot_5_6 = new javax.swing.JButton();
        player2PropertySlot_5_5 = new javax.swing.JButton();
        player2PropertySlot_5_4 = new javax.swing.JButton();
        player2PropertySlot_5_3 = new javax.swing.JButton();
        player2PropertySlot_5_2 = new javax.swing.JButton();
        player2PropertySlot_5 = new javax.swing.JButton();
        player2PropertySlot_6_6 = new javax.swing.JButton();
        player2PropertySlot_6_5 = new javax.swing.JButton();
        player2PropertySlot_6_4 = new javax.swing.JButton();
        player2PropertySlot_6_3 = new javax.swing.JButton();
        player2PropertySlot_6_2 = new javax.swing.JButton();
        player2PropertySlot_6 = new javax.swing.JButton();
        player2PropertySlot_7_6 = new javax.swing.JButton();
        player2PropertySlot_7_5 = new javax.swing.JButton();
        player2PropertySlot_7_4 = new javax.swing.JButton();
        player2PropertySlot_7_3 = new javax.swing.JButton();
        player2PropertySlot_7_2 = new javax.swing.JButton();
        player2PropertySlot_7 = new javax.swing.JButton();
        player2PropertySlot_8_6 = new javax.swing.JButton();
        player2PropertySlot_8_5 = new javax.swing.JButton();
        player2PropertySlot_8_4 = new javax.swing.JButton();
        player2PropertySlot_8_3 = new javax.swing.JButton();
        player2PropertySlot_8_2 = new javax.swing.JButton();
        player2PropertySlot_8 = new javax.swing.JButton();
        player2PropertySlot_9_6 = new javax.swing.JButton();
        player2PropertySlot_9_5 = new javax.swing.JButton();
        player2PropertySlot_9_4 = new javax.swing.JButton();
        player2PropertySlot_9_3 = new javax.swing.JButton();
        player2PropertySlot_9_2 = new javax.swing.JButton();
        player2PropertySlot_9 = new javax.swing.JButton();
        player2PropertySlot_10_6 = new javax.swing.JButton();
        player2PropertySlot_10_5 = new javax.swing.JButton();
        player2PropertySlot_10_4 = new javax.swing.JButton();
        player2PropertySlot_10_3 = new javax.swing.JButton();
        player2PropertySlot_10_2 = new javax.swing.JButton();
        player2PropertySlot_10 = new javax.swing.JButton();
        moneyEmblem = new javax.swing.JLabel();
        player2TotalMoney = new javax.swing.JTextField();
        player2Label = new javax.swing.JLabel();
        yourPlayArea = new javax.swing.JPanel();
        yourMoneySlot = new javax.swing.JButton();
        yourPropertySlot_1_6 = new javax.swing.JButton();
        yourPropertySlot_1_5 = new javax.swing.JButton();
        yourPropertySlot_1_4 = new javax.swing.JButton();
        yourPropertySlot_1_3 = new javax.swing.JButton();
        yourPropertySlot_1_2 = new javax.swing.JButton();
        yourPropertySlot_1 = new javax.swing.JButton();
        yourPropertySlot_2_6 = new javax.swing.JButton();
        yourPropertySlot_2_5 = new javax.swing.JButton();
        yourPropertySlot_2_4 = new javax.swing.JButton();
        yourPropertySlot_2_3 = new javax.swing.JButton();
        yourPropertySlot_2_2 = new javax.swing.JButton();
        yourPropertySlot_2 = new javax.swing.JButton();
        yourPropertySlot_3_6 = new javax.swing.JButton();
        yourPropertySlot_3_5 = new javax.swing.JButton();
        yourPropertySlot_3_4 = new javax.swing.JButton();
        yourPropertySlot_3_3 = new javax.swing.JButton();
        yourPropertySlot_3_2 = new javax.swing.JButton();
        yourPropertySlot_3 = new javax.swing.JButton();
        yourPropertySlot_4_6 = new javax.swing.JButton();
        yourPropertySlot_4_5 = new javax.swing.JButton();
        yourPropertySlot_4_4 = new javax.swing.JButton();
        yourPropertySlot_4_3 = new javax.swing.JButton();
        yourPropertySlot_4_2 = new javax.swing.JButton();
        yourPropertySlot_4 = new javax.swing.JButton();
        yourPropertySlot_5_6 = new javax.swing.JButton();
        yourPropertySlot_5_5 = new javax.swing.JButton();
        yourPropertySlot_5_4 = new javax.swing.JButton();
        yourPropertySlot_5_3 = new javax.swing.JButton();
        yourPropertySlot_5_2 = new javax.swing.JButton();
        yourPropertySlot_5 = new javax.swing.JButton();
        yourPropertySlot_6_6 = new javax.swing.JButton();
        yourPropertySlot_6_5 = new javax.swing.JButton();
        yourPropertySlot_6_4 = new javax.swing.JButton();
        yourPropertySlot_6_3 = new javax.swing.JButton();
        yourPropertySlot_6_2 = new javax.swing.JButton();
        yourPropertySlot_6 = new javax.swing.JButton();
        yourPropertySlot_7_6 = new javax.swing.JButton();
        yourPropertySlot_7_5 = new javax.swing.JButton();
        yourPropertySlot_7_4 = new javax.swing.JButton();
        yourPropertySlot_7_3 = new javax.swing.JButton();
        yourPropertySlot_7_2 = new javax.swing.JButton();
        yourPropertySlot_7 = new javax.swing.JButton();
        yourPropertySlot_8_6 = new javax.swing.JButton();
        yourPropertySlot_8_5 = new javax.swing.JButton();
        yourPropertySlot_8_4 = new javax.swing.JButton();
        yourPropertySlot_8_3 = new javax.swing.JButton();
        yourPropertySlot_8_2 = new javax.swing.JButton();
        yourPropertySlot_8 = new javax.swing.JButton();
        yourPropertySlot_9_6 = new javax.swing.JButton();
        yourPropertySlot_9_5 = new javax.swing.JButton();
        yourPropertySlot_9_4 = new javax.swing.JButton();
        yourPropertySlot_9_3 = new javax.swing.JButton();
        yourPropertySlot_9_2 = new javax.swing.JButton();
        yourPropertySlot_9 = new javax.swing.JButton();
        yourPropertySlot_10_6 = new javax.swing.JButton();
        yourPropertySlot_10_5 = new javax.swing.JButton();
        yourPropertySlot_10_4 = new javax.swing.JButton();
        yourPropertySlot_10_3 = new javax.swing.JButton();
        yourPropertySlot_10_2 = new javax.swing.JButton();
        yourPropertySlot_10 = new javax.swing.JButton();
        yourTotalMoney = new javax.swing.JTextField();
        moneyEmblem2 = new javax.swing.JLabel();
        youLabel = new javax.swing.JLabel();
        tableBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirmExitPanel.setBackground(new java.awt.Color(153, 0, 0));
        confirmExitPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        confirmExitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areYouSureLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        areYouSureLabel.setForeground(new java.awt.Color(255, 255, 255));
        areYouSureLabel.setText("Are you sure you want to exit the game?");
        confirmExitPanel.add(areYouSureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        yesToExitButton.setBackground(new java.awt.Color(255, 255, 255));
        yesToExitButton.setText("Yes");
        yesToExitButton.setBorder(exitGameButton.getBorder());
        yesToExitButton.setPreferredSize(new java.awt.Dimension(128, 32));
        yesToExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesToExitButtonActionPerformed(evt);
            }
        });
        confirmExitPanel.add(yesToExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        noToExitButton.setBackground(new java.awt.Color(255, 255, 255));
        noToExitButton.setText("Nope, nevermind!");
        noToExitButton.setBorder(exitGameButton.getBorder());
        noToExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noToExitButtonActionPerformed(evt);
            }
        });
        confirmExitPanel.add(noToExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        confirmExitPanel.setVisible(false);

        jLayeredPane1.add(confirmExitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 420, 150));

        menuPanel.setBackground(new java.awt.Color(153, 0, 0));
        menuPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuPanel.setVisible(false);

        exitGameButton.setBackground(new java.awt.Color(255, 255, 255));
        exitGameButton.setText("Exit Game");
        exitGameButton.setPreferredSize(new java.awt.Dimension(100, 40));
        exitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameButtonActionPerformed(evt);
            }
        });
        menuPanel.add(exitGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, 40));

        howToPlayButton.setBackground(new java.awt.Color(255, 255, 255));
        howToPlayButton.setText("How To Play");
        howToPlayButton.setBorder(exitGameButton.getBorder());
        howToPlayButton.setPreferredSize(new java.awt.Dimension(100, 40));
        howToPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToPlayButtonActionPerformed(evt);
            }
        });
        menuPanel.add(howToPlayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));

        resumeButton.setBackground(new java.awt.Color(255, 255, 255));
        resumeButton.setText("Resume");
        resumeButton.setBorder(exitGameButton.getBorder());
        resumeButton.setPreferredSize(new java.awt.Dimension(100, 40));
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });
        menuPanel.add(resumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, -1));

        menuLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        menuLabel.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel.setText("Menu");
        menuPanel.add(menuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLayeredPane1.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 480, 210, 280));

        yourHandPanel.setBackground(new java.awt.Color(153,0,0,150));
        yourHandPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        yourHandPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        handSlot_1.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_1.setBorder(null);
        handSlot_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_1ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 228));

        handSlot_2.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_2.setBorder(null);
        handSlot_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_2ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 228));

        handSlot_3.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_3.setBorder(null);
        handSlot_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_3ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 150, 228));

        handSlot_4.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_4.setBorder(null);
        handSlot_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_4ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 150, 228));

        handSlot_5.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_5.setBorder(null);
        handSlot_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_5ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 150, 228));

        handSlot_6.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_6.setBorder(null);
        handSlot_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_6ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 150, 228));

        handSlot_7.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_7.setBorder(null);
        handSlot_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_7ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 150, 228));

        handSlot_8.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_8.setBorder(null);
        handSlot_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_8ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 150, 228));

        handSlot_9.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_9.setBorder(null);
        handSlot_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_9ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 150, 228));

        handSlot_10.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_10.setBorder(null);
        handSlot_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_10ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 150, 228));

        handSlot_11.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_11.setBorder(null);
        handSlot_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_11ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 150, 228));

        handSlot_12.setBackground(new java.awt.Color(153, 0, 0));
        handSlot_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png"))); // NOI18N
        handSlot_12.setBorder(null);
        handSlot_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handSlot_12ActionPerformed(evt);
            }
        });
        yourHandPanel.add(handSlot_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 150, 228));

        yourHandPanel.setVisible(false);

        jLayeredPane1.add(yourHandPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 970, 490));

        propertiesLabel.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        propertiesLabel.setForeground(new java.awt.Color(255, 255, 255));
        propertiesLabel.setText("Properties:");
        jLayeredPane1.add(propertiesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        discardDeckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        discardDeckButton.setBorder(null);
        discardDeckButton.setContentAreaFilled(false);
        discardDeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardDeckButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(discardDeckButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        moneyLabel.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(255, 255, 255));
        moneyLabel.setText("Money:");
        jLayeredPane1.add(moneyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        discardDeckLabel.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        discardDeckLabel.setForeground(new java.awt.Color(255, 255, 255));
        discardDeckLabel.setText("Discard Deck:");
        jLayeredPane1.add(discardDeckLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, -1, -1));

        deckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_of_card.png"))); // NOI18N
        deckButton.setBorder(null);
        deckButton.setContentAreaFilled(false);
        deckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deckButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(deckButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        deckLabel.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        deckLabel.setForeground(new java.awt.Color(255, 255, 255));
        deckLabel.setText("Deck:");
        jLayeredPane1.add(deckLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        viewMenuButton.setBackground(new java.awt.Color(153, 0, 0));
        viewMenuButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        viewMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        viewMenuButton.setText("View Menu");
        viewMenuButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMenuButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(viewMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 140, 50));

        endTurnEarlyButton.setBackground(new java.awt.Color(153, 0, 0));
        endTurnEarlyButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        endTurnEarlyButton.setForeground(new java.awt.Color(255, 255, 255));
        endTurnEarlyButton.setText("End Turn Early");
        endTurnEarlyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        endTurnEarlyButton.setPreferredSize(new java.awt.Dimension(160, 50));
        endTurnEarlyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnEarlyButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(endTurnEarlyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, -1, -1));

        viewHandButton.setBackground(new java.awt.Color(153, 0, 0));
        viewHandButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        viewHandButton.setForeground(new java.awt.Color(255, 255, 255));
        viewHandButton.setText("View Hand");
        viewHandButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewHandButton.setPreferredSize(new java.awt.Dimension(160, 50));
        viewHandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHandButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(viewHandButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 110, -1, -1));

        hideHandButton.setBackground(new java.awt.Color(153, 0, 0));
        hideHandButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        hideHandButton.setForeground(new java.awt.Color(255, 255, 255));
        hideHandButton.setText("Hide Hand");
        hideHandButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hideHandButton.setPreferredSize(new java.awt.Dimension(160, 50));
        hideHandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideHandButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(hideHandButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 110, -1, -1));

        player3PlayArea.setBackground(new java.awt.Color(0, 0, 0));
        player3PlayArea.setOpaque(false);
        player3PlayArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player3MoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3MoneySlot.setBorder(null);
        player3MoneySlot.setContentAreaFilled(false);
        player3MoneySlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3MoneySlotActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3MoneySlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        player3PropertySlot_1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1_6.setBorder(null);
        player3PropertySlot_1_6.setContentAreaFilled(false);
        player3PropertySlot_1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_1_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        player3PropertySlot_1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1_5.setBorder(null);
        player3PropertySlot_1_5.setContentAreaFilled(false);
        player3PropertySlot_1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_1_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        player3PropertySlot_1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1_4.setBorder(null);
        player3PropertySlot_1_4.setContentAreaFilled(false);
        player3PropertySlot_1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_1_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        player3PropertySlot_1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1_3.setBorder(null);
        player3PropertySlot_1_3.setContentAreaFilled(false);
        player3PropertySlot_1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_1_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        player3PropertySlot_1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1_2.setBorder(null);
        player3PropertySlot_1_2.setContentAreaFilled(false);
        player3PropertySlot_1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_1_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        player3PropertySlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_1.setBorder(null);
        player3PropertySlot_1.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        player3PropertySlot_2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2_6.setBorder(null);
        player3PropertySlot_2_6.setContentAreaFilled(false);
        player3PropertySlot_2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_2_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        player3PropertySlot_2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2_5.setBorder(null);
        player3PropertySlot_2_5.setContentAreaFilled(false);
        player3PropertySlot_2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_2_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        player3PropertySlot_2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2_4.setBorder(null);
        player3PropertySlot_2_4.setContentAreaFilled(false);
        player3PropertySlot_2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_2_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        player3PropertySlot_2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2_3.setBorder(null);
        player3PropertySlot_2_3.setContentAreaFilled(false);
        player3PropertySlot_2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_2_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        player3PropertySlot_2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2_2.setBorder(null);
        player3PropertySlot_2_2.setContentAreaFilled(false);
        player3PropertySlot_2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_2_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        player3PropertySlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_2.setBorder(null);
        player3PropertySlot_2.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        player3PropertySlot_3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3_6.setBorder(null);
        player3PropertySlot_3_6.setContentAreaFilled(false);
        player3PropertySlot_3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_3_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        player3PropertySlot_3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3_5.setBorder(null);
        player3PropertySlot_3_5.setContentAreaFilled(false);
        player3PropertySlot_3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_3_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        player3PropertySlot_3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3_4.setBorder(null);
        player3PropertySlot_3_4.setContentAreaFilled(false);
        player3PropertySlot_3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_3_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        player3PropertySlot_3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3_3.setBorder(null);
        player3PropertySlot_3_3.setContentAreaFilled(false);
        player3PropertySlot_3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_3_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        player3PropertySlot_3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3_2.setBorder(null);
        player3PropertySlot_3_2.setContentAreaFilled(false);
        player3PropertySlot_3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_3_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        player3PropertySlot_4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4_6.setBorder(null);
        player3PropertySlot_4_6.setContentAreaFilled(false);
        player3PropertySlot_4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_4_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, -1, -1));

        player3PropertySlot_4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4_5.setBorder(null);
        player3PropertySlot_4_5.setContentAreaFilled(false);
        player3PropertySlot_4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_4_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        player3PropertySlot_4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4_4.setBorder(null);
        player3PropertySlot_4_4.setContentAreaFilled(false);
        player3PropertySlot_4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_4_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        player3PropertySlot_4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4_3.setBorder(null);
        player3PropertySlot_4_3.setContentAreaFilled(false);
        player3PropertySlot_4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_4_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        player3PropertySlot_4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4_2.setBorder(null);
        player3PropertySlot_4_2.setContentAreaFilled(false);
        player3PropertySlot_4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_4_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        player3PropertySlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_4.setBorder(null);
        player3PropertySlot_4.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        player3PropertySlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_3.setBorder(null);
        player3PropertySlot_3.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        player3PropertySlot_5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5_6.setBorder(null);
        player3PropertySlot_5_6.setContentAreaFilled(false);
        player3PropertySlot_5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_5_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, -1, -1));

        player3PropertySlot_5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5_5.setBorder(null);
        player3PropertySlot_5_5.setContentAreaFilled(false);
        player3PropertySlot_5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_5_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, -1, -1));

        player3PropertySlot_5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5_4.setBorder(null);
        player3PropertySlot_5_4.setContentAreaFilled(false);
        player3PropertySlot_5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_5_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, -1, -1));

        player3PropertySlot_5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5_3.setBorder(null);
        player3PropertySlot_5_3.setContentAreaFilled(false);
        player3PropertySlot_5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_5_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        player3PropertySlot_5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5_2.setBorder(null);
        player3PropertySlot_5_2.setContentAreaFilled(false);
        player3PropertySlot_5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_5_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        player3PropertySlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_5.setBorder(null);
        player3PropertySlot_5.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        player3PropertySlot_6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6_6.setBorder(null);
        player3PropertySlot_6_6.setContentAreaFilled(false);
        player3PropertySlot_6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_6_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 110, -1, -1));

        player3PropertySlot_6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6_5.setBorder(null);
        player3PropertySlot_6_5.setContentAreaFilled(false);
        player3PropertySlot_6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_6_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 90, -1, -1));

        player3PropertySlot_6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6_4.setBorder(null);
        player3PropertySlot_6_4.setContentAreaFilled(false);
        player3PropertySlot_6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_6_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, -1, -1));

        player3PropertySlot_6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6_3.setBorder(null);
        player3PropertySlot_6_3.setContentAreaFilled(false);
        player3PropertySlot_6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_6_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, -1, -1));

        player3PropertySlot_6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6_2.setBorder(null);
        player3PropertySlot_6_2.setContentAreaFilled(false);
        player3PropertySlot_6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_6_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

        player3PropertySlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_6.setBorder(null);
        player3PropertySlot_6.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        player3PropertySlot_7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7_6.setBorder(null);
        player3PropertySlot_7_6.setContentAreaFilled(false);
        player3PropertySlot_7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_7_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 110, -1, -1));

        player3PropertySlot_7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7_5.setBorder(null);
        player3PropertySlot_7_5.setContentAreaFilled(false);
        player3PropertySlot_7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_7_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, -1, -1));

        player3PropertySlot_7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7_4.setBorder(null);
        player3PropertySlot_7_4.setContentAreaFilled(false);
        player3PropertySlot_7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_7_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 70, -1, -1));

        player3PropertySlot_7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7_3.setBorder(null);
        player3PropertySlot_7_3.setContentAreaFilled(false);
        player3PropertySlot_7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_7_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, -1, -1));

        player3PropertySlot_7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7_2.setBorder(null);
        player3PropertySlot_7_2.setContentAreaFilled(false);
        player3PropertySlot_7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_7_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, -1, -1));

        player3PropertySlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_7.setBorder(null);
        player3PropertySlot_7.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, -1, -1));

        player3PropertySlot_8_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8_6.setBorder(null);
        player3PropertySlot_8_6.setContentAreaFilled(false);
        player3PropertySlot_8_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_8_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 110, -1, -1));

        player3PropertySlot_8_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8_5.setBorder(null);
        player3PropertySlot_8_5.setContentAreaFilled(false);
        player3PropertySlot_8_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_8_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 90, -1, -1));

        player3PropertySlot_8_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8_4.setBorder(null);
        player3PropertySlot_8_4.setContentAreaFilled(false);
        player3PropertySlot_8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_8_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 70, -1, -1));

        player3PropertySlot_8_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8_3.setBorder(null);
        player3PropertySlot_8_3.setContentAreaFilled(false);
        player3PropertySlot_8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_8_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        player3PropertySlot_8_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8_2.setBorder(null);
        player3PropertySlot_8_2.setContentAreaFilled(false);
        player3PropertySlot_8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_8_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 30, -1, -1));

        player3PropertySlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_8.setBorder(null);
        player3PropertySlot_8.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, -1, -1));

        player3PropertySlot_9_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9_6.setBorder(null);
        player3PropertySlot_9_6.setContentAreaFilled(false);
        player3PropertySlot_9_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_9_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_9_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 110, -1, -1));

        player3PropertySlot_9_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9_5.setBorder(null);
        player3PropertySlot_9_5.setContentAreaFilled(false);
        player3PropertySlot_9_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_9_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_9_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 90, -1, -1));

        player3PropertySlot_9_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9_4.setBorder(null);
        player3PropertySlot_9_4.setContentAreaFilled(false);
        player3PropertySlot_9_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_9_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 70, -1, -1));

        player3PropertySlot_9_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9_3.setBorder(null);
        player3PropertySlot_9_3.setContentAreaFilled(false);
        player3PropertySlot_9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_9_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 50, -1, -1));

        player3PropertySlot_9_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9_2.setBorder(null);
        player3PropertySlot_9_2.setContentAreaFilled(false);
        player3PropertySlot_9_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_9_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 30, -1, -1));

        player3PropertySlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_9.setBorder(null);
        player3PropertySlot_9.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 10, -1, -1));

        player3PropertySlot_10_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10_6.setBorder(null);
        player3PropertySlot_10_6.setContentAreaFilled(false);
        player3PropertySlot_10_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_10_6ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_10_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 110, -1, -1));

        player3PropertySlot_10_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10_5.setBorder(null);
        player3PropertySlot_10_5.setContentAreaFilled(false);
        player3PropertySlot_10_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_10_5ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_10_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 90, -1, -1));

        player3PropertySlot_10_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10_4.setBorder(null);
        player3PropertySlot_10_4.setContentAreaFilled(false);
        player3PropertySlot_10_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_10_4ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_10_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 70, -1, -1));

        player3PropertySlot_10_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10_3.setBorder(null);
        player3PropertySlot_10_3.setContentAreaFilled(false);
        player3PropertySlot_10_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_10_3ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 50, -1, -1));

        player3PropertySlot_10_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10_2.setBorder(null);
        player3PropertySlot_10_2.setContentAreaFilled(false);
        player3PropertySlot_10_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3PropertySlot_10_2ActionPerformed(evt);
            }
        });
        player3PlayArea.add(player3PropertySlot_10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, -1, -1));

        player3PropertySlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player3PropertySlot_10.setBorder(null);
        player3PropertySlot_10.setContentAreaFilled(false);
        player3PlayArea.add(player3PropertySlot_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 10, -1, -1));

        player3Label.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        player3Label.setForeground(new java.awt.Color(255, 255, 255));
        player3Label.setText("Player3:");
        player3PlayArea.add(player3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        moneyEmblem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money emblem red.png"))); // NOI18N
        player3PlayArea.add(moneyEmblem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 70, -1));

        player3TotalMoney.setEditable(false);
        player3TotalMoney.setBackground(null);
        player3TotalMoney.setFont(new java.awt.Font("Eras Demi ITC", 0, 54)); // NOI18N
        player3TotalMoney.setForeground(new java.awt.Color(255, 255, 255));
        player3TotalMoney.setText("0");
        player3TotalMoney.setBorder(null);
        player3TotalMoney.setOpaque(false);
        player3PlayArea.add(player3TotalMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, -1));

        jLayeredPane1.add(player3PlayArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1910, 260));

        player2PlayArea.setBackground(new java.awt.Color(0, 0, 0));
        player2PlayArea.setOpaque(false);
        player2PlayArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player2MoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2MoneySlot.setBorder(null);
        player2MoneySlot.setContentAreaFilled(false);
        player2MoneySlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2MoneySlotActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2MoneySlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        player2PropertySlot_1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1_6.setBorder(null);
        player2PropertySlot_1_6.setContentAreaFilled(false);
        player2PropertySlot_1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_1_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        player2PropertySlot_1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1_5.setBorder(null);
        player2PropertySlot_1_5.setContentAreaFilled(false);
        player2PropertySlot_1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_1_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        player2PropertySlot_1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1_4.setBorder(null);
        player2PropertySlot_1_4.setContentAreaFilled(false);
        player2PropertySlot_1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_1_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        player2PropertySlot_1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1_3.setBorder(null);
        player2PropertySlot_1_3.setContentAreaFilled(false);
        player2PropertySlot_1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_1_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        player2PropertySlot_1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1_2.setBorder(null);
        player2PropertySlot_1_2.setContentAreaFilled(false);
        player2PropertySlot_1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_1_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        player2PropertySlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_1.setBorder(null);
        player2PropertySlot_1.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        player2PropertySlot_2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2_6.setBorder(null);
        player2PropertySlot_2_6.setContentAreaFilled(false);
        player2PropertySlot_2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_2_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        player2PropertySlot_2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2_5.setBorder(null);
        player2PropertySlot_2_5.setContentAreaFilled(false);
        player2PropertySlot_2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_2_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        player2PropertySlot_2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2_4.setBorder(null);
        player2PropertySlot_2_4.setContentAreaFilled(false);
        player2PropertySlot_2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_2_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        player2PropertySlot_2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2_3.setBorder(null);
        player2PropertySlot_2_3.setContentAreaFilled(false);
        player2PropertySlot_2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_2_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        player2PropertySlot_2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2_2.setBorder(null);
        player2PropertySlot_2_2.setContentAreaFilled(false);
        player2PropertySlot_2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_2_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        player2PropertySlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_2.setBorder(null);
        player2PropertySlot_2.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        player2PropertySlot_3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3_6.setBorder(null);
        player2PropertySlot_3_6.setContentAreaFilled(false);
        player2PropertySlot_3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_3_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        player2PropertySlot_3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3_5.setBorder(null);
        player2PropertySlot_3_5.setContentAreaFilled(false);
        player2PropertySlot_3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_3_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        player2PropertySlot_3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3_4.setBorder(null);
        player2PropertySlot_3_4.setContentAreaFilled(false);
        player2PropertySlot_3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_3_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        player2PropertySlot_3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3_3.setBorder(null);
        player2PropertySlot_3_3.setContentAreaFilled(false);
        player2PropertySlot_3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_3_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        player2PropertySlot_3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3_2.setBorder(null);
        player2PropertySlot_3_2.setContentAreaFilled(false);
        player2PropertySlot_3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_3_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        player2PropertySlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_3.setBorder(null);
        player2PropertySlot_3.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        player2PropertySlot_4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4_6.setBorder(null);
        player2PropertySlot_4_6.setContentAreaFilled(false);
        player2PropertySlot_4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_4_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, -1, -1));

        player2PropertySlot_4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4_5.setBorder(null);
        player2PropertySlot_4_5.setContentAreaFilled(false);
        player2PropertySlot_4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_4_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        player2PropertySlot_4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4_4.setBorder(null);
        player2PropertySlot_4_4.setContentAreaFilled(false);
        player2PropertySlot_4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_4_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        player2PropertySlot_4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4_3.setBorder(null);
        player2PropertySlot_4_3.setContentAreaFilled(false);
        player2PropertySlot_4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_4_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        player2PropertySlot_4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4_2.setBorder(null);
        player2PropertySlot_4_2.setContentAreaFilled(false);
        player2PropertySlot_4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_4_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        player2PropertySlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_4.setBorder(null);
        player2PropertySlot_4.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        player2PropertySlot_5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5_6.setBorder(null);
        player2PropertySlot_5_6.setContentAreaFilled(false);
        player2PropertySlot_5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_5_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, -1, -1));

        player2PropertySlot_5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5_5.setBorder(null);
        player2PropertySlot_5_5.setContentAreaFilled(false);
        player2PropertySlot_5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_5_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, -1, -1));

        player2PropertySlot_5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5_4.setBorder(null);
        player2PropertySlot_5_4.setContentAreaFilled(false);
        player2PropertySlot_5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_5_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, -1, -1));

        player2PropertySlot_5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5_3.setBorder(null);
        player2PropertySlot_5_3.setContentAreaFilled(false);
        player2PropertySlot_5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_5_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        player2PropertySlot_5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5_2.setBorder(null);
        player2PropertySlot_5_2.setContentAreaFilled(false);
        player2PropertySlot_5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_5_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        player2PropertySlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_5.setBorder(null);
        player2PropertySlot_5.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        player2PropertySlot_6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6_6.setBorder(null);
        player2PropertySlot_6_6.setContentAreaFilled(false);
        player2PropertySlot_6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_6_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 110, -1, -1));

        player2PropertySlot_6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6_5.setBorder(null);
        player2PropertySlot_6_5.setContentAreaFilled(false);
        player2PropertySlot_6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_6_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 90, -1, -1));

        player2PropertySlot_6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6_4.setBorder(null);
        player2PropertySlot_6_4.setContentAreaFilled(false);
        player2PropertySlot_6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_6_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, -1, -1));

        player2PropertySlot_6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6_3.setBorder(null);
        player2PropertySlot_6_3.setContentAreaFilled(false);
        player2PropertySlot_6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_6_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, -1, -1));

        player2PropertySlot_6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6_2.setBorder(null);
        player2PropertySlot_6_2.setContentAreaFilled(false);
        player2PropertySlot_6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_6_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

        player2PropertySlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_6.setBorder(null);
        player2PropertySlot_6.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        player2PropertySlot_7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7_6.setBorder(null);
        player2PropertySlot_7_6.setContentAreaFilled(false);
        player2PropertySlot_7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_7_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 110, -1, -1));

        player2PropertySlot_7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7_5.setBorder(null);
        player2PropertySlot_7_5.setContentAreaFilled(false);
        player2PropertySlot_7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_7_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, -1, -1));

        player2PropertySlot_7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7_4.setBorder(null);
        player2PropertySlot_7_4.setContentAreaFilled(false);
        player2PropertySlot_7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_7_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 70, -1, -1));

        player2PropertySlot_7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7_3.setBorder(null);
        player2PropertySlot_7_3.setContentAreaFilled(false);
        player2PropertySlot_7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_7_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, -1, -1));

        player2PropertySlot_7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7_2.setBorder(null);
        player2PropertySlot_7_2.setContentAreaFilled(false);
        player2PropertySlot_7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_7_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, -1, -1));

        player2PropertySlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_7.setBorder(null);
        player2PropertySlot_7.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, -1, -1));

        player2PropertySlot_8_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8_6.setBorder(null);
        player2PropertySlot_8_6.setContentAreaFilled(false);
        player2PropertySlot_8_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_8_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 110, -1, -1));

        player2PropertySlot_8_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8_5.setBorder(null);
        player2PropertySlot_8_5.setContentAreaFilled(false);
        player2PropertySlot_8_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_8_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 90, -1, -1));

        player2PropertySlot_8_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8_4.setBorder(null);
        player2PropertySlot_8_4.setContentAreaFilled(false);
        player2PropertySlot_8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_8_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 70, -1, -1));

        player2PropertySlot_8_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8_3.setBorder(null);
        player2PropertySlot_8_3.setContentAreaFilled(false);
        player2PropertySlot_8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_8_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        player2PropertySlot_8_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8_2.setBorder(null);
        player2PropertySlot_8_2.setContentAreaFilled(false);
        player2PropertySlot_8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_8_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 30, -1, -1));

        player2PropertySlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_8.setBorder(null);
        player2PropertySlot_8.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, -1, -1));

        player2PropertySlot_9_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9_6.setBorder(null);
        player2PropertySlot_9_6.setContentAreaFilled(false);
        player2PropertySlot_9_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_9_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_9_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 110, -1, -1));

        player2PropertySlot_9_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9_5.setBorder(null);
        player2PropertySlot_9_5.setContentAreaFilled(false);
        player2PropertySlot_9_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_9_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_9_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 90, -1, -1));

        player2PropertySlot_9_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9_4.setBorder(null);
        player2PropertySlot_9_4.setContentAreaFilled(false);
        player2PropertySlot_9_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_9_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 70, -1, -1));

        player2PropertySlot_9_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9_3.setBorder(null);
        player2PropertySlot_9_3.setContentAreaFilled(false);
        player2PropertySlot_9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_9_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 50, -1, -1));

        player2PropertySlot_9_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9_2.setBorder(null);
        player2PropertySlot_9_2.setContentAreaFilled(false);
        player2PropertySlot_9_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_9_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 30, -1, -1));

        player2PropertySlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_9.setBorder(null);
        player2PropertySlot_9.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 10, -1, -1));

        player2PropertySlot_10_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10_6.setBorder(null);
        player2PropertySlot_10_6.setContentAreaFilled(false);
        player2PropertySlot_10_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_10_6ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_10_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 110, -1, -1));

        player2PropertySlot_10_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10_5.setBorder(null);
        player2PropertySlot_10_5.setContentAreaFilled(false);
        player2PropertySlot_10_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_10_5ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_10_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 90, -1, -1));

        player2PropertySlot_10_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10_4.setBorder(null);
        player2PropertySlot_10_4.setContentAreaFilled(false);
        player2PropertySlot_10_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_10_4ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_10_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 70, -1, -1));

        player2PropertySlot_10_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10_3.setBorder(null);
        player2PropertySlot_10_3.setContentAreaFilled(false);
        player2PropertySlot_10_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_10_3ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 50, -1, -1));

        player2PropertySlot_10_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10_2.setBorder(null);
        player2PropertySlot_10_2.setContentAreaFilled(false);
        player2PropertySlot_10_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2PropertySlot_10_2ActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2PropertySlot_10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, -1, -1));

        player2PropertySlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        player2PropertySlot_10.setBorder(null);
        player2PropertySlot_10.setContentAreaFilled(false);
        player2PlayArea.add(player2PropertySlot_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 10, -1, -1));

        moneyEmblem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money emblem red.png"))); // NOI18N
        player2PlayArea.add(moneyEmblem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 70, -1));

        player2TotalMoney.setEditable(false);
        player2TotalMoney.setBackground(null);
        player2TotalMoney.setFont(new java.awt.Font("Eras Demi ITC", 0, 54)); // NOI18N
        player2TotalMoney.setForeground(new java.awt.Color(255, 255, 255));
        player2TotalMoney.setText("0");
        player2TotalMoney.setBorder(null);
        player2TotalMoney.setOpaque(false);
        player2TotalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2TotalMoneyActionPerformed(evt);
            }
        });
        player2PlayArea.add(player2TotalMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, -1));

        player2Label.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        player2Label.setForeground(new java.awt.Color(255, 255, 255));
        player2Label.setText("Player2:");
        player2PlayArea.add(player2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLayeredPane1.add(player2PlayArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1910, 260));

        yourPlayArea.setBackground(new java.awt.Color(0, 0, 0));
        yourPlayArea.setOpaque(false);
        yourPlayArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yourMoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_money_slot.png"))); // NOI18N
        yourMoneySlot.setBorder(null);
        yourMoneySlot.setContentAreaFilled(false);
        yourMoneySlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourMoneySlotActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourMoneySlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        yourPropertySlot_1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_1_6.setBorder(null);
        yourPropertySlot_1_6.setContentAreaFilled(false);
        yourPropertySlot_1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        yourPropertySlot_1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_1_5.setBorder(null);
        yourPropertySlot_1_5.setContentAreaFilled(false);
        yourPropertySlot_1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        yourPropertySlot_1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_1_4.setBorder(null);
        yourPropertySlot_1_4.setContentAreaFilled(false);
        yourPropertySlot_1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        yourPropertySlot_1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_1_3.setBorder(null);
        yourPropertySlot_1_3.setContentAreaFilled(false);
        yourPropertySlot_1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        yourPropertySlot_1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_1_2.setBorder(null);
        yourPropertySlot_1_2.setContentAreaFilled(false);
        yourPropertySlot_1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        yourPropertySlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_1.setBorder(null);
        yourPropertySlot_1.setContentAreaFilled(false);
        yourPropertySlot_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_1ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        yourPropertySlot_2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_2_6.setBorder(null);
        yourPropertySlot_2_6.setContentAreaFilled(false);
        yourPropertySlot_2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        yourPropertySlot_2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_2_5.setBorder(null);
        yourPropertySlot_2_5.setContentAreaFilled(false);
        yourPropertySlot_2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        yourPropertySlot_2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_2_4.setBorder(null);
        yourPropertySlot_2_4.setContentAreaFilled(false);
        yourPropertySlot_2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        yourPropertySlot_2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_2_3.setBorder(null);
        yourPropertySlot_2_3.setContentAreaFilled(false);
        yourPropertySlot_2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        yourPropertySlot_2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_2_2.setBorder(null);
        yourPropertySlot_2_2.setContentAreaFilled(false);
        yourPropertySlot_2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        yourPropertySlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_2.setBorder(null);
        yourPropertySlot_2.setContentAreaFilled(false);
        yourPropertySlot_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        yourPropertySlot_3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_3_6.setBorder(null);
        yourPropertySlot_3_6.setContentAreaFilled(false);
        yourPropertySlot_3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        yourPropertySlot_3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_3_5.setBorder(null);
        yourPropertySlot_3_5.setContentAreaFilled(false);
        yourPropertySlot_3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        yourPropertySlot_3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_3_4.setBorder(null);
        yourPropertySlot_3_4.setContentAreaFilled(false);
        yourPropertySlot_3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        yourPropertySlot_3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_3_3.setBorder(null);
        yourPropertySlot_3_3.setContentAreaFilled(false);
        yourPropertySlot_3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        yourPropertySlot_3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_3_2.setBorder(null);
        yourPropertySlot_3_2.setContentAreaFilled(false);
        yourPropertySlot_3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        yourPropertySlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_3.setBorder(null);
        yourPropertySlot_3.setContentAreaFilled(false);
        yourPropertySlot_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        yourPropertySlot_4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_4_6.setBorder(null);
        yourPropertySlot_4_6.setContentAreaFilled(false);
        yourPropertySlot_4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, -1, -1));

        yourPropertySlot_4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_4_5.setBorder(null);
        yourPropertySlot_4_5.setContentAreaFilled(false);
        yourPropertySlot_4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        yourPropertySlot_4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_4_4.setBorder(null);
        yourPropertySlot_4_4.setContentAreaFilled(false);
        yourPropertySlot_4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        yourPropertySlot_4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_4_3.setBorder(null);
        yourPropertySlot_4_3.setContentAreaFilled(false);
        yourPropertySlot_4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        yourPropertySlot_4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_4_2.setBorder(null);
        yourPropertySlot_4_2.setContentAreaFilled(false);
        yourPropertySlot_4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        yourPropertySlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_4.setBorder(null);
        yourPropertySlot_4.setContentAreaFilled(false);
        yourPropertySlot_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        yourPropertySlot_5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_5_6.setBorder(null);
        yourPropertySlot_5_6.setContentAreaFilled(false);
        yourPropertySlot_5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, -1, -1));

        yourPropertySlot_5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_5_5.setBorder(null);
        yourPropertySlot_5_5.setContentAreaFilled(false);
        yourPropertySlot_5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, -1, -1));

        yourPropertySlot_5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_5_4.setBorder(null);
        yourPropertySlot_5_4.setContentAreaFilled(false);
        yourPropertySlot_5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, -1, -1));

        yourPropertySlot_5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_5_3.setBorder(null);
        yourPropertySlot_5_3.setContentAreaFilled(false);
        yourPropertySlot_5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        yourPropertySlot_5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_5_2.setBorder(null);
        yourPropertySlot_5_2.setContentAreaFilled(false);
        yourPropertySlot_5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        yourPropertySlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_5.setBorder(null);
        yourPropertySlot_5.setContentAreaFilled(false);
        yourPropertySlot_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        yourPropertySlot_6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_6_6.setBorder(null);
        yourPropertySlot_6_6.setContentAreaFilled(false);
        yourPropertySlot_6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 110, -1, -1));

        yourPropertySlot_6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_6_5.setBorder(null);
        yourPropertySlot_6_5.setContentAreaFilled(false);
        yourPropertySlot_6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 90, -1, -1));

        yourPropertySlot_6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_6_4.setBorder(null);
        yourPropertySlot_6_4.setContentAreaFilled(false);
        yourPropertySlot_6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, -1, -1));

        yourPropertySlot_6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_6_3.setBorder(null);
        yourPropertySlot_6_3.setContentAreaFilled(false);
        yourPropertySlot_6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, -1, -1));

        yourPropertySlot_6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_6_2.setBorder(null);
        yourPropertySlot_6_2.setContentAreaFilled(false);
        yourPropertySlot_6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

        yourPropertySlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_6.setBorder(null);
        yourPropertySlot_6.setContentAreaFilled(false);
        yourPropertySlot_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        yourPropertySlot_7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_7_6.setBorder(null);
        yourPropertySlot_7_6.setContentAreaFilled(false);
        yourPropertySlot_7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 110, -1, -1));

        yourPropertySlot_7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_7_5.setBorder(null);
        yourPropertySlot_7_5.setContentAreaFilled(false);
        yourPropertySlot_7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, -1, -1));

        yourPropertySlot_7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_7_4.setBorder(null);
        yourPropertySlot_7_4.setContentAreaFilled(false);
        yourPropertySlot_7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 70, -1, -1));

        yourPropertySlot_7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_7_3.setBorder(null);
        yourPropertySlot_7_3.setContentAreaFilled(false);
        yourPropertySlot_7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, -1, -1));

        yourPropertySlot_7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_7_2.setBorder(null);
        yourPropertySlot_7_2.setContentAreaFilled(false);
        yourPropertySlot_7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, -1, -1));

        yourPropertySlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_7.setBorder(null);
        yourPropertySlot_7.setContentAreaFilled(false);
        yourPropertySlot_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_7ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, -1, -1));

        yourPropertySlot_8_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_8_6.setBorder(null);
        yourPropertySlot_8_6.setContentAreaFilled(false);
        yourPropertySlot_8_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 110, -1, -1));

        yourPropertySlot_8_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_8_5.setBorder(null);
        yourPropertySlot_8_5.setContentAreaFilled(false);
        yourPropertySlot_8_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 90, -1, -1));

        yourPropertySlot_8_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_8_4.setBorder(null);
        yourPropertySlot_8_4.setContentAreaFilled(false);
        yourPropertySlot_8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 70, -1, -1));

        yourPropertySlot_8_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_8_3.setBorder(null);
        yourPropertySlot_8_3.setContentAreaFilled(false);
        yourPropertySlot_8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        yourPropertySlot_8_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_8_2.setBorder(null);
        yourPropertySlot_8_2.setContentAreaFilled(false);
        yourPropertySlot_8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 30, -1, -1));

        yourPropertySlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_8.setBorder(null);
        yourPropertySlot_8.setContentAreaFilled(false);
        yourPropertySlot_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_8ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, -1, -1));

        yourPropertySlot_9_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_9_6.setBorder(null);
        yourPropertySlot_9_6.setContentAreaFilled(false);
        yourPropertySlot_9_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 110, -1, -1));

        yourPropertySlot_9_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_9_5.setBorder(null);
        yourPropertySlot_9_5.setContentAreaFilled(false);
        yourPropertySlot_9_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 90, -1, -1));

        yourPropertySlot_9_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_9_4.setBorder(null);
        yourPropertySlot_9_4.setContentAreaFilled(false);
        yourPropertySlot_9_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 70, -1, -1));

        yourPropertySlot_9_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_9_3.setBorder(null);
        yourPropertySlot_9_3.setContentAreaFilled(false);
        yourPropertySlot_9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 50, -1, -1));

        yourPropertySlot_9_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_9_2.setBorder(null);
        yourPropertySlot_9_2.setContentAreaFilled(false);
        yourPropertySlot_9_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 30, -1, -1));

        yourPropertySlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_9.setBorder(null);
        yourPropertySlot_9.setContentAreaFilled(false);
        yourPropertySlot_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_9ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 10, -1, -1));

        yourPropertySlot_10_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_10_6.setBorder(null);
        yourPropertySlot_10_6.setContentAreaFilled(false);
        yourPropertySlot_10_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10_6ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 110, -1, -1));

        yourPropertySlot_10_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_10_5.setBorder(null);
        yourPropertySlot_10_5.setContentAreaFilled(false);
        yourPropertySlot_10_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10_5ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 90, -1, -1));

        yourPropertySlot_10_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_10_4.setBorder(null);
        yourPropertySlot_10_4.setContentAreaFilled(false);
        yourPropertySlot_10_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10_4ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 70, -1, -1));

        yourPropertySlot_10_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_10_3.setBorder(null);
        yourPropertySlot_10_3.setContentAreaFilled(false);
        yourPropertySlot_10_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10_3ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 50, -1, -1));

        yourPropertySlot_10_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_slot.png"))); // NOI18N
        yourPropertySlot_10_2.setBorder(null);
        yourPropertySlot_10_2.setContentAreaFilled(false);
        yourPropertySlot_10_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10_2ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, -1, -1));

        yourPropertySlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_property_slot.png"))); // NOI18N
        yourPropertySlot_10.setBorder(null);
        yourPropertySlot_10.setContentAreaFilled(false);
        yourPropertySlot_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourPropertySlot_10ActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourPropertySlot_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 10, -1, -1));

        yourTotalMoney.setEditable(false);
        yourTotalMoney.setBackground(null);
        yourTotalMoney.setFont(new java.awt.Font("Eras Demi ITC", 0, 54)); // NOI18N
        yourTotalMoney.setForeground(new java.awt.Color(255, 255, 255));
        yourTotalMoney.setText("0");
        yourTotalMoney.setBorder(null);
        yourTotalMoney.setOpaque(false);
        yourTotalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourTotalMoneyActionPerformed(evt);
            }
        });
        yourPlayArea.add(yourTotalMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 70, -1));

        moneyEmblem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money emblem red.png"))); // NOI18N
        yourPlayArea.add(moneyEmblem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 70, -1));

        youLabel.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        youLabel.setForeground(new java.awt.Color(255, 255, 255));
        youLabel.setText("You:");
        youLabel.setText(playerName);
        yourPlayArea.add(youLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLayeredPane1.add(yourPlayArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 1910, 310));

        tableBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table background.png"))); // NOI18N
        tableBackground.setText("jLabel1");
        tableBackground.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jLayeredPane1.add(tableBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void player2TotalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2TotalMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2TotalMoneyActionPerformed

    private void viewMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMenuButtonActionPerformed
        menuPanel.setVisible(true); //pops menu up
        
    }//GEN-LAST:event_viewMenuButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        menuPanel.setVisible(false);
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void exitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameButtonActionPerformed
        menuPanel.setVisible(false);
        confirmExitPanel.setVisible(true);
    }//GEN-LAST:event_exitGameButtonActionPerformed

    private void yesToExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesToExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_yesToExitButtonActionPerformed

    private void noToExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noToExitButtonActionPerformed
        confirmExitPanel.setVisible(false);
        menuPanel.setVisible(true);
    }//GEN-LAST:event_noToExitButtonActionPerformed

    private void howToPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToPlayButtonActionPerformed
        HowToPlayScreen HTPS = new HowToPlayScreen();
        HTPS.setVisible(true);
    }//GEN-LAST:event_howToPlayButtonActionPerformed

    private void handSlot_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_1ActionPerformed
        handSlotButtonPressed[0] = 1;
    }//GEN-LAST:event_handSlot_1ActionPerformed

    private void handSlot_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_2ActionPerformed
        handSlotButtonPressed[1] = 1;
    }//GEN-LAST:event_handSlot_2ActionPerformed

    private void handSlot_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_3ActionPerformed
        handSlotButtonPressed[2] = 1;
    }//GEN-LAST:event_handSlot_3ActionPerformed

    private void handSlot_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_4ActionPerformed
        handSlotButtonPressed[3] = 1;
    }//GEN-LAST:event_handSlot_4ActionPerformed

    private void handSlot_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_5ActionPerformed
        handSlotButtonPressed[4] = 1;
    }//GEN-LAST:event_handSlot_5ActionPerformed

    private void handSlot_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_6ActionPerformed
        handSlotButtonPressed[5] = 1;
    }//GEN-LAST:event_handSlot_6ActionPerformed

    private void handSlot_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_7ActionPerformed
        handSlotButtonPressed[6] = 1;
    }//GEN-LAST:event_handSlot_7ActionPerformed

    private void handSlot_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_8ActionPerformed
        handSlotButtonPressed[7] = 1;
    }//GEN-LAST:event_handSlot_8ActionPerformed

    private void handSlot_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_9ActionPerformed
        handSlotButtonPressed[8] = 1;
    }//GEN-LAST:event_handSlot_9ActionPerformed

    private void handSlot_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_10ActionPerformed
        handSlotButtonPressed[9] = 1;
    }//GEN-LAST:event_handSlot_10ActionPerformed

    private void handSlot_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_11ActionPerformed
        handSlotButtonPressed[10] = 1;
    }//GEN-LAST:event_handSlot_11ActionPerformed

    private void handSlot_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handSlot_12ActionPerformed
        handSlotButtonPressed[11] = 1;
    }//GEN-LAST:event_handSlot_12ActionPerformed

    private void viewHandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHandButtonActionPerformed
        yourHandPanel.setVisible(true);
    }//GEN-LAST:event_viewHandButtonActionPerformed

    private void hideHandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideHandButtonActionPerformed
        yourHandPanel.setVisible(false);
    }//GEN-LAST:event_hideHandButtonActionPerformed

    private void player2MoneySlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2MoneySlotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2MoneySlotActionPerformed

    private void player3MoneySlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3MoneySlotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3MoneySlotActionPerformed

    private void discardDeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardDeckButtonActionPerformed
        discardDeckPressed = true;
    }//GEN-LAST:event_discardDeckButtonActionPerformed

  //DONT NEED ANYMORE, WAS USSED TO SHOW OFF GUI  private int testCount = 0; //for showing cards being added to hand one at a time from deck. Testing GUI purposes. Will be removed in future.
    
    /**
     * 
     * @param evt 
     */
    private void deckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deckButtonActionPerformed
       cardDeckPressed = true;
    }//GEN-LAST:event_deckButtonActionPerformed

    private void yourPropertySlot_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3ActionPerformed
        setYourPropertySlotPressed(3, 1);
        lastPropertyPressed = yourPropertySlot_3;
    }//GEN-LAST:event_yourPropertySlot_3ActionPerformed

    private void yourMoneySlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourMoneySlotActionPerformed
        yourMoneySlotButtonPressed = true;
    }//GEN-LAST:event_yourMoneySlotActionPerformed

    private void yourPropertySlot_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1ActionPerformed
        setYourPropertySlotPressed(1, 1);
        lastPropertyPressed = yourPropertySlot_1;
    }//GEN-LAST:event_yourPropertySlot_1ActionPerformed

    private void yourTotalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourTotalMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yourTotalMoneyActionPerformed

    private void yourPropertySlot_1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1_2ActionPerformed
        setYourPropertySlotPressed(1, 2);
        lastPropertyPressed = yourPropertySlot_1_2;
    }//GEN-LAST:event_yourPropertySlot_1_2ActionPerformed

    private void yourPropertySlot_1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1_3ActionPerformed
        setYourPropertySlotPressed(1, 3);
        lastPropertyPressed = yourPropertySlot_1_3;
    }//GEN-LAST:event_yourPropertySlot_1_3ActionPerformed

    private void yourPropertySlot_1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1_4ActionPerformed
        setYourPropertySlotPressed(1, 4);
        lastPropertyPressed = yourPropertySlot_1_4;
    }//GEN-LAST:event_yourPropertySlot_1_4ActionPerformed

    private void yourPropertySlot_1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1_5ActionPerformed
        setYourPropertySlotPressed(1, 5);
        lastPropertyPressed = yourPropertySlot_1_5;
    }//GEN-LAST:event_yourPropertySlot_1_5ActionPerformed

    private void yourPropertySlot_1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_1_6ActionPerformed
        setYourPropertySlotPressed(1, 6);
        lastPropertyPressed = yourPropertySlot_1_6;
    }//GEN-LAST:event_yourPropertySlot_1_6ActionPerformed

    private void yourPropertySlot_2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2_6ActionPerformed
        setYourPropertySlotPressed(2, 6);
        lastPropertyPressed = yourPropertySlot_2_6;
    }//GEN-LAST:event_yourPropertySlot_2_6ActionPerformed

    private void yourPropertySlot_2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2_5ActionPerformed
        setYourPropertySlotPressed(2, 5);
        lastPropertyPressed = yourPropertySlot_2_5;
    }//GEN-LAST:event_yourPropertySlot_2_5ActionPerformed

    private void yourPropertySlot_2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2_4ActionPerformed
        setYourPropertySlotPressed(2, 4);
        lastPropertyPressed = yourPropertySlot_2_4;
    }//GEN-LAST:event_yourPropertySlot_2_4ActionPerformed

    private void yourPropertySlot_2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2_3ActionPerformed
        setYourPropertySlotPressed(2, 3);
        lastPropertyPressed = yourPropertySlot_2_3;
    }//GEN-LAST:event_yourPropertySlot_2_3ActionPerformed

    private void yourPropertySlot_2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2_2ActionPerformed
        setYourPropertySlotPressed(2, 2);
        lastPropertyPressed = yourPropertySlot_2_2;
    }//GEN-LAST:event_yourPropertySlot_2_2ActionPerformed

    private void yourPropertySlot_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_2ActionPerformed
        setYourPropertySlotPressed(2, 1);
        lastPropertyPressed = yourPropertySlot_2;
    }//GEN-LAST:event_yourPropertySlot_2ActionPerformed

    private void yourPropertySlot_3_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3_6ActionPerformed
        setYourPropertySlotPressed(3, 6);
        lastPropertyPressed = yourPropertySlot_3_6;
    }//GEN-LAST:event_yourPropertySlot_3_6ActionPerformed

    private void yourPropertySlot_3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3_5ActionPerformed
        setYourPropertySlotPressed(3, 5);
        lastPropertyPressed = yourPropertySlot_3_5;
    }//GEN-LAST:event_yourPropertySlot_3_5ActionPerformed

    private void yourPropertySlot_3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3_4ActionPerformed
        setYourPropertySlotPressed(3, 4);
        lastPropertyPressed = yourPropertySlot_3_4;
    }//GEN-LAST:event_yourPropertySlot_3_4ActionPerformed

    private void yourPropertySlot_3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3_3ActionPerformed
        setYourPropertySlotPressed(3, 3);
        lastPropertyPressed = yourPropertySlot_3_3;
    }//GEN-LAST:event_yourPropertySlot_3_3ActionPerformed

    private void yourPropertySlot_3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_3_2ActionPerformed
        setYourPropertySlotPressed(3, 2);
        lastPropertyPressed = yourPropertySlot_3_2;
    }//GEN-LAST:event_yourPropertySlot_3_2ActionPerformed

    private void yourPropertySlot_4_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4_6ActionPerformed
        setYourPropertySlotPressed(4, 6);
        lastPropertyPressed = yourPropertySlot_4_6;
    }//GEN-LAST:event_yourPropertySlot_4_6ActionPerformed

    private void yourPropertySlot_4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4_5ActionPerformed
        setYourPropertySlotPressed(4, 5);
        lastPropertyPressed = yourPropertySlot_4_5;
    }//GEN-LAST:event_yourPropertySlot_4_5ActionPerformed

    private void yourPropertySlot_4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4_4ActionPerformed
        setYourPropertySlotPressed(4, 4);
        lastPropertyPressed = yourPropertySlot_4_4;
    }//GEN-LAST:event_yourPropertySlot_4_4ActionPerformed

    private void yourPropertySlot_4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4_3ActionPerformed
        setYourPropertySlotPressed(4, 3);
        lastPropertyPressed = yourPropertySlot_4_3;
    }//GEN-LAST:event_yourPropertySlot_4_3ActionPerformed

    private void yourPropertySlot_4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4_2ActionPerformed
        setYourPropertySlotPressed(4, 2);
        lastPropertyPressed = yourPropertySlot_4_2;
    }//GEN-LAST:event_yourPropertySlot_4_2ActionPerformed

    private void yourPropertySlot_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_4ActionPerformed
        setYourPropertySlotPressed(4, 1);
        lastPropertyPressed = yourPropertySlot_4;
    }//GEN-LAST:event_yourPropertySlot_4ActionPerformed

    private void yourPropertySlot_5_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5_6ActionPerformed
        setYourPropertySlotPressed(5, 6);
        lastPropertyPressed = yourPropertySlot_5_6;
    }//GEN-LAST:event_yourPropertySlot_5_6ActionPerformed

    private void yourPropertySlot_5_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5_5ActionPerformed
        setYourPropertySlotPressed(5, 5);
        lastPropertyPressed = yourPropertySlot_5_5;
    }//GEN-LAST:event_yourPropertySlot_5_5ActionPerformed

    private void yourPropertySlot_5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5_4ActionPerformed
        setYourPropertySlotPressed(5, 4);
        lastPropertyPressed = yourPropertySlot_5_4;
    }//GEN-LAST:event_yourPropertySlot_5_4ActionPerformed

    private void yourPropertySlot_5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5_3ActionPerformed
        setYourPropertySlotPressed(5, 3);
        lastPropertyPressed = yourPropertySlot_5_3;
    }//GEN-LAST:event_yourPropertySlot_5_3ActionPerformed

    private void yourPropertySlot_5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5_2ActionPerformed
        setYourPropertySlotPressed(5, 2);
        lastPropertyPressed = yourPropertySlot_5_2;
    }//GEN-LAST:event_yourPropertySlot_5_2ActionPerformed

    private void yourPropertySlot_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_5ActionPerformed
        setYourPropertySlotPressed(5, 1);
        lastPropertyPressed = yourPropertySlot_5;
    }//GEN-LAST:event_yourPropertySlot_5ActionPerformed

    private void yourPropertySlot_6_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6_6ActionPerformed
        setYourPropertySlotPressed(6, 6);
        lastPropertyPressed = yourPropertySlot_6_6;
    }//GEN-LAST:event_yourPropertySlot_6_6ActionPerformed

    private void yourPropertySlot_6_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6_5ActionPerformed
        setYourPropertySlotPressed(6, 5);
        lastPropertyPressed = yourPropertySlot_6_5;
    }//GEN-LAST:event_yourPropertySlot_6_5ActionPerformed

    private void yourPropertySlot_6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6_4ActionPerformed
        setYourPropertySlotPressed(6, 4);
        lastPropertyPressed = yourPropertySlot_6_4;
    }//GEN-LAST:event_yourPropertySlot_6_4ActionPerformed

    private void yourPropertySlot_6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6_3ActionPerformed
        setYourPropertySlotPressed(6, 3);
        lastPropertyPressed = yourPropertySlot_6_3;
    }//GEN-LAST:event_yourPropertySlot_6_3ActionPerformed

    private void yourPropertySlot_6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6_2ActionPerformed
        setYourPropertySlotPressed(6, 2);
        lastPropertyPressed = yourPropertySlot_6_2;
    }//GEN-LAST:event_yourPropertySlot_6_2ActionPerformed

    private void yourPropertySlot_7_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7_6ActionPerformed
        setYourPropertySlotPressed(7, 6);
        lastPropertyPressed = yourPropertySlot_7_6;
    }//GEN-LAST:event_yourPropertySlot_7_6ActionPerformed

    private void yourPropertySlot_7_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7_5ActionPerformed
        setYourPropertySlotPressed(7, 5);
        lastPropertyPressed = yourPropertySlot_7_5;
    }//GEN-LAST:event_yourPropertySlot_7_5ActionPerformed

    private void yourPropertySlot_7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7_4ActionPerformed
        setYourPropertySlotPressed(7, 4);
        lastPropertyPressed = yourPropertySlot_7_4;
    }//GEN-LAST:event_yourPropertySlot_7_4ActionPerformed

    private void yourPropertySlot_7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7_3ActionPerformed
        setYourPropertySlotPressed(7, 3);
        lastPropertyPressed = yourPropertySlot_7_3;
    }//GEN-LAST:event_yourPropertySlot_7_3ActionPerformed

    private void yourPropertySlot_7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7_2ActionPerformed
        setYourPropertySlotPressed(7, 2);
        lastPropertyPressed = yourPropertySlot_7_2;
    }//GEN-LAST:event_yourPropertySlot_7_2ActionPerformed

    private void yourPropertySlot_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_6ActionPerformed
        setYourPropertySlotPressed(6, 1);
        lastPropertyPressed = yourPropertySlot_6;
    }//GEN-LAST:event_yourPropertySlot_6ActionPerformed

    private void yourPropertySlot_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_7ActionPerformed
        setYourPropertySlotPressed(7, 1);
        lastPropertyPressed = yourPropertySlot_7;
    }//GEN-LAST:event_yourPropertySlot_7ActionPerformed

    private void yourPropertySlot_8_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8_6ActionPerformed
        setYourPropertySlotPressed(8, 6);
        lastPropertyPressed = yourPropertySlot_8_6;
    }//GEN-LAST:event_yourPropertySlot_8_6ActionPerformed

    private void yourPropertySlot_8_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8_5ActionPerformed
        setYourPropertySlotPressed(8, 5);
        lastPropertyPressed = yourPropertySlot_8_5;
    }//GEN-LAST:event_yourPropertySlot_8_5ActionPerformed

    private void yourPropertySlot_8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8_4ActionPerformed
        setYourPropertySlotPressed(8, 4);
        lastPropertyPressed = yourPropertySlot_8_4;
    }//GEN-LAST:event_yourPropertySlot_8_4ActionPerformed

    private void yourPropertySlot_8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8_3ActionPerformed
        setYourPropertySlotPressed(8, 3);
        lastPropertyPressed = yourPropertySlot_8_3;
    }//GEN-LAST:event_yourPropertySlot_8_3ActionPerformed

    private void yourPropertySlot_8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8_2ActionPerformed
        setYourPropertySlotPressed(8, 2);
        lastPropertyPressed = yourPropertySlot_8_2;
    }//GEN-LAST:event_yourPropertySlot_8_2ActionPerformed

    private void yourPropertySlot_9_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9_6ActionPerformed
        setYourPropertySlotPressed(9, 6);
        lastPropertyPressed = yourPropertySlot_9_6;
    }//GEN-LAST:event_yourPropertySlot_9_6ActionPerformed

    private void yourPropertySlot_9_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9_5ActionPerformed
        setYourPropertySlotPressed(9, 5);
        lastPropertyPressed = yourPropertySlot_9_5;
    }//GEN-LAST:event_yourPropertySlot_9_5ActionPerformed

    private void yourPropertySlot_9_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9_4ActionPerformed
        setYourPropertySlotPressed(9, 4);
        lastPropertyPressed = yourPropertySlot_9_4;
    }//GEN-LAST:event_yourPropertySlot_9_4ActionPerformed

    private void yourPropertySlot_9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9_3ActionPerformed
        setYourPropertySlotPressed(9, 3);
        lastPropertyPressed = yourPropertySlot_9_3;
    }//GEN-LAST:event_yourPropertySlot_9_3ActionPerformed

    private void yourPropertySlot_9_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9_2ActionPerformed
        setYourPropertySlotPressed(9, 2);
        lastPropertyPressed = yourPropertySlot_9_2;
    }//GEN-LAST:event_yourPropertySlot_9_2ActionPerformed

    private void yourPropertySlot_10_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10_6ActionPerformed
        setYourPropertySlotPressed(10, 6);
        lastPropertyPressed = yourPropertySlot_10_6;
    }//GEN-LAST:event_yourPropertySlot_10_6ActionPerformed

    private void yourPropertySlot_10_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10_5ActionPerformed
        setYourPropertySlotPressed(10, 5);
        lastPropertyPressed = yourPropertySlot_10_5;
    }//GEN-LAST:event_yourPropertySlot_10_5ActionPerformed

    private void yourPropertySlot_10_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10_4ActionPerformed
        setYourPropertySlotPressed(10, 4);
        lastPropertyPressed = yourPropertySlot_10_4;
    }//GEN-LAST:event_yourPropertySlot_10_4ActionPerformed

    private void yourPropertySlot_10_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10_3ActionPerformed
        setYourPropertySlotPressed(10, 3);
        lastPropertyPressed = yourPropertySlot_10_3;
    }//GEN-LAST:event_yourPropertySlot_10_3ActionPerformed

    private void yourPropertySlot_10_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10_2ActionPerformed
        setYourPropertySlotPressed(10, 2);
        lastPropertyPressed = yourPropertySlot_10_2;
    }//GEN-LAST:event_yourPropertySlot_10_2ActionPerformed

    private void yourPropertySlot_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_8ActionPerformed
        setYourPropertySlotPressed(8, 1);
        lastPropertyPressed = yourPropertySlot_8;
    }//GEN-LAST:event_yourPropertySlot_8ActionPerformed

    private void yourPropertySlot_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_9ActionPerformed
        setYourPropertySlotPressed(9, 1);
        lastPropertyPressed = yourPropertySlot_9;
    }//GEN-LAST:event_yourPropertySlot_9ActionPerformed

    private void yourPropertySlot_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourPropertySlot_10ActionPerformed
        setYourPropertySlotPressed(10, 1);
        lastPropertyPressed = yourPropertySlot_10;
    }//GEN-LAST:event_yourPropertySlot_10ActionPerformed

    private void player2PropertySlot_1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_1_2ActionPerformed

    private void player2PropertySlot_1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_1_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_1_3ActionPerformed

    private void player2PropertySlot_1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_1_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_1_4ActionPerformed

    private void player2PropertySlot_1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_1_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_1_5ActionPerformed

    private void player2PropertySlot_1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_1_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_1_6ActionPerformed

    private void player2PropertySlot_2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_2_2ActionPerformed

    private void player2PropertySlot_2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_2_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_2_3ActionPerformed

    private void player2PropertySlot_2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_2_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_2_4ActionPerformed

    private void player2PropertySlot_2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_2_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_2_5ActionPerformed

    private void player2PropertySlot_2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_2_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_2_6ActionPerformed

    private void player2PropertySlot_3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_3_2ActionPerformed

    private void player2PropertySlot_3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_3_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_3_3ActionPerformed

    private void player2PropertySlot_3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_3_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_3_4ActionPerformed

    private void player2PropertySlot_3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_3_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_3_5ActionPerformed

    private void player2PropertySlot_3_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_3_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_3_6ActionPerformed

    private void player2PropertySlot_4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_4_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_4_2ActionPerformed

    private void player2PropertySlot_4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_4_3ActionPerformed

    private void player2PropertySlot_4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_4_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_4_4ActionPerformed

    private void player2PropertySlot_4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_4_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_4_5ActionPerformed

    private void player2PropertySlot_4_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_4_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_4_6ActionPerformed

    private void player2PropertySlot_5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_5_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_5_2ActionPerformed

    private void player2PropertySlot_5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_5_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_5_3ActionPerformed

    private void player2PropertySlot_5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_5_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_5_4ActionPerformed

    private void player2PropertySlot_5_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_5_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_5_5ActionPerformed

    private void player2PropertySlot_5_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_5_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_5_6ActionPerformed

    private void player2PropertySlot_6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_6_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_6_2ActionPerformed

    private void player2PropertySlot_6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_6_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_6_3ActionPerformed

    private void player2PropertySlot_6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_6_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_6_4ActionPerformed

    private void player2PropertySlot_6_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_6_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_6_5ActionPerformed

    private void player2PropertySlot_6_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_6_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_6_6ActionPerformed

    private void player2PropertySlot_7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_7_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_7_2ActionPerformed

    private void player2PropertySlot_7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_7_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_7_3ActionPerformed

    private void player2PropertySlot_7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_7_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_7_4ActionPerformed

    private void player2PropertySlot_7_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_7_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_7_5ActionPerformed

    private void player2PropertySlot_7_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_7_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_7_6ActionPerformed

    private void player2PropertySlot_8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_8_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_8_2ActionPerformed

    private void player2PropertySlot_8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_8_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_8_3ActionPerformed

    private void player2PropertySlot_8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_8_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_8_4ActionPerformed

    private void player2PropertySlot_8_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_8_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_8_5ActionPerformed

    private void player2PropertySlot_8_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_8_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_8_6ActionPerformed

    private void player2PropertySlot_9_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_9_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_9_2ActionPerformed

    private void player2PropertySlot_9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_9_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_9_3ActionPerformed

    private void player2PropertySlot_9_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_9_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_9_4ActionPerformed

    private void player2PropertySlot_9_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_9_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_9_5ActionPerformed

    private void player2PropertySlot_9_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_9_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_9_6ActionPerformed

    private void player2PropertySlot_10_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_10_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_10_2ActionPerformed

    private void player2PropertySlot_10_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_10_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_10_3ActionPerformed

    private void player2PropertySlot_10_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_10_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_10_4ActionPerformed

    private void player2PropertySlot_10_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_10_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_10_5ActionPerformed

    private void player2PropertySlot_10_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2PropertySlot_10_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2PropertySlot_10_6ActionPerformed

    private void player3PropertySlot_2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_2_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_2_6ActionPerformed

    private void player3PropertySlot_1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_1_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_1_4ActionPerformed

    private void player3PropertySlot_2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_2_2ActionPerformed

    private void player3PropertySlot_1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_1_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_1_3ActionPerformed

    private void player3PropertySlot_2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_2_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_2_5ActionPerformed

    private void player3PropertySlot_2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_2_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_2_3ActionPerformed

    private void player3PropertySlot_2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_2_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_2_4ActionPerformed

    private void player3PropertySlot_1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_1_2ActionPerformed

    private void player3PropertySlot_1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_1_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_1_5ActionPerformed

    private void player3PropertySlot_3_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_3_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_3_6ActionPerformed

    private void player3PropertySlot_1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_1_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_1_6ActionPerformed

    private void player3PropertySlot_3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_3_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_3_5ActionPerformed

    private void player3PropertySlot_3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_3_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_3_4ActionPerformed

    private void player3PropertySlot_3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_3_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_3_3ActionPerformed

    private void player3PropertySlot_3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_3_2ActionPerformed

    private void player3PropertySlot_4_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_4_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_4_6ActionPerformed

    private void player3PropertySlot_4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_4_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_4_5ActionPerformed

    private void player3PropertySlot_4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_4_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_4_4ActionPerformed

    private void player3PropertySlot_4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_4_3ActionPerformed

    private void player3PropertySlot_4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_4_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_4_2ActionPerformed

    private void player3PropertySlot_5_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_5_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_5_6ActionPerformed

    private void player3PropertySlot_5_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_5_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_5_5ActionPerformed

    private void player3PropertySlot_5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_5_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_5_4ActionPerformed

    private void player3PropertySlot_5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_5_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_5_3ActionPerformed

    private void player3PropertySlot_5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_5_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_5_2ActionPerformed

    private void player3PropertySlot_6_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_6_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_6_6ActionPerformed

    private void player3PropertySlot_6_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_6_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_6_5ActionPerformed

    private void player3PropertySlot_6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_6_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_6_4ActionPerformed

    private void player3PropertySlot_6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_6_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_6_3ActionPerformed

    private void player3PropertySlot_6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_6_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_6_2ActionPerformed

    private void player3PropertySlot_7_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_7_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_7_6ActionPerformed

    private void player3PropertySlot_7_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_7_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_7_5ActionPerformed

    private void player3PropertySlot_7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_7_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_7_4ActionPerformed

    private void player3PropertySlot_7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_7_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_7_3ActionPerformed

    private void player3PropertySlot_7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_7_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_7_2ActionPerformed

    private void player3PropertySlot_8_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_8_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_8_6ActionPerformed

    private void player3PropertySlot_8_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_8_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_8_5ActionPerformed

    private void player3PropertySlot_8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_8_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_8_4ActionPerformed

    private void player3PropertySlot_8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_8_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_8_3ActionPerformed

    private void player3PropertySlot_8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_8_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_8_2ActionPerformed

    private void player3PropertySlot_9_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_9_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_9_6ActionPerformed

    private void player3PropertySlot_9_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_9_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_9_5ActionPerformed

    private void player3PropertySlot_9_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_9_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_9_4ActionPerformed

    private void player3PropertySlot_9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_9_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_9_3ActionPerformed

    private void player3PropertySlot_9_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_9_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_9_2ActionPerformed

    private void player3PropertySlot_10_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_10_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_10_6ActionPerformed

    private void player3PropertySlot_10_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_10_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_10_5ActionPerformed

    private void player3PropertySlot_10_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_10_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_10_4ActionPerformed

    private void player3PropertySlot_10_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_10_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_10_3ActionPerformed

    private void player3PropertySlot_10_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3PropertySlot_10_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3PropertySlot_10_2ActionPerformed

    private void endTurnEarlyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnEarlyButtonActionPerformed
        endTurnEarlyPressed = true;
    }//GEN-LAST:event_endTurnEarlyButtonActionPerformed

    /**
     * Set player starting hand visually in GUI.
     * @param cardImagePaths 
     */
    public void setPlayerStartingHand(ArrayList cardImagePaths){
        handSlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImagePaths.get(0).toString())));
        handSlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImagePaths.get(1).toString())));
        handSlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImagePaths.get(2).toString())));
        handSlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImagePaths.get(3).toString())));
        handSlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImagePaths.get(4).toString())));
    }
    
    /**
     * Set the player's name visually in GUI
     * @param name 
     */
    public void setPlayerName(String name){
        playerName = name;
        youLabel.setText(name);
    }
    
    /**
     * Sets your total money visually in the GUI
     * @param value 
     */
    public void setYourTotalMoney(int value, String name){
        if (name.equals("bot_1")){
            player2TotalMoney.setText(""+value);
        }
        else if (name.equals("bot_2")){
            player3TotalMoney.setText(""+value);
        }
        else {
            yourTotalMoney.setText(""+value);
        }
        
    }
    
    /**
     * sets int[] of your propertyslot location to correlated property slot button in GUI.
     * @param row
     * @param column 
     */
    public void setYourPropertySlotPressed(int row, int column){
        yourPropertySlotPressed[0] = row;
        yourPropertySlotPressed[1] = column;
    }
    
     /**
     * Will set the boolean value of your money slot.
     * @param value 
     */
    public void setYourMoneySlotButtonAction(boolean value){
        yourMoneySlotButtonPressed = value;
    }
    
    /**
     * Will set the boolean value of your discard deck.
     * @param value 
     */
    public void setYourDiscardDeckPressed(boolean value){
        discardDeckPressed = value;
    }
    
     /**
     * Will set the boolean value of your card deck.
     * @param value 
     */
    public void setYourCardDeckPressed(boolean value){
        cardDeckPressed = value;
    }
    
    public void setEndTurnEarlyPressed(boolean value){
        endTurnEarlyPressed = value;
    }
    
    public void setNumberOfPlayers(int numPlayers){
        numberOfPlayers = numPlayers;
    }
    
    public void setDifficultyLevel(int level){
        difficultyLevel = level;
    }
    
    
    /**
     * Checks to see which hand slot button was pressed.
     * @return hand slot number, or 0 if no hand slot was pressed.
     */
    public int checkHandSlotButtonPressed(){
        
        try{
            //iterate through int array to find which button was pressed.
            for (int i=0; i<handSlotButtonPressed.length; i++){
                //button pressed will be the only 1 in the array.
                if(handSlotButtonPressed[i] == 1){
                    handSlotButtonPressed[i] = 0; //reset back to 0, since we know what button was pressed now.
                    return i+1; //returns handslot number
                }
            }
        }
        catch(Exception e){
            System.out.println("Error when checking hand slot button pressed. e: "+e);
        }

        return 0;
    }

    /**
     * Gets your property slot num
     * @return int[] of property slot num in row column form
     */
    public int[] getYourPropertySlotPressed(){
        return yourPropertySlotPressed;
    }
    
    /**
     * Tells you if the discard deck has been selected
     * @return true if selected, false if not selected
     */
    public boolean getYourDiscardDeckPressed(){
        return discardDeckPressed;
    }
    
    /**
     * Tells you if the card deck has been selected
     * @return true if selected, false if not selected
     */
    public boolean getYourCardDeckPressed(){
        return cardDeckPressed;
    }
    
     /**
     * Tells you if the end turn early button has been selected
     * @return true if selected, false if not selected
     */
    public boolean getEndTurnEarlyPressed(){
        return endTurnEarlyPressed;
    }
    

    /**
     * gets the hand slot card image path from handslot num provided, using handSlots arraylist.
     * @param handSlot
     * @return card image path from hand slot.
     */
    public String getHandSlotCardImage(int handSlot){
        return handSlots.get(handSlot-1).getIcon().toString(); //handSlot-1 is accurate representation of correlating handSlot to handSlot number passed in.
    }
    
    /**
     * Will get the boolean value of your money slot button
     * @return 
     */
    public boolean getYourMoneySlotButtonAction(){
        return yourMoneySlotButtonPressed;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    
    public int getDifficultyLevel(){
        return difficultyLevel;
    }
    
    public boolean getPlayAgain(){
        return WS.getPlayAgain();
    }
    
    /**
     * Displays a property card in property slot given the image path. Looks at last property button pressed.
     * to know where to put the image.
     * @param imagePath 
     */
    public void displayPlayedPropertyCard(String imagePath){
        lastPropertyPressed.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));  
    }
    
    /**
     * Displays a property the bot wants to play.
     * @param imagePath
     * @param property 
     */
    public void displayBotPlayedPropertyCard(String imagePath, int[] property, String name){
        //get property slot in string to use as key in hash map
        String propertySlot = ""+property[0]+property[1];
        
        //get property to put image in it
        if (name.equals("bot_1")){
            player2Properties.get(propertySlot).setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        }
        else if (name.equals("bot_2")){
            player3Properties.get(propertySlot).setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        }
    }
    
    /**
     * Displays a money card on your money slot with given image path.
     * Using player param, will decide whose money to update.
     * @param imagePath 
     * @param player
     */
    public void displayPlayedMoneyCard(String imagePath, String name){
        if (name.equals("bot_1")){
            player2MoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        }
        else if (name.equals("bot_2")){
            player3MoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));  
        }
        else {
            yourMoneySlot.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        }
        
    }
    
    /**
     * Displays the winner screen when one is found.
     * @param name 
     * @param money
     * @param properties
     */
    public void displayWinnerScreen(String name, int money, int properties){
        WS.setWinner(name, money, properties);
        WS.setVisible(true);
        this.setVisible(false); //sets game play screen view to false
        dispose();
    }
    
    
    /**
     * removes the card image from the player's hand at appropriate slot, resetting image back to empty card slot
     * @param handSlotNum 
     */
    public void removeCardImageFromHand(int handSlotNum){
        if (handSlotNum == 1){
            handSlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 2){
            handSlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 3){
            handSlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 4){
            handSlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 5){
            handSlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 6){
            handSlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 7){
            handSlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 8){
            handSlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 9){
            handSlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 10){
            handSlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 11){
            handSlot_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
        if (handSlotNum == 12){
            handSlot_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_card_slot.png")));
        }
        
    }
    /**
     * Adds correct card to first available hand slot in GUI
     * @param imagePath 
     */
    public void addCardImageToHand(String imagePath){
          
          if(getHandSlotCardImage(1).contains("/images/empty_card_slot.png")==true){
               handSlot_1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_1");
          }
          
          else if(getHandSlotCardImage(2).contains("/images/empty_card_slot.png")==true){
               handSlot_2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_2");
          }
          
          else if(getHandSlotCardImage(3).contains("/images/empty_card_slot.png")==true){
               handSlot_3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_3");
          }
          
          else if(getHandSlotCardImage(4).contains("/images/empty_card_slot.png")==true){
               handSlot_4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_4");
          }
          
          else if(getHandSlotCardImage(5).contains("/images/empty_card_slot.png")==true){
               handSlot_5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_5");
          }
          
          else if(getHandSlotCardImage(6).contains("/images/empty_card_slot.png")==true){
               handSlot_6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_6");
          }
          
          else if(getHandSlotCardImage(7).contains("/images/empty_card_slot.png")==true){
               handSlot_7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_7");
          }
          
          else if(getHandSlotCardImage(8).contains("/images/empty_card_slot.png")==true){
               handSlot_8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_8");
          }
          
          else if(getHandSlotCardImage(9).contains("/images/empty_card_slot.png")==true){
               handSlot_9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_9");
          }
          
          else if(getHandSlotCardImage(10).contains("/images/empty_card_slot.png")==true){
               handSlot_10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_10");
          }
         
          else if(getHandSlotCardImage(11).contains("/images/empty_card_slot.png")==true){
               handSlot_11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_11");
          }
          
          else if(getHandSlotCardImage(12).contains("/images/empty_card_slot.png")==true){
               handSlot_12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
               System.out.println("placed card in handSlot_12");
          }
          
          else{
              System.out.println("Could not draw card from deck: "+imagePath);
          }
          
                
    }
    
    public void addCardImageToDiscardDeck(String img){
        discardDeckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
       
    }
    
    public void hideHandMenu(){
         yourHandPanel.setVisible(false);
    }
    
    
    public void hideThirdPlayer(){
       
        player3PlayArea.setVisible(false);
        moneyLabel.setVisible(false);
        propertiesLabel.setVisible(false);
        tableBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table background Two Players.png")));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamePlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePlayScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areYouSureLabel;
    private javax.swing.JPanel confirmExitPanel;
    private javax.swing.JButton deckButton;
    private javax.swing.JLabel deckLabel;
    private javax.swing.JButton discardDeckButton;
    private javax.swing.JLabel discardDeckLabel;
    private javax.swing.JButton endTurnEarlyButton;
    private javax.swing.JButton exitGameButton;
    private javax.swing.JButton handSlot_1;
    private javax.swing.JButton handSlot_10;
    private javax.swing.JButton handSlot_11;
    private javax.swing.JButton handSlot_12;
    private javax.swing.JButton handSlot_2;
    private javax.swing.JButton handSlot_3;
    private javax.swing.JButton handSlot_4;
    private javax.swing.JButton handSlot_5;
    private javax.swing.JButton handSlot_6;
    private javax.swing.JButton handSlot_7;
    private javax.swing.JButton handSlot_8;
    private javax.swing.JButton handSlot_9;
    private javax.swing.JButton hideHandButton;
    private javax.swing.JButton howToPlayButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel moneyEmblem;
    private javax.swing.JLabel moneyEmblem1;
    private javax.swing.JLabel moneyEmblem2;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton noToExitButton;
    private javax.swing.JLabel player2Label;
    private javax.swing.JButton player2MoneySlot;
    private javax.swing.JPanel player2PlayArea;
    private javax.swing.JButton player2PropertySlot_1;
    private javax.swing.JButton player2PropertySlot_10;
    private javax.swing.JButton player2PropertySlot_10_2;
    private javax.swing.JButton player2PropertySlot_10_3;
    private javax.swing.JButton player2PropertySlot_10_4;
    private javax.swing.JButton player2PropertySlot_10_5;
    private javax.swing.JButton player2PropertySlot_10_6;
    private javax.swing.JButton player2PropertySlot_1_2;
    private javax.swing.JButton player2PropertySlot_1_3;
    private javax.swing.JButton player2PropertySlot_1_4;
    private javax.swing.JButton player2PropertySlot_1_5;
    private javax.swing.JButton player2PropertySlot_1_6;
    private javax.swing.JButton player2PropertySlot_2;
    private javax.swing.JButton player2PropertySlot_2_2;
    private javax.swing.JButton player2PropertySlot_2_3;
    private javax.swing.JButton player2PropertySlot_2_4;
    private javax.swing.JButton player2PropertySlot_2_5;
    private javax.swing.JButton player2PropertySlot_2_6;
    private javax.swing.JButton player2PropertySlot_3;
    private javax.swing.JButton player2PropertySlot_3_2;
    private javax.swing.JButton player2PropertySlot_3_3;
    private javax.swing.JButton player2PropertySlot_3_4;
    private javax.swing.JButton player2PropertySlot_3_5;
    private javax.swing.JButton player2PropertySlot_3_6;
    private javax.swing.JButton player2PropertySlot_4;
    private javax.swing.JButton player2PropertySlot_4_2;
    private javax.swing.JButton player2PropertySlot_4_3;
    private javax.swing.JButton player2PropertySlot_4_4;
    private javax.swing.JButton player2PropertySlot_4_5;
    private javax.swing.JButton player2PropertySlot_4_6;
    private javax.swing.JButton player2PropertySlot_5;
    private javax.swing.JButton player2PropertySlot_5_2;
    private javax.swing.JButton player2PropertySlot_5_3;
    private javax.swing.JButton player2PropertySlot_5_4;
    private javax.swing.JButton player2PropertySlot_5_5;
    private javax.swing.JButton player2PropertySlot_5_6;
    private javax.swing.JButton player2PropertySlot_6;
    private javax.swing.JButton player2PropertySlot_6_2;
    private javax.swing.JButton player2PropertySlot_6_3;
    private javax.swing.JButton player2PropertySlot_6_4;
    private javax.swing.JButton player2PropertySlot_6_5;
    private javax.swing.JButton player2PropertySlot_6_6;
    private javax.swing.JButton player2PropertySlot_7;
    private javax.swing.JButton player2PropertySlot_7_2;
    private javax.swing.JButton player2PropertySlot_7_3;
    private javax.swing.JButton player2PropertySlot_7_4;
    private javax.swing.JButton player2PropertySlot_7_5;
    private javax.swing.JButton player2PropertySlot_7_6;
    private javax.swing.JButton player2PropertySlot_8;
    private javax.swing.JButton player2PropertySlot_8_2;
    private javax.swing.JButton player2PropertySlot_8_3;
    private javax.swing.JButton player2PropertySlot_8_4;
    private javax.swing.JButton player2PropertySlot_8_5;
    private javax.swing.JButton player2PropertySlot_8_6;
    private javax.swing.JButton player2PropertySlot_9;
    private javax.swing.JButton player2PropertySlot_9_2;
    private javax.swing.JButton player2PropertySlot_9_3;
    private javax.swing.JButton player2PropertySlot_9_4;
    private javax.swing.JButton player2PropertySlot_9_5;
    private javax.swing.JButton player2PropertySlot_9_6;
    private javax.swing.JTextField player2TotalMoney;
    private javax.swing.JLabel player3Label;
    private javax.swing.JButton player3MoneySlot;
    private javax.swing.JPanel player3PlayArea;
    private javax.swing.JButton player3PropertySlot_1;
    private javax.swing.JButton player3PropertySlot_10;
    private javax.swing.JButton player3PropertySlot_10_2;
    private javax.swing.JButton player3PropertySlot_10_3;
    private javax.swing.JButton player3PropertySlot_10_4;
    private javax.swing.JButton player3PropertySlot_10_5;
    private javax.swing.JButton player3PropertySlot_10_6;
    private javax.swing.JButton player3PropertySlot_1_2;
    private javax.swing.JButton player3PropertySlot_1_3;
    private javax.swing.JButton player3PropertySlot_1_4;
    private javax.swing.JButton player3PropertySlot_1_5;
    private javax.swing.JButton player3PropertySlot_1_6;
    private javax.swing.JButton player3PropertySlot_2;
    private javax.swing.JButton player3PropertySlot_2_2;
    private javax.swing.JButton player3PropertySlot_2_3;
    private javax.swing.JButton player3PropertySlot_2_4;
    private javax.swing.JButton player3PropertySlot_2_5;
    private javax.swing.JButton player3PropertySlot_2_6;
    private javax.swing.JButton player3PropertySlot_3;
    private javax.swing.JButton player3PropertySlot_3_2;
    private javax.swing.JButton player3PropertySlot_3_3;
    private javax.swing.JButton player3PropertySlot_3_4;
    private javax.swing.JButton player3PropertySlot_3_5;
    private javax.swing.JButton player3PropertySlot_3_6;
    private javax.swing.JButton player3PropertySlot_4;
    private javax.swing.JButton player3PropertySlot_4_2;
    private javax.swing.JButton player3PropertySlot_4_3;
    private javax.swing.JButton player3PropertySlot_4_4;
    private javax.swing.JButton player3PropertySlot_4_5;
    private javax.swing.JButton player3PropertySlot_4_6;
    private javax.swing.JButton player3PropertySlot_5;
    private javax.swing.JButton player3PropertySlot_5_2;
    private javax.swing.JButton player3PropertySlot_5_3;
    private javax.swing.JButton player3PropertySlot_5_4;
    private javax.swing.JButton player3PropertySlot_5_5;
    private javax.swing.JButton player3PropertySlot_5_6;
    private javax.swing.JButton player3PropertySlot_6;
    private javax.swing.JButton player3PropertySlot_6_2;
    private javax.swing.JButton player3PropertySlot_6_3;
    private javax.swing.JButton player3PropertySlot_6_4;
    private javax.swing.JButton player3PropertySlot_6_5;
    private javax.swing.JButton player3PropertySlot_6_6;
    private javax.swing.JButton player3PropertySlot_7;
    private javax.swing.JButton player3PropertySlot_7_2;
    private javax.swing.JButton player3PropertySlot_7_3;
    private javax.swing.JButton player3PropertySlot_7_4;
    private javax.swing.JButton player3PropertySlot_7_5;
    private javax.swing.JButton player3PropertySlot_7_6;
    private javax.swing.JButton player3PropertySlot_8;
    private javax.swing.JButton player3PropertySlot_8_2;
    private javax.swing.JButton player3PropertySlot_8_3;
    private javax.swing.JButton player3PropertySlot_8_4;
    private javax.swing.JButton player3PropertySlot_8_5;
    private javax.swing.JButton player3PropertySlot_8_6;
    private javax.swing.JButton player3PropertySlot_9;
    private javax.swing.JButton player3PropertySlot_9_2;
    private javax.swing.JButton player3PropertySlot_9_3;
    private javax.swing.JButton player3PropertySlot_9_4;
    private javax.swing.JButton player3PropertySlot_9_5;
    private javax.swing.JButton player3PropertySlot_9_6;
    private javax.swing.JTextField player3TotalMoney;
    private javax.swing.JLabel propertiesLabel;
    private javax.swing.JButton resumeButton;
    private javax.swing.JLabel tableBackground;
    private javax.swing.JButton viewHandButton;
    private javax.swing.JButton viewMenuButton;
    private javax.swing.JButton yesToExitButton;
    private javax.swing.JLabel youLabel;
    private javax.swing.JPanel yourHandPanel;
    private javax.swing.JButton yourMoneySlot;
    private javax.swing.JPanel yourPlayArea;
    private javax.swing.JButton yourPropertySlot_1;
    private javax.swing.JButton yourPropertySlot_10;
    private javax.swing.JButton yourPropertySlot_10_2;
    private javax.swing.JButton yourPropertySlot_10_3;
    private javax.swing.JButton yourPropertySlot_10_4;
    private javax.swing.JButton yourPropertySlot_10_5;
    private javax.swing.JButton yourPropertySlot_10_6;
    private javax.swing.JButton yourPropertySlot_1_2;
    private javax.swing.JButton yourPropertySlot_1_3;
    private javax.swing.JButton yourPropertySlot_1_4;
    private javax.swing.JButton yourPropertySlot_1_5;
    private javax.swing.JButton yourPropertySlot_1_6;
    private javax.swing.JButton yourPropertySlot_2;
    private javax.swing.JButton yourPropertySlot_2_2;
    private javax.swing.JButton yourPropertySlot_2_3;
    private javax.swing.JButton yourPropertySlot_2_4;
    private javax.swing.JButton yourPropertySlot_2_5;
    private javax.swing.JButton yourPropertySlot_2_6;
    private javax.swing.JButton yourPropertySlot_3;
    private javax.swing.JButton yourPropertySlot_3_2;
    private javax.swing.JButton yourPropertySlot_3_3;
    private javax.swing.JButton yourPropertySlot_3_4;
    private javax.swing.JButton yourPropertySlot_3_5;
    private javax.swing.JButton yourPropertySlot_3_6;
    private javax.swing.JButton yourPropertySlot_4;
    private javax.swing.JButton yourPropertySlot_4_2;
    private javax.swing.JButton yourPropertySlot_4_3;
    private javax.swing.JButton yourPropertySlot_4_4;
    private javax.swing.JButton yourPropertySlot_4_5;
    private javax.swing.JButton yourPropertySlot_4_6;
    private javax.swing.JButton yourPropertySlot_5;
    private javax.swing.JButton yourPropertySlot_5_2;
    private javax.swing.JButton yourPropertySlot_5_3;
    private javax.swing.JButton yourPropertySlot_5_4;
    private javax.swing.JButton yourPropertySlot_5_5;
    private javax.swing.JButton yourPropertySlot_5_6;
    private javax.swing.JButton yourPropertySlot_6;
    private javax.swing.JButton yourPropertySlot_6_2;
    private javax.swing.JButton yourPropertySlot_6_3;
    private javax.swing.JButton yourPropertySlot_6_4;
    private javax.swing.JButton yourPropertySlot_6_5;
    private javax.swing.JButton yourPropertySlot_6_6;
    private javax.swing.JButton yourPropertySlot_7;
    private javax.swing.JButton yourPropertySlot_7_2;
    private javax.swing.JButton yourPropertySlot_7_3;
    private javax.swing.JButton yourPropertySlot_7_4;
    private javax.swing.JButton yourPropertySlot_7_5;
    private javax.swing.JButton yourPropertySlot_7_6;
    private javax.swing.JButton yourPropertySlot_8;
    private javax.swing.JButton yourPropertySlot_8_2;
    private javax.swing.JButton yourPropertySlot_8_3;
    private javax.swing.JButton yourPropertySlot_8_4;
    private javax.swing.JButton yourPropertySlot_8_5;
    private javax.swing.JButton yourPropertySlot_8_6;
    private javax.swing.JButton yourPropertySlot_9;
    private javax.swing.JButton yourPropertySlot_9_2;
    private javax.swing.JButton yourPropertySlot_9_3;
    private javax.swing.JButton yourPropertySlot_9_4;
    private javax.swing.JButton yourPropertySlot_9_5;
    private javax.swing.JButton yourPropertySlot_9_6;
    private javax.swing.JTextField yourTotalMoney;
    // End of variables declaration//GEN-END:variables
}
