// Classe Alunos
package ListaAluno;
public class Alunos {
    private String matrc;
    private String nome;
    private double nota;
    private int falta;

    public Alunos(String matric) {
        this.matrc = matric;
    }

    public String getMatrc() {
        return this.matrc;
    }

    public String getNome() {
        return this.nome;
    }

    public double getNota() {
        return this.nota;
    }

    public int getFalta() {
        return this.falta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    public int compareTo(Alunos outrAln) {
        int comparaAln;
        comparaAln = this.matrc.compareTo(outrAln.matrc);
        return comparaAln;
    }

    public String toString() {
        return "Matrícula: " + this.matrc + ", aluno: " + this.nome + ", nota: " + this.nota + " e falta: " + this.falta + ".";
    }
}