public class Fruit {
  public static void main(String[] args) {
    Apple v1 = new Apple();
    Apple v2 = new Jazz();
    Jazz  v3 = new Jazz();

    // <--- right here!
    System.out.println(v3.foo());
    System.out.println(v3.foo('x'));
    System.out.println(v3.foo(7));
    System.out.println(Jazz.bar(v3));
  }
}
