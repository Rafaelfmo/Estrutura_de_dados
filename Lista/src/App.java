import Pacote01.Lista;
public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista = new Lista(5);
        lista.adicionarPosicao(1, 1);
        lista.adicionarPosicao(2, 2);
        lista.adicionarPosicao(3, 3);
        lista.adicionarPosicao(4, 4);
        lista.adicionarPosicao(5, 5);
        lista.retornarElemento(0);
        lista.retornarElemento(1);
        lista.retornarElemento(2);
        lista.retornarElemento(3);
        lista.retornarElemento(4);
        lista.estaCheia();
        
        
    }
}
