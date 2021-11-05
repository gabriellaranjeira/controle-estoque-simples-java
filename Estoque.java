package br.estoque;

import br.estoque.Produto;
import java.util.Arrays;
import java.io.*;

public class Estoque{
    Produto[] produtos = new Produto[1000];
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Estoque(){
        Arrays.fill(produtos, null);
    }

    public void addProduto() throws IOException{
        System.out.print("Digite o nome do produto: ");
        String nome = reader.readLine();

        System.out.print("Digite o valor do produto: ");
        float valor = Float.parseFloat(reader.readLine());

        System.out.print("Digite a qtde em estoque do produto: ");
        int estoque = Integer.parseInt( reader.readLine() );

        Produto p = new Produto(nome, valor, estoque);


        for(int i = 0; i < produtos.length;i++){
            if(produtos[i] == null){
                produtos[i] = p; 
                break;
            }
        }

        System.out.println("[!] Produto Adicionado com sucesso!");
    }

    public void rmProduto(int index){
        produtos[index] = null;
    }

    public void rmEstoque(int cod) throws IOException{
        if(produtos[cod] != null){
            System.out.print("Digite o valor a ser removido do estoque: ");
            int v = Integer.parseInt(reader.readLine());
            if((produtos[cod].getEstoque() - v) < 0){
                System.out.println("[!] Valor invalido, produto irá ficar com estoque negativo!");
            }else{
                produtos[cod].removeProduto(v);
                System.out.println("[!] Produto Removido do estoque com sucesso");
            }
        }else{
            System.out.println("[!] Produto invalido");
        }
    }

    public void addEstoque(int cod) throws IOException{
        if(produtos[cod] != null){
            System.out.print("Digite o valor a ser adicionado do estoque: ");
            int v = Integer.parseInt(reader.readLine());
            produtos[cod].addProduto(v);
            System.out.println("[!] Produto Adicionado ao estoque com sucesso");
        }else{
            System.out.println("[!] Produto invalido");
        }
    }

    public void imprimeDados(){
        for(int i = 0; i < produtos.length;i++){
            if(produtos[i] != null){
                produtos[i].imprimeDados(i);
            }
        }
    }

    public void Menu() throws IOException{
        System.out.println("====================================" + "\n" +
        "1. Listar produtos" + "\n" +
        "2. Adicionar produto" + "\n" +
        "3. Remover produto" + "\n" +
        "4. Editar produto" + "\n" +
        "5. Adicionar estoque" + "\n" +
        "6. Remover estoque" + "\n");

        System.out.print("Digite o comando: ");
        String cmd = reader.readLine();

        if(cmd.equals("1")){
            this.imprimeDados();
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else if(cmd.equals("2")){
            this.addProduto();
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else if(cmd.equals("3")){
            System.out.print("Digite o codigo do produto: ");
            int cod = Integer.parseInt(reader.readLine());
            this.removeProduto(cod);
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else if(cmd.equals("4")){
            System.out.print("Digite o codigo do produto: ");
            int cod = Integer.parseInt(reader.readLine());
            this.alteraProduto(cod);
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else if(cmd.equals("5")){
            System.out.print("Digite o codigo do produto: ");
            int cod = Integer.parseInt(reader.readLine());
            this.rmEstoque(cod);
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else if(cmd == "6"){
            System.out.print("Digite o codigo do produto: ");
            int cod = Integer.parseInt(reader.readLine());
            this.addEstoque(cod);
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }else{
            System.out.println("Comando invalido!");
            System.out.print("Pressione enter para continuar...");
            reader.readLine();
            this.Menu();
        }
    }


    public void alteraProduto(int i) throws IOException{
        if(produtos[i] != null){
            System.out.print("["+produtos[i].getNome()+"] Digite o nome do produto: (Deixe vazio para não alterar)");
            String input = reader.readLine();

            input = "";

            System.out.print("["+produtos[i].getValor()+"] Digite o valor do produto: (Deixe vazio para não alterar)");
            input = reader.readLine();

            if(input != ""){ produtos[i].setValor(Float.parseFloat(input)); }

            input = "";

            System.out.print("["+produtos[i].getEstoque()+"] Digite a qtde em estoque do produto: (Deixe vazio para não alterar)");
            input = reader.readLine();

            if(input != ""){ produtos[i].setEstoque(Integer.parseInt(input)); }

            System.out.println("[!] Produto alterado com sucesso!");
        }else{
            System.out.println("[!] Produto invalido");
        }
    }

    public void removeProduto(int i){
        if(produtos[i] != null){
            this.produtos[i] = null;
        }else{
            System.out.println("[!] Produto invalido");
        }
    }

    public void iniciar() throws IOException{
        this.Menu();
    }

    public static void main(String[] args) throws IOException{
        Estoque estoque = new Estoque();

        estoque.iniciar();
    }
}
