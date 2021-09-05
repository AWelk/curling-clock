package org._3rev.curlingclock.gui.endmode;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class ProgressBar extends SubPanel {

    private int numEnds;

    private List<EndBlock> blocks;

    ProgressBar(PApplet parent, float x1, float y1, float x2, float y2, int numEnds) {
        super(parent, x1, y1, x2, y2);
        this.numEnds = numEnds;
    }

    public void setup() {
        initBlocks();

    }

    public void draw(float percentComplete) {
        float filledBlocks = percentComplete * numEnds / 100;
        int totalFullBlocks = (int) filledBlocks;
        int lastBlockPercent = (int) ((filledBlocks - Math.floor(filledBlocks)) * 100);

        for (int i = 0; i < numEnds; i++) {
            EndBlock block = blocks.get(i);
            if (i < totalFullBlocks) {
                block.draw(100);
            } else if (i == totalFullBlocks) {
                block.draw(lastBlockPercent);
            } else {
                block.draw(0);
            }
        }
    }

    private void initBlocks() {
        float blockRadius = width / numEnds;
        float blockTop = centerY - (blockRadius / 2);
        float blockBottom = centerY + (blockRadius / 2);
        float blockLeft = left;
        blocks = new ArrayList<>(numEnds);
        int end = 1;
        while (blockLeft < right) {
            EndBlock block = new EndBlock(end, parent, blockLeft, blockTop, blockLeft + blockRadius, blockBottom);
            block.setup();
            blocks.add(block);
            blockLeft += blockRadius;
            end++;
        }
    }

    public void setNumEnds(int numEnds) {
        this.numEnds = numEnds;
    }


}
