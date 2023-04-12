// Aplicação Java
package ListaAluno;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Scanner entrada = new Scanner (System.in);
        char opcMn;
        String matric;
        Alunos aln;
        LseComDescritor list = new LseComDescritor();
        MenuAlunos();
        do {
            System.out.println();
            System.out.println("Digite 9 para ver o menu novamente.");
            System.out.print("Informe a sua opção desejada: ");
            opcMn = in.next().charAt(0);
            if (opcMn == '1') {
                System.out.print("Informe a matrícula do aluno: ");
                matric = entrada.nextLine();
                aln = new Alunos(matric);
                list.InserInc(aln);
            }
            else if (opcMn == '2') {
                System.out.print("Informe a matrícula do aluno: ");
                matric = entrada.nextLine();
                aln = new Alunos(matric);
                list.InserFnl(aln);
            }
            else if (opcMn == '3') {
                list.RemoveInc();
            }
            else if (opcMn == '4') {
                list.RemoverFnl();
            }
            else if (opcMn == '5') {
                System.out.print("Informe a matrícula do aluno que deseja remover: ");
                matric = entrada.nextLine();
                aln = new Alunos(matric);
                list.RemoveAlun(aln);
            }
            else if (opcMn == '6') {
                list.ExibAlun();
            }
            else if (opcMn == '7') {
                System.out.print("Informe a matrícula do aluno que deseja exibir: ");
                matric = entrada.nextLine();
                aln = new Alunos(matric);
                list.ExibUnicAlun(aln);
            }
            else if (opcMn == '8') {
                System.out.print("Informe o matrícula do aluno que deseja alterar: ");
                matric = entrada.nextLine();
                aln = new Alunos(matric);
                list.AlterAlun(aln);
            }
            else if (opcMn == '9') {
                MenuAlunos();
            }
            else if (opcMn == '0') {
                System.out.println("Fim do programa.");
            }
            else {
                System.out.println("Opção inválida.");
            }
        } while (opcMn != '0');
    }

    public static void MenuAlunos() {
        System.out.println("Opções da lista de alunos:");
        System.out.println("1 - Inserir um novo aluno no início da lista.");
        System.out.println("2 - Inserir um novo aluno no fim da lista.");
        System.out.println("3 - Remover o primeiro estudante da lista.");
        System.out.println("4 - Remover o último estudante da lista.");
        System.out.println("5 - Remover um aluno expecífico da lista.");
        System.out.println("6 - Exibir os dados de todos os alunos registrados.");
        System.out.println("7 - Exibir os dados de um único aluno.");
        System.out.println("8 - Alterar os dados de um aluno.");
        System.out.println("0 - Sair do programa.");
    }
}