package src;

import javax.swing.JOptionPane;

public class PilhaEncadeada {
  private int quantidade;s
  private No primeiro;
  private No ultimo;

  public PilhaEncadeada() {
    this.quantidade = 0;
    this.primeiro = null;
    this.ultimo = null;
  }

  // Método para retornar a quantidade de elementos da pilha
  public int getQuantidade() {
    return quantidade;
  }

  // Método para verificar se a pilha está vazia
  public boolean estaVazia() {
    if (quantidade == 0) {
      return true;
    } else {
      return false;
    }
  }

  // Método para verificar se a posição é válida
  public boolean verificarEntrada(int posicao) {
    if (posicao >= 0 && posicao <= quantidade) {
      return true;
    } else {
      return false;
    }
  }

  // Método para retornar o elemento do topo da pilha
  public No retornarElemento(int posicao) {
    if (estaVazia() || !verificarEntrada(posicao)) {
      return null;
    } else {
      return ultimo;
    }
  }

  // Método para adicionar um novo Nó no topo da pilha
  public void empilhar(No novoNo) {
    if (estaVazia()) {
      primeiro = novoNo;
      ultimo = novoNo;
    } else {
      ultimo.setProximo(novoNo);
      ultimo = novoNo;
    }
    quantidade++;
  }

  // Método para remover o Nó do topo da pilha
  public No desempilhar() {
    if (estaVazia()) {
      return null;
    } else {
      No aux = ultimo;
      No anterior = null;

      for(int i = 1; i < quantidade ; i++){
        if (anterior == null) {
          anterior = primeiro;
        } else {
          anterior = anterior.getProximo();
        }
      }
      if (anterior == null) {
        primeiro = null;
        ultimo = null;
      } else {
        anterior.setProximo(null);
        ultimo = anterior;
      }
      quantidade--;
      return aux;
    }
  }

  public void exibir(){
    No atual = primeiro;
    String elementos = "";
    for (int i = 0; i < quantidade; i++) {
        elementos += atual.getElemento();

        atual = atual.getProximo();

        if(i != (quantidade - 1))
            elementos += ", ";
    }

    JOptionPane.showMessageDialog(null, elementos);
  }
}
 

