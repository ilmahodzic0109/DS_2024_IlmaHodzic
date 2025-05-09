package org.example.week1;

public class Main {

    public static void main(String[] args) {
        linkedListDemo();
    }

    private static void linkedListDemo() {
        System.out.println("Linked list demo:");
        LinkedList<Integer> list = new LinkedList<>();

        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addToRear(4);
        list.addToFront(5);
        list.addToFront(6);

        list.removeFromRear();
        list.removeFromFront();

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("element: " + list.get(0));
        System.out.println("element: " + list.get(2));
        System.out.println("list size: " + list.count());

        System.out.println("Reversing the list:");
        list.reverse();
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}
