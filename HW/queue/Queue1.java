import java.util.*;

public class Queue{
   
  private class Node{
    public String data;
    public Node next;
    public Node(String d, Node n){
      data = d;
      next = n;
    }
  }

  private Node head;
  private Node tail = null;
  /**
   * Adds s to the back of the queue
   */
  public void enqueue(String s){
    if (this.empty()){
      Node N = new Node(s, this.tail);
      this.head = N;
    }
    else {
      this.tail = new Node(s, this.tail);
      
      //Node N = new Node(s, this.tail);
      //Node temp = this.head;
      //int i = 0;
      //while(temp.next != this.tail){
      //  i ++;
      //  temp = temp.next;
      //}
      //temp.next = N;
    }
  }
  /**
   *removes and returns string from the front of the queue
   */
  public String dequeue(){
    String info = this.head.data;
    this.head = this.head.next; //noo??
    return info;
  }
  /**
   * Returns true if list is empty
   */
  public boolean empty(){
    if(this.head == this.tail){
      return true;
    }
    return false;
  }



  public static void main(String[] args){
    Queue Q = new Queue();
    Q.enqueue("Hi");
    Q.enqueue("Holla");
    Q.enqueue("Hi1");
    Q.enqueue("Hi2");
    Q.enqueue("Hi3");
    Q.enqueue("Hi4");
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
    System.out.println(Q.empty());    
  }
}

