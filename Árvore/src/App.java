public class App {
    public static void main(String[] args) throws Exception {
        ArvoreBinariaComPilha arvore = new ArvoreBinariaComPilha();
        arvore.raiz = new NoAB(1);
        arvore.raiz.esquerda = new NoAB(2);
        arvore.raiz.direita = new NoAB(3);
        arvore.raiz.esquerda.esquerda = new NoAB(4);
        arvore.raiz.esquerda.direita = new NoAB(5);
        arvore.raiz.direita.esquerda = new NoAB(6);
        arvore.raiz.direita.direita = new NoAB(7);

       arvore.varreduraLargura();
       arvore.varreduraPreOrdem();
       arvore.varreduraEmOrdem();
       arvore.varreduraPosOrdem();

    }
}
