// Blocker.java
// Subclass of GameElement customized for the Blocker
package com.morrill.cannongame;

import android.graphics.Rect;

public class Blocker extends GameElement {
    private int missPenalty; // the miss penalty for this Blocker
    private int y; // the y position value for this Blocker

    //constructor
    public Blocker(CannonView view, int color, int missPenalty, int x,
        int y, int width, int length, float velocityY) {
        super(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length,
            velocityY);
        this.missPenalty = missPenalty;
        this.y = y;
    }

    // test whether Blocker bumps the top or bottom of the screen
    public boolean verticalBump() {
        return shape.bottom > view.getScreenHeight() || shape.top < 0;
    }
    // returns the miss penalty for this Blocker
    public int getMissPenalty() {
        return missPenalty;
    }

}
