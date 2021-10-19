package iterator;

import java.util.Iterator;

public class ReverseStringIter implements Iterable<Character>{
    private final String data;
    public ReverseStringIter(String s) {
        this.data = s;
    }

    @Override
    public Iterator<Character> iterator() {
        return new MyIterator();
    }
    class MyIterator implements Iterator<Character> {
        private int indexFollower = data.length()-1;
        @Override
        public boolean hasNext() {
            return indexFollower != -1;
        }

        @Override
        public Character next() {
            Character ch = data.charAt(indexFollower);
            indexFollower--;
            return ch;
        }
    }

    public static void main(String[] args) {
        ReverseStringIter iter = new ReverseStringIter("Hello World");

        for(Character ch : iter) {
            if (ch == ' ')  {
                System.out.println();
                continue;
            }
            System.out.print(ch);
        }
    }
}
