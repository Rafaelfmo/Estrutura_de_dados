
import javax.swing.JOptionPane;
public class Lista {
  private int quantidade;
  private int [] elementos;

  public Lista(int tamanho){
    quantidade = 0;
    elementos = new int[tamanho];
  }

  //Método para verificar input da posição
  public boolean verificarEntrada(int posicao){
    if (posicao >= 0 && posicao <= quantidade){
      return true;
    } else {
      return false;
    }
  }

  //Método para retornar a quantidade
  public int getQuantidade(){
    return quantidade;
  }

  //Método para verificar se a lista está vazia
  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else {
      return false;
    }
  }

  //Método para verificar se a lista está cheia
  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else {
      return false;
    }
  }

  //Método para retornar um elemento na posição desejada
  public int retornarElemento(int posicao){
    if (verificarEntrada(posicao)){
      return elementos[posicao];
    } else {
      return -1;
    }
  }

  //Método para inserir um elemento na posição desejada
  public void adicionarPosicao(int elemento, int posicao){
    if (estaCheia()){
      System.out.println("Lista está cheia!");
    } else if (verificarEntrada(posicao)){
      for (int i = quantidade - 1; i >= posicao; i--){
        elementos[i+1] = elementos[i];
      }
      elementos[posicao] = elemento;
      quantidade++;
    }
  }

  //Método para adicionar um elemento no início da lista
  public void adicionarInicio(int elemento){
    adicionarPosicao(elemento, 0);
  }

  //Método para adicionar um elemento no final da lista
  public void adicionarFinal(int elemento){
    adicionarPosicao(elemento, quantidade);
  }

  //Método para remover um elemento na posição desejada
  public void removerPosicao(int posicao){
    if (estaVazia()){
      System.out.println("Não há o que remover");
    } else if (verificarEntrada(posicao)){
      for (int i = posicao; i < quantidade - 1; i++){
        elementos[i] = elementos[i+1];
        quantidade--;
      }
    }
  }

  //Método para remover o elemento no início da lista
  public void removerInicio(){
    removerPosicao(0);
  }

  //Método para remover o elemento no final da lista
  public void removerFinal(){
    removerPosicao(quantidade-1);
  }

  //Método para exibir elementos da lista
  public void exibir() {
    String elementos = this.elementos[0] + ", ";
    for (int i = 1; i < quantidade; i++) {
      elementos += this.elementos[i];
      if (i != (quantidade - 1))
      elementos += ", ";
    }
    JOptionPane.showMessageDialog(null, elementos);
  }

  //Método para retornar o elemento do meio da lista
  public void retornarMeio(){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else if (quantidade % 2 == 1){
      JOptionPane.showMessageDialog(null,"O elemento do meio é " + elementos[quantidade/2]);
    } else {
      JOptionPane.showMessageDialog(null,"Não há elemento do meio");
    }
  }

  //Método para trocar primeiro elemento com o último da lista
  public void trocar_PrimeiroUltimo(){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else {
      int aux = elementos[0];
      elementos[0] = elementos[quantidade-1];
      elementos[quantidade-1] = aux;
      exibir();
    }
  }

  //Método para verificar a posição do elemento especificado
  public void retornarPosicao(int elemento){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else {
      for (int i = 0; i < quantidade; i++){
        if (elementos[i] == elemento){
          JOptionPane.showMessageDialog(null,"O elemento está na posição " + i);
          return;
        }
      }
      JOptionPane.showMessageDialog(null,"O elemento não está na lista");
    }
  } 

  //Método para inverter a lista
  public void inverter(){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else {
      int [] aux = new int[quantidade];
      for (int i = 0; i < quantidade; i++){
        aux[i] = elementos[quantidade-1-i];
      }
      elementos = aux;
      exibir();
    }
  }

  //método para remover elementos repetidos da lista
  /*public void removerRepetidos(){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else {
      int [] aux = elementos;
      for (int i = 0; i < quantidade; i++){
        int k = i + 1;
        int removidos = 0;
        for (int j = i+1; j < quantidade; j++){
          if (aux[i] == aux[j]){
            removidos++;
          } else {
            aux[k] = aux[j];
            k++;
          }
        }
        quantidade = quantidade - removidos;
      }
      elementos = aux;
      exibir();
    }
  }*/

  public void removerRepetidos(){
    if (estaVazia()){
      System.out.println("A lista está vazia!");
    } else {
      for (int i = 0; i < quantidade - 1; i++){
        for (int j = quantidade - 1; j > i; j--){
          if (elementos[i] == elementos[j]){
            removerPosicao(j);
            j--;
          } 
        }
      }
      exibir();
    }
  }
}

