public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dibujo de Línea y Círculo");

            // Crear puntos, línea y círculo
            Punto p1 = new Punto(50, 50);
            Punto p2 = new Punto(200, 200);
            Linea linea = new Linea(p1, p2);
            Circulo circulo = new Circulo(new Punto(150, 150), 50);

            // Crear y agregar el panel de dibujo
            Dibujo dibujo = new Dibujo(linea, circulo);
            frame.add(dibujo);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
