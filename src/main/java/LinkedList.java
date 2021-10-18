import java.lang.reflect.Array;
import exception.*;

public class LinkedList<T> {
    private Node<T> head = null;

    public void append(T val) {
        if (head == null) {
            head = new Node<>(val);
        } else {
            Node<T> cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            Node<T> newNode = new Node<>(val);
            cur.setNext(newNode);
        }
    }


    public int size() {
        int sizeCounter = 0;
        if (head == null) {
            return sizeCounter;
        } else {
            Node<T> cur = head;
            while (cur != null) {
                sizeCounter++;
                cur = cur.getNext();
            }
            return sizeCounter;
        }
    }


    public T get(int index) {
        return getNode(index).getData();
    }

    // ListIsEmptyException eklendi!
    public Node<T> getNode(int index) throws ListIsEmptyException {
        // Ayrıca index size'dan büyükse outofbounds atsın ekledim!
        if (head == null) {
            throw new ListIsEmptyException();

        } else if (index >= size()) {
            throw new ListIndexOutOfBoundsException();
        }
        int sizeCounter = 0;
        Node<T> cur = head;
        while (cur.getNext() != null && sizeCounter < index) {
            sizeCounter++;
            cur = cur.getNext();
        }
        //TODO: throw exception if index exceed the size of list
        return cur;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public boolean contains(T val) {
        if (head == null) {
            return false;
        }
        Node<T> cur = head;
        while (cur != null) {
            if (cur.getData().equals(val)) {//TODO: referans türleri == operatörü ile karşılaştırılamaz ne yapmalıyız.
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }


    public void remove(int index) throws ListIndexOutOfBoundsException {
        if (index >= size()) {
            throw new ListIndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
        } else if (index == size() - 1) {
            getNode(index - 1).setNext(null);
        } else {
            Node<T> targetNode = getNode(index);
            Node<T> nextNodeOfTarget = targetNode.getNext();
            Node<T> previousTargetNode = getNode(index - 1);
            previousTargetNode.setNext(nextNodeOfTarget);

        }
    }


    public void set(int index, T val) {
        Node<T> setter = getNode(index);
        if (setter != null) {
            setter.setData(val);
        }
    }


    public T[] toArray(Class<T> clazz) {
        int sizeOfArray = size();
        T[] tempArray =  (T[])Array.newInstance(clazz, sizeOfArray);
        for (int i = 0; i < sizeOfArray; i++) {
            tempArray[i] = get(i);
        }
        return tempArray;
    }


    public void clear() {
        Node<T> cur = head;
        Node<T> next = head.getNext();
        while (next != null) {
            cur = null;
            cur = next;
            next = cur.getNext();
        }
        head = null;
    }



    public String toString() {
        //String result = "";
        StringBuilder result = new StringBuilder();
        Node<T> cur = head;
        while (cur.getNext() != null) {
            result.append(cur).append("---");
            //result += cur + "---";
            cur = cur.getNext();
        }
        //result += cur;
        result.append(cur);
        return result.toString();
    }


    static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> newNode) {
            this.next = newNode;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String toString() {
            return "" + getData();
        }
    }
}