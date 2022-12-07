public class NoAB {
  
  private int elemento;
  private NoAB esquerda;
  private NoAB direita;

  public NoAB() {
    this.elemento = -1;
    this.esquerda = null;
    this.direita = null;
  }

  public NoAB(int elemento) {
    this.elemento = elemento;
    this.esquerda = null;
    this.direita = null;
  }

  public NoAB(int elemento, NoAB esquerda, NoAB direita) {
    this.elemento = elemento;
    this.esquerda = esquerda;
    this.direita = direita;
  }

  public int getElemento() {
    return elemento;
  }

  public void setElemento(int elemento) {
    this.elemento = elemento;
  }

  public NoAB getEsquerda() {
    return esquerda;
  }

  public void setEsquerda(NoAB esquerda) {
    this.esquerda = esquerda;
  }

  public NoAB getDireita() {
    return direita;
  }

  public void setDireita(NoAB direita) {
    this.direita = direita;
  }
}