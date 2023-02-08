public class Mid {
  private String last;
  private String alpha;

  public Mid(String ln, String al) {
    last = ln;
    alpha = al;
  }
  public String toString() {
    return alpha + " " + last;
  }
  public String getAlpha() {
    return alpha;
  }
  public String getLast() {
    return last;
  }
}
