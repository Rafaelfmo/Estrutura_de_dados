package Lista.src;
public class App {
    public static void main(String[] args) throws Exception {
        
        Lista lista = new Lista(5);
        
        lista.adicionarFinal(1);
        lista.adicionarFinal(2);
        lista.adicionarFinal(1);
        lista.adicionarFinal(4);
        lista.adicionarFinal(5);
        
        lista.exibir();
        lista.retornarMeio();
        lista.trocar_PrimeiroUltimo();
        lista.retornarPosicao(1);
        lista.inverter();
        lista.removerRepetidos();

    }
}
