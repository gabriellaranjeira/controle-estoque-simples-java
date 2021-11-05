package br.estoque;
public class Produto{
    float valor;
    String nome;
    int estoque;

    Produto(){}

    Produto(String n, float v, int e){
        this.nome = n;
        this.valor = v;
        this.estoque = e;
    }

    public void imprimeDados(int index){
        System.out.println("Código: " + index + "\n" +
            "Nome: " + this.nome + "\n" +
            "Valor: " + this.valor + "\n" +
            "Estoque: " + this.estoque + "\n" + 
            "====================================" + "\n");
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setValor(float v){
        this.valor = v;
    }

    public void setEstoque(int e){
        this.estoque = e;
    }

    public String getNome(){
        return this.nome;
    }

    public Float getValor(){
        return this.valor;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public void removeProduto(int v){
        this.estoque -= v;
    }

    public void addProduto(int v){
        this.estoque = v;
    }
}
