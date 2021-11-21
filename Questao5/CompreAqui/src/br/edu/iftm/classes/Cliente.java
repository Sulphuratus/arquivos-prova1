package br.edu.iftm.classes;

public class Cliente {
    private static int totalDeClientes;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Cliente cliente;
    

    public Cliente (){
        Cliente.totalDeClientes = Cliente.totalDeClientes + 1;
    }

    public Cliente (Cliente cliente){
        this();
        this.cliente = cliente;
    }

    public Cliente (int numero, Cliente cliente){
        this(cliente);
    }

    public Cliente (String nome, String cpf, String email, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente (String nome, Cliente cliente){
        this.nome = nome;
        this.cliente = cliente;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Cliente getCliente (){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public int getTotalDeClientes(){
        return Cliente.totalDeClientes;
    }
    
}
