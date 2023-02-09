import java.util.*;
/**
 * This class creates a queue (or linked list) and has pointers to the front and
 * back of said list
 * @author Cora Skidmore
 */
public class Queue{
  /**
   * This class actually establishes the linked list with data type Tweet
   */
  private class Node{
    private Tweet data;
    private Node next;
    public Node(Tweet d, Node n){
      data = d;
      next = n;
    }
  }

  private Node head;
  private Node tail = null;
  /**
   * Adds s to the back of the queue
   * @param s Tweet that should be added to the queue
   */
  public void enqueue(Tweet s){
    if (this.empty()){
      this.head = new Node(s, null);
      this.tail = this.head;
    }
    else {
      this.tail.next = new Node(s, null);
      this.tail = this.tail.next;
    }
  }
  /**
   * Removes and returns Tweet from the front of the queue
   * @return Tweet at the front of the queue
   */
  public Tweet dequeue(){
    Tweet info = this.head.data;
    this.head = this.head.next; //noo??
    return info;
  }
  /**
   * Returns true if list is empty
   * @return boolean (true if Queue is empty, otherwise false)
   */
  public boolean empty(){
    if(this.head == null){
      return true;
    }
    return false;
  }
  /**
   * Returns the length of the current queue
   * @return int length of Queue
   */
  public int length(){
    int len = 0;
    Node cp = this.head;
    while(cp != null){
      len++;
      cp = cp.next;
    }
    return len;
  }
  /**
   * Prints all of the current tweets in the Queue
   */
  public void printall(){
    Node cp = this.head;
    for(int i = 0; i < this.length(); i++){
      System.out.println(cp.data.toString());
      cp = cp.next;
    }
  }
  /**
   * This method copies the queue and returns that copy
   * @return Queue that points to the queue instance that the method is called
   * on
   */
  public Queue copy(){
    Queue Q = new Queue();
    Q.head = this.head;
    Q.tail = this.tail;
    return Q;
  }
  /**
   * Filters for keyword in the current Queue instance and returns a new queue
   * with only tweets containing that new keyword
   * @param keyword a string with the set of letters you are looking for
   * @return Queue will all tweets containing that keyword
   */
  public Queue filterForKeyword(String keyword){
    Queue Q = new Queue();
    Node cp = this.head;
    while(cp != null){
      if(cp.data.containsKeyword(keyword)){
        Q.enqueue(cp.data);
      }  
      cp = cp.next;
    }
    return Q;
  }
  /**
   * Filters out all tweets that contain a keyword in the current Queue instance
   * and returns a new queue containing every tweet not containing that keyword
   * @param keyword a string with the set of letters you want to filter out
   * @return Queue with all tweets not containing that keyword
   */
  public Queue filterForNotKeyword(String keyword){
    Queue Q = new Queue();
    Node cp = this.head;
    while(cp != null){
      if(!cp.data.containsKeyword(keyword)){
        Q.enqueue(cp.data);
      }  
      cp = cp.next;
    }
    return Q; 
  }
  /**
   * Filters all of the tweets for a specific date in the current Queue instance
   * and returns a new queue containing every tweet from that date
   * @param date String representation of the date
   * @return Queue with all tweets from that date
   */
  public Queue filterForDate(String date){
    Queue Q = new Queue();
    Node cp = this.head;
    while(cp != null){
      if(cp.data.onDate(date)){
        Q.enqueue(cp.data);
      }  
      cp = cp.next;
    }
    return Q; 


  }

  public static void main(String[] args){
    Queue Q = new Queue();
    Tweet t = new Tweet("hi", "me", "2003-12-45");
    Tweet t2 = new Tweet("nooooo", "me", "2003-12-45");
    Tweet t3 = new Tweet("hi bob", "me", "2003-12-45");
    
    Q.enqueue(t);
    Q.enqueue(t2);
    Q.enqueue(t3);
    //System.out.println(Q.dequeue());
    System.out.println(Q.empty());
    Q.printall();
    Q = Q.filterForKeyword("hi");
    Q.printall();
  }
}

