import java.awt.*;
import java.util.*;
import java.util.List;

public class Graph {
    public List<Point> points;
    public List<Edge> edges;

    public Graph() {
        points = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void add_point(int x, int y, Character id) {
        points.add(new Point(x, y, id));
    }

    public void add_edge(Character in, Character out, int value) {
        edges.add(new Edge(in, out, value));
    }

    public Point get_point(Character id) {
        for (Point point : points) {
            if (point.id.equals(id)) {
                return point;
            }
        }
        return null;
    }

    public List<Edge> get_edges_from(Character node) {
        List<Edge> connectedEdges = new ArrayList<>();
        for (Edge edge: edges) {
            if (edge.in.equals(node)) {
                connectedEdges.add(edge);
            }
        }
        return connectedEdges;
    }

    public List<Character> dijkstra(Character start, Character end, Pannel panel) throws InterruptedException {
        Map<Character, Integer> distances = new HashMap<>();
        Map<Character, Character> previous = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Point point : points) {
            distances.put(point.id, Integer.MAX_VALUE);
            previous.put(point.id, null);
        }

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Character current = queue.poll();

            panel.repaint();
            Thread.sleep(300);

            if (current.equals(end)) break;

            for (Edge edge : get_edges_from(current)) {
                int newDist = distances.get(current) + edge.value;

                panel.updateEdgeColor(edge.in, edge.out, Color.ORANGE, 2);
                panel.repaint();
                Thread.sleep(300);

                if (newDist < distances.get(edge.out)) {
                    distances.put(edge.out, newDist);
                    previous.put(edge.out, current);

                    panel.updateEdgeColor(edge.in, edge.out, Color.ORANGE, 2);
                    queue.add(edge.out);
                } else {
                    panel.updateEdgeColor(edge.in, edge.out, Color.RED, 2);
                }

                panel.repaint();
            }
        }

        List<Character> path = new ArrayList<>();
        for (Character at = end; at != null; at = previous.get(at)) {
            path.add(0, at); // Add nodes to the path in reverse order
        }

        for (Edge edge : edges) {
            panel.updateEdgeColor(edge.in, edge.out, Color.BLACK, 1);
        }
        for (int i = 0; i < path.size() - 1; i++) {
            Character from = path.get(i);
            Character to = path.get(i + 1);

            panel.updateEdgeColor(from, to, Color.GREEN, 4);
            panel.repaint();
            Thread.sleep(300);
        }

        return path.getFirst().equals(start) ? path : new ArrayList<>();
    }



}



