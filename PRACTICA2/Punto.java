public class Punto {
    public float x, y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }
}
