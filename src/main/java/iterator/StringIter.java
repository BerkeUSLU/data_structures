package iterator;

import java.util.Iterator;

public class StringIter implements Iterable<Character>{
    private final String data;
    public StringIter(String s) {
        this.data = s;
    }

    @Override
    public Iterator<Character> iterator() {
        return new MyIterator();
    }
    class MyIterator implements Iterator<Character> {
        private int indexFollower = 0;
        @Override
        public boolean hasNext() {
            return indexFollower != data.length();
        }

        @Override
        public Character next() {
            Character ch = data.charAt(indexFollower);
            indexFollower++;
            return ch;
        }
    }

    public static void main(String[] args) {
        StringIter iter = new StringIter("Hello World");

        for(Character ch : iter) {
            System.out.println(ch);
        }
    }
}
