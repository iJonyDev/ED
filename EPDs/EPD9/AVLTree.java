package EPDs.EPD9;

//E1. (5 mins.) Analice cómo sería la interfaz que representa los árboles AVL.

public class AVLTree {
    private Nodo root;

    public AVLTree() {
        this.root = null;
    }

    public void insertar(int key, String value) {
        Nodo nuevoNodo = new Nodo(key, value);
        this._insertar(nuevoNodo);
    }

    private void _insertar(Nodo nuevoNodo) {
        if (this.root == null) {
            this.root = nuevoNodo;
        } else {
            this._insertar_ayudante(nuevoNodo, this.root);
        }
        this._actualizar_altura(this.root);
        this._balancear(this.root);
    }

    private void _insertar_ayudante(Nodo nuevoNodo, Nodo nodoActual) {
        if (nuevoNodo.getKey() < nodoActual.getKey()) {
            if (nodoActual.getLeft() == null) {
                nodoActual.setLeft(nuevoNodo);
            } else {
                this._insertar_ayudante(nuevoNodo, nodoActual.getLeft());
            }
        } else {
            if (nodoActual.getRight() == null) {
                nodoActual.setRight(nuevoNodo);
            } else {
                this._insertar_ayudante(nuevoNodo, nodoActual.getRight());
            }
        }
        this._actualizar_altura(nodoActual);
        this._balancear(nodoActual);
    }

    private void _actualizar_altura(Nodo nodo) {
        nodo.setAltura(Math.max(this._obtener_altura(nodo.getLeft()), this._obtener_altura(nodo.getRight())) + 1);
    }
    
    private int _obtener_altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private void _balancear(Nodo nodo) {
        int balanceFactor = this._obtener_balance_factor(nodo);
        if (balanceFactor > 1) {
            if (this._obtener_balance_factor(nodo.getLeft()) < 0) {
                this._rotacion_izquierda(nodo.setLeft(null));
            }
            this._rotacion_derecha(nodo);
        } else if (balanceFactor < -1) {
            if (this._obtener_balance_factor(nodo.getRight()) > 0) {
                this._rotacion_derecha(nodo.getRight());
            }
            this._rotacion_izquierda(nodo);
        }
    }

    private void _rotacion_izquierda(Nodo nodo) {
        Nodo hijoDerecho = nodo.getRight();
        nodo.setRight(hijoDerecho.getLeft());
        hijoDerecho.left = nodo;
        this._actualizar_altura(nodo);
        this._actualizar_altura(hijoDerecho);

        if (nodo == this.root) {
            this.root = hijoDerecho;
        }
    }

    private void _rotacion_derecha(Nodo nodo) {
        Nodo hijoIzquierdo = nodo.getLeft();
        nodo.setRight(hijoIzquierdo.getRight());
        hijoIzquierdo.setRight(nodo);
        this._actualizar_altura(nodo);
        this._actualizar_altura(hijoIzquierdo);

        if (nodo == this.root) {
            this.root = hijoIzquierdo;
        }
    }

    public String buscar(int key) {
        Nodo nodoActual = this.root;
        while (nodoActual != null) {
            if (key < nodoActual.getKey()) {
                nodoActual = nodoActual.setLeft(null);
            } else if (key > nodoActual.getKey()) {
                nodoActual = nodoActual.getRight();
            } else {
                return nodoActual.getValue();
            }
        }
        return null;
    }

    public void eliminar(int key) {
        this.root = _eliminar(this.root, key);
    }
//Este método elimina un nodo con la clave dada del árbol.
    private Nodo _eliminar(Nodo nodo, int key) {
        // Si el nodo no existe, se devuelve null.
        if (nodo == null) {
            return null;
        }
        //Si el nodo tiene un hijo, se reemplaza por ese hijo. 
        if (key < nodo.getKey()) {
            nodo.setLeft(_eliminar(nodo.getLeft(), key));
        } else if (key > nodo.getKey()) {
            nodo.setRight(_eliminar(nodo.getRight(), key));
        } else {
        //Si el nodo tiene dos hijos, se encuentra el sucesor del nodo y se reemplaza por él.
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                nodo = null;
            
            } else if (nodo.getLeft() == null) {
                nodo = nodo.getRight();
            } else if (nodo.getRight() == null) {
                nodo = nodo.getLeft();
            } else {
                Nodo sucesor = _encontrar_sucesor(nodo.getRight());
                nodo.setKey(sucesor.getKey());
                nodo.setValue(sucesor.getValue());
                nodo.setRight(_eliminar(nodo.getRight(), sucesor.getKey()));
            }
        }

        if (nodo != null) {
            this._actualizar_altura(nodo);
            this._balancear(nodo);
        }

        return nodo;
    }
// El método _encontrar_sucesor() se utiliza para encontrar el sucesor de un nodo en el árbol AVL. Comienza desde el nodo dado y continúa siguiendo los enlaces izquierdos hasta llegar al nodo con el valor más pequeño. 
    private Nodo _encontrar_sucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getLeft() != null) {
            actual = actual.setLeft(actual);
        }
        return actual;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        
        // Insertar elementos en el árbol
        tree.insertar(5, "Valor 5");
        tree.insertar(3, "Valor 3");
        tree.insertar(7, "Valor 7");
        tree.insertar(2, "Valor 2");
        tree.insertar(4, "Valor 4");
        tree.insertar(6, "Valor 6");
        tree.insertar(8, "Valor 8");
        
        // Buscar un elemento en el árbol
        String valor = tree.buscar(4);
        System.out.println("Valor encontrado: " + valor);
        
        // Eliminar un elemento del árbol
        tree.eliminar(7);
        
        // Buscar un elemento que ya no está en el árbol
        valor = tree.buscar(7);
        System.out.println("Valor encontrado: " + valor);
    }
}
