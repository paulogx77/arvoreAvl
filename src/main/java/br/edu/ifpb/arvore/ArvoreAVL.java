package br.edu.ifpb.arvore;

public class ArvoreAVL {

    public Node raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public int altura(Node node) {
        if (node == null) {
            return 0;
        }
        return node.altura;
    }

    public int fatorBalanceamento(Node node) {
        if (node == null) {     //Se o FB for > 1 o Nó esta pesado para a esquerda,
            return 0;           //Se o FB for < -1 o Nó esta pesado para a direta.
        }                       //Se o FB for {-1,0,1} o Nó esta balanceado
        return altura((node.esquerdo)) - altura((node.direito));
    }

    public void atualizarAltura(Node node) {
        if (node != null) {
            node.altura = 1 + Math.max(altura(node.direito), altura(node.esquerdo));
        }
    }

    public Node rotacaoEsquerda(Node z) {
        // y = filho direto de z
        Node y = z.direito;
        // T2 = filho esquerdo de Y
        Node T2 = y.esquerdo;

        // o filho de y agora vai ser a antiga raiz
        y.esquerdo = z;
        z.direito = T2;

        atualizarAltura(z);
        atualizarAltura(y);

        return y;
    }

    public Node rotacaoDireita(Node z) {
        Node y = z.esquerdo;
        Node T3 = y.direito;

        y.direito = z;
        z.esquerdo = T3;

        atualizarAltura(z);
        atualizarAltura(y);

        return y;
    }

    public Node inserir(Node atual, int valor) {
        if (atual == null) {
            atual = new Node(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserir(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserir(atual.direito, valor);
        } else {
            return atual;
        }

        atualizarAltura(atual);

        int balanceamento = fatorBalanceamento(atual);

        if (balanceamento > 1 && fatorBalanceamento(atual.esquerdo) >= 0) {
            return rotacaoDireita(atual);
        }

        if (balanceamento < -1 && fatorBalanceamento(atual.direito) <= 0) {
            return rotacaoEsquerda(atual);
        }

        if (balanceamento > 1 && fatorBalanceamento(atual.esquerdo) < 0) {
            atual.esquerdo = rotacaoEsquerda(atual.esquerdo);
            return rotacaoDireita(atual);
        }

        if (balanceamento < -1 && fatorBalanceamento(atual.direito) > 0) {
            atual.direito = rotacaoDireita(atual.direito);
            return rotacaoEsquerda(atual);
        }
        return atual;
    }
}