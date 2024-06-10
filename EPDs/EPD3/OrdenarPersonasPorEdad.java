package EPDs.EPD3;
import java.util.Comparator;

public class OrdenarPersonasPorEdad implements Comparator<IPersona> {

    public int compare(IPersona persona1, IPersona persona2) {
        
        if (persona1.getEdad() < persona2.getEdad()) {
            return -1;
        } else if (persona1.getEdad() > persona2.getEdad()) {
            return +1;
        } else {
            return 0;
        }
    }
}
