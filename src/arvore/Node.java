package arvore;

import gui.BotaoNode;

public class Node {
    private Node Esquerda;
    private Node Direita;
    private int valor;
    private BotaoNode botao;

    public Node(int valor) {
        this.valor = valor;
        this.Esquerda = null;
        this.Direita = null;
    }

    public void setPosition(int cordX, int cordY) {
        botao.setPosition(cordX, cordY);
    }

    public void setBotao(BotaoNode botao) {
        this.botao = botao;
    }

    public BotaoNode getBotao() {
        return this.botao;
    }

    public void setEsquerda(Node node) {
        this.Esquerda = node;
    }

    public Node getEsquerda() {
        return this.Esquerda;
    }

    public void setDireita(Node node) {
        this.Direita = node;
    }

    public Node getDireita() {
        return this.Direita;
    }

    public int getValor() {
        return this.valor;
    }
}
