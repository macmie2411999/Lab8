public class BoundedWaitList<E> extends WaitList<E> {
    // field
    private int capacity;

    // constructor
    public BoundedWaitList(int capacity){
        this.capacity = capacity;
    }

    // methods
    public int getCapacity(){
        return this.capacity;
    }

    public void add(Object element){
        super.add(element);
    }

    // return String that represents for class
    public String toString(){
        return super.toString();
    }
}
