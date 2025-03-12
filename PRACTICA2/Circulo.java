public class Circulo {
    private Punto centro;
    private float radio;

    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public void dibujaCirculo(Graphics g) {
        g.drawOval((int) (centro.x - radio), (int) (centro.y - radio), (int) (2 * radio), (int) (2 * radio));
    }

    @Override
    public String toString() {
        return "Circulo: centro " + centro + ", radio " + String.format("%.2f", radio);
    }
}
