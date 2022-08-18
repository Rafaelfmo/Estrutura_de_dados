import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) throws Exception {
        Fila fila = new Fila(5);
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        fila.enfileirar(5);
        fila.exibir();  
        JOptionPane.showMessageDialog(null, "O elemento removido é: " + fila.desenfileirar());
        fila.exibir();
        JOptionPane.showMessageDialog(null, "O elemento removido é: " + fila.desenfileirar());
        fila.exibir();
        JOptionPane.showMessageDialog(null, "O elemento removido é: " + fila.desenfileirar());
        fila.exibir();
        fila.enfileirar(10);
        fila.exibir();

    }
}
