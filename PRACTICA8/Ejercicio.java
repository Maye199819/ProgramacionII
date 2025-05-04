class A {
    public int x;
    public  int z;

    public A(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public void incrementaxz() {
        x += 1;
        z += 1;
    }

    public void incrementaz() {
        z += 1;
    }
}

class B {
    protected int y;
    protected int z;

    public B(int y, int z) {
        this.y = y;
        this.z = z;
    }

    public void incrementayz() {
        y += 1;
        z += 1;
    }

    public void incrementaz() {
        z += 1;
    }
}

class D extends A {
    private int y;

    public D(int x, int y, int z) {
        super(x, z);
        this.y = y;
    }

    public void incrementaxyz() {
        x += 1;
        y += 1;
        z += 1;
    }

    public void incrementayz() {
        y += 1;
        z += 1;
    }

    public void mostrar() {
        System.out.println("x:" + x + ", y:" + y + ", z:" + z);
    }
}

public class Main {
    public static void main(String[] args) {
        D objeto = new D(6, 5, 2);
        objeto.incrementaxyz();
        objeto.mostrar();
        objeto.incrementayz();
        objeto.mostrar();
    }
}
