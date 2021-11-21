import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int vet [] = new int [10];
        int j, cont;
        int vazio = 0;
        
        Scanner leia = new Scanner(System.in);

        System.out.println("Programa que lê um vetor de 10 posições e verifica se existem valores iguais.");
        System.out.println("Digite cada valor do vetor e tecle ENTER: ");

        for (int i = 0; i < 10; i++){
            vet [i] = leia.nextInt();
        }

        for ( int i = 0; i < 10; i++){
            cont = 0;
                        for ( j = i+1; j <= 9; j++){
                if ( vet [j] == vet [i] ){
                    cont ++ ;
                } 
            }

            if ( cont > 0 && cont < 2 ){
                System.out.println("O valor " + vet[i] + " é repetido.");
                vazio ++;
            }
            
            if (i == 9){
                if (vazio == 0){
                    System.out.println("Não existem valores repetidos no vetor.");
                }
            } 
        }
    }
}
