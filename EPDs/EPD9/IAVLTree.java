package EPDs.EPD9;

public interface IAVLTree {

        // Inserta un nuevo nodo en el árbol AVL.
        void insertar(int key, String value);
    
        // Busca un nodo en el árbol AVL dado su valor clave.
        String buscar(int key);
    
        // Elimina un nodo del árbol AVL dado su valor clave.
        void eliminar(int key);
    
     
}
