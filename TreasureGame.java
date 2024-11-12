
/**
 * Ryan Le
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * https://stackoverflow.com/questions/22982295/what-does-pack-do
 * https://coderanch.com/t/459865/java/componts-JFrame
 * https://www.javatpoint.com/downcasting-with-instanceof-operator
 * https://stackoverflow.com/questions/6835682/how-to-disable-gui-button-in-java
 *
 * Version: 07/23/2024
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;
 
/**

 *  |-----------------------------------------------------------|

 *  |                          TreasureGame                      |

 *  |-----------------------------------------------------------|

 *  |      Responsibilities         |   Collaborating Classes   |

 *  |-------------------------------+---------------------------|

 *  |    Create the gameboard       |     EmptyButton           |

 *  |    and methods to called on   |     EmptyButtonListener   |

 *  |    by collaborating classes   |     TreasureButton        |

 *  |                               | TreasureButtnonListener   |

 *  |                               |                           |

 *  |-------------------------------+---------------------------|

 */


public class TreasureGame
{
    //Establish varibles for the gameboards main panel and frame
    private JFrame frame; 
    private JPanel boardPanel;
    
    //Create labels for each of the game information aspects
    private JLabel triesLeftLabel;
    private JLabel treasuresLeftLabel;
    private JLabel treasuresFoundLabel;
    
    //Intialialize each of the game information with an integer value
    private int triesLeft = 50;
    private int treasuresLeft = 20;
    private int treasuresFound = 0;

    //Constructor
    //Purpose: Creates a main window that will house a title, information panel, and the game panel
    public TreasureGame()
    {
        //Display the title of the game
        frame = new JFrame("Treasure Hunt");
        
        
        //Specify action for the close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create a border layout for the main window
        frame.setLayout(new BorderLayout());

        //Create labels to display each aspect of the game information 
        treasuresLeftLabel = new JLabel("Treasures Left: " + treasuresLeft);
        treasuresFoundLabel = new JLabel("Treasures Found: " + treasuresFound);
        triesLeftLabel = new JLabel("Tries Left: " + triesLeft);
        
        
        //Creeate a new JPanel that is populated with the previously created information labels 
        JPanel infoPanel = new JPanel();
        infoPanel.add(treasuresLeftLabel);
        infoPanel.add(treasuresFoundLabel);
        infoPanel.add(triesLeftLabel);
        
        //Adds the information panel to the left most side of the main window
        frame.add(infoPanel, BorderLayout.WEST);
        
        //Create a new game"board" panel that is 8 by 8
        boardPanel = new JPanel(new GridLayout(8, 8));
        
        //Adds the gameboard panel to the middle of the main window
        frame.add(boardPanel, BorderLayout.CENTER);

        //Cals on method to populate the board
        initializeBoard();
        
        //Alternate to setSize
        frame.pack();

        frame.setVisible(true);
    }

    //Purpose: Populate board with 64 (8 * 8)  buttons, 20 of them being treasure and the rest empty
    private void initializeBoard()
    {
        //Create an empty array with 64 elements that wull store whether a respective grid is a treasure or not
        int[] buttonArray = new int[64];
        
        //Assigns all 64 elements as "0" which will serve as place holders
        for(int i = 0; i< 64; i++)
        {
            buttonArray[i] = 0;
        }
        
        //Replace 20 unique elements with "1" to determine which element's respective place in the 8x8 grid is a treasure
        for(int x = 0; x < 20;x++)
        {
            //Create a new random class
            Random random = new Random();
            int place = random.nextInt(64);
            
            if(buttonArray[place] != 1)
            {
                buttonArray[place] = 1;
            }
            else //Redo the random integer if a duplicate element with 1 is selected
            {
                x--;
            }
            
        }
        
        //Adds buttons to the grid based off of the array. A 0 corresponds to an empty button and 1 to a treasure button
        for(int i = 0; i < 64; i++)
        {
            if(buttonArray[i] == 0)
            {
                EmptyButton button = new EmptyButton(this);
                boardPanel.add(button);
            }
            else
            {
                TreasureButton button = new TreasureButton(this);
                boardPanel.add(button);
            }
        }
        
    }
    
    //Purpose: Subtracts ones from the numebr of tries the user has left and sets the text to correctly show the new change
    public void reduceNumberOfTries() 
    {
        triesLeft--;
        triesLeftLabel.setText("Tries Left: " + triesLeft);
    }

    //Purpouse: Add one to the number of terasures found and subtract one from treasures left and sets the text to show 
    //the new change
    public void foundTreasure() 
    {
        treasuresFound++;
        treasuresFoundLabel.setText("Treasures Found: " + treasuresFound);
        treasuresLeft--;
        treasuresLeftLabel.setText("Treasures Left: " + treasuresLeft);
    }

    
    //Boolean expression to determine if the number of tries left equals 0 is true or false
    public boolean isGameOver() 
    {
        return triesLeft == 0;
    }

    //Purpose: Reaveals all of the treasure compoenets and disbales all of the buttons
    public void endGame() 
    {
        Component[] components = boardPanel.getComponents();
        //Goes through each component of the array 
        for (Component component : components) 
        {
            if (component instanceof EmptyButton) //instance of is only used in a switch statement
            {
                ((EmptyButton) component).reveal();
            }
            component.setEnabled(false);
        }
    }
    
    
    //Purpose:Creates and runs the game
    public static void main(String[] args)
    {
        new TreasureGame();
    }
}
    
