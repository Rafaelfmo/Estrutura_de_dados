package src;
public class LSE {
  
  private No primeiro;
  private No ultimo;
  private int quantidade;

  public LSE() {
    this.primeiro = null;
    this.ultimo = null;
    this.quantidade = 0;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public boolean estaVazia(){
    if (this.quantidade == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void retornarElemento(int posicao) {
    if (posicao > this.quantidade) {
      System.out.println("Posição inválida");
    } else {
      No aux = this.primeiro;
      for (int i = 1; i < posicao; i++) {
        aux = aux.getProximo();
      }
      System.out.println(aux.getElemento());
    }
  }

  public void adicionarPosicao(No no, int posicao) {
    if (posicao > this.quantidade) {
      System.out.println("Posição inválida");
    } else {
      No aux = this.primeiro;
      for (int i = 1; i < posicao; i++) {
        aux = aux.getProximo();
      }
      no.setProximo(aux.getProximo());
      aux.setProximo(no);
      this.quantidade++;
    }
  }

  public void adicionarInicio(No no) {
    if (this.estaVazia()) {
      this.primeiro = no;
      this.ultimo = no;
    } else {
      no.setProximo(this.primeiro);
      this.primeiro = no;
    }
    this.quantidade++;
  }

  public void adicionarFinal(No no) {
    if (this.estaVazia()) {
      this.primeiro = no;
      this.ultimo = no;
    } else {
      No aux = this.primeiro;
      while (aux.getProximo() != null) {
        aux = aux.getProximo();
      }
      aux.setProximo(no);
    }
    this.quantidade++;
  }

  public void removerPosicao(int posicao) {
    if (posicao > this.quantidade) {
      System.out.println("Posição inválida");
    } else {
      No aux = this.primeiro;
      for (int i = 1; i < posicao; i++) {
        aux = aux.getProximo();
      }
      aux.setProximo(aux.getProximo().getProximo());
      this.quantidade--;
    }
  }

  public void removerInicio() {
    if (this.estaVazia()) {
      System.out.println("Lista vazia");
    } else {
      this.primeiro = this.primeiro.getProximo();
      this.quantidade--;
    }
  }

  public void removerFinal() {
    if (this.estaVazia()) {
      System.out.println("Lista vazia");
    } else {
      No aux = this.primeiro;
      for (int i = 1; i < this.quantidade; i++) {
        aux = aux.getProximo();
      }
      aux.setProximo(null);
      this.ultimo = aux;
      this.quantidade--;
    }
  }

  public void exibir() {
    if (this.estaVazia()) {
      System.out.println("Lista vazia");
    } else {
      No aux = this.primeiro;
      while (aux != null) {
        System.out.println(aux.getElemento());
        aux = aux.getProximo();
      }
    }
  }
}
