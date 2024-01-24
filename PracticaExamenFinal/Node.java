package PracticaExamenFinal;

public class Node {
    private Persona persona;
    private Node next;

    public Node(Persona persona) {
        this.persona = persona;
        this.next = null;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
