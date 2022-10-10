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

  public void atulizarUltimo(){
    No aux = primeiro;
    while (aux.getProximo() != primeiro) {
      aux = aux.getProximo();
    }
    ultimo = aux;
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
      if (estaVazia()){
        primeiro = novoNo;
        ultimo = novoNo;
      } else {
        if (posicao == 0){
          novoNo.setProximo(primeiro);
          primeiro = novoNo;
        } else {
          No aux = retornarElemento(posicao - 1);
          novoNo.setProximo(aux.getProximo());
          aux.setProximo(novoNo);
        }
      } 
      atulizarUltimo();
      quantidade++;
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
        if (quantidade == 1){
          primeiro = null;
          ultimo = null;
        } else {
          primeiro = primeiro.getProximo();
        }
      } else {
        No anterior = retornarElemento(posicao - 1);
        aux = anterior.getProximo();
        anterior.setProximo(aux.getProximo());
      }
      atulizarUltimo();
      quantidade--;
      return aux;
    }
  }

  // Método para remover o primeiro Nó da lista encadeada circular
  public No removerInicio(){
    return removerPosicao(0);
  }

  // Método para remover o último Nó da lista encadeada circular
  public No removerFim(){
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

