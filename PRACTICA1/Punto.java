public class Punto {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] coordCartesianas() {
        return new float[]{x, y};
    }

    public double[] coordPolares() {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[]{r, theta};
    }

    @Override
    public String toString() {
        return "Punto(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Punto p = new Punto(3, 4);
        System.out.println(p); // Punto(3.0, 4.0)
        System.out.println(java.util.Arrays.toString(p.coordCartesianas())); // [3.0, 4.0]
        System.out.println(java.util.Arrays.toString(p.coordPolares())); // [5.0, 0.93...]
    }
}
