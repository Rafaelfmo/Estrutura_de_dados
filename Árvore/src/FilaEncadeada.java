public class FilaEncadeada {
  ElementoArvore inicio;

  public FilaEncadeada() {
    this.inicio = null;
  }

  public boolean fila_estaVazia() {
    if (this.inicio == null) {
      return true;
    } else {
      return false;
    }
  }

  public NoAB verInicio() {
    return inicio.elemento_arvore;
  }

  public void enfileirar(NoAB elemento) {
    ElementoArvore novo_elemento = new ElementoArvore(elemento);
    if (fila_estaVazia()) {
      this.inicio = novo_elemento;
    } else {
      ElementoArvore aux = this.inicio;
      while (aux.proximo_no != null) {
        aux = aux.proximo_no;
      }
      aux.proximo_no = novo_elemento;
    }
  }

  public ElementoArvore desenfileirar() {
    ElementoArvore removerNo = null;
    if (fila_estaVazia()) {
      return null;
    } else {
      removerNo = this.inicio;
      this.inicio = this.inicio.proximo_no;
      return removerNo;
    }
  }
}
