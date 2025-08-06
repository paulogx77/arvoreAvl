package org.example;



public class ArvoreAVL {

    public Node raiz;

    public int altura(Node no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    //Fator Balanceamento = altura(esquerda) - altura(direita)
    public int getFatorBalanceamento(Node no) {
        if (no == null) {
            return 0;
        }

        return altura(no.getEsquerdo()) - altura(no.getDireito());
    }

    public void atualizarAltura(Node no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        }
    }

    Node rotacaoDireita(Node y) {
        System.out.println("Rotacionando à direita do nó" + y.valor);
        Node x = y.esquerdo;
        Node
    }
}