
public class Queue {

  private Node front, back;
  
  /**
   * adds s to the back of the queue
   */
  public void enqueue(String s) {
    Node n = new Node(s, null);
    if( front == null )
      front = back = n;
    else {
      back.next = n;
      back = n;
    }
  }

  /**
   * removes and returns string from the front of the queue
   */
  public String dequeue() {
    if( front == null )
      return null;
    String str = front.data;
    front = front.next;
    return str;
  }


  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return front == null;
  }


  private class Node {
    public String data;
    public Node next;
    public Node(String d, Node n) {
      data = d;
      next = n;
    }
  }

}
