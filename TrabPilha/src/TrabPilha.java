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
  private int acessarElemento(int posicao){
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
    
  }

  //Método para verificar se a palavra é palíndromo
  public void palindromo(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    for (int i = 0; i < getQuantidade(); i++){
      pilhaAux1.elementos[i] = pilha.elementos[i];
      pilhaAux1.quantidade++;
    }
    pilhaAux1.inverter(pilhaAux1);
    while (!pilha.estaVazia()){
      if (pilha.retornarElemento() != pilhaAux1.retornarElemento()){
        System.out.println("Não é palíndromo");
        break;
      } else {
        pilha.desempilhar();
        pilhaAux1.desempilhar();
      }
    }
    if (pilha.estaVazia() && pilhaAux1.estaVazia()){
      System.out.println("É palíndromo");
    }
  }

  //Método para verificar int
  public void expressao(TrabPilha pilha){
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
  }

  //Método para eliminar maior elemento da pilha
  public void removerMaior(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    TrabPilha pilhaAux2 = new TrabPilha(getQuantidade());
    int maior = pilha.retornarElemento();
    for (int i = 0; i < getQuantidade(); i++) {
      pilhaAux1.elementos[i] = pilha.elementos[i];
      pilhaAux1.quantidade++;
    }
    for (int i = 0; i < getQuantidade(); i++) {
      if (maior < pilhaAux1.elementos[i]){
        maior = pilhaAux1.elementos[i];
      }
    }
    for (int i = 0; i < getQuantidade(); i++) {
      if (maior != pilhaAux1.elementos[i]){
        pilhaAux2.empilhar(pilhaAux1.elementos[i]);
      }
    }
    for (int i = 0; i < getQuantidade(); i++) {
      pilha.elementos[i] = pilhaAux2.elementos[i];
      pilha.quantidade = pilhaAux2.quantidade;
    }
  }

  //Método para remover o menor elemento da pilha
  public void removerMenor(TrabPilha pilha){
    TrabPilha pilhaAux1 = new TrabPilha(getQuantidade());
    TrabPilha pilhaAux2 = new TrabPilha(getQuantidade());
    int menor = pilha.retornarElemento();
    for (int i = 0; i < getQuantidade(); i++) {
      pilhaAux1.elementos[i] = pilha.elementos[i];
      pilhaAux1.quantidade++;
    }
    for (int i = 0; i < getQuantidade(); i++) {
      if (menor > pilhaAux1.elementos[i]){
        menor = pilhaAux1.elementos[i];
      }
    }
    for (int i = 0; i < getQuantidade(); i++) {
      if (menor != pilhaAux1.elementos[i]){
        pilhaAux2.empilhar(pilhaAux1.elementos[i]);
      }
    }
    for (int i = 0; i < getQuantidade(); i++) {
      pilha.elementos[i] = pilhaAux2.elementos[i];
      pilha.quantidade = pilhaAux2.quantidade;
    }
  }  
  //Método para remover o maior e o menor elemento da pilha
  public void removerMaiorEMenor(TrabPilha pilha){
    pilha.removerMaior(pilha);
    pilha.removerMenor(pilha);
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