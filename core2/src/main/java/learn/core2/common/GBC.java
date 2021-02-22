package learn.core2.common;

import java.awt.*;

public class GBC extends GridBagConstraints {
    /**
     * Constructs a GBC with a given gridx and gridy position and
     * all other grid bag constraint values set to the default.
     *
     * @param gridX the gridx position
     * @param gridY the gridy position
     */
    public GBC(int gridX, int gridY) {
        this.gridx = gridX;
        this.gridy = gridY;
    }

    /**
     * Constructs a GBC with given gridx, gridy, gridwidth, gridheight
     * and all other grid bag constraint values set to the default.
     *
     * @param gridX      the gridx position
     * @param gridY      the gridy position
     * @param gridWidth  the cell span in x-direction
     * @param gridHeight the cell span in y-direction
     */
    public GBC(int gridX, int gridY, int gridWidth, int gridHeight) {
        this.gridx = gridX;
        this.gridy = gridY;
        this.gridwidth = gridWidth;
        this.gridheight = gridHeight;
    }

    /**
     * Sets the anchor.
     *
     * @param anchor the anchor value
     * @return this object for further modification
     */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Sets the fill direction.
     *
     * @param fill the fill direction
     * @return this object for further modification
     */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Sets the cell weights.
     *
     * @param weightX the cell weight in x-direction
     * @param weightY the cell weight in y-direction
     * @return this object for further modification
     */
    public GBC setWeight(double weightX, double weightY) {
        this.weightx = weightX;
        this.weighty = weightY;
        return this;
    }

    /**
     * Sets the insets of this cell.
     *
     * @param distance the spacing to use in all directions
     * @return this object for further modification
     */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * Sets the insets of this cell.
     *
     * @param top    the spacing to use on top
     * @param left   the spacing to use to the left
     * @param bottom the spacing to use on the bottom
     * @param right  the spacing to use to the right
     * @return this object for further modification
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Sets the internal padding
     *
     * @param iPadX the internal padding in x-direction
     * @param iPadY the internal padding in y-direction
     * @return this object for further modification
     */
    public GBC setIpad(int iPadX, int iPadY) {
        this.ipadx = iPadX;
        this.ipady = iPadY;
        return this;
    }
}
