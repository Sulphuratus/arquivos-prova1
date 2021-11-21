package br.edu.iftm.classes;

public class Produto {

    //private static float totalCompras;
    private String nome;
    private float preco;
    private int quantidade;
    private Produto produto;

    //public Produto (){
    //    Produto.totalCompras = Produto.totalCompras + this.preco;
    //}

    //public Produto (Produto produto){
    //    this();
    //    this.produto = produto;
    //}
    
    public Produto(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return this.produto;
    }

    //public float getTotalCompras(){
    //    return this.getTotalCompras();
   // }

    //public void setTotalCompras(float retira) {
    //}


    
}
