import java.util.ArrayList;
import java.util.List;

 class Node {
    String state;
    List<Integer> years = new ArrayList<Integer>();
    double averageRate;
    Node left, right;

    public Node(String country, List<Integer> pop, double average) {
        state = country;
        for (int i = 0; i < pop.size(); i++) {
            years.add(pop.get(i));
        }
        averageRate = average;
        left = right = null;
    }

}
