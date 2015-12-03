
package info.gridworld.actor;

import java.awt.Color;

/**
 * A <code>Sea</code> is an actor that does nothing. It's mostly used to show what lies outside
 * the shores of the island. <br />
 */

public class Sea extends Actor
{

    /**
     * Constructs a black rock.
     */
    public Sea()
    {
        setColor(Color.BLUE);
    }

    /**
     * Constructs a sea of a given color.
     * @param seacolor the color of this sea
     */
    public Sea(Color seaColor)
    {
        setColor(seaColor);
    }

    /**
     * Overrides the <code>act</code> method in the <code>Actor</code> class
     * to do nothing.
     */
    public void act()
    {
    }
}
