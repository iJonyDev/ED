package EPDs.EPD2;
/* Esperimento 6
  a) Si deseamos ordenar los objetos de la clase Numero con respecto a otro orden distinto al natural deberemos definir un comparador. Examine el código del siguiente comparador para la clase Numero y determine que orden impone a los objetos.
  b) Modifique el código del programa principal del experimento anterior para que se aplique en la ordenación el criterio de orden establecido por el anterior comparador.
 */
import java.util.Comparator;

public class ComparadorNumero implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        Numero n = (Numero) o1;
        Numero m = (Numero) o2;
        if (n.getNumero() == m.getNumero())
            return 0;
        else if (n.getNumero() > m.getNumero())
            return -1;
        else
            return 1;
    }
}
