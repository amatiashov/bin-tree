import java.util.List;

public class Main {
    public static void main(String... args){
        BinTree<Integer, String> binTree = new BinTree<>();

        binTree.add(78, "S1");
        binTree.add(30, "S5");
        binTree.add(10, "S2");
        binTree.add(13, "S3");
        binTree.add(56, "S4");
        binTree.add(33, "S6");

        List<String> allTree = binTree.walk();
        System.out.println("All elements in tree: " + allTree);

        System.out.println("get for key 78: " + binTree.get(78));
        System.out.println("remove for key 78");
        binTree.remove(78);
        System.out.println("get for key 78: " + binTree.get(78));

        String minValue = binTree.getMin();
        String maxValue = binTree.getMax();

        System.out.println("Min value in tree: " + minValue);
        System.out.println("Max value in tree: " + maxValue);

        System.out.println("While: ");
        while (binTree.hasNext())
            System.out.println("--> " + binTree.next() + " remainder elements: " + binTree.getLenght());
    }
}
