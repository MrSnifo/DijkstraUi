import java.awt.*;

public class Edge {
    public Character in;
    public Character out;
    public int value;
    public Color color;
    public int stroke;

    public Edge(Character in, Character out, int value, Color color, int stroke) {
        this.in = in;
        this.out = out;
        this.value = value;
        this.color = color;
        this.stroke = stroke;
    }

    public Edge(Character in, Character out, int value) {
        this(in, out, value, Color.BLACK, 3);
    }
}
