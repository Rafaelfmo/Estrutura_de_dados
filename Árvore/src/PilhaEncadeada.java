
public class PilhaEncadeada {
  ElementoArvore topo;

  public PilhaEncadeada() {
    this.topo = null;
  }

  public boolean pilha_estaVazia() {
    if (this.topo == null) {
      return true;
    } else {
      return false;
    }
  }

  public NoAB verTopo() {
    return topo.elemento_arvore;
  }

  public void empilhar(NoAB dados) {
    ElementoArvore novoNo = new ElementoArvore(dados);
    if (pilha_estaVazia()) {
      this.topo = novoNo;
    } else {
      novoNo.proximo_no = this.topo;
      this.topo = novoNo;
    }
  }

  public ElementoArvore desempilhar() {
    ElementoArvore removerNo = null;
    if (pilha_estaVazia()) {
      return null;
    } else {
      removerNo = this.topo;
      this.topo = this.topo.proximo_no;
      return removerNo;
    }
  }

  public void verPilhaInvertendoPilha(PilhaEncadeada pilha) {
    if (pilha_estaVazia()){
      System.out.println("Pilha vazia");
    }
    else {
      PilhaEncadeada pilhaAux = new PilhaEncadeada();
      while (topo != null) {
        System.out.println(verTopo());
        pilhaAux.empilhar(verTopo());
        desempilhar();
      }
      while (pilhaAux.topo != null) {
        empilhar(pilhaAux.verTopo());
        pilhaAux.desempilhar();
      }
    }
  }

  public void Ver_Pilha() {
    if (pilha_estaVazia()) {
        System.out.println("Pilha Vazia");
    } else {
        ElementoArvore Auxiliar = topo;
        System.out.print("[");
        while (Auxiliar.proximo_no != null) {
            System.out.println(Auxiliar.elemento_arvore);
            Auxiliar = Auxiliar.proximo_no;
        }
        System.out.println(Auxiliar.elemento_arvore + "]\n");
    }
  }
}
 

