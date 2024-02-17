package ru.itsjava.collections.lists.linkedlist.HW_314;

public class MyLinkedListHW_314 {
    private NodeHW_314 head;

    public int size() {
        int count = 1;
        NodeHW_314 curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        NodeHW_314 curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
            if (o == curNode.getValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Object o) {
        NodeHW_314 resNode = new NodeHW_314(o, null);
        if (head == null) {
            head = resNode;
        } else {
            NodeHW_314 curNode = head;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(resNode);
        }
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public void clear() {

    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "MyLinkedListHW_314{" +
                "head=" + head +
                '}';
    }
}
