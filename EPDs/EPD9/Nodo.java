package EPDs.EPD9;

public class Nodo {
    private int key;
    private String value;
    private Nodo left;
    private Nodo right;
    private int altura;

    public Nodo(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.altura = 0;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Nodo getLeft() {
        return left;
    }

    public Nodo setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}