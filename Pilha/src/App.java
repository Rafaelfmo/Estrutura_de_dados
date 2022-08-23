package Pilha.src;
public class App {
    public static void main(String[] args) throws Exception {
        Pilha pilha = new Pilha(5);

        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.empilhar(4);
        pilha.empilhar(5);
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.retornarElemento();
    }
}
