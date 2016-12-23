
public class Main {
    public static void main(String... args){
        BinTree<Integer, String> binTree = new BinTree<>();

        binTree.add(78, "S1");
        binTree.add(34, "S2");
        binTree.add(13, "S3");
        binTree.add(56, "S4");
        binTree.add(90, "S5");
        binTree.add(33, "S6");

        System.out.println("get for key 78: " + binTree.get(78));
        System.out.println("remove for key 78");
        binTree.remove(78);
        System.out.println("get for key 78: " + binTree.get(78));

        System.out.println("While: ");
        while (binTree.hasNext())
            System.out.println("--> " + binTree.next() + " remainder elements: " + binTree.getLenght());
    }
}
