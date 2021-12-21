
/*
 * NOTE: https://happycoding.io/tutorials/java/processing-in-java
 * 
 * NOTE: pode ocorrer sobreposicao de nodes
 *
 * TODO: Desenhar linha ate o elemento em que o mouse esta
 *
 * TODO: ajustar a disposicao dos nodes
*/
package gui;

import static arvore.NodeUtils.*;

import java.util.ArrayList;
import java.util.List;

import arvore.Node;
import processing.core.PApplet;
import gui.Botao;
import gui.BotaoNode;

public class Init extends PApplet {
    private Botao botaoCriaNode;
    private List<BotaoNode> nodes;
    private final int COLOR_DEFAULT;
    private final int SIZE_DEFAULT;
    private final int RANDOM_LIMIT;

    public Init() {
        COLOR_DEFAULT = color(75, 75, 75);
        SIZE_DEFAULT = 50;
        RANDOM_LIMIT = 100;

        botaoCriaNode = new Botao(this, COLOR_DEFAULT, SIZE_DEFAULT);
        nodes = new ArrayList<BotaoNode>();
    }

    public void settings() {
        size(768, 480);

    }

    public void setup() {
        setSketch(this);
        textAlign(CENTER);
        frameRate(60);
        textSize(48);
        noStroke();
        botaoCriaNode.setPosition(width / 2, 50);
    }

    public void draw() {
        background(250);
        botaoCriaNode.render();
        int height = 50;

        for (BotaoNode btnNode : nodes) {
            btnNode.render();
            if (btnNode.over()) {
                text(btnNode.toString() + ",", 50, height);
                height += 60;
            }
        }

        update();
    }

    public void update() {
        botaoCriaNode.update();

        for (BotaoNode btnNode : nodes) {
            btnNode.update();
        }
    }

    public void mousePressed() {
        if (botaoCriaNode.over()) {
            Node novoNode = criarNode((int) random(RANDOM_LIMIT));

            if (inserirNode(novoNode)) {
                BotaoNode botaoNode = new BotaoNode(this, novoNode, COLOR_DEFAULT, SIZE_DEFAULT / 2);
                nodes.add(botaoNode);
            }

            organizarArvore(getRoot(), width / 2, 100);
        }
    }

}
