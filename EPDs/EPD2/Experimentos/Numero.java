package EPDs.EPD2.Experimentos;
/*
 *a) El siguiente código corresponde a una clase diseñada para que sus objetos alberguen un número entero del 1 al 100 de
origen aleatorio. Observe como su constructor sin argumentos inicializa automáticamente el atributo a un número aleatorio. La clase
implementa la interfaz Comparable, por lo que tiene un orden natural definido. Examine el código y determine cuál es el orden
natural que se ha definido. ¿Por qué se hace un casting del objeto que el método compareTo recibe como argumento?
 */
public class Numero implements Comparable<Object> {
    private int numero;

    public Numero() {
        this.numero = (int) Math.round(Math.random() * 100);
    }

    public int getNumero() {
        return numero;
    }

    public int compareTo(Object o) {
        Numero n = (Numero) o; // a) Porque se van a comparar Objetos de tipo Entero.
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
