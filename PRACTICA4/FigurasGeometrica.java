public class FigurasGeometrica {

    double area(double radio) { 
        return Math.PI * radio * radio; 
    }
    // Área de un rectángulo 
    double area(double base, double altura) { 
        return base * altura; 
    }

    // Área de un triángulo rectángulo 
    double area(double base, double altura, double divisor) { 
        return (base * altura) / divisor; 
    }

    // Área de un trapecio
    double area(double baseMayor, double baseMenor, double altura, double divisor) { 
        return ((baseMayor + baseMenor) / divisor) * altura; 
    }
    // Área de un pentágono 
    double area(double perimetro, double apotema, double lados, double extra, double divisor) { 
        return (perimetro * apotema) / divisor; 
    }
    
    public static void main(String[] args) {
        FigurasGeometrica figuras = new FigurasGeometrica();

        System.out.println("area del Circulo: " + figuras.area(5));              
        System.out.println("area del Rectangulo: " + figuras.area(4, 6));       
        System.out.println("area del Triangulo: " + figuras.area(4, 6, 2));      
        System.out.println("area del Trapecio: " + figuras.area(6, 4, 5, 2));    
        System.out.println("area del Pentagono: " + figuras.area(10, 5, 5, 0, 2)); 
    }
}
