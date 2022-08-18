import javax.swing.JOptionPane;

public class Fila {
  private int quantidade;
  private int [] elementos;

  public Fila(int limite){
    quantidade = 0;
    elementos = new int[limite];
  }

  public int getquantidade(){
    return quantidade;
  }

  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else return false;
  }

  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else return false;
  }
   public int retornarElemento(){
    if (estaVazia()){
      return -1;
    } else return elementos[0];
   }

   public void enfileirar(int elemento){
    if (estaCheia()){
      System.out.println("A filha está cheia!");
    } else {
      elementos[quantidade] = elemento;
      quantidade++;
    }
  }

   public int desenfileirar(){
    if (estaVazia()){
      return -1;
    } else {
      int removido = elementos[0];
      for (int i = 0; i < quantidade-1; i++){
        elementos[i] = elementos[i+1];
      }
      quantidade--;
      return removido;
    }
  }

  public void exibir(){
    String elementos = this.elementos[0] + ", ";
    for (int i = 1; i < this.quantidade; i++){
      elementos += this.elementos[i];
      if (i != this.quantidade-1){
        elementos += ", ";
      }
    }
    JOptionPane.showMessageDialog(null, elementos);
  }
}
