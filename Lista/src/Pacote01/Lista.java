package Pacote01;
public class Lista {
  private int quantidade;
  private int [] elementos;

  public Lista(){
    quantidade = 0;
    elementos = new int[5];
  }

  public Lista(int limite){
    quantidade = 0;
    elementos = new int[limite];
  }

  public int getQuantidade(){
    return quantidade;
  }

  public boolean estaVazia(){
    if(quantidade == 0){
      System.out.println("Está vazia!");
      return true;
    }
    else
    return false;
  }

  public boolean estaCheia(){
    if(quantidade == elementos.length){
      System.out.println("Está cheia!");
      return true;
    } else
    return false;
  }

  public void retornarElemento(int posicao){
    for(int i = quantidade; i <= posicao; i--){
      elementos[i] = elementos[i-1];
    }
    System.out.println("Elemento retornado foi: " + elementos[posicao]);
  }

  public void adicionarPosicao(int valor, int posicao){
    for (int i = quantidade; i >= posicao; i--){
      elementos[i+1] = elementos[i];
    }
    elementos[posicao-1] = valor;
    quantidade += 1;
    System.out.println("Elemento " + valor + " Adicionado na posicao " + posicao);
  }

  public void adicionarInicio(int valor){
    for (int i = quantidade; i >= 0; i--){
      elementos[i+1] = elementos[i];
    }
    elementos[0] = valor;
    quantidade += 1;
    System.out.println("Elemento " + valor + " Adicionado no inicio da lista");
  }

  public void adicionarFinal(int valor){
    for (int i = quantidade; i >= 0; i--){
      elementos[i+1] = elementos[i];
    }
    elementos[quantidade] = valor;
    quantidade += 1;
    System.out.println("Elemento " + valor + " Adicionado no final");
  }

  public void removerPosicao(int posicao){
   int elementoRemovido = elementos[posicao-1];
   for(int i = posicao-1; i < quantidade; i++){
    elementos[i] = elementos[i+1];
   }
   quantidade -= 1;
   System.out.println("Elemento removido foi: " + elementoRemovido);
  }

  public void removerInicio(int posicao){
    int elementoRemovido = elementos[0];
    for (int i = 0; i < quantidade-1; i++){
      elementos[i] = elementos[i+1];
    }
    quantidade -= 1;
    System.out.println("Elemento inicial removido: " + elementoRemovido);
  }
  
  public void removerFinal(int posicao){
    quantidade -= 1;
    int elementoRemovido = elementos[quantidade];
    System.out.println("Elemento final removido: " + elementoRemovido);
  }
}