import javax.swing.JOptionPane;

public class ClasseTeste {
    public static void main(String[] args) throws Exception {
        
        LivroNotas livro = new LivroNotas("Programação Orientada a Objetos");

        livro.mostraMensagem();

        livro.calculaMediaClasse();

        JOptionPane.showMessageDialog(null, "Nota atingiu conceito "+ 
        livro.calculaConceito(95)+" ", "Conceito", JOptionPane.INFORMATION_MESSAGE);


    }
}
