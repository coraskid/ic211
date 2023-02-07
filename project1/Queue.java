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
    public Tweet data;
    public Node next;
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
    Node N = new Node(s, this.tail);
    if (this.empty()){
      this.head = N;
    }
    else {
      Node temp = this.head;
      int i = 0;
      while(temp.next != this.tail){
        i ++;
        temp = temp.next;
      }
      temp.next = N;
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
    if(this.head == this.tail){
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



  public static void main(String[] args){
    Queue Q = new Queue();
    Tweet t = new Tweet("hi", "me", "2003-12-45");
    Q.enqueue(t);
    System.out.println(Q.dequeue());
    System.out.println(Q.empty());    
  }
}

