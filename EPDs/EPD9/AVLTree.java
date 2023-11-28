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
        if (nuevoNodo.key < nodoActual.key) {
            if (nodoActual.left == null) {
                nodoActual.left = nuevoNodo;
            } else {
                this._insertar_ayudante(nuevoNodo, nodoActual.left);
            }
        } else {
            if (nodoActual.right == null) {
                nodoActual.right = nuevoNodo;
            } else {
                this._insertar_ayudante(nuevoNodo, nodoActual.right);
            }
        }
        this._actualizar_altura(nodoActual);
        this._balancear(nodoActual);
    }

    private void _actualizar_altura(Nodo nodo) {
        nodo.altura = Math.max(this._obtener_altura(nodo.left), this._obtener_altura(nodo.right)) + 1;
    }

    private int _obtener_altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private void _balancear(Nodo nodo) {
        int balanceFactor = this._obtener_balance_factor(nodo);
        if (balanceFactor > 1) {
            if (this._obtener_balance_factor(nodo.left) < 0) {
                this._rotacion_izquierda(nodo.left);
            }
            this._rotacion_derecha(nodo);
        } else if (balanceFactor < -1) {
            if (this._obtener_balance_factor(nodo.right) > 0) {
                this._rotacion_derecha(nodo.right);
            }
            this._rotacion_izquierda(nodo);
        }
    }

    private void _rotacion_izquierda(Nodo nodo) {
        Nodo hijoDerecho = nodo.right;
        nodo.right = hijoDerecho.left;
        hijoDerecho.left = nodo;
        this._actualizar_altura(nodo);
        this._actualizar_altura(hijoDerecho);

        if (nodo == this.root) {
            this.root = hijoDerecho;
        }
    }

    private void _rotacion_derecha(Nodo nodo) {
        Nodo hijoIzquierdo = nodo.left;
        nodo.left = hijoIzquierdo.right;
        hijoIzquierdo.right = nodo;
        this._actualizar_altura(nodo);
        this._actualizar_altura(hijoIzquierdo);

        if (nodo == this.root) {
            this.root = hijoIzquierdo;
        }
    }

    public String buscar(int key) {
        Nodo nodoActual = this.root;
        while (nodoActual != null) {
            if (key < nodoActual.key) {
                nodoActual = nodoActual.left;
            } else if (key > nodoActual.key) {
                nodoActual = nodoActual.right;
            } else {
                return nodoActual.value;
            }
        }
        return null;
    }

    public void eliminar(int key) {
        this.root = _eliminar(this.root, key);
    }

    private Nodo _eliminar(Nodo nodo, int key) {
        if (nodo == null) {
            return null;
        }

        if (key < nodo.key) {
            nodo.left = _eliminar(nodo.left, key);
        } else if (key > nodo.key) {
            nodo.right = _eliminar(nodo.right, key);
        } else {
            if (nodo.left == null && nodo.right == null) {
                nodo = null;
            } else if (nodo.left == null) {
                nodo = nodo.right;
            } else if (nodo.right == null) {
                nodo = nodo.left;
            } else {
                Nodo sucesor = _encontrar_sucesor(nodo.right);
                nodo.key = sucesor.key;
                nodo.value = sucesor.value;
                nodo.right = _eliminar(nodo.right, sucesor.key);
            }
        }

        if (nodo != null) {
            this._actualizar_altura(nodo);
            this._balancear(nodo);
        }

        return nodo;
    }

    private Nodo _encontrar_sucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual;
    }
}
