import java.util.Scanner;

public class Matriz {
    int linha;
    int coluna;
    int [][] matriz = new int [5][5];

    public Matriz (int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public void lerMatriz(){
        Scanner leia = new Scanner(System.in);

        for ( linha = 0; linha < matriz.length; linha++){
            for ( coluna = 0; coluna < matriz.length; coluna++){
                System.out.println("Digite o termo M"+linha+coluna+": ");
                matriz[linha][coluna] = leia.nextInt();
            }
        }
    }

    public void mostrarMatriz(){
        for ( linha = 0; linha < matriz.length; linha++){
            for ( coluna = 0; coluna < matriz.length; coluna++){
                if ( matriz[linha][coluna] >= 0 && matriz[linha][coluna] <= 9){
                    System.out.print(matriz [linha][coluna] + "   ");
                }else if ( matriz[linha][coluna] >= 10 && matriz[linha][coluna] <= 99){
                    System.out.print(matriz [linha][coluna] + "  ");
                } else if ( matriz[linha][coluna] >= 100 && matriz[linha][coluna] <= 999){
                    System.out.print(matriz [linha][coluna] + " ");
                }
            }System.out.println();
        }System.out.println();
    }

    public void mostrarDiagonais(){
        for (linha = 0; linha < matriz.length; linha++){
            for ( coluna = 0; coluna < matriz.length; coluna++){
                if ( linha == coluna || (linha + coluna) == (matriz.length - 1)){
                    if ( matriz[linha][coluna] >= 0 && matriz[linha][coluna] <= 9){
                        System.out.print(matriz [linha][coluna] + "   ");
                    }else if ( matriz[linha][coluna] >= 10 && matriz[linha][coluna] <= 99){
                        System.out.print(matriz [linha][coluna] + "  ");
                    } else if ( matriz[linha][coluna] >= 100 && matriz[linha][coluna] <= 999){
                        System.out.print(matriz[linha][coluna] + " ");
                    }
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void mostrarDiferenca(){
        int diagonais = 0;
        int termos = 0;
        int diferenca;

        for (linha = 0; linha < matriz.length; linha++){
            for ( coluna = 0; coluna < matriz.length; coluna++){
                if ( linha == coluna || (linha + coluna) == (matriz.length - 1)){
                    diagonais += matriz[linha][coluna];
                }else{
                    termos += matriz[linha][coluna];
                }
            }
        } 
        diferenca = diagonais - termos;
        if (diferenca < 0){
           diferenca = diferenca * (-1);
        }
        System.out.println("A soma dos termos das diagonais principal e secundária é: "+diagonais);
        System.out.println("A soma dos termos que não estão nas diagonais é: "+termos);
        System.out.println("A diferença entre a soma das diagonais e a soma dos demais termos é : "+diferenca);

    }

}


