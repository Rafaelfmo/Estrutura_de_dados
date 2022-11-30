
public class ArvoreBinariaComPilha {
  NoAB raiz;

  public ArvoreBinariaComPilha() {
    this.raiz = null;
  }

  public boolean estaVazia() {
    if(this.raiz == null) {
      return true;
    } else {
      return false;
    }
  }

  public NoAB buscarElemento(int elemento){
    if (estaVazia()){
      return null;
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      while (!pilha.pilha_estaVazia()){
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        if(noAux.elemento_armazenado == elemento){
          return noAux;
        }
        if(noAux.direita != null){
          pilha.empilhar(noAux.direita);
        }
        if(noAux.esquerda != null){
          pilha.empilhar(noAux.esquerda);
        }
      }
    }
    return null;
  }

  public NoAB buscarPai(int elemento){
    if(estaVazia()){
      return null;
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      while(!pilha.pilha_estaVazia()){
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        if(noAux.direita != null){
          if(noAux.direita.elemento_armazenado == elemento){
            return noAux;
          }
          pilha.empilhar(noAux.direita);
        }
        if(noAux.esquerda != null){
          if(noAux.esquerda.elemento_armazenado == elemento){
            return noAux;
          }
          pilha.empilhar(noAux.esquerda);
        }
      }
    }
    return null;
  }

  public int nivelElemento(int elemento){
    if(estaVazia()){
      return -1;
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      int nivel = 0;
      while(!pilha.pilha_estaVazia()){
        
        while(pilha.verTopo().elemento_armazenado != elemento){
          NoAB noAux = pilha.desempilhar().elemento_arvore;
          if(noAux.elemento_armazenado == elemento){
            return nivel;
          }
          if(noAux.direita != null){
            pilha.empilhar(noAux.direita);
          }
          if(noAux.esquerda != null){
            pilha.empilhar(noAux.esquerda);
          }
        }
        nivel++;
      }
    }
    return -1;
  }

  public int alturaArvore(){
    if(estaVazia()){
      return -1;
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      int altura = 1;
      while(!pilha.pilha_estaVazia()){
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        if(noAux.direita != null){
          pilha.empilhar(noAux.direita);
        }
        if(noAux.esquerda != null){
          pilha.empilhar(noAux.esquerda);
        }
        altura++;
      }
      return altura;
    }
  }

  public void adicionarEsquerda(int elemento, int pai) {
    NoAB novoNo = new NoAB(elemento);
    if (!estaVazia()){
      NoAB noPai = buscarElemento(pai);
      if (noPai != null){
        if(noPai.esquerda == null){
          noPai.esquerda = novoNo;
        }
        else {
          System.out.println("Já existe um elemento a esquerda do nó pai");
        }
      } else {
        System.out.println("Nó pai não encontrado");
      }
    } else {
      raiz = novoNo;
    }
  }

  public void adicionarDireita(int elemento, int pai) {
    NoAB novoNo = new NoAB(elemento);
    if (!estaVazia()){
      NoAB noPai = buscarElemento(pai);
      if (noPai != null){
        if(noPai.direita == null){
          noPai.direita = novoNo;
        }
        else {
          System.out.println("Já existe um elemento a direita do nó pai");
        }
      } else {
        System.out.println("Nó pai não encontrado");
      }
    } else {
      raiz = novoNo;
    }
  }

  public NoAB removerElemento(int elemento){
    if(estaVazia()){
      return null;
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      while(!pilha.pilha_estaVazia()){
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        if(noAux.direita != null){
          if(noAux.direita.elemento_armazenado == elemento){
            noAux.direita = null;
            return noAux;
          }
          pilha.empilhar(noAux.direita);
        }
        if(noAux.esquerda != null){
          if(noAux.esquerda.elemento_armazenado == elemento){
            noAux.esquerda = null;
            return noAux;
          }
          pilha.empilhar(noAux.esquerda);
        }
      }
    }
    return null;
  }

  public void varreduraLargura() {
    ListaEncadeada lista = new ListaEncadeada();
    if (estaVazia()) {
      System.out.println("Arvore vazia");
    } 
    else {
      FilaEncadeada fila = new FilaEncadeada();
      fila.enfileirar(this.raiz);
      while (!fila.fila_estaVazia()) {
        NoAB noAux = fila.desenfileirar().elemento_arvore;
        lista.inserirFim(noAux);
        if (noAux.esquerda != null) {
          fila.enfileirar(noAux.esquerda);
        }
        if (noAux.direita != null) {
          fila.enfileirar(noAux.direita);
        }
      }
    }
    lista.verLista();
  }

  public void varreduraPreOrdem() {
    ListaEncadeada lista = new ListaEncadeada();
    if (estaVazia()) {
      System.out.println("Arvore vazia");
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      while (!pilha.pilha_estaVazia()) {
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        lista.inserirFim(noAux);
        if (noAux.direita != null) {
          pilha.empilhar(noAux.direita);
        }
        if (noAux.esquerda != null) {
          pilha.empilhar(noAux.esquerda);
        }
      }
    } 
    lista.verLista();
  }

  public void varreduraPosOrdem() {
    ListaEncadeada lista = new ListaEncadeada();
    if (estaVazia()) {
      System.out.println("Arvore vazia");
    } 
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      pilha.empilhar(this.raiz);
      while (!pilha.pilha_estaVazia()) {
        NoAB noAux = pilha.desempilhar().elemento_arvore;
        lista.inserirInicio(noAux);
        if (noAux.esquerda != null) {
          pilha.empilhar(noAux.esquerda);
        }
        if (noAux.direita != null) {
          pilha.empilhar(noAux.direita);
        }
      }
    }
    lista.verLista();
  }

  public void varreduraEmOrdem() {
    ListaEncadeada lista = new ListaEncadeada();
    if (estaVazia()) {
      System.out.println("Arvore vazia");
    }
    else {
      PilhaEncadeada pilha = new PilhaEncadeada();
      NoAB noAux = this.raiz;
      while (!pilha.pilha_estaVazia() || noAux != null) {
        if (noAux != null) {
          pilha.empilhar(noAux);
          noAux = noAux.esquerda;
        } 
        else {
          noAux = pilha.desempilhar().elemento_arvore;
          lista.inserirFim(noAux);
          noAux = noAux.direita;
        }
      }
    }
    lista.verLista();
  }

}
