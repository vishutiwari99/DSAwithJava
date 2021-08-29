package linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int val) {
            this.value = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.value;
        }
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = tail = null;
        } else {
            var prev = getPrevious(tail);
            tail = prev;
            tail.next = null;
        }

        size--;
    }

    public Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;

    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
        } else {
            var tmp = head.next;
            head.next = null;
            head = tmp;
        }
        size--;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = head;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;

    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = head;
        int i = 0;
        while (current != null) {
            array[i] = current.value;
            i++;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        var previous = head;
        var current = previous.next;
        while (current != null) {
            var tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        tail = head;
        tail.next = null;
        head = previous;
    }

    public int findKNode(int val) {
        var a = head;
        var b = head;
        for (int i = 0; i < val - 1; i++) {
            b = b.next;
            if (b == null) {
                throw new IllegalStateException();
            }
        }
        while (b != tail) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        var a = head;
        var b = head;
        while (b != tail && b.next != tail) {
            b = b.next.next;
            a = a.next;
        }
        if (b == tail) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + " " + a.next.value);
        }

    }

    public void createLoop(int k) {
        var temp = head;
        int i = 1;
        while (i < k) {
            temp = temp.next;
            i++;
        }
        var joint = temp;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = joint;
    }

    public void removeDuplicates() {
        var res = new LinkedList();
        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();
            if (res.size() == 0 || res.tail.value != val) {
                res.addLast(val);
            }
        }
        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    private static LinkedList mergeTwoSortedList(LinkedList fsh, LinkedList ssh) {
        var first = fsh.head;
        var second = ssh.head;
        LinkedList res = new LinkedList();
        while (first != null && second != null) {
            if (first.value < second.value) {
                res.addLast(first.value);
                first = first.next;
            } else {
                res.addLast(second.value);
                second = second.next;
            }
        }
        while (first != null) {
            res.addLast(first.value);
            first = first.next;
        }
        while (second != null) {
            res.addLast(second.value);
            second = second.next;
        }
        return res;
    }

    private static Node getMidNode(Node head, Node tail) {
        var a = head;
        var b = head;
        while (b != tail && b.next != tail) {
            b = b.next.next;
            a = a.next;
        }
        return a;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedList br = new LinkedList();
            br.addLast(head.value);
            return br;
        }
        var mid = getMidNode(head, tail);
        var fsh = mergeSort(head, mid);
        var ssh = mergeSort(mid.next, tail);
        var cl = mergeTwoSortedList(fsh, ssh);
        return cl;
    }

    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(50);
        list.addLast(20);
        list.addLast(5);
        list.addLast(2);
        list.addLast(15);
        // LinkedList res = mergeSort(list.head, list.tail);
        int[] ans = list.toArray();
        System.out.println(Arrays.toString(ans));
        list.removeDuplicates();
        int[] result = list.toArray();
        System.out.println(Arrays.toString(result));

        // list.createLoop(3);
        // int res = list.findKNode(2);
        // System.out.println(res);
        // list.printMiddle();

        // list.reverse();

        // int[] a = list.toArray();
        // System.out.println(Arrays.toString(a));
        // System.out.println(list.size());
        // list.removeFirst();
        // list.removeLast();
        // list.addFirst(5);
        // System.out.println(list.contains(40));
    }

}