public class BST {

  private NoAB raiz;

  public BST() {
    this.raiz = null;
  }

  public BST(NoAB raiz) {
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
    return buscarElemento(elemento, raiz);
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
    return buscarPai(elemento, raiz);
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
    }
    NoAB pai = buscarPai(elemento);
    if(pai != null) {
      return 1 + nivelElemento(pai.getElemento());
    } else {
      return -1;
    }
  }

  public int alturaArvore() {
    return alturaElemento(raiz);
  }
  private int alturaElemento(NoAB noAtual) {
    if(noAtual == null) {
      return 0;
    }
    int alturaEsquerda = 0;
    int alturaDireita = 0;
    if(noAtual.getEsquerda() != null) {
      alturaEsquerda = 1 + alturaElemento(noAtual.getEsquerda());
    }
    if(noAtual.getDireita() != null) {
      alturaDireita = 1 + alturaElemento(noAtual.getDireita());
    }
    if(alturaEsquerda > alturaDireita) {
      return alturaEsquerda;
    } else {
      return alturaDireita;
    }
  }

  // Não se usa o método abaixo, mas é uma forma de adicionar um elemento à esquerda
  public void adicionarEsquerda(int elemento, int pai){
    NoAB noPai = buscarElemento(pai);
    noPai.setEsquerda(new NoAB(elemento));
  }
  // Não se usa o método abaixo, mas é uma forma de adicionar um elemento à direita
  public void adicionarDireita(int elemento, int pai){
    NoAB noPai = buscarElemento(pai);
    noPai.setDireita(new NoAB(elemento));
  }

  // Método para adicionar elementos numa BST
  public void adicionar(int elemento) {
    if(estaVazia()) {
      raiz = new NoAB(elemento);
    } else {
      adicionar(elemento, raiz);
    }
  }
  private void adicionar(int elemento, NoAB noAtual) {
    if(elemento < noAtual.getElemento()) {
      if(noAtual.getEsquerda() == null) {
        noAtual.setEsquerda(new NoAB(elemento));
      } else {
        adicionar(elemento, noAtual.getEsquerda());
      }
    } else {
      if(noAtual.getDireita() == null) {
        noAtual.setDireita(new NoAB(elemento));
      } else {
        adicionar(elemento, noAtual.getDireita());
      }
    }
  }

  public NoAB removerElemento(int elemento) {
    NoAB noRemovido = buscarElemento(elemento);
    if(noRemovido != null) {
      if(noRemovido.getEsquerda() == null && noRemovido.getDireita() == null) {
        if(noRemovido == raiz) {
          raiz = null;
        } else {
          NoAB pai = buscarPai(elemento);
          if(pai.getEsquerda() == noRemovido) {
            pai.setEsquerda(null);
          } else {
            pai.setDireita(null);
          }
        }
      } else if(noRemovido.getEsquerda() == null) {
        if(noRemovido == raiz) {
          raiz = noRemovido.getDireita();
        } else {
          NoAB pai = buscarPai(elemento);
          if(pai.getEsquerda() == noRemovido) {
            pai.setEsquerda(noRemovido.getDireita());
          } else {
            pai.setDireita(noRemovido.getDireita());
          }
        }
      } else if(noRemovido.getDireita() == null) {
        if(noRemovido == raiz) {
          raiz = noRemovido.getEsquerda();
        } else {
          NoAB pai = buscarPai(elemento);
          if(pai.getEsquerda() == noRemovido) {
            pai.setEsquerda(noRemovido.getEsquerda());
          } else {
            pai.setDireita(noRemovido.getEsquerda());
          }
        }
      } else {
        NoAB maiorEsquerda = noRemovido.getEsquerda();
        while(maiorEsquerda.getDireita() != null) {
          maiorEsquerda = maiorEsquerda.getDireita();
        }
        int aux = maiorEsquerda.getElemento();
        removerElemento(maiorEsquerda.getElemento());
        noRemovido.setElemento(aux);
      }
    }
    return noRemovido;
  }
}
