import java.util.*;

public interface MyList<E> extends Collection<E>{

	  /** Add a new element at the specified position*/
	  public void add(int index, E e);
	  
	  /** Returns the element from this list at the specified index
	   * Throw exception if index out of range
	  */
	  public E get(int index);
	  
	  
	  /** Returns the index of the first matching element in this list */
	  public int indexOf(Object o);
	  
	  /** Returns the index of the last matching element in this list. */
	  public int lastIndexOf(Object o);
	  
	  /** Remove the element at the specified position in this list
	   *  Return the element that was removed from the list. 
	   *  Throw exception if index out of range
	  */
	  public E remove(int index);
	  
	 
	  
	  /** Replace element at given index with new element 
	   * Throw exception if index out of range
	  */
	  public E set(int index, E element);
  
	 
     
	  /** Return size of this list */
	  public int size();
  
	  
}
