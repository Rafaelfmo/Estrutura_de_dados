package Pilha.src;
import javax.swing.JOptionPane;

public class Pilha {
  private int quantidade;
  private int [] elementos;

  public Pilha(int tamanho) {
    quantidade = 0;
    elementos = new int[tamanho];
  }

  //Método para verificar a quantidade de elementos na pilha
  public int getQuantidade(){
    return quantidade;
  }

  //Método para verificar se a pilha está vazia
  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else return false;
  }

  //Método para verificar se a pilha está cheia
  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else return false;
  }

  //Método para retornar um elemento na posição desejada
  public int retornarElemento(){
    if (estaVazia()){
      return -1;
    } else {
      return elementos[quantidade-1];
    }
  } 

  //Método para inserir um elemento no topo da pilha
  public void empilhar(int elemento){
    if (estaCheia()){
      System.out.println("A pilha está cheia!");
    } else {
      elementos[quantidade] = elemento;
      quantidade++;
      exibir();
    }
  }

  //Método para desempilhar um elemento do topo da pilha
  public void desempilhar(){
    if (estaVazia()){
      System.out.println("A pilha está vazia!");
    } else {
      quantidade--;
      exibir();
    }
  }

  //Método para imprimir todos os elementos da pilha
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
