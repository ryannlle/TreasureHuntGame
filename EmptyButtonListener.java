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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**

 *  |-----------------------------------------------------------|

 *  |                     EmptyButtonListener                   |

 *  |-----------------------------------------------------------|

 *  |      Responsibilities         |   Collaborating Classes   |

 *  |-------------------------------+---------------------------|

 *  |   Monitors when the empty     |     TreasureGame          |

 *  |   button is clicked and how   |     EmptyButton           |

 *  |   to process that click       |     TreasureButton        |

 *  |   depending on the game status|                           |

 *  |-------------------------------+---------------------------|

 */

public class EmptyButtonListener implements ActionListener
{
    private EmptyButton button;//has an empty button
    private TreasureGame game; //has a game

    //Constructor
    //Purpose: Create an instance of the current  EmptyButton and TreasureGame variable
    public EmptyButtonListener(EmptyButton button, TreasureGame game) 
    {
        this.button = button;
        this.game = game;
    }

    
    //Purpose: Unique action perfomed exlcusive to the empty button method that will first reveal the card. If the game 
    //is over before the button is clicked, it will not be revealed. If the game is over after the button has been revealed,
    //then endGame() is called to reveal all the cards
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (game.isGameOver()) 
        {
            return; //returns nothing to end method...
        }
        
        //...otherwise carry on with reveal and processing, and THEN checking if the game is now over
        button.reveal();
        game.reduceNumberOfTries();
        
        if (game.isGameOver()) 
        {
            game.endGame();
        }
    }
}

