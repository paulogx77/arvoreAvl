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
}