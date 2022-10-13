package src;

public class LDECircular{

  private int quantidade;
  private NoDinamico primeiro;
  private NoDinamico ultimo;

  public LDECircular() {
    this.quantidade = 0;
    this.primeiro = null;
    this.ultimo = null;
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

  // Método para atualizar o ultimo
  public void atualizarUltimo() {
    NoDinamico aux = primeiro;
    for (int i = 0; i < quantidade - 1; i++) {
      aux = aux.getProximo();
    }
    ultimo = aux;
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
      ultimo = novoNo;
      primeiro.setProximo(ultimo);
      primeiro.setAnterior(ultimo);
      ultimo.setProximo(primeiro);
      ultimo.setAnterior(primeiro);
    } else if (posicao == 0) {
      novoNo.setProximo(primeiro);
      primeiro.setAnterior(novoNo);
      primeiro = novoNo;
      primeiro.setAnterior(ultimo);
      ultimo.setProximo(primeiro);
    } else {
      NoDinamico aux = retornarElemento(posicao - 1);
      novoNo.setProximo(aux.getProximo());
      novoNo.setAnterior(aux);
      aux.getProximo().setAnterior(novoNo);
      aux.setProximo(novoNo);
    }
    atualizarUltimo();
    quantidade++;
  }

  // Método para adicionar um novo nó no inicio da lista
  public void adicionarInicio(NoDinamico novoNo) {
    adicionarPosicao(novoNo, 0);
  }

  // Método para adicionar um novo nó no final da lista
  public void adicionarFinal(NoDinamico novoNo) {
    adicionarPosicao(novoNo, quantidade);
  }

  // Método para remover um nó na posicao pedida
  public void removerPosicao(int posicao) {
    if (estaVazia() || !verificarEntrada(posicao)) {
      System.out.println("Posição inválida");
    } else if (posicao == 0) {
      primeiro = primeiro.getProximo();
      primeiro.setAnterior(ultimo);
      ultimo.setProximo(primeiro);
    } else {
      NoDinamico aux = retornarElemento(posicao - 1);
      aux.setProximo(aux.getProximo().getProximo());
      aux.getProximo().setAnterior(aux);
    }
    atualizarUltimo();
    quantidade--;
  }

  // Método para remover o primeiro nó da lista
  public void removerInicio() {
    removerPosicao(0);
  }

  // Método para remover o último nó da lista
  public void removerFinal() {
    removerPosicao(quantidade - 1);
  }
 
  // Método para exibir a lista
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