
class Node<K extends Comparable, V>  {
    Node<K, V> left;
    Node<K, V> right;

    K key;
    V value;

    Node(K key, V value){
        this.key = key;
        this.value = value;
    }

}