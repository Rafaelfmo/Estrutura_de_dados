import javax.swing.JOptionPane;

public class TrabPilha {
  private int quantidade;
  private int [] elementos;

  public TrabPilha(int tamanho) {
    quantidade = 0;
    elementos = new int[tamanho];
  }

  //Método para verificar a quantidade de elementos na pilha
  public int getQuantidade(){
    return quantidade;
  }

  //Método para verificar se a pilha está vazia
  public boolean estaVazia(){
    if (quantidade == 0){
      return true;
    } else return false;
  }

  //Método para verificar se a pilha está cheia
  public boolean estaCheia(){
    if (quantidade == elementos.length){
      return true;
    } else return false;
  }

  //Método para retornar um elemento na posição desejada
  public int retornarElemento(){
    if (estaVazia()){
      return ' ';
    } else {
      return elementos[quantidade-1];
    }
  } 

  //Método para acessar elementos da pilha
  public int acessarElemento(int posicao){
    if (estaVazia()){
      System.out.println("Pilha vazia");
      return -1;
    } else {
      return elementos[posicao];
    }
  }

  //Método para inserir um elemento no topo da pilha
  public void empilhar(int elemento){
    if (estaCheia()){
      System.out.println("A pilha está cheia!");
    } else {
      elementos[quantidade] = elemento;
      quantidade++;
    }
  }

  //Método para desempilhar um elemento do topo da pilha
  public void desempilhar(){
    if (estaVazia()){
      System.out.println("A pilha está vazia!");
    } else {
      quantidade--;
    }
  }

  //Método para inverter a pilha
  public void inverter(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    TrabPilha pilhaAux2 = new TrabPilha(getQuantidade());
    while (!pilha.estaVazia()){
      pilhaAux1.empilhar(pilha.retornarElemento());
      pilha.desempilhar();
    }
    while (!pilhaAux1.estaVazia()){
      pilhaAux2.empilhar(pilhaAux1.retornarElemento());
      pilhaAux1.desempilhar();
    }
    while (!pilhaAux2.estaVazia()){
      pilha.empilhar(pilhaAux2.retornarElemento());
      pilhaAux2.desempilhar();
    }
    exibir();
  }

  //Método para ordenar a pilha do maior para o menor
  public void ordenar(TrabPilha pilha){
    TrabPilha pilhaAux = new TrabPilha(getQuantidade());
    while (!pilha.estaVazia()){
      int elemento = pilha.retornarElemento();
      pilha.desempilhar();
      while (!pilhaAux.estaVazia() && elemento > pilhaAux.retornarElemento()){
        pilha.empilhar(pilhaAux.retornarElemento());
        pilhaAux.desempilhar();
      }
      pilhaAux.empilhar(elemento);
    }
    while (!pilhaAux.estaVazia()){
      pilha.empilhar(pilhaAux.retornarElemento());
      pilhaAux.desempilhar();
    }
    exibir();
  }

  //Método para verificar se a palavra é palíndromo
  public void palindromo(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    pilhaAux1 = pilha;
    pilhaAux1.inverter(pilha);
    if (pilha.retornarElemento() != pilhaAux1.retornarElemento()){
      System.out.println("A palavra não é palíndromo!");
    } else {
      System.out.println("A palavra é palíndromo!");
    }
  }

  //Método para verificar int
  public boolean expressao(TrabPilha pilha){
    for (int i = 0; i < getQuantidade(); i++){
      switch (pilha.acessarElemento(i)){
        case '(':
          System.out.println("Não é expressão");
          break;
        case ')':
          System.out.println("Não é expressão");
          break;
        case '[':
          System.out.println("Não é expressão");
          break;
        case ']':
          System.out.println("Não é expressão");
          break;
        case '{':
          System.out.println("Não é expressão");
          break;
        case '}':
          System.out.println("Não é expressão");
          break;
      }
    }
    return true;
  }

  //Método para eliminar maior elemento da pilha
  public void removerMaior(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    TrabPilha pilhaAux2 = new TrabPilha(getQuantidade());
    exibir();
  }

  //Método para remover o menor elemento da pilha
  public void removerMenor(TrabPilha pilha){
    TrabPilha pilhaAux = new TrabPilha(getQuantidade());
    while (!pilha.estaVazia()){
      int elemento = pilha.retornarElemento();
      pilha.desempilhar();
      while (!pilhaAux.estaVazia() && elemento < pilhaAux.retornarElemento()){
        pilha.empilhar(pilhaAux.retornarElemento());
        pilhaAux.desempilhar();
      }
      pilhaAux.empilhar(elemento);
    }
    while (!pilhaAux.estaVazia()){
      pilha.empilhar(pilhaAux.retornarElemento());
      pilhaAux.desempilhar();
    }
    exibir();
  }

  //Método para imprimir todos os elementos da pilha
  public void exibir(){
    String elementos = this.elementos[0] + ", ";
    for (int i = 1; i < this.quantidade; i++){
      elementos += this.elementos[i];
      if (i != this.quantidade-1){
        elementos += ", ";
      }
    }
    JOptionPane.showMessageDialog(null, elementos);
  }
}