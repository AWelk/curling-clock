package org._3rev.curlingclock.gui;

import processing.core.PApplet;
import processing.core.PFont;

public abstract class SubPanel {

    protected final PApplet parent;
    protected final float x1;
    protected final float y1;
    protected final float x2;
    protected final float y2;

    protected final float width;
    protected final float height;

    protected final float centerX;
    protected final float centerY;

    protected final float top;
    protected final float bottom;
    protected final float left;
    protected final float right;

    private PFont font;
    private float textSize;
    protected int textAlignX = PApplet.CENTER;
    protected int textAlignY = PApplet.CENTER;

    public SubPanel(PApplet parent) {
        this(parent, 0, 0, parent.width, parent.height);
    }

    public SubPanel(PApplet parent, float x1, float y1, float x2, float y2) {
        this.parent = parent;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.width = x2 - x1;
        this.height = y2 - y1;

        this.centerX = (x1+x2)/2;
        this.centerY = (y1+y2)/2;

        this.top = y1;
        this.bottom = y2;
        this.left = x1;
        this.right = x2;
    }

    protected void fitText(String message, float x1, float y1, float x2, float y2) {
        font = parent.createFont("Consolas-Bold-250", 250);
        parent.textFont(font);

        float textTestSize = 1;
        parent.textSize(textTestSize);
        while (parent.textWidth(message) < width
                && parent.textAscent() + parent.textDescent() < height) {
            textTestSize++;
            parent.textSize(textTestSize);
        }

        textSize = textTestSize - textTestSize * 0.05f;
        font = parent.createFont("Consolas-Bold-250", textSize);
    }

    protected void fitText(String message) {
        this.fitText(message, x1, y1, x2, y2);
    }

    protected void text(String message, float x, float y) {
        parent.textFont(font);
        parent.textSize(textSize);
        parent.textAlign(textAlignX, textAlignY);
        parent.text(message, x, y);
    }

    public abstract void setup();

    public void setTextAlign(int textAlignX, int textAlignY) {
        this.textAlignX = textAlignX;
        this.textAlignY = textAlignY;
    }
}

