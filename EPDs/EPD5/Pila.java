package EPDs.EPD5;

public class Pila implements IPila {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int size;

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }else
        return false;
    }

    @Override
    public Object pop() throws PilaVaciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public void push(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Object top() throws PilaVaciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'top'");
    }
    
}
