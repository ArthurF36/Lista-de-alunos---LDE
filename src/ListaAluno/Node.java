// Classe Node
package ListaAluno;
public class Node {
    private Alunos info;
    private Node prox;

    public Node (Alunos aln) {
        this.info = aln;
    }

    public Alunos getInfo() {
        return this.info;
    }

    public Node getProx() {
        return this.prox;
    }

    public void setInfo(Alunos outrAln) {
        this.info = outrAln;
    }

    public void setProx(Node outrProx) {
        this.prox = outrProx;
    }
}