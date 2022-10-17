package src;

import javax.swing.JOptionPane;

public class FilaEncadeada {
  private int quantidade;
  private No primeiro;

  public FilaEncadeada() {
    this.quantidade = 0;
    this.primeiro = null;
  }

  // Método para retornar a quantidade
  public int getQuantidade() {
    return quantidade;
  }

  // Método para verificar se a fila está vazia
  public boolean estaVazia() {
    if (quantidade == 0) {
      return true;
    } else {
      return false;
    }
  }

  // Método para verificar se a entrada é valida
  public boolean verificarEntrada(int posicao) {
    if (posicao >= 0 && posicao <= quantidade) {
      return true;
    } else {
      return false;
    }
  }

  // Método para retornar o nó na posição pedida
  public No retornarElemento(){
    if (estaVazia()) {
      return null;
    } else return primeiro;
  }

  // Método para adicionar um novo nó no final da fila
  public void enfileirar(No novoNo){
    if (estaVazia()) {
      primeiro = novoNo;
    } else {
      No aux = primeiro;
      for (int i = 0; i < quantidade - 1; i++) {
        aux = aux.getProximo();
      }
      aux.setProximo(novoNo);
    }
    quantidade++;
  }

  // Método para remover o nó do começo da fila
  public No desenfileirar(){
    if (estaVazia()) {
      return null;
    } else {
      No aux = primeiro;
      if (quantidade == 1) {
        primeiro = null;
      } else {
        primeiro = primeiro.getProximo();
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
