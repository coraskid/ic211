public class ListStuff {
    
    public static StringNode addToFront(String s, StringNode Nold) {
        //Adds new node to the front of the linked list
        StringNode Nnew = new StringNode();
        Nnew.data = s;
        Nnew.next = Nold;
        return Nnew;
    }

    public static String[] listToArray(StringNode N) {
        //Turns linked list into array
        int size = length(N);
        String arr[] = new String[size];

        StringNode copy = N;
        for(int i=0; i<size; i++) {
            arr[i] = copy.data;
            copy = copy.next;
        }
        return arr;
    }

    public static int length(StringNode N) {
        //returns length of linked list
        StringNode copy = N;
        int count = 0;

        while(copy != null) {
            count++;
            copy = copy.next;
        }
        return count;
    }

    public static void main(String[] args) {
        //tests all functions in ListStuff.java
        StringNode N = null;      // at this point N *is* an empty list
        N = addToFront("rat",N);  // at this point N *is* the list ("rat")
        N = addToFront("dog",N);  // at this point N *is* the list ("dog","rat")
        N = addToFront("pig",N);  // at this point N *is* the list ("pig","dog","rat")
        String[] A = listToArray(N);
        for(int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        } 
    }
}
