package info.gridworld.actor;

import java.awt.Color;

/**
 * A <code>Earth</code> is an actor that does nothing. It's the ground without grass on it. <br />
 */

public class Earth extends Obstacle
{
    private static final Color DEFAULT_COLOR = new Color(160 , 82 , 45);

    /**
     * Constructs a brown piece of earth.
     */
    public Earth()
    {
        setColor(DEFAULT_COLOR);
    }

    /**
     * Constructs a sea of a given color.
     * @param seacolor the color of this sea
     */
    public Earth(Color seaColor)
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
