import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class mainTest {
    public static void main(String args[]){
        // create collection
        Collection<Integer> listInteger = Arrays.asList(5,-10,24,3,72,0,1);
        Collection<String> listString = Arrays.asList("Mac Mie", "Tom", "Misa", "Anna", "Michael");
        Collection<Double> listDouble = Arrays.asList(5.5,6.2,7.8,14.3,45.3);

        // test WaitList
        testWaitList(listInteger);

        // test UnfairWaitList
        testUnfairWaitList(listString);

        // test BoundedWaitList
        testBoundedWaitList(listDouble);
    }

    public static void testWaitList(Collection collection){
        // create WaitList
        WaitList<Integer> instanceOfWL = new WaitList<Integer>(collection);

        // test methods and show results
        System.out.print("-------------------------------CHECK testWaitList----------------------------------");
        System.out.print("\nList: ");
        System.out.println(instanceOfWL.toString());
        instanceOfWL.add(50);
        System.out.print("List after add 50: ");
        System.out.println(instanceOfWL.toString());
        instanceOfWL.remove();
        System.out.print("List after remove one element on top: ");
        System.out.println(instanceOfWL.toString());
        System.out.println("List contains 72: " + instanceOfWL.contains(72));
        System.out.println("List contains " + collection.toString() + ": " + instanceOfWL.containsAll(collection));
        System.out.println("List is empty: " + instanceOfWL.isEmpty());
    }

    public static void testUnfairWaitList(Collection collection){
        // create UnfairWaitList
        UnfairWaitList<String> instanceOfUWL = new UnfairWaitList<String>();

        // add elements for instanceOfUW's content
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            instanceOfUWL.content.add(iterator.next());
        }

        // test methods of UnfairWaitList and show results
        System.out.print("----------------------------CHECK testUnfairWaitList--------------------------------");
        System.out.print("\nList: ");
        System.out.println(instanceOfUWL.toString());
        instanceOfUWL.remove("Tom");
        System.out.print("List after remove 'Tom': " + instanceOfUWL.toString());
        instanceOfUWL.remove("Harry");
        System.out.print("List after remove 'Harry': " + instanceOfUWL.toString());
        instanceOfUWL.moveToBack("Mac Mie");
        System.out.print("\nList after move 'Mac Mie' to back: " + instanceOfUWL.toString());

        // test methods of WaitList (superclass) and show results
        System.out.println("\nList contains 'Anna': " + instanceOfUWL.contains("Anna"));
        System.out.println("List contains " + collection.toString() + ": " + instanceOfUWL.containsAll(collection));
        System.out.println("List is empty: " + instanceOfUWL.isEmpty());
    }

    public static void testBoundedWaitList(Collection collection){
        // create UnfairWaitList
        BoundedWaitList<Double> instanceOfBWL = new BoundedWaitList<Double>(collection.size());

        // add elements for instanceOfUW's content
        Iterator<Double> iterator = collection.iterator();
        while(iterator.hasNext()){
            instanceOfBWL.content.add(iterator.next());
        }

        // test methods of BoundedWaitList and show results
        System.out.print("----------------------------CHECK testBoundedWaitList--------------------------------");
        System.out.print("\nList: ");
        System.out.println(instanceOfBWL.toString());
        System.out.println("Capacity: " + instanceOfBWL.getCapacity());
        instanceOfBWL.add(-25.7);
        System.out.println("List after add -25.7 to back: " + instanceOfBWL.toString());

        // test methods of WaitList (superclass) and show results
        System.out.println("List contains 10.1 : " + instanceOfBWL.contains(10.1));
        System.out.println("List contains " + collection.toString() + ": " + instanceOfBWL.containsAll(collection));
        System.out.println("List is empty: " + instanceOfBWL.isEmpty());
    }
}



