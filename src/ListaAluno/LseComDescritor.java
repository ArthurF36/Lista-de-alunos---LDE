// Classe Lse com descritor
package ListaAluno;
import java.util.Scanner;
public class LseComDescritor {
    Scanner in = new Scanner (System.in);
    Scanner entrada = new Scanner (System.in);
    private Node primer;
    private Node ultm;
    private int qtd;
    Node aux;
    String nome;
    double nota;
    int falta;

    public void InserInc(Alunos aln) {
        Node nvAln = new Node(aln);
        if (this.isEmpity()) {
            this.primer = nvAln;
            this.ultm = nvAln;
            this.qtd++;
            informAlun(aln);
        }
        else {
            aux = buscaAln (aln);
            if (aux == null) {
                nvAln.setProx(this.primer);
                this.primer = nvAln;
                this.qtd++;
                informAlun(aln);
            }
            else {
                System.out.println("Aluno cadastrado anteriomente. Inserção não efetuada.");
            }
        }
    }

    public void InserFnl(Alunos aln) {
        Node nvAln = new Node(aln);
        if (this.isEmpity()) {
            this.primer = nvAln;
            this.ultm = nvAln;
            this.qtd++;
            informAlun(aln);
        }
        else {
            aux = buscaAln(aln);
            if (aux == null) {
                this.ultm.setProx(nvAln);
                this.ultm = nvAln;
                this.qtd++;
                informAlun(aln);
            }
            else {
                System.out.println("Aluno cadastrado anteriomente. Inserção não efetuada.");
            }
        }
    }

    private void informAlun(Alunos aln) {
        System.out.print("Informe o seu nome: ");
        nome = entrada.nextLine();
        aln.setNome(nome);
        System.out.print("Informe a sua nota: ");
        nota = in.nextDouble();
        aln.setNota(nota);
        System.out.print("Informe a quantidade se faltas: ");
        falta = in.nextInt();
        aln.setFalta(falta);
        System.out.println("Aluno cadrastrado.");
    }

    public void RemoveInc() {
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            if (this.qtd == 1) {
                this.primer = null;
                this.ultm = null;
            }
            else {
                this.primer = this.primer.getProx();
            }
            this.qtd--;
            System.out.println("Remoção efetuada.");
        }
    }

    public void RemoverFnl() {
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            if (this.qtd == 1) {
                this.primer = null;
                this.ultm = null;
            }
            else {
                aux = this.primer;
                while (aux.getProx().getProx() != null) {
                    aux = aux.getProx();
                }
                this.ultm = aux;
                this.ultm.setProx(null);
            }
            this.qtd--;
            System.out.println("Remoção efetuada.");
        }
    }

    public void RemoveAlun(Alunos procAln) {
        Node aux2;
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            aux = buscaAln(procAln);
            if (aux == null) {
                System.out.println("Aluno não cadastrado.");
            }
            else {
                if (this.qtd == 1) {
                    this.primer = null;
                    this.ultm = null;
                }
                else {
                    if (this.primer == aux) {
                        this.primer = this.primer.getProx();
                    }
                    else if (this.ultm == aux) {
                        aux2 = this.primer;
                        while (aux2.getProx() != null) {
                            aux2 = aux2.getProx();
                        }
                        this.ultm = aux2;
                        this.ultm.setProx(null);
                    }
                    else {
                        aux2 = this.primer;
                        while (aux2.getProx() != null) {
                            if (aux2 == aux) {
                                aux2.setProx(aux2.getProx());
                                break;
                            }
                            aux2 = aux.getProx();
                        }
                    }
                }
                this.qtd--;
                System.out.println("Aluno removido");
            }
        }
    }

    public void ExibAlun() {
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            aux = this.primer;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void ExibUnicAlun(Alunos matricAlun) {
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            aux = buscaAln(matricAlun);
            if (aux == null) {
                System.out.println("Aluno não cadastrado.");
            }
            else {
                System.out.println(aux.getInfo());
            }
        }
    }

    public void AlterAlun(Alunos aln) {
        char opcAlter, opcVal;
        if (this.isEmpity()) {
            System.out.println("Nenhum aluno foi cadastrado.");
        }
        else {
            aux = buscaAln(aln);
            if (aux == null) {
                System.out.println("Aluno não cadastrado.");
            }
            else {
                menuAlter();
                System.out.print("Informe uma opção: ");
                opcAlter = in.next().charAt(0);
                while (opcAlter < '1' || opcAlter > '3') {
                    System.out.print("Opção inválida. Informe novamente: ");
                    opcAlter = in.next().charAt(0);
                }
                if (opcAlter == '1') {
                    System.out.print("Informe um novo nome: ");
                    nome = entrada.nextLine();
                    aln.setNome(nome);
                }
                else if (opcAlter == '2') {
                    System.out.print("Informe a nova nota: ");
                    nota = in.nextDouble();
                    while (nota < 0 || nota > 10) {
                        System.out.print("Valor inválido, informe um valor de 0 até 10: ");
                        nota = in.nextDouble();
                    }
                    aln.setNota(nota);
                }
                else {
                    System.out.print("Informe a nova quantidade de faltas: ");
                    falta = in.nextInt();
                    while (falta < 0) {
                        System.out.print("Falta inválida, informe um valor positivo: ");
                        falta = in.nextInt();
                    }
                    aln.setFalta(falta);
                }
                System.out.println("Informação alterada.");
            }
        }
    }

    public boolean isEmpity() {
        if (this.primer == null && this.ultm == null && this.qtd == 0) {
            return true;
        }
        return false;
    }

    private Node buscaAln(Alunos aln) {
        aux = this.primer;
        while (aux != null) {
            if (aux.getInfo().compareTo(aln) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void menuAlter() {
        System.out.println("Opções para dados alteráveis:");
        System.out.println("1 - Alterar o nome.");
        System.out.println("2 - Alterar a nota.");
        System.out.println("3 - Alterar a quantidade de faltas.");
    }
}