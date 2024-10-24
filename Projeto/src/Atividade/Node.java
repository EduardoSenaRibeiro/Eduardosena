package Atividade;

public class Node {

    Aluno aluno;
    Node next;
    Node prev;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.next = null;
        this.prev = null;
    }
}
