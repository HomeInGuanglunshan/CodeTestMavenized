package getResourceTest;
public class TestMain {
    public static void main(String[] args) {
        TestMain t = new TestMain();
        System.out.println(t.getClass());
        System.out.println(t.getClass().getClassLoader());
        System.out.println(t.getClass().getClassLoader().getResource(""));
        System.out.println(t.getClass().getClassLoader().getResource("test.txt"));//null
    }
}