public class UnfairWaitList<E> extends WaitList<E> {

    // constructor
    public UnfairWaitList(){
    }

    // methods
    public void remove(E element){
        if(super.contains(element)){
            this.content.remove(element);
        } else {
            System.out.println("\nHave no " + element + " in List to delete!");
        }
    }

    // find in List, if the List has element and that element is
    // not in the last position in List then move it to the last
    public void moveToBack(E element){
        if(super.contains(element)){
            this.content.add(element);
            this.remove(element);
        } else {
            System.out.println("\nHave no " + element + " in List to move to back!");
        }
    }
}
