import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BinTree<K extends Comparable, V> implements Iterator<V>{

    private Node<K, V> root = null;
    private int lenght = 0;

    public void add(K key, V value){
        Node<K, V> currentBranch = root;
        Node<K, V> lastBranch = null;

        while (currentBranch != null) {
            int cmp = key.compareTo(currentBranch.key);
            if (cmp == 0) {
                currentBranch.value = value;
                return;
            }
            else {
                lastBranch = currentBranch;
                if (cmp < 0)
                    currentBranch = currentBranch.left;
                else
                    currentBranch = currentBranch.right;
            }
        }

        Node<K, V> newNode = new Node<K, V>(key, value);
        lenght ++;

        if (lastBranch == null)
            root = newNode;
        else {
            if (key.compareTo(lastBranch.key) < 0)
                lastBranch.left = newNode;
            else
                lastBranch.right = newNode;
        }
    }

    public V get(K key){
        Node<K, V> currentBranch = root;
        while (currentBranch != null){
            int cmp = key.compareTo(currentBranch.key);
            if (cmp == 0)
                return currentBranch.value;
            if (cmp < 0)
                currentBranch = currentBranch.left;
            else
                currentBranch = currentBranch.right;
        }
        return null;
    }

    public void remove(K key) {
        Node<K, V> currentBranch = root;
        Node<K, V> lastBranch = null;

        while (currentBranch != null) {
            int cmp = key.compareTo(currentBranch.key);
            if (cmp == 0)
                break;
            else {
                lastBranch = currentBranch;
                if (cmp < 0)
                    currentBranch = currentBranch.left;
                else
                    currentBranch = currentBranch.right;
            }
        }

        if (currentBranch == null)
            return;

        lenght--;
        if (currentBranch.right == null){
            if (lastBranch == null)
                root = currentBranch.left;
            else{
                if (currentBranch == lastBranch.left)
                    lastBranch.left = currentBranch.left;
                else
                    lastBranch.right = currentBranch.left;
            }
        }
        else {
            Node<K, V> leftMost = currentBranch.right;
            lastBranch = null;

            while (leftMost.left != null) {
                lastBranch = leftMost;
                leftMost = leftMost.left;
            }

            if (lastBranch != null)
                lastBranch.left = leftMost.right;
            else
                currentBranch.right = leftMost.right;

            currentBranch.key = leftMost.key;
            currentBranch.value = leftMost.value;
        }
    }

    public int getLenght(){
        return this.lenght;
    }

    @Override
    public boolean hasNext() {
        if (root != null)
            return true;
        return false;
    }

    @Override
    public V next() {
        if (!hasNext())
            throw new NoSuchElementException();

        lenght--;

        Node<K, V> currentBranch = root;
        Node<K, V> parentBranch = null;

        while (currentBranch.left != null || currentBranch.right != null){
            parentBranch = currentBranch;
            if (currentBranch.left != null)
                currentBranch = currentBranch.left;
            else
            if (currentBranch.right != null)
                currentBranch = currentBranch.right;
        }
        if (parentBranch != null) {
            if (parentBranch.left == currentBranch)
                parentBranch.left = null;
            else
                parentBranch.right = null;
            return currentBranch.value;
        }
        root = null;
        return currentBranch.value;
    }

    @Override
    public void remove() {
        next();
    }

    @Override
    public void forEachRemaining(Consumer<? super V> action) {

    }
}
