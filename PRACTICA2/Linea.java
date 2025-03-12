import java.awt.Graphics;

public class Linea {
    private Punto p1;
    private Punto p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void dibujaLinea(Graphics g) {
        g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
    }

    @Override
    public String toString() {
        return "Linea: " + p1 + " - " + p2;
    }
}

