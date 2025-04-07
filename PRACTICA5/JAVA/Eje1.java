import java.util.Scanner;

public class EcuacionCuadratica {
    private double a, b, c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public Double getRaiz1() {
        double d = getDiscriminante();
        return d >= 0 ? (-b + Math.sqrt(d)) / (2 * a) : null;
    }

    public Double getRaiz2() {
        double d = getDiscriminante();
        return d >= 0 ? (-b - Math.sqrt(d)) / (2 * a) : null;
    }

    public void resolver() {
        double d = getDiscriminante();
        if (d > 0) {
            System.out.printf("La ecuación tiene dos raíces %.5f y %.5f%n", getRaiz1(), getRaiz2());
        } else if (d == 0) {
            System.out.printf("La ecuación tiene una raíz %.5f%n", -b / (2 * a));
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese a, b, c:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        ecuacion.resolver();
    }
}
