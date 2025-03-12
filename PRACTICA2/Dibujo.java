public class Dibujo extends JPanel {
    private Linea linea;
    private Circulo circulo;

    public Dibujo(Linea linea, Circulo circulo) {
        this.linea = linea;
        this.circulo = circulo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        linea.dibujaLinea(g);
        circulo.dibujaCirculo(g);
    }
}
