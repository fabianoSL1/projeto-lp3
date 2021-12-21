package gui;

import processing.core.PApplet;
import static java.lang.Math.*;

public class Botao implements Draw {
    private PApplet sketch;
    private int cordX;
    private int cordY;
    private int height;
    private int width;
    private int color;
    private int realHeight;

    public Botao(PApplet sketch, int color, int height) {
        this.sketch = sketch;
        this.color = color;
        this.height = height;
    }

    public void setPosition(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }

    public void render() {
        this.render(this.realHeight);
    }

    public void render(int height) {
        sketch.fill(color);

        sketch.circle(cordX, cordY, height);

    }

    public void update() {
        if (realHeight < height)
            realHeight += 2;
    }

    public boolean over() {
        float disX = cordX - sketch.mouseX;
        float disY = cordY - sketch.mouseY;

        return sqrt(pow(disX, 2) + pow(disY, 2)) < (height / 2);
    }

    public int getX() {
        return this.cordX;
    }

    public int getY() {
        return this.cordY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
