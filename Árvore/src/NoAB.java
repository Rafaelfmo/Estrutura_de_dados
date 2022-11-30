public class NoAB {

  int elemento_armazenado;
  NoAB esquerda;
  NoAB direita;

  public NoAB(int valor) {
    this.elemento_armazenado = valor;
    this.esquerda = null;
    this.direita = null;
  }
}
