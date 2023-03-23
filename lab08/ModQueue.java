/**
 * ModQueue adds some extra features to Queue class
 * @author Cora Skidmore
 */
public class ModQueue extends Queue {
  
  /**
   * This dequeue method takes data off the queue until String s is reached,
   * otherwise it will just take off all data members of the queue
   * @param s String it is looking for while dequeueing data members
   */
  public void dequeue(String s){
    String top;
    do{
      top = this.dequeue();
    } while(!top.equals(s));
  }
  
  /**
   * This dump method turns the queue into a string, with comma seperating each
   * data member
   * @return String representation of all memebrs currently in the queue
   */
  public String dump() {
    //turn queue into array
    String[] arr = super.toArray();
    //Turn the array into a string
    String d = arr[0]; 
    for(int i = 1; i < arr.length; i++){
      d = d.concat(",");
      d = d.concat(arr[i]);
    }
    return d;
  }

  /**
   * This enqueue method adds a little extra functionality to Queue class'
   * enqueue, by only adding the String if its not in the queue already
   * @param s String the user wants to add to the queue
   */
  public void enqueue(String s){
    //if the queue is empty, just add the String
    if(this.empty()){
      super.enqueue(s);
      return;
    }
    //check if s equals anything in current array
    String[] arr = super.toArray();
    for(int i = 0; i < arr.length; i++){
      if(arr[i].equals(s))
        return;
    }
    super.enqueue(s);
  }
}
