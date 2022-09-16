package heap;

public class Tester {
    public static void main(String [] args){
        int [] a = {50, 4, 3, 25, 1, 60};

        Heap test = new Heap(a, a.length);
        test.buildMaxHeap();
        System.out.println(test.right(2));

        System.out.println(test);

    }
}
