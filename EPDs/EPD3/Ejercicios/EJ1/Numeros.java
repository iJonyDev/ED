package EPDs.EPD3.Ejercicios.EJ1;

import java.util.HashSet;
import java.util.Set;

public class Numeros implements INumeros {
    private Set<Integer> SNum;

    public Numeros() {
        this.SNum = new HashSet<>();
    }

    public Set<Integer> getPrimos() {
        Set<Integer> primos = new HashSet<>();
        for (Integer num : SNum) {
            if (esPrimo(num)) {
                primos.add(num);
            }
        }
        return primos;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public boolean addNumero(Integer num) {
        return this.SNum.add(num);
    }
}
