//Cora Skidmore

public class Queue {
  

  public void enqueue(String s) {
    arr[tail] = s;
    tail++;
/**
    if( arr[head] == null ) {
      arr[tail] = s;
      tail++;
    } else {

      tail.next = new Node(s, null);
      tail      = tail.next;
    }
    */
  }

  public String dequeue() {
    String temp = arr[head];
    arr[head] = null;
    head++;
    /**
    Node t = head;
    head = head.next;

    if( head == null ) {
      tail = null;
    }
    */
    return temp;
  }

  public boolean empty() {
    return arr[head] == null;
  }

  public Iter iterator() {
    return new Iter(head, tail);
  }

  protected class Iter {
    private int curr;
    private int end;
    public Iter(int s, int e) {
      curr = s;
      end = e;
    }

    public boolean hasNext() {
      return curr != end;
    }

    public String next() {
      String s = arr[curr];
      curr++;
      return s;
    }
  }
  /**
  private class Node {
    public String data;
    public Node   next;
    public Node(String d, Node n) {
      data = d;
      next = n;
    }
  }
  */
  private String[] arr = new String[1024];
  private int head = 0, tail = 0;
}
