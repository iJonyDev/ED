package EPDs.EPD5;

public class EJ4 {
    
    public static void main(String[] args) throws PilaVaciaException {
        ListaEnlazada<Integer> list = new ListaEnlazada<>();
        int i = 0;
        while (list.getSize() < 10) {
            list.addEnd(i);
            i++;
        }

        System.out.println(list.toString());
        System.out.println("La lista tiene " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        list.removeFront();
        list.removeEnd();
        list.add(3, 5);

        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        list.remove(2);
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");

        list.add(3, 6);
        list.add(3, null);
        list.add(0, null);
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");

        list.listStatus();
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        while (!list.isEmpty()) {
            list.removeFront();
            System.out.println(list.toString());
            System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");
        }

        System.out.println(list.listStatus());
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());


        IPila<Integer> pila = new Pila();
        try {
            pila.pop();
        } catch (PilaVaciaException e) {
            System.out.println(e.getMessage());
        }

        int j = 0;
        while (pila.size() < 10) {
            pila.push(j);
            j++;
        }

        System.out.println("La pila tiene " + pila.size() + " elementos.");
        while(!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
        System.out.println("La pila tiene " + pila.size() + " elementos.");



    }
}