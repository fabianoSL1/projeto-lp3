import gui.Init;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {
        String[] processingArgs = { "Init" };
        Init init = new Init();
        PApplet.runSketch(processingArgs, init);
    }

}
