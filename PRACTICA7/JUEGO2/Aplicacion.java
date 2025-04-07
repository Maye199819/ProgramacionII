import java.util.Random;
import java.util.Scanner;

class Juego {
    protected int numeroDeVidas;
    protected int record;
    protected int vidasActuales;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        System.out.println("\nIniciando nueva partida...");
        this.vidasActuales = numeroDeVidas;
    }

    public void actualizaRecord() {
        if (this.vidasActuales > this.record) {
            this.record = this.vidasActuales;
            System.out.println("¡Nuevo récord!");
        }
    }

    public boolean quitaVida() {
        this.vidasActuales--;
        return this.vidasActuales > 0;
    }
}

class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = new Random().nextInt(11);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Adivina un número entre 0 y 10: ");
            int numero = sc.nextInt();

            if (!validaNumero(numero)) {
                System.out.println("Número inválido. Intenta otra vez.");
                continue;
            }

            if (numero == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                if (quitaVida()) {
                    String mensaje = numero < numeroAAdivinar ? "mayor" : "menor";
                    System.out.println("Fallaste. El número a adivinar es " + mensaje + ". Te quedan " + vidasActuales + " vidas.");
                } else {
                    System.out.println("Perdiste. El número era " + numeroAAdivinar);
                    break;
                }
            }
        }
        sc.close();
    }
}

class JuegoAdivinaPar extends JuegoAdivinaNumero {
    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (!(numero >= 0 && numero <= 10)) {
            System.out.println("Número fuera de rango (0-10).");
            return false;
        }
        if (numero % 2 != 0) {
            System.out.println("Error: El número no es par.");
            return false;
        }
        return true;
    }
}

class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (!(numero >= 0 && numero <= 10)) {
            System.out.println("Número fuera de rango (0-10).");
            return false;
        }
        if (numero % 2 == 0) {
            System.out.println("Error: El número no es impar.");
            return false;
        }
        return true;
    }
}

public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);

        System.out.println("\n--- Juego general ---");
        juego1.juega();

        System.out.println("\n--- Juego de pares ---");
        juego2.juega();

        System.out.println("\n--- Juego de impares ---");
        juego3.juega();
    }
}
