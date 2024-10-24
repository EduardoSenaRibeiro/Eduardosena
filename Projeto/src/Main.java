import Atividade.Aluno;
import Atividade.FuncaoAtividade;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Francinaldo", 0001, "Sistemas");
        Aluno aluno2 = new Aluno("Pablo", 0002, "Sistemas");
        Aluno aluno3 = new Aluno("Talles", 0003, "Direito");
        Aluno aluno4 = new Aluno("Ademario", 0004, "Educação Física");

        FuncaoAtividade fila1 = new FuncaoAtividade(null, null, 0);
        FuncaoAtividade fila2 = new FuncaoAtividade(null, null, 0);
        FuncaoAtividade fila3 = new FuncaoAtividade(null, null, 0);

        fila1.addLast(aluno1);
        fila1.addLast(aluno2);
        fila1.addLast(aluno3);
        fila1.addLast(aluno4);
        fila2.addLast(aluno1);
        fila2.addLast(aluno2);
        fila2.addLast(aluno3);
//        fila.pop(aluno1);
//        fila.print();
//        System.out.println(fila.popFirstAndRepeated());
//        fila.print();
//        fila.printReverse();
      System.out.println(fila1.isPalindromo(fila1));
//        fila1.removeDuplicates();
//        fila1.print();
        fila3.concatenar(fila1, fila2);
    }
}