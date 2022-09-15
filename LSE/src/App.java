package src;
public class App {
    public static void main(String[] args) throws Exception {
        LSE lse = new LSE();

        lse.adicionarInicio(new No(1));
        lse.adicionarInicio(new No(2));
        lse.adicionarInicio(new No(3));
        lse.adicionarFinal(new No(4));

        lse.exibir();

    }
}
