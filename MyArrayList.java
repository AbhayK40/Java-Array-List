//Abhay Khanna 
//Pproject 02 

import java.util.*;

public class MyArrayList<E> implements MyList<E> {
    
    private E[] list;
    private int size = 0;
    private int capacity=10;
    
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.size = 0;
        capacity = 10;
        list = (E[])(new Object[capacity]);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        this.size = 0;
        capacity = initialCapacity;
        list = (E[])(new Object[capacity]);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(Collection<? extends E> c) {
        this.capacity = Math.max(10, c.size());
        list = (E[]) (new Object[capacity]);
        for (E element : c) {
            add(element); // Use add to maintain size management
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();  
        size = size + 1;
        list[size - 1] = e;  
    
        return true;
    }

    private void checkIndex(int index) {
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException("Index "+ index +" out of bound for length "+size);
        }
    }

    @Override
    public void add(int index, E element) {
        try{ 
        checkIndex(index);  
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
            return;
        }
          
        ensureCapacity();   
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];  
        }
        list[index] = element;  
        size++; 
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    public String toString() {
        if(size==0)
            return "[]";
        @SuppressWarnings("unchecked")
        E[] temp = (E[])(new Object[size]);
        System.arraycopy(list, 0, temp, 0, size);
        return Arrays.asList(temp).toString();
    }

    @SuppressWarnings({ "unchecked", "unchecked" })
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public E get(int index) {
        try{ 
        checkIndex(index);  
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }
        return list[index];  
    }

    @SuppressWarnings("unchecked")
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (list[i] == null) {
                    return i;  
                }
            }
        } 
        else {
            for (int i = 0; i < size; i++) {
                if (o.equals(list[i])) {
                    return i;  
                }
            }
        }
        return -1;  
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (list[i] == null) {
                    return i;  
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(list[i])) {
                    return i; 
                }
            }
        }
        return -1; 
    }

    @Override
    public E remove(int index) {
        try{ 
        checkIndex(index);  
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        } 
        E removedElement = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1]; 
        }
        list[--size] = null; 
        return removedElement;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    public E set(int index, E element) {
        try{ 
        checkIndex(index);  
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }  
        E oldElement = list[index];
        list[index] = element;  
        return oldElement;  
    }

    @Override
    public int size() {
        return size;
    }

    public void trimToSize() {
        if (size < capacity) {
            @SuppressWarnings("unchecked")
            E[] newList = (E[]) new Object[size];  
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];  
            }
            list = newList;  
            capacity = size;  
        }
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            @SuppressWarnings("unchecked")
            E[] newList = (E[]) new Object[capacity];

            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }

            list = newList; 
            System.out.println("New capacity: " + capacity);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];  
        for (int i = 0; i < size; i++) {
            result[i] = list[i];  
        }
        return result; 
    }

    /** Returns an array containing all of the elements in this collection;
    * the runtime type of the returned array is that of the specified array.
    */
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] array) {
        if (array.length < size) {
            array = (E[]) new Object[size];
        }
        for (int i = 0; i < size; i++) {
            array[i] = (E) list[i];
        }
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            while (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(list[i])) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator
    implements java.util.Iterator<E> {
        private int current = 0; 
        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return (E)list[current++];
        }

        @Override 
        public void remove() {
            if (current == 0) 
                throw new IllegalStateException();
            MyArrayList.this.remove(--current);
        }
    }
}


