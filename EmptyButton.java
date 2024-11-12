/**
 * Ryan Le; 
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

/**

 *  |-----------------------------------------------------------|

 *  |                          EmptyButton                      |

 *  |-----------------------------------------------------------|

 *  |      Responsibilities         |   Collaborating Classes   |

 *  |-------------------------------+---------------------------|

 *  |  Creates a class with methods |     TreasureGame          |

 *  |  for an empty button that     |     EmptyButtonListener   |

 *  |  can be clicked on            |     TreasureButton        |

 *  |                               |                           |

 *  |-------------------------------+---------------------------|

 */


public class EmptyButton extends JButton 
{
    private TreasureGame game; //has an empty button
    
    //Constrcutor
    //Purpose: Recieve the treasure game board/information and pass it on to empty button listener while referencing the 
    //current TreasureGame
    public EmptyButton(TreasureGame game) 
    {
        super(" "); //Allows refernce to parent class
        this.game = game;
        addActionListener(new EmptyButtonListener(this, game));
    }
    
    //Purpose: Reveals that the card is empty and disables it from being clicked 
    public void reveal() 
    {
        setText("Empty");
        setEnabled(false);
    }
}


