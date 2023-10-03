package EPDs.EPD2;

public class Numero implements Comparable<Object> {
    private int numero;

    public Numero() {
        this.numero = (int) Math.round(Math.random() * 100);
    }

    public int getNumero() {
        return numero;
    }

    public int compareTo(Object o) {
        Numero n = (Numero) o;
        if (this.numero == n.numero)
            return 0;
        else if (this.numero < n.numero)
            return -1;
        else
            return 1;
    }

    public String toString() {
        return String.valueOf(numero);
    }
}
