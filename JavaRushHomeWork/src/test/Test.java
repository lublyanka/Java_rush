package test;

/**
 * Created with IntelliJ IDEA.
 * User: RedCat
 * Date: 26.08.13
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
    void test() {
        Test:{
            test:
            for (int i = 0; true; i++) {
               // if (i % 2 == 0) continue Test;
                if (i > 10) break Test;
                System.out.print(i);
            }
        }
    }
}
