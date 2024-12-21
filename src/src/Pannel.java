import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {
    private final Graph graph;

    public Pannel(Graph graph) {
        this.graph = graph;
    }

    public void updateEdgeColor(Character from, Character to, Color color, int thickness) {
        for (Edge edge : graph.edges) {
            if (edge.in.equals(from) && edge.out.equals(to)) {
                edge.color = color;
                edge.stroke = thickness;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Edge edge : graph.edges) {
            g.setColor(edge.color);
            ((Graphics2D) g).setStroke(new BasicStroke(edge.stroke));
            Point from = graph.get_point(edge.in);
            Point to = graph.get_point(edge.out);
            g.drawLine(from.x, from.y, to.x, to.y);
            g.setColor(Color.BLACK);

            int midX = (from.x + to.x) / 2;
            int midY = (from.y + to.y) / 2;

            g.drawString(String.valueOf(edge.value), midX, midY);
        }

        for (Point point : graph.points) {
            g.setColor(Color.BLACK);
            g.fillOval(point.x - 5, point.y - 5, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(point.id), point.x + 10, point.y);
        }
    }
}
