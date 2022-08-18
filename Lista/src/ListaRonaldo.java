

import javax.swing.JOptionPane;

public class ListaRonaldo {
  private int[] elementos;
    private int quantidade;

    //Criar uma nova lista – Lista()
    public ListaRonaldo() {
        elementos = new int[5];
        quantidade = 0;
    }

    public ListaRonaldo(int limite) {
        elementos = new int[limite];
        quantidade = 0;
    }

    //Retornar a quantidade de elementos – getQuantidade()
    public int getQuantidade() {
        return quantidade;
    }

    //Verificar se a lista está vazia – estaVazia()
    public boolean estaVazia() {
        if(quantidade == 0)
            return true;
        else
            return false;
    }

    //Verificar se a lista está cheia, caso possua um limite – estaCheia()
    public boolean estaCheia() {
        if(quantidade == elementos.length)
            return true;
        else
            return false;
    }

    /**
     * Acessar o elemento na posição i – retornarElemento(i)
     * A primeira posição é zero
     * @param posicao
     * @return
     */
    public int retornarElemento(int posicao) {
        if(entradaValida(posicao))
            return elementos[posicao];
        else
            return -1;
    }

    //Checa se a posicao desejada é valida, ou seja, está dentro do vetor de elementos
    private boolean entradaValida(int posicao) {
        if(posicao >= 0 && posicao <= quantidade)
            return true;
        else
            return false;
    }

    //Inserir um elemento e na posição i – adicionarPosicao(e, i)
    public void adicionarPosicao(int elemento, int posicao) {
        if(estaCheia())
            System.out.println("Lista está cheia!");
        else if(entradaValida(posicao)) {
            for(int i = quantidade - 1; i >= posicao; i--)
                elementos[i+1] = elementos[i];
                
            elementos[posicao] = elemento;
            quantidade++;
        }
    }

    //Inserir um elemento e no início – adicionarInicio(e)
    public void adicionarInicio(int elemento) {
        adicionarPosicao(elemento, 0);
    }

    //Inserir um elemento e no final – adicionarFinal(e)
    public void adicionarFinal(int elemento) {
        adicionarPosicao(elemento, quantidade);
    }

    //Remover o elemento e na posição i – removerPosicao(i)
    public void removerPosicao(int posicao) {
        if(estaVazia())
            System.out.println("Lista está vazia!");
        else if(entradaValida(posicao)) {
            
            for(int i = posicao; i < quantidade - 1; i++)
                elementos[i] = elementos[i+1];
            
            quantidade--;
        }
    }

    //Remover o elemento no inicio – removerInicio()
    public void removerInicio() {
        removerPosicao(0);
    }

    //Remover o elemento no final – removerFinal()
    public void removerFinal() {
        removerPosicao(quantidade - 1);
    }

    //Exibir todos os elementos
    public void exibir(){
        String elementos = this.elementos[0] + ", ";
        for (int i = 1; i < quantidade; i++) {
            elementos += this.elementos[i];

            if(i != (quantidade - 1))
                elementos += ", ";
        }

        JOptionPane.showMessageDialog(null, elementos);
    }

    //Retornar o elemento no meio da lista – retornarMeio()
    public void retornarMeio(){
        if (estaVazia()){
            System.out.println("Lista está vazia!");
        } else if (quantidade % 2 == 1){
            JOptionPane.showMessageDialog(null, "O elemento no meio da lista é " + elementos[quantidade / 2]);
        } else {
            System.out.println("Não há elemento central");
        }
    }

    //Trocar o primeiro e último elemento – trocar_PrimeiroUltimo()
    public void trocar_PrimeiroUltimo(){
        if (estaVazia()){
            System.out.println("Lista está vazia!");
        } else {
            int aux = elementos[0];
            elementos[0] = elementos[quantidade - 1];
            elementos[quantidade - 1] = aux;
            exibir();
        }
    }
    
    public int getPosicao(int posicao){
        return elementos[posicao];
    }

    // Inverter a lista – inverter()
    public void inverterLista(){
        if (estaVazia()){
            System.out.println("Lista está vazia!");
        } else {
            int[] aux = new int[quantidade];
            for (int i = 0; i < quantidade; i++) {
                aux[i] = elementos[quantidade - 1 - i];
            }
            elementos = aux;
            exibir();
        }
    }

    // Remover elementos repetidos – removerRepetidos()
    public void removerRepetidos(){
        if (estaVazia()){
            System.out.println("Lista está vazia!");
        } else {
            for (int i = 0; i < quantidade; i++) {
                for (int j = i + 1; j < quantidade; j++) {
                    if (elementos[i] == elementos[j]){
                        removerPosicao(j);
                        j--;
                    } else {
                        System.out.println("Não há elementos repetidos");
                    }
                }
            }
            exibir();
        }
    }

}

