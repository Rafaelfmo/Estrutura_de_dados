public class App {
    public static void main(String[] args) throws Exception {
        TrabPilha pilha = new TrabPilha(5);
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.exibir();

        pilha.inverter(pilha);
        pilha.ordenar(pilha);
        //pilha.palindrome(pilha);
        pilha.expressao(pilha);
        pilha.removerMaior(pilha);
        //pilha.removerMenor(pilha);




        

    }    
}
