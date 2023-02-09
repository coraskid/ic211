public class AcMid extends Mid {

  private String major;
  
  public AcMid(String name, String alpha, String major){
    super(name, alpha);
    this.major = major;
  }
  
  public String toString() {
    return super.toString() + " " + this.major;
  }


  public static void main(String[] args){
    AcMid m = new AcMid("Poe", "172234", "SCS");
    System.out.println(m.toString());


  }



}
