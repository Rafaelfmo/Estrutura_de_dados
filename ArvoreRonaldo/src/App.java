public class App {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria arvore = new ArvoreBinaria(new NoAB(1));

        arvore.adicionarEsquerda(2, 1);
        arvore.adicionarDireita(3, 1);
        arvore.adicionarEsquerda(4, 2);
        arvore.adicionarDireita(5, 2);
        arvore.adicionarEsquerda(6, 3);
        arvore.adicionarDireita(7, 3);

        arvore.removerElemento(7);
        arvore.removerElemento(6);
        
        System.out.println(arvore.buscarElemento(3).getElemento());
        System.out.println(arvore.nivelElemento(3));
        System.out.println(arvore.alturaArvore());
        System.out.println(arvore.buscarPai(5).getElemento());        
    }
}
