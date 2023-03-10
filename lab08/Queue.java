/**
 * Queue Class has all standard queue stuff
 * @author 211 website + a few additions from cora skidmore
 */
public class Queue {
  private Node head = null, tail = null;
  
  /**
   * Node Class, just the standard node setup
   */
  private class Node {
    public String data;
    public Node   next;
    public Node(String d, Node n) {
      data = d;
      next = n;
    }
  }
  /**
   * enqueue method adds a String to the queue
   * @param s String added to the queue
   */
  public void enqueue(String s) {
    if( head == null ) {
      head = tail = new Node(s, null);
    } else {
      tail.next = new Node(s, null);
      tail      = tail.next;
    }
  }

  /**
   * dequeue method removes one thing from the queue, will throw an exception if
   * there is nothing else to remove from the queue
   * @return The removed data member
   */
  public String dequeue() throws QueueException{
    
    Node t = head;
    if(head == null){
      throw new QueueException("dequeue empty queue");
    }
    head = head.next;
    if( head == null )
      tail = null;

    return t.data;
  }

  /**
   * Checks if the current queue is empty or not
   * @return true if nothing in queue, otherwise false
   */
  public boolean empty() {
    return head == null;
  }
  
  /**
   * toArray method takes a queue and returns an array with the same data in the
   * queue
   * @return String[] with data members from the queue
   */
  public String[] toArray() throws QueueException {
    // Assumes at least one node exists.
    // (a dumb way to do it, but don't change this).
    //
    if( head == null){
      throw new QueueException("toArray past end of queue");
    }
    Node t = head;
    int n = 1;
    while( t.next != null ) {
      t = t.next;
      n++;
    }
      
    // Create array and return it.
    String[] arr = new String[n];
    int i = 0;
    for( t = head; t != null; t = t.next )
      arr[i++] = t.data;
    return arr;
  }
}
