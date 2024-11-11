import java.util.Arrays;

public class TestMyArrayList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] name2 = {"George", "Michael", "Michelle", "Daniel"};
        String[] name3 = {"Tom", "Peter","Jane","Adam","Peter","Mary","David"};
        
        
        MyArrayList<String> list = new MyArrayList<>(Arrays.asList(name1));
        System.out.println("Test constructor and toString methods");
        System.out.println("list is: " + list);
        // Test add(E e) method and contains(Object e)
        System.out.println("\nTest add(e) and contains() method");
        list.add("Daniel");
        System.out.println("list is: "+list+" and contains Daniel: "+list.contains("Daniel"));
        // Test add(int index, E element) and get(int index)
        list.add(3,"Michael");
        System.out.println("\nTest add(int index, E element) and get(int index)");
        System.out.println("list is: " + list);
        System.out.println("Element at index 3 is: "+list.get(3));
        // Test addAll()
        System.out.println("\nTest addAll() method");
        list.addAll(Arrays.asList(name2));
        System.out.println("list is: "+list);
        // Test indexOf()
        System.out.println("\nTest indexOf() method");
        System.out.println("Index of Michael is: "+ list.indexOf("Michael"));
        // Test lastIndexOf()
        System.out.println("\nTest lastIndexOf() method");
        System.out.println("Last Index of Michael is: "+ list.lastIndexOf("Michael"));
        // Test remove() methods
        System.out.println("\nTest remove() methods");
        System.out.println(list.remove(3));
        System.out.println(list.remove("Michael"));
        System.out.println(list);
        // Test set() method
        System.out.println("\nTest set()and size() methods");
        System.out.println(list.set(3,"John"));
        System.out.println(list.set(list.size()-1,"Michael"));
        System.out.println(list);
        list.trimToSize();
        Integer[] l1 = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> list1 = new MyArrayList<>(Arrays.asList(l1));
        MyArrayList<Integer> list2 = new MyArrayList<>(Arrays.asList(l1));
        System.out.println("List1 contains All list2: "+list1.containsAll(list2));
        list1.add(11);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(list1.size()-1);
        System.out.println(list1);
        System.out.println(list1.get(11));
        System.out.println(list1.remove(11));
        list1.add(11,10);
        System.out.println(list1);
        list1.set(11,20);
        System.out.println(list1);
        list1.forEach(e -> System.out.print(e + " "));
        System.out.println();
        Object[] temp = list1.toArray();
        for(Object n : temp ) {
            System.out.print(n+" ");
        }
        System.out.println();
        System.out.println("List1 contains All list2: "+list1.containsAll(list2));
        System.out.println(list1);
        System.out.println(list2);
        list1.add(20);
        
        System.out.println(list1.removeAll(list2));
        System.out.println(list1);
        Integer[] l2 = {3,4,6,7,8};
        MyArrayList<Integer> list3 = new MyArrayList<>(Arrays.asList(l2));
        System.out.println(list3.retainAll(list2));
        System.out.println(list3);    
        list1.addAll(list3);
        System.out.println(list1);
        list1.clear();
        System.out.println(list1);
        }
    }


