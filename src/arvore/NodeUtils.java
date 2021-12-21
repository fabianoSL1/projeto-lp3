package arvore;

import arvore.Node;
import gui.Init;
import gui.BotaoNode;

public class NodeUtils {

    private static Node root;
    private static Init sketch;

    public static Node getRoot() {
        return root;
    }

    public static void setSketch(Init sketch) {
        NodeUtils.sketch = sketch;
    }

    public static void organizarArvore(Node node, int cordX, int cordY) {
        if (node != null) {
            node.setPosition(cordX, cordY);
            organizarArvore(node.getEsquerda(), cordX - 35, cordY + 30);
            organizarArvore(node.getDireita(), cordX + 35, cordY + 30);
        }
    }

    public static Node criarNode(int valor) {
        Node node = new Node(valor);
        return node;
    }

    public static boolean inserirNode(Node novoNode) {
        boolean inseriu = false;

        if (root == null) {
            root = novoNode;
            inseriu = true;
        } else {
            inseriu = inserirNode(novoNode, root);
        }

        return inseriu;
    }

    public static boolean inserirNode(Node novoNode, Node node) {

        boolean inseriu = false;
        int valor = novoNode.getValor();

        if (valor == node.getValor()) {
            System.out.println("já existe");
        } else if (node != null && node.getValor() > valor) {
            if (node.getEsquerda() == null) {
                node.setEsquerda(novoNode);
                inseriu = true;
            } else {
                inseriu = inserirNode(novoNode, node.getEsquerda());

            }
        } else {
            if (node.getDireita() == null) {
                node.setDireita(novoNode);
                inseriu = true;
            } else {
                inseriu = inserirNode(novoNode, node.getDireita());
            }
        }

        return inseriu;
    }

}
