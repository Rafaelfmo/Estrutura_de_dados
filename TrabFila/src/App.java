public class App {
    public static void main(String[] args) {
        TrabFila trabfila = new TrabFila(5);
        trabfila.enfileirar(1);
        trabfila.enfileirar(2);
        trabfila.enfileirar(3);
        trabfila.enfileirar(4);
        trabfila.enfileirar(5);
        trabfila.exibir();

        trabfila.removerCauda(trabfila);
        trabfila.inverterFilaUsandoPilha(trabfila);
        trabfila.imprimirFilaAoContrario(trabfila);
        trabfila.inverterFilaUsandoApenasFila(trabfila);
    }
}
