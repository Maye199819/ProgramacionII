public class Cola {
    private long[] arreglo;
    private int inicio;
    private int fin;
    private int n;
    private int cantidad;

    public Cola(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.inicio = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

    public void insert(long e) {
        if (!isFull()) {
            fin = (fin + 1) % n;
            arreglo[fin] = e;
            cantidad++;
        } else {
            throw new RuntimeException("La cola está llena");
        }
    }

    public long remove() {
        if (!isEmpty()) {
            long elemento = arreglo[inicio];
            inicio = (inicio + 1) % n;
            cantidad--;
            return elemento;
        }
        throw new RuntimeException("La cola está vacía");
    }

    public long peek() {
        if (!isEmpty()) {
            return arreglo[inicio];
        }
        throw new RuntimeException("La cola está vacía");
    }

    public boolean isEmpty() {
        return cantidad == 0;
    }

    public boolean isFull() {
        return cantidad == n;
    }

    public int size() {
        return cantidad;
    }

    public static void main(String[] args) {
        Cola cola = new Cola(5);
        cola.insert(10);
        cola.insert(20);
        cola.insert(30);

        System.out.println("Elemento eliminado: " + cola.remove()); // 10
        System.out.println("Primer elemento en la cola: " + cola.peek()); // 20
        System.out.println("Tamaño de la cola: " + cola.size()); // 2

        cola.insert(40);
        cola.insert(50);
        cola.insert(60); // Aquí debería llenarse la cola

        System.out.println("Elemento eliminado: " + cola.remove()); // 20
        System.out.println("Primer elemento en la cola: " + cola.peek()); // 30
        System.out.println("Tamaño de la cola: " + cola.size()); // 3
    }
}
