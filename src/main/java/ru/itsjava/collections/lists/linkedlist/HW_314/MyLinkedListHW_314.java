package ru.itsjava.collections.lists.linkedlist.HW_314;

public class MyLinkedListHW_314 {
    private NodeHW_314 head;

    public int size() {
        if (head==null) {
            return 0;
        }
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
        if (head==null) {
            return false;
        }
        NodeHW_314 curNode = head;
        for (int i = 0; i < size(); i++) {
            if (o == curNode.getValue()) {
                return true;
            }
            curNode = curNode.getNext();
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
        if (head == null) {
            return false;
        }
        if (head.getValue().equals(o)) {
            head = head.getNext();
            return true;
        }
        if (head.getNext() == null) {
            return false;
        }
        NodeHW_314 curNode = head;
        NodeHW_314 prevNode = head;
        while ((curNode = curNode.getNext()) != null) {
            if (curNode.getValue().equals(o)) {
                break;
            }
            prevNode = prevNode.getNext();
        }
        if (curNode == null) {
            return false;
        }

        prevNode.setNext(curNode.getNext());
        curNode.setNext(null);
        return true;

    }

    public void clear() {

        head = null;
    }

    public Object get(int index) {
        checkIndex(index);
        NodeHW_314 resNode = head;
        for (int i = 0; i < size(); i++) {
            if (index == i) {
                return resNode.getValue();
            }
            resNode = resNode.getNext();
        }
        return null;
    }

    public Object set(int index, Object element) {
        checkIndex(index);
        NodeHW_314 resNode = head;
        for (int i = 0; i < size(); i++) {
            if (index == i) {
                resNode.setValue(element);
                return resNode.getValue();
            }
            resNode = resNode.getNext();
        }

        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        checkIndex(index);
        if (index == 0) {
            Object resValue = head.getValue();
            if (head.getNext() == null) {
                head = null;
            } else {
                head = head.getNext();
            }
            return resValue;
        }
        NodeHW_314 curNode = head;
        NodeHW_314 prevNode = head;
        int count = 0;
        while ((curNode = curNode.getNext()) != null) {
            count++;
            if (count == index) {
                break;
            }
            prevNode = prevNode.getNext();
        }
        Object resValue = curNode.getValue();
        if (curNode.getNext() == null) {
            prevNode.setNext(null);
        } else {
            prevNode.setNext(curNode.getNext());
            curNode.setNext(null);
        }
        return resValue;

    }

    public int indexOf(Object o) {
        NodeHW_314 resNode = head;
        for (int i = 0; i < size(); i++) {
            if (resNode.getValue().equals(o)) {
                return i;
            }
            resNode = resNode.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        NodeHW_314 resNode = head;
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (resNode.getValue().equals(o)) {
                count = i;
            }
            resNode = resNode.getNext();
        }
        if (resNode == null && count == 0) {
            return -1;
        }
        return count;
    }

    @Override
    public String toString() {
        return "MyLinkedListHW_314{" + "head=" + head + '}';
    }

    private void checkIndex(int index) {
        if (!isCorrectIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс");
        }
    }

    private boolean isCorrectIndex(int index) {
        if (index > -1 && index < size()) {
            return true;
        } else {
            return false;
        }
    }
}
