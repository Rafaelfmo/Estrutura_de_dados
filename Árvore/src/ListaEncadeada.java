public class ListaEncadeada {
  ElementoArvore inicio;

  public ListaEncadeada() {
    this.inicio = null;
  }

  public boolean lista_estaVazia() {
    if (this.inicio == null) {
      return true;
    } else {
      return false;
    }
  }

  public void inserirInicio(NoAB elemento) {
    ElementoArvore novo_elemento = new ElementoArvore(elemento);
    if (lista_estaVazia()) {
      this.inicio = novo_elemento;
    } else {
      novo_elemento.proximo_no = this.inicio;
      this.inicio = novo_elemento;
    }
  }

  public void inserirFim(NoAB elemento) {
    ElementoArvore novo_elemento = new ElementoArvore(elemento);
    if (lista_estaVazia()) {
      this.inicio = novo_elemento;
    } else {
      ElementoArvore aux = this.inicio;
      while (aux.proximo_no != null) {
        aux = aux.proximo_no;
      }
      aux.proximo_no = novo_elemento;
    }
  }

  public Boolean buscarElemento(NoAB elemento) {
    ElementoArvore aux = this.inicio;
    while (aux != null) {
      if (aux.elemento_arvore == elemento) {
        return true;
      }
      aux = aux.proximo_no;
    }
    return false;
  }

  public void verLista(){
    if (lista_estaVazia()) {
      System.out.println("Lista Vazia");
  } else {
      ElementoArvore Auxiliar = inicio;
      System.out.print("[");
      while (Auxiliar.proximo_no != null) {
          System.out.print(Auxiliar.elemento_arvore.elemento_armazenado + ", ");
          Auxiliar = Auxiliar.proximo_no;
      }
      System.out.println(Auxiliar.elemento_arvore.elemento_armazenado + "]");
  }
  }
}
