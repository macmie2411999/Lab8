import java.util.Collection;

public interface IWaitList<E> {
    public  abstract void add(E element);
    public abstract E remove();
    public abstract boolean contains(E element);
    public abstract boolean containsAll(Collection<E> c);
    public abstract boolean isEmpty();
}
