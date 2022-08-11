package Pacote01;

import javax.swing.JOptionPane;

public class Lista_Att {
  private int quantidade;
  private int [] elementos;

  public Lista_Att(int limite){
    quantidade = 0;
    elementos = new int[limite];
  }

  private boolean verificar(int posicao){
    if (estaCheia()){
      return false;
    } else if (posicao >= 0 && posicao <= elementos.length){
      return true;
    } else {
      return false;
    }
  }

  public int getQuantidade(){
    return quantidade;
  }

  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else {
      return false;
    }
  }

  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else {
      return false;
    }
  }

  public int retornarElemento(int posicao){
    if (verificar(posicao)){
      return elementos[posicao];
    } else {
      return -1;
    }
  }

  public void adicionarPosicao(int elemento, int posicao){
    if (verificar(posicao)){
      for (int i = quantidade-1; i <= posicao; i--){
        elementos[i+1] = elementos[i];
        elementos[posicao] = elemento;
        quantidade++;
      }
    }
  }
  
  public void adicionarInicio(int elemento){
    adicionarPosicao(elemento, 0);
  }

  public void adicionarFinal(int elemento){
    adicionarPosicao(elemento, quantidade);
  }

  public void removerPosicao(int posicao){
    if (estaVazia(){
      for (int i = posicao; i < quantidade-1; i++){
        elemento[i] = elemento[i+1];
        quantidade--;
    }
  }
        
  public void removerInicio(){
    removerPosicao(0);
  }
        
  public void removerFinal(){
    removerPosicao(quantidade-1);
  }

  public void exibir(){
    String elementos = this.elementos[0] + ", ";
    for (int i = 1; i < quantidade; i++){
      elementos += this.elementos[i];
      if (i != quantidade - 1){
        elementos += ", ";
      }
    }
    JOptionPane.showMessageDialog(null, elementos);
  }
}
