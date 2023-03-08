import java.util.*;
import java.io.*;

public class Lab08 {

  public static void main(String[] args) {
    boolean v = false;
    boolean f = false;
    String filen = null;
    //System.out.println(args[0]);
    if(args.length > 2){
      System.out.println("Usage: java Lab08 (-v) (file.txt)");
      return;
    }
    for(int i = 0; i < args.length; i++){
      if(args[i].equals("-v"))
        v = true;
      else{
        f = true;
        filen = args[i];
      }
    }

    Scanner sc = null;
    if(f){
      try{
        sc = new Scanner(new FileReader(filen));
      } catch(IOException e){
        System.out.println("File '" + filen + "' could not be opened; switching input to standard in.");
      }
    }
    if(sc == null){
      sc = new Scanner(System.in);
      f = false;
    }
    
    ModQueue Q  = new ModQueue();

    do {
      if(!f)
        System.out.print("> ");
      String cmd;
      try{
        cmd = sc.next();
      } catch(NoSuchElementException nsee){
        System.out.print("\n");
        break;
      }
      try{
      if( cmd.equals("quit") ) {
        break;
      } else if( cmd.equals("clearto") ) {
        String next = sc.next();
        try{
          Q.dequeue(next);
        } catch(QueueException qe) {
          if(v)
            System.out.println("String '" + next + "' not found!");
        }
      } else if( cmd.equals("add") )   {
        String next;
          next = sc.next();
          Q.enqueue(next);
      } else if( cmd.equals("dump") )   {
        try{
          System.out.println(Q.dump());
        } catch(QueueException qe){
        }
      } else {
        //throw new QueueException("Unknown command '" + cmd + "'.");
        if(v)
          System.out.println("Unknown command '" + cmd + "'.");
      } 
      } catch(NoSuchElementException nsee){
          System.out.println("Unexpected end of input.");
          break;
      }
      /*} catch(QueueException qe){
      qe.getMessage();
      
      if(v && cmd.equals("clearto")){
        //System.out.println(qe.getCause());
        System.out.println("String '" + cmd + "' not found");
      }*/
    
    } while( true );
  }
}
