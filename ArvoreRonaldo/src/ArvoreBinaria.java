public class ArvoreBinaria {

  private NoAB raiz;

  public ArvoreBinaria() {
    this.raiz = null;
  }

  public ArvoreBinaria(NoAB raiz) {
    this.raiz = raiz;
  }

  public boolean estaVazia() {
    if(this.raiz == null) {
      return true;
    } else {
      return false;
    }
  }

  public NoAB buscarElemento(int elemento) {
    return buscarElemento(elemento, this.raiz);
  }
  private NoAB buscarElemento(int elemento, NoAB noAtual) {
    if (estaVazia() || noAtual == null) {
      return null;
    }
    if(elemento == noAtual.getElemento()) {
      return noAtual;
    }
    NoAB aux = buscarElemento(elemento, noAtual.getEsquerda());
    if(aux == null) {
      aux = buscarElemento(elemento, noAtual.getDireita());
    }
    return aux;
  }

  public NoAB buscarPai(int elemento) {
    return buscarPai(elemento, this.raiz);
  }
  private NoAB buscarPai(int filho, NoAB noAtual) {
    if (estaVazia() || noAtual == null) {
      return null;
    }
    if(noAtual.getEsquerda() != null && noAtual.getEsquerda().getElemento() == filho) {
      return noAtual;
    } else if(noAtual.getDireita() != null && noAtual.getDireita().getElemento() == filho) {
      return noAtual;
    }
    NoAB aux = buscarPai(filho, noAtual.getEsquerda());
    if(aux == null) {
      aux = buscarPai(filho, noAtual.getDireita());
    }
    return aux;
  }

  public int nivelElemento(int elemento) {
    NoAB aux = buscarElemento(elemento);
    if(raiz == aux) {
      return 0;
    } else {
      NoAB pai = buscarPai(elemento);
      if(pai != null) {
        return nivelElemento(pai.getElemento()) + 1;
      } else {
        return -1;
      }
    }
  }

  public int alturaArvore() {
    return alturaElemento(raiz);
  }
  private int alturaElemento(NoAB noAtual) {
    if(raiz == null) {
      return 0;
    } else {
      int alturaEsquerda = 0;
      int alturaDireita = 0;
      if(noAtual.getEsquerda() != null) {
        alturaEsquerda = alturaElemento(noAtual.getEsquerda());
      }
      if(noAtual.getDireita() != null) {
        alturaDireita = alturaElemento(noAtual.getDireita());
      }
      if(alturaEsquerda > alturaDireita) {
        return alturaEsquerda + 1;
      } else {
        return alturaDireita + 1;
      }
    }
  }

  public void adicionarEsquerda(int elemento, int pai) {
    NoAB noPai = buscarElemento(pai);
    noPai.setEsquerda(new NoAB(elemento));
  }

  public void adicionarDireita(int elemento, int pai) {
    NoAB noPai = buscarElemento(pai);
    noPai.setDireita(new NoAB(elemento));
  }

  public NoAB removerElemento(int elemento) {
    NoAB noRemovido = buscarElemento(elemento);
    if(noRemovido != null) {
      NoAB pai = buscarPai(elemento);
      if(pai != null) {
        if(pai.getEsquerda() != null && pai.getEsquerda().getElemento() == elemento) {
          pai.setEsquerda(null);
        } else {
          pai.setDireita(null);
        }
      } else {
        this.raiz = null;
      }
    }
    return noRemovido;
  }
}