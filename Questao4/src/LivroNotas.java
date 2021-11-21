
import javax.swing.JOptionPane;

public class LivroNotas {
    
    private String nomeCurso;

    public LivroNotas(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }

    public void mostraMensagem(){
        LivroNotas l = new LivroNotas(nomeCurso);
        JOptionPane.showMessageDialog(null, "Curso: " + l.getNomeCurso(), 
        "Bem-vindo ao Curso!", JOptionPane.INFORMATION_MESSAGE);

    }

    public void calculaMediaClasse(){
        float soma = 0;
        float media;
        for (int cont = 0; cont < 10; cont++){
            String temp = JOptionPane.showInputDialog(null, "Digite a nota " 
            + (cont+1) + " (Valores de 0 a 100)", "Entrada de dados", 
            JOptionPane.INFORMATION_MESSAGE);
            float nota = Float.parseFloat(temp);
            if (nota > 0 && nota <= 100){
                soma += nota;
                
            }else{
                JOptionPane.showMessageDialog(null, "Tente novamente", 
                "Nota inválida!", JOptionPane.INFORMATION_MESSAGE);
                cont -= 1;
            }
        }
        media = soma / 10;
        JOptionPane.showMessageDialog(null, "A média das notas é: " + 
        String.format("%.1f", media), "Média Calculada", JOptionPane.INFORMATION_MESSAGE);
    }

    public char calculaConceito(float nota){
        char conceito = ' ';
        if (nota >= 0 && nota < 20){
            conceito  = 'F';
        }else if(nota >= 20 && nota < 40){
            conceito = 'E';
        }else if(nota >= 40 && nota < 60){
            conceito = 'D';
        }else if(nota >= 60 && nota < 80){
            conceito = 'C';
        }else if(nota >= 80 && nota < 95){
            conceito = 'B';
        }else if(nota >= 95 && nota <= 100){
            conceito = 'A';
        }
        return conceito;
    }


    public String getNomeCurso() {
        return this.nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

}
