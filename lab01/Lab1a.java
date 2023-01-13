public class Lab1a {
  public static void main(String[] args){
    int[] x = new int[10];
    int k = 0;
    for(int j = 0; j < 10; j++){
      x[j] = j*j;
    }
    for(int i = 0; i < 10; i++){
      System.out.println(i + " squared is " + x[i]);
    }
  }
}
