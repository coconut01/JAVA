package src.ch01;

public class Demo {
    public static void main(String[] args) {
        int data = 279;
        int d1 = data / 100; // 2
        System.out.println(d1);
        int d2 = data % (100 / 10); // 7
        System.out.println(d2);
        int d3 = data % 10; // 9
        System.out.println(d3);
        int s = d1 + d2 + d3;
        System.out.println("" + s);
    }
}
