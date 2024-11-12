
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

/**

 *  |-----------------------------------------------------------|

 *  |                        TreasureButton                     |

 *  |-----------------------------------------------------------|

 *  |      Responsibilities         |   Collaborating Classes   |

 *  |-------------------------------+---------------------------|

 *  |  Creates a class with methods |     TreasureGame          |

 *  |  for a treasure button that   |  TreasureButtonListener   |

 *  |  can be clicked on            |     EmptyButton           |

 *  |                               |                           |

 *  |-------------------------------+---------------------------|

 */

public class TreasureButton extends EmptyButton 
{
    //Constrcutor
    //Purpose: Refernce the current game that was passed via the EmptyButton extension and passes that game to the
    //Treasure button listener
    public TreasureButton(TreasureGame game) 
    {
        super(game);
        addActionListener(new TreasureButtonListener(this, game));
    }

    //Purpose: Creates a seperate reveal function exclusive to the TreasurButton class that reveals a Treasure and
    //disables the button
    @Override
    public void reveal() 
    {
        setText("Treasure!");
        setEnabled(false);
    }  
}
