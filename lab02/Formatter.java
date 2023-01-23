public class Formatter {
    public static void writeInColumns(String[] A, int cols) {
        //takes in an array of strings and a number of columns and formats the
        //text in that size
        for(int i=0; i<A.length; i++) {
            int cnt = 1;
            String s = A[i];
            while((i+cnt < A.length) && (s.length() + A[i+cnt].length() < cols)) {
                s = s + ' ' + A[i+cnt];
                cnt++;
            }
            System.out.println(s);
            i+=cnt-1;
        }
    }

    public static void main(String[] args) {
        String[] A = new String[8];
        A[0] = "these";
        A[1] = "are";
        A[2] = "the";
        A[3] = "times";
        A[4] = "that";
        A[5] = "try";
        A[6] = "men's";
        A[7] = "souls";
        writeInColumns(A, 10);
    }
}
