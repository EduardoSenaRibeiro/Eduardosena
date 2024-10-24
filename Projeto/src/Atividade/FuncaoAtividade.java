package Atividade;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class FuncaoAtividade  {
    Node head;
    Node tail;
    int size;

    public FuncaoAtividade(Node head, Node tail,int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(Aluno aluno) {
        Node newNode = new Node(aluno);
        if(isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.size++;
    }

    public String primeiroAlunoRemovido() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Aluno primeiroAlunoRemovido = this.head.aluno;
        this.head = this.head.next;
        if(this.head == null) {
            this.head.prev = null;
        }
        this.size--;

        return primeiroAlunoRemovido.getNome() + " removido com sucesso! Proximo da fila é: " + head.next.aluno.getNome();
    }

    public void removerLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if(this.tail == null) {
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    public void remover(Aluno aluno) {
        if(isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Node aux = this.head;
        for(int i = 0; i < this.size - 1; i++) {
            if(aux.aluno != null && aux.aluno.equals(aluno)) {
                if(aux.next== null) {
                    removerLast();
                    break;
                }
                if (aux == this.head) {
                    primeiroAlunoRemovido();
                    break;
                }
                aux = aux.next.prev = aux.prev;
                aux.prev.next = aux.next;
                size--;
                break;
            }
            aux = aux.next;
        }
    }

    public void print() {
        if(this.isEmpty()) {
            System.out.println("Não tem niguém na fila");
        }

        Node aux = this.head;

        while(aux != null) {
            System.out.println(aux.aluno.getNome());
            aux = aux.next;
        }
    }

    public void printReverse() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node aux = this.head;
        Node temp = null;
        while(aux != null) {
            temp = aux.next;
            aux.next = aux.prev;
            aux.prev = temp;
            aux = temp;
        }
        this.head = this.tail;
        this.tail = temp;
        print();
    }

    public void removeDuplicates() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node aux = this.head;
        HashSet<Aluno> hash = new HashSet<>();
        while (aux != null) {
            if (hash.contains(aux.aluno)) {
                remover(aux.aluno);
            } else {
                hash.add(aux.aluno);
            }
            aux = aux.next;
        }
    }

    public Aluno getByIndex(int index) {
        if (isEmpty()) {
            System.out.println("Ta vazia corno!");
        }
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.aluno;
    }

    public boolean isPalindromo(FuncaoAtividade fila) {
        boolean palindromo = true;

        if (isEmpty()) {
            palindromo = false;
            return palindromo;
        }

        for (int i = 0, j = this.size - 1; i < j; i++, j--) {
            if (fila.getByIndex(i) != fila.getByIndex(j)) {
                palindromo = false;
                break;
            }
        }
        return palindromo;
    }

    public void concatenar(FuncaoAtividade fila1, FuncaoAtividade fila2){
        FuncaoAtividade filaConcatenada = new FuncaoAtividade(null, null, 0);
        Node aux1 = fila1.head;
        Node aux2 = fila2.head;

        for(int i = 0; i < fila1.size; i++){
            filaConcatenada.addLast(aux1.aluno);
            aux1 = aux1.next;
        }
        for(int i = 0; i < fila2.size; i++){
            filaConcatenada.addLast(aux2.aluno);
            aux2 = aux2.next;
        }
        filaConcatenada.print();
    }

}
