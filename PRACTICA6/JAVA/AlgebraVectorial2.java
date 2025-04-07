public class Vector {
    private double x, y, z;

    // Constructor
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Constructor por defecto
    public Vector() {
        this(0, 0, 0);
    }

    // Suma de vectores
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Multiplicación por escalar o producto punto
    public Object multiply(Object other) {
        if (other instanceof Number) {
            double scalar = ((Number) other).doubleValue();
            return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
        } else if (other instanceof Vector) {
            Vector v = (Vector) other;
            double dotProduct = this.x * v.x + this.y * v.y + this.z * v.z;
            return dotProduct == 0 ? "Un vector ortogonal" : dotProduct;
        }
        return null;
    }

    // Producto cruzado
    public Vector cross(Vector other) {
        return new Vector(
            this.y * other.z - this.z * other.y,
            this.z * other.x - this.x * other.z,
            this.x * other.y - this.y * other.x
        );
    }

    // Longitud del vector
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // Normalizar
    public Vector normalize() {
        double len = length();
        return len == 0 ? new Vector() : new Vector(this.x / len, this.y / len, this.z / len);
    }

    @Override
    public String toString() {
        return String.format("(x=%.2f, y=%.2f, z=%.2f)", x, y, z);
    }

    // Test
    public static void main(String[] args) {
        Vector v1 = new Vector(5, 4, 2);
        Vector v2 = new Vector(-2, 3, -1);

        System.out.println(v1);
        System.out.println(v2);

        Vector v3 = v1.add(v2);
        System.out.println("El vector suma es " + v3);

        Vector v4 = (Vector) v1.multiply(3);
        System.out.println("El vector multiplicado por escalar es " + v4);
    }
}
