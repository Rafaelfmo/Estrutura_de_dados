package src;

import javax.swing.JOptionPane;

public class LSE {
  
  private No primeiro;
  private int quantidade;

  public LSE() {
    this.primeiro = null;
    this.quantidade = 0;
  }

  // Método para retornar a quantidade
  public int getQuantidade() {
    return quantidade;
  }

  // Método para verificar se a lista está vazia
  public boolean estaVazia(){
    if (this.quantidade == 0) {
      return true;
    } else {
      return false;
    }
  }

  // Método para verificar se a entrada é valida
  public boolean verificarEntrada(int posicao){
    if (posicao >= 0 && posicao <= quantidade) {
      return true;
    } else {
      return false;
    }
  }

  // Método para retonar o elemento na posicao pedida
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

  // Método para adicionar um novo no na posicao pedida
  public void adicionarPosicao(No novoNo, int posicao){
    if (estaVazia()){
      primeiro = novoNo;
    } else if (posicao == 0){
      novoNo.setProximo(primeiro);
      primeiro = novoNo;
    } else {
      No aux = retornarElemento(posicao - 1);
      novoNo.setProximo(aux.getProximo());
      aux.setProximo(novoNo);
    }
    quantidade++;
  }

  // Método para adicionar um nó novo no início
  public void adicionarInicio(No novoNo){
    adicionarPosicao(novoNo, 0);
  }

  // Método para adicionar um nó novo no final
  public void adicionarFinal(No novoNo){
    adicionarPosicao(novoNo, quantidade);
  }

  // Método para remover um nó na posicao pedida
  public No removerPosicao(int posicao){
    if (estaVazia() || !verificarEntrada(posicao)){
      return null;
    } else {
      No aux = primeiro;
      if (posicao == 0) {
        primeiro = primeiro.getProximo();
      } else {
        for (int i = 0; i < posicao - 1; i++) {
          aux = aux.getProximo();
        }
        aux.setProximo(aux.getProximo().getProximo());
      }
      quantidade--;
      return aux;
    }
  }

  // Método para remover um nó no início
  public No removerInicio(){
    return removerPosicao(0);
  }

  // Método para remover um nó no final
  public No removerFinal(){
    return removerPosicao(quantidade - 1);
  }

  // Método para retornar o último elemento 
  public No retornarUltimo(){
    if (estaVazia()){
      return null;
    } else {
      return retornarElemento(quantidade - 1);
    }
  }

  // Método para retornar o penúltimo elemento
  public No retornarPenultimo(){
    if (estaVazia()){
      return null;
    } else if (quantidade == 1){
      return primeiro;
    } else {
      return retornarElemento(quantidade - 2);
    }
  }

  // Método para retornar o i-ésimo elemento
  public No retornarIesimo(int i){
    if (estaVazia()){
      return null;
    } else if (i == 0){
      return primeiro;
    } else {
      return retornarElemento(i - 1).getProximo();
    }
  }

  // Método para inverter a lista de forma referencial
  public void inverterLSE(){
    No anterior = null;
    No proximo = null;
    No atual = primeiro;

    while (atual != null) {
      proximo = atual.getProximo();
      atual.setProximo(anterior);
      anterior = atual;
      atual = proximo;
    }
    primeiro = anterior;
  }

  // Método para verificar se existem elementos repetidos
  public boolean verificarRepetidos(){
    No aux = primeiro;
    No aux2 = primeiro.getProximo();
    while (aux != null) {
      while (aux2 != null) {
        if (aux.getElemento() == aux2.getElemento()) {
          return true;
        }
        aux2 = aux2.getProximo();
      }
      aux = aux.getProximo();
      aux2 = aux.getProximo();
    }
    return false;
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

