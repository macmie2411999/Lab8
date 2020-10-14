import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements IWaitList {
    // fields
    protected ConcurrentLinkedQueue<E> content = new ConcurrentLinkedQueue<>();

    // constructors
    public WaitList(){
    }

    public WaitList(Collection<E> c){
        Iterator<E> iterator = c.iterator();
        while(iterator.hasNext()){
            E element = iterator.next();
            content.add(element);
        }
    }

    // Implementing all public abstract methods from IWaitList
    @Override
    public void add(Object element) {
        content.add((E) element);
    }

    @Override
    public Object remove() {
        return content.remove();
    }

    @Override
    public boolean contains(Object element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    // return String that represents for class
    public String toString(){
        return content.toString();
    }
}
