import java.util.*;
/**
 * This class is oberationally similar to the ArrayList class
 * @author Cora Skidmore
 */
public class ArrList<T> implements Iterable<T>{
  private T[] arr;
  private int length;

  /**
   * Constructor: makes an array of 10 objects of types T
   */
  public ArrList(){
    //Syntax aid from stack overflow example that also had a generic array
    //creation error
    this.arr = (T[]) new Object[10];
    this.length = 0;
  }

  /**
   * This method sets up the Iter class and allows the ArrList to be iterable
   * @return an Iterator (defined below)
   */
  public Iterator<T> iterator(){
    return new Iter(arr, length);
  }

  /**
   * Nested class Iter that will add functionality to ArrList
   */
  protected class Iter implements Iterator<T> {
    protected T[] data;
    protected int len;
    protected int index;

    /**
     * Constructor: makes an Iter from ArrList data
     * @param data arr from given ArrList instance (type T[])
     * @param length the length of arr in ArrList instance (type int)
     */
    public Iter(T[] data, int length){
      this.data = data;
      this.len = length;
      this.index = 0;
    }

    /**
     * Inforced method from Iterator interface
     * @return the next object in the array (type T)
     */
    public T next(){
      T curr = this.data[index];
      this.index++;
      return curr;
    }

    /**
     * Inforced method from Iterator interface
     * @return a boolean; true if there are more objects, otherwise false
     */
    public boolean hasNext(){
      if(index >= len)
        return false;
      else
        return true;
    }
  }

  /**
   * This method adds an object to the ArrList
   * It will also make a new array (double the size) is current array is too
   * small
   * @param d Object you would like to add (type T)
   */
  public void add(T d){
    if(arr.length == length){
      T[] temp = (T[]) new Object[arr.length*2];
      int i = 0;
      for(T k : arr){
        temp[i] = k;
        i++;
      }
      this.arr = temp;
    }
    this.arr[length] = d;
    this.length++;

  }

  /**
   * Classic getter method
   * Given an index, will return the value at that index
   * @param index the index at which you would like the object
   * @return the object at that index
   */
  public T get(int index){
    return arr[index];
  }

  /**
   * This method gets the size of the array
   * @return the length of the array as an int
   */
  public int size(){
    return length;
  }

  /**
   * This method removes an object at a given index
   * It will thow an IndexOutOfBoundsException if its not a valid index
   * @param index the index youd like to remove
   * @return the object you removed
   */
  public T remove(int index) throws IndexOutOfBoundsException{
    
    if(index < 0 || index >= length){
      throw new IndexOutOfBoundsException();
    }
    T removed = arr[index];
    for(int i = index; i < length -1; i++)
      arr[i] = arr[i+1];
    arr[length] = null;
    length--;
    return removed;
  }

  /**
   * This method removes the first instance of an object if it is in the Array
   * @param d the object youd like to remove
   * @return a boolean; true if it is sucessful, otherwise false;
   */
  public boolean remove(T d){
    int index = -1;
    for(int i = 0; i < length; i++){
      if(arr[i].equals(d)){
        index = i;
        break;
      }
    }
    try {
      T removed = this.remove(index);
    }
    catch (IndexOutOfBoundsException ioobe){
      return false;
    }
    return true;

  }


  public static void main(String[] args){
    
    ArrList<Integer> t1 = new ArrList<Integer>();

    t1.add(4);
    t1.add(4);    
    t1.add(4);    
    t1.add(4);    
    t1.add(4);    
    t1.add(4);    
    t1.add(4);
    t1.add(4);   
    t1.add(6);
    t1.add(8);
    t1.add(4);    
    t1.add(4);    

    
    for(Integer k : t1){
      System.out.println(k);
    }
    t1.remove(8);
    for(Integer k : t1){
      System.out.println(k);
    }

    ArrList<String> t2 = new ArrList<String>();

    t2.add("Hi");
    t2.add("j");
    t2.add("k");

    if(t2.remove("j")){
      System.out.print("yayyy");
    } else { System.out.print("booo"); }

    System.out.println(t2.remove(-1));
    if(t2.remove("p")){
      System.out.println("shit");
    } else { System.out.print("fuck yea"); }
  }
}
