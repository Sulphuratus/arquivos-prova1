package br.edu.iftm.classes;

import javax.swing.JOptionPane;

public class Carrinho {

    private int indice, indicep, indicec;
    private Cliente[] vetorPessoas;
    private Produto[] vetorItens;
    private Produto[] vetorCompras;
    private Cliente cliente;
    private Produto produto;

    public Carrinho(){
        vetorPessoas = new Cliente[10];
        vetorItens = new Produto[10];
        vetorCompras = new Produto[10];
    }
   
    public Carrinho (Cliente cliente){
        this.cliente = cliente;
    }

    public Carrinho(Produto produto){
        this.produto = produto;
    }

    public Carrinho (Cliente cliente, Produto produto){
        this.cliente = cliente;
        this.produto = produto;        
    }

    public Carrinho(Cliente cliente, Produto[] vetorItens) {
        this.cliente = cliente;
        this.vetorItens = vetorItens;
    }
  
    private String inputDados(String msg){
        String temp = JOptionPane.showInputDialog(null, msg);
        while (temp.equals("")){
            JOptionPane.showMessageDialog(null, "Dado recusado: em branco!");
            temp = JOptionPane.showInputDialog(null, msg);
      }
        return temp;
    }

    private Cliente cadastroCliente(){
        String nome = inputDados("Digite o nome do Cliente: ");
        String cpf = inputDados("Digite o CPF do Cliente: ");
        String email = inputDados("Digite o email do Cliente: ");
        String endereco = inputDados( "Digite o endereço do Cliente: ");
        Cliente cl = new Cliente(nome, cpf, email, endereco);
        Cliente contado = new Cliente(cl);
        
        // (***) Parte do método para contar Cliente
        this.vetorPessoas[indice] = cl;// Erro estava aparecendo por atribuir o objeto 
        // 'conta' ao 'vetorPessoas', deve permanecer com o objeto 'cl'.
        indice ++;
        JOptionPane.showMessageDialog(null,"Numero de clientes: "+ contado.getTotalDeClientes(),
        "**Contagem do cadastro**", JOptionPane.INFORMATION_MESSAGE);
        // (***) Parte do método contarCliente

        return cl;
    }

    private Produto cadastroProduto(){
        String nome = inputDados("Digite o nome do Produto");
        String temp = inputDados("Digite o preco do Produto");
        float preco = Float.parseFloat(temp);
        temp = inputDados("Digite a quantidade desejada");
        int quantidade = Integer.parseInt(temp);
        Produto p = new Produto(nome, preco, quantidade);
        this.vetorItens[indicep] = p;
        indicep ++;
        return p;
    }

    public Cliente buscarCliente(String nome){
        for(Cliente pessoa : vetorPessoas){
            if (pessoa == null){
                JOptionPane.showMessageDialog(null,"Cliente Inexistente!","Operação Inválida",
                JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

            if(pessoa.getNome().equals(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public Produto buscarProduto(String nome){
        for (Produto item : vetorItens){
            if (item == null){
                JOptionPane.showMessageDialog(null,"Produto Inexistente!","Operação Inválida",
                JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
            if (item.getNome().equals(nome)){
                return item;
            }
        }
        return null;
    }

    public Produto excluirProduto(String nome){
        int ind = indicec;
        for (int i=0; i < ind; i++){
            if (vetorCompras[i] == null){
                JOptionPane.showMessageDialog(null,"Produto Inexistente!","Operação Inválida",
                JOptionPane.INFORMATION_MESSAGE);
            }
            if (vetorCompras[i].getNome().equals(nome)){
                JOptionPane.showMessageDialog(null,"Produto buscado: "+vetorCompras[i].getNome(),"Excluir",
                JOptionPane.INFORMATION_MESSAGE);
                vetorCompras[i] = null;
                indicec--;
                JOptionPane.showMessageDialog(null,"Produto Excluido!","Operação realizada",
                JOptionPane.INFORMATION_MESSAGE);
                }
        }
        return null;
    }

    public int selecionarFuncao(){
        System.out.println("Menu:");
        System.out.println("1 - Cadastro de CLiente ");
        System.out.println("2 - Cadastro de Produto ");
        System.out.println("3 - Buscar Cliente ");
        System.out.println("4 - Adicionar Produto no Carrinho ");
        System.out.println("5 - Excluir Produto ");
        System.out.println("6 - Nota Fiscal");
        System.out.println("0 - Sair");
        String temp = inputDados("Qual opção deseja escolher? ");
         if( temp.equals(" ")){
            JOptionPane.showMessageDialog(null,"Opção Inválida! Tente novamente!","AVISO!",
            JOptionPane.INFORMATION_MESSAGE);
        }
        int opcao = Integer.parseInt(temp);

        if (opcao == 1){
            cadastroCliente();
            
        }else if(opcao == 2){
            cadastroProduto();
            
        }else if(opcao == 3){
            String nome = inputDados("Digite o nome do cliente: ");
            Cliente cl = buscarCliente(nome);
            JOptionPane.showMessageDialog(null,"Cliente encontrado: " + cl.getNome() + " - CPF:" 
             + cl.getCpf(),"Busca de Cliente", JOptionPane.INFORMATION_MESSAGE);
                        
        }else if (opcao == 4){
            String nome = inputDados("Digite o nome do cliente: ");
            Cliente cl = buscarCliente(nome);

                if( cl != null){
                    String nomeProduto = inputDados("Informe o nome do produto a adicionar:");
                    Produto prod = buscarProduto(nomeProduto);
        
                    Carrinho cart = new Carrinho(cl, prod); 
                    this.vetorCompras[indicec] = prod;
           
                    JOptionPane.showMessageDialog(null,"Produto: " + cart.getProduto().getNome() +
                    " do cliente: " + cart.getCliente().getNome()+ " foi adicionado.","Carrinho", 
                    JOptionPane.INFORMATION_MESSAGE);
        
                    indicec ++;
                }

        }else if (opcao == 5){
            String nomeProduto = inputDados("Informe o nome do produto que deseja excluir:");
            excluirProduto(nomeProduto);
                         
        }else if (opcao == 6){
            float totalCarrinho = 0;
            String nome = inputDados("Digite o nome do cliente para imprimir a NF: ");
            Cliente cl = buscarCliente(nome);
            Produto[] item = vetorCompras;
            Carrinho car = new Carrinho(cl, item);

            System.out.println("========================      NOTA FISCAL    ============================");
            System.out.println("Cliente: " + car.getCliente().getNome()+"  CPF: " + car.getCliente().getCpf());
            System.out.println("=========================================================================");
            System.out.println("                                                                         ");

            for (int i=0; i < indicec; i++){
                System.out.println("Produto: " + vetorCompras[i].getNome() + " - Preço unitário: R$" 
                + vetorCompras[i].getPreco() + " - Quantidade: " + vetorCompras[i].getQuantidade());
                
                System.out.println(" == > > Total por produto: R$ " + vetorCompras[i].getQuantidade() 
                * vetorCompras[i].getPreco());
                System.out.println("--------------------------------------------------------------------");

                totalCarrinho += (vetorCompras[i].getQuantidade() * vetorCompras[i].getPreco());

            }
            System.out.println("                                 == > >   Total do Carrinho: " 
            + totalCarrinho);
            System.out.println("                                                                      ");
            System.out.println("=====================================================================:");
            System.out.println();
        }
        return opcao;
    }
    public void iniciar() {
        int opcao = 0;
        do { 
            opcao = selecionarFuncao();
        } while (opcao != 0);
    }
 
    public Cliente[] getVetorPessoas(){
        return this.vetorPessoas;
    }

    public Produto[] getVetorItens(){
        return this.vetorItens;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public int getIndice() {
        return this.indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    public void setVetorPessoas(Cliente[] vetorPessoas) {
        this.vetorPessoas = vetorPessoas;
    }
    public void setVetorItens(Produto[] vetorItens) {
        this.vetorItens = vetorItens;
    }

    public Produto[] getVetorCompras() {
        return this.vetorCompras;
    }

    public void setVetorCompras(Produto[] vetorCompras) {
        this.vetorCompras = vetorCompras;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}


