package src;

import javax.swing.JOptionPane;

public class LDE {
  private int quantidade;
  private NoDinamico primeiro;

  public LDE() {
    this.quantidade = 0;
    this.primeiro = null;
  }

  // Método para retornar a quantidade
  public int getQuantidade() {
    return quantidade;
  }

  // Método para verificar se a lista está vazia
  public boolean estaVazia() {
    if (this.quantidade == 0) {
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

  // Método para retonar o elemento na posicao pedida
  public NoDinamico retornarElemento(int posicao) {
    if (estaVazia() || !verificarEntrada(posicao)) {
      return null;
    } else {
      NoDinamico aux = primeiro;
      for (int i = 0; i < posicao; i++) {
        aux = aux.getProximo();
      }
      return aux;
    }
  }

  // Método para adicionar um novo nó na posicao pedida
  public void adicionarPosicao(NoDinamico novoNo, int posicao) {
    if (estaVazia()) {
      primeiro = novoNo;
    } else if (posicao == 0) {
      novoNo.setProximo(primeiro);
      primeiro.setAnterior(novoNo);
      primeiro = novoNo;
    } else {
      NoDinamico aux = retornarElemento(posicao - 1);
      novoNo.setProximo(aux.getProximo());
      novoNo.setAnterior(aux);
      aux.getProximo().setAnterior(novoNo);
      aux.setProximo(novoNo);
    }
    quantidade++;
  }

  // Método para adicionar um novo nó no início da lista
  public void adicionarInicio(NoDinamico novoNo) {
    adicionarPosicao(novoNo, 0);
  }

  // Método para adicionar um novo nó no final da lista
  public void adicionarFinal(NoDinamico novoNo) {
    adicionarPosicao(novoNo, quantidade);
  }

  // Método para remover um nó na posicao pedida
  public NoDinamico removerPosicao(int posicao){
    if(estaVazia() || !verificarEntrada(posicao)){
      return null;
    }else{
      NoDinamico aux = retornarElemento(posicao - 1);
      if(posicao == 0){
        primeiro = primeiro.getProximo();
        primeiro.setAnterior(null);
        aux.setProximo(null);
      }else{
        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());
        aux.setProximo(null);
        aux.setAnterior(null);
      }
      quantidade--;
      return aux;
    }
  }

  // Método para remover o primeiro nó da lista
  public NoDinamico removerInicio(){
    return removerPosicao(0);
  }

  // Método para remover o último nó da lista
  public NoDinamico removerFinal(){
    return removerPosicao(quantidade - 1);
  }

  // Método para buscar um elemento na lista
  public int buscarElemento(int elemento){
    if(estaVazia()){
      return -1;
    } else {
      for (int i = 0; i < quantidade; i++) {
        if(retornarElemento(i).getElemento() == elemento){
          return i;
        }
      }
      return -1;
    }
  }

  //Método para remover o elemento do meio da lista
  public NoDinamico removerMeio(){
    if(estaVazia()){
      return null;
    } else {
      if (quantidade % 2 == 0) {
        return removerPosicao(quantidade / 2);
      } else {
        return removerPosicao((quantidade - 1) / 2);
      }
    }
  }

  // Método para verificar elementos repetidos
  public boolean verificarRepetidos(){
    if(estaVazia()){
      return false;
    } else {
      for (int i = 0; i < quantidade; i++) {
        for (int j = i + 1; j < quantidade; j++) {
          if(retornarElemento(i).getElemento() == retornarElemento(j).getElemento()){
            return true;
          }
        }
      }
      return false;
    }
  }

  //Método para verificar qual elemento mais se repete
  public int verificarMaisRepetido(){
    if(estaVazia()){
      return -1;
    } else {
      int elemento = retornarElemento(0).getElemento();
      int quantidadeRepetida = 0;
      for (int i = 0; i < quantidade; i++) {
        int aux = 0;
        for (int j = 0; j < quantidade; j++) {
          if(retornarElemento(i).getElemento() == retornarElemento(j).getElemento()){
            aux++;
          }
        }
        if(aux > quantidadeRepetida){
          elemento = retornarElemento(i).getElemento();
          quantidadeRepetida = aux;
        }
      }
      return elemento;
    }
  }

  // Método para inverter uma LDE
  public void inverterLDE(){
    if(estaVazia){
      System.out.println("Lista vazia");
    } else {
      NoDinamico aux = primeiro;
      NoDinamico aux2 = primeiro;
      for (int i = 0; i < quantidade; i++) {
        aux = aux.getProximo();
        aux2.setProximo(aux.getAnterior());
        aux2.setAnterior(aux.getProximo());
        aux2 = aux;
      }
      primeiro = aux2;
    }
  }

  // Método para remover qualquer posicao
  public NoDinamico removerQualquerPosicao(int posicao){
    removerPosicao(posicao);
  }

  // Método para exibir a lista
  public void exibir(){
    NoDinamico atual = primeiro;
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
