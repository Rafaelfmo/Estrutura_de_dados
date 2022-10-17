package src;

import javax.swing.JOptionPane;

public class LSECircular {
  private int quantidade;
  private No primeiro;
  private No ultimo;

  public LSECircular() {
    this.quantidade = 0;
    this.primeiro = null;
    this.ultimo = null;
  }

  // Método para retornar a quantidade de elementos da lista encadeada circular
  public int getQuantidade() {
    return quantidade;
  }

  // Método para verificar se a lista está vazia
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

  public void atualizarUltimo(){
    if(!estaVazia()){
      No ultimo = retornarElemento(quantidade - 1);
      ultimo.setProximo(primeiro);
    }
  }

  // Método para retornar o elemento da lista encadeada circular
  public No retornarElemento(int posicao){
    if (estaVazia() || !verificarEntrada(posicao)){
      return null;
    } else {
      No aux = primeiro;
      for (int i = 0; i < posicao; i++) {
        aux = aux.getProximo();
      }
      return aux;
    }
  }

  // Método para adicionar um novo Nó na posicao da lista encadeada circular
  public void adicionarPosicao(No novoNo, int posicao){
    if (!verificarEntrada(posicao)){
      System.out.println("Posição inválida");
    } else {
      if (posicao == 0){
        if (estaVazia()){
          primeiro = novoNo;
          ultimo = novoNo;
        } else {
          novoNo.setProximo(primeiro);
          primeiro = novoNo;
        }
      } else {
        No anterior = retornarElemento(posicao - 1);
        No seguinte = anterior.getProximo();
        anterior.setProximo(novoNo);
        novoNo.setProximo(seguinte);
      }
      quantidade++;
      atualizarUltimo();
    }
  }

  // Método para adicionar um novo Nó no início da lista encadeada circular
  public void adicionarInicio(No novoNo){
    adicionarPosicao(novoNo, 0);
  }

  // Método para adicionar um novo Nó no final da lista encadeada circular
  public void adicionarFim(No novoNo){
    adicionarPosicao(novoNo, quantidade);
  }

  // Método para remover um Nó da lista encadeada circular
  public No removerPosicao(int posicao){
    if (estaVazia() || !verificarEntrada(posicao)){
      return null;
    } else {
      No aux = null;
      if (posicao == 0){
        aux = primeiro;
        primeiro = primeiro.getProximo();
      } else {
        No anterior = retornarElemento(posicao - 1);
        aux = anterior.getProximo();
        No seguinte = aux.getProximo();
        anterior.setProximo(seguinte);
      }
      quantidade--;
      atualizarUltimo();
      return aux;
    }
  }

  // Método para remover o primeiro Nó da lista encadeada circular
  public No removerInicio(){
    return removerPosicao(0);
  }

  // Método para remover o último Nó da lista encadeada circular
  public No removerFinal(){
    return removerPosicao(quantidade - 1);
  }

  // Método para exibir a lista encadeada circular
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

