import javax.swing.JOptionPane;

public class TrabFila {
  private int quantidade;
  private int [] elementos;

  public TrabFila(int tamanho){
    quantidade = 0;
    elementos = new int[tamanho];
  }

  //Método para verificar a quantidade de elementos na trabfila
  public int getquantidade(){
    return quantidade;
  }

  //Método para verificar se a trabfila está vazia
  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else return false;
  }

  //Método para verificar se a trabfila está cheia
  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else return false;
  }

  //Método para retornar um elemento na posição desejada
   public int retornarElemento(){
    if (estaVazia()){
      return -1;
    } else return elementos[0];
   }

  //Método para inserir um elemento no fim da trabfila
   public void enfileirar(int elemento){
    if (estaCheia()){
      System.out.println("A filha está cheia!");
    } else {
      elementos[quantidade] = elemento;
      quantidade++;
    }
  }

  //Método para remover um elemento do inicio da trabfila
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

  //Método para remover o último elemento da trabfila usando trabfila
  public void removerCauda(TrabFila trabfila){
    if (trabfila.estaVazia()){
      System.out.println("A trabfila está vazia!");
    } else {
      trabfila.quantidade--;
    }
    exibir();
  }

  //Método para inverter a trabfila usando pilha
  public void inverterFilaUsandoPilha(TrabFila trabfila){
    TrabPilha pilha = new TrabPilha(trabfila.getquantidade());
    while (!trabfila.estaVazia()){
      pilha.empilhar(trabfila.desenfileirar());
    }
    while (!pilha.estaVazia()){
      trabfila.enfileirar(pilha.desempilhar());
    }
    exibir();
  }

  //Método para imprimir a trabfila ao contrário
  public void imprimirFilaAoContrario(TrabFila trabfila){
    if (trabfila.estaVazia()){
      System.out.println("A trabfila está vazia!");
    } else {
      for (int i = trabfila.getquantidade()-1; i >= 0; i--){
        System.out.println(trabfila.elementos[i]);
      }
    }
  }

  //Método para inverter a trabfila usando fila
  public void inverterFilaUsandoApenasFila(TrabFila trabfila){
    TrabFila filaAux1 = new TrabFila(trabfila.getquantidade());
    TrabFila filaAux2 = new TrabFila(trabfila.getquantidade());
    while (!filaAux2.estaCheia()){
      while (!trabfila.estaVazia()){
        if (trabfila.getquantidade() == 1){
          filaAux2.enfileirar(trabfila.desenfileirar());
        } 
        else filaAux1.enfileirar(trabfila.desenfileirar()); 
      }
      while (!filaAux1.estaVazia()){
        if (filaAux1.getquantidade() == 1){
          filaAux2.enfileirar(filaAux1.desenfileirar());
        } 
        else trabfila.enfileirar(filaAux1.desenfileirar());
      }
    }
    while (!filaAux2.estaVazia()){
      trabfila.enfileirar(filaAux2.desenfileirar());
    }
    exibir();
  }

  //Método para exibir os elementos da trabfila
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