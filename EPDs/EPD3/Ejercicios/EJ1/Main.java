package EPDs.EPD3.Ejercicios.EJ1;

public class Main {
    public static void main(String[] args) {
        Numeros numeros = new Numeros();
        
        numeros.addNumero(2);
        numeros.addNumero(3);
        numeros.addNumero(4);
        numeros.addNumero(5);
        numeros.addNumero(6);
        
        System.out.println("Números primos: " + numeros.getPrimos());
    }
}
