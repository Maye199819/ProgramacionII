import java.util.Arrays;

public class AlgebraVectorial {
    private double[] v;

    public AlgebraVectorial(double[] v) {
        this.v = v;
    }

    public boolean perpendicular(AlgebraVectorial o) {
        Object resultado = this.productoPunto(o);
        if (resultado instanceof String) return false;
        return ((Double) resultado) == 0;
    }

    public Object productoPunto(AlgebraVectorial o) {
        if (this.v.length != o.v.length)
            return "Los vectores deben tener la misma longitud";
        double suma = 0;
        for (int i = 0; i < this.v.length; i++) {
            suma += this.v[i] * o.v[i];
        }
        return suma;
    }

    public Object paralela(AlgebraVectorial o) {
        if (this.v.length != 2 || o.v.length != 2)
            return "Definido solo para vectores de dimensión 2";
        Object cruzado = productoCruzado(o);
        return cruzado instanceof Double && ((Double) cruzado) == 0;
    }

    public Object productoCruzado(AlgebraVectorial o) {
        if (this.v.length != 2 || o.v.length != 2)
            return "Definido solo para vectores de dimensión 2";
        return this.v[0] * o.v[1] - this.v[1] * o.v[0];
    }

    public Object proyeccion(AlgebraVectorial o) {
        Object producto = productoPunto(o);
        Object modulo2 = o.productoPunto(o);

        if (producto instanceof String || modulo2 instanceof String)
            return "Los vectores deben tener la misma longitud";

        double denom = (Double) modulo2;
        if (denom == 0) return "No se puede proyectar sobre un vector nulo";

        double escala = (Double) producto / denom;
        double[] resultado = new double[o.v.length];
        for (int i = 0; i < o.v.length; i++) {
            resultado[i] = escala * o.v[i];
        }
        return resultado;
    }

    public Object componente(AlgebraVectorial o) {
        Object producto = productoPunto(o);
        Object norma = o.productoPunto(o);

        if (producto instanceof String || norma instanceof String)
            return "Los vectores deben tener la misma longitud";

        double normaReal = Math.sqrt((Double) norma);
        if (normaReal == 0) return "No se puede calcular la componente sobre un vector nulo";

        return (Double) producto / normaReal;
    }

    @Override
    public String toString() {
        return Arrays.toString(v);
    }

    // Test
    public static void main(String[] args) {
        double[] v1 = {3.2, 5.0};
        double[] v2 = {7.3, -1.6};
        AlgebraVectorial vector1 = new AlgebraVectorial(v1);
        AlgebraVectorial vector2 = new AlgebraVectorial(v2);

        System.out.println("Son perpendiculares: " + vector1.perpendicular(vector2));
        System.out.println("Son paralelos: " + vector1.paralela(vector2));
        System.out.println("Proyección de v1 sobre v2: " + Arrays.toString((double[]) vector1.proyeccion(vector2)));
        System.out.println("Componente de v1 en la dirección de v2: " + vector1.componente(vector2));
    }
}
