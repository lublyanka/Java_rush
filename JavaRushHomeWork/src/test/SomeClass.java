package test;

public class SomeClass {
    public static void main(String[] args) {
        SomeClass c = new SomeClass();
        c.f1(' ', 'h');
    }
    public void f1(byte b, char c) {
        System.out.println("1");
    }
    public void f1(byte b, byte c) {
        System.out.println("2");
    }
    public void f1(char b, char c) {
        System.out.println("3");
    }
    public void f1(char b, byte c) {
        System.out.println("4");
    }
}

