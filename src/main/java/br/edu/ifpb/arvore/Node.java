package org.example;

public class Node {

     int valor;
     int altura;
     Node esquerdo;
     Node direito;


    public Node(int valor) {
        this.valor = valor;
        this.altura = 1; // "a altura de um nó novo é 1 <- (verificar o por que)"
    }

    public int getValor() {
        return valor;
    }
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Node getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Node esquerdo) {
        this.esquerdo = esquerdo;
    }

    public Node getDireito() {
        return direito;
    }

    public void setDireito(Node direito) {
        this.direito = direito;
    }
}
