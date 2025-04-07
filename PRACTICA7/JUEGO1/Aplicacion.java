import java.util.Scanner;
import java.util.Random;

class Juego {
    protected int numeroDeVidas;
    protected int record;

    public void reiniciaPartida() {
        numeroDeVidas = 3; // puedes ajustar el número inicial aquí
    }

    public void actualizaRecord() {
        record++;
        System.out.println("¡Nuevo récord actualizado! Total: " + record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        System.out.println("Te quedan " + numeroDeVidas + " vidas.");
        return numeroDeVidas > 0;
    }
}

class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int vidas) {
        this.numeroDeVidas = vidas;
        this.record = 0;
    }

    public void juega() {
        reiniciaPartida();
        Random rand = new Random();
        numeroAAdivinar = rand.nextInt(11); // número entre 0 y 10

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adivina un número entre 0 y 10:");

        while (true) {
            int intento = scanner.nextInt();

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                if (quitaVida()) {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número a adivinar es mayor.");
                    } else {
                        System.out.println("El número a adivinar es menor.");
                    }
                    System.out.println("Intenta de nuevo:");
                } else {
                    System.out.println("¡Te quedaste sin vidas! El número era: " + numeroAAdivinar);
                    break;
                }
            }
        }
    }
}

public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        juego.juega();
    }
}
