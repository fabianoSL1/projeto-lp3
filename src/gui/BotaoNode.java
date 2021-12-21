package gui;

import gui.Botao;
import arvore.Node;
import arvore.NodeUtils;
import processing.core.PApplet;

public class BotaoNode extends Botao {
    private Node node;

    public BotaoNode(PApplet sketch, Node node, int color, int height) {
        super(sketch, color, height);
        this.node = node;
        node.setBotao(this);
    }

    public int getValor() {
        return this.node.getValor();
    }

    @Override
    public String toString() {
        return Integer.toString(this.node.getValor());
    }

}
