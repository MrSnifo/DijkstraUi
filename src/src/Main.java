import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Graph graph = new Graph();

        // Add points
        graph.add_point(100, 50, 'A');
        graph.add_point(200, 50, 'B');
        graph.add_point(100, 150, 'C');
        graph.add_point(150, 100, 'D');
        graph.add_point(300, 50, 'E');
        graph.add_point(200, 150, 'F');
        graph.add_point(300, 150, 'G');

        // Add edges
        graph.add_edge('A', 'B', 4);
        graph.add_edge('A', 'C', 8);
        graph.add_edge('B', 'E', 21);
        graph.add_edge('B', 'D', 17);
        graph.add_edge('E', 'G', 17);
        graph.add_edge('C', 'D', 10);
        graph.add_edge('D', 'E', 12);
        graph.add_edge('D', 'G', 31);
        graph.add_edge('E', 'F', 10);
        graph.add_edge('D', 'F', 12);
        graph.add_edge('C', 'F', 25);
        graph.add_edge('F', 'G', 7);

        JFrame frame = new JFrame("Graph Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        Pannel panel = new Pannel(graph);
        frame.add(panel);
        frame.setVisible(true);

        List<Character> shortestPath = graph.dijkstra('A', 'G', panel);
        System.out.println("Shortest path: " + shortestPath);
    }
}
