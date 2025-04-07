import random

class Juego:
    def __init__(self, numeroDeVidas):
        self.numeroDeVidas = numeroDeVidas
        self.record = 0

    def reiniciaPartida(self):
        print("\nIniciando nueva partida...")
        self.vidasActuales = self.numeroDeVidas

    def actualizaRecord(self):
        if self.vidasActuales > self.record:
            self.record = self.vidasActuales
            print("¡Nuevo record!")

    def quitaVida(self):
        self.vidasActuales -= 1
        return self.vidasActuales > 0

class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__(numeroDeVidas)
        self.numeroAAdivinar = 0

    def validaNumero(self, numero):
        return 0 <= numero <= 10

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        while True:
            try:
                numero = int(input("Adivina un numero entre 0 y 10: "))
                if not self.validaNumero(numero):
                    print("Numero inválido. Intenta otra vez.")
                    continue

                if numero == self.numeroAAdivinar:
                    print("¡Acertaste!")
                    self.actualizaRecord()
                    break
                else:
                    if self.quitaVida():
                        msg = "mayor" if numero < self.numeroAAdivinar else "menor"
                        print(f"Fallaste. El numero a adivinar es {msg}. Te quedan {self.vidasActuales} vidas.")
                    else:
                        print(f"Perdiste. El numero era {self.numeroAAdivinar}")
                        break
            except ValueError:
                print("Ingresa un número válido.")

class JuegoAdivinaPar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if not (0 <= numero <= 10):
            print("Numero fuera de rango (0-10).")
            return False
        if numero % 2 != 0:
            print("Error: El numero no es par.")
            return False
        return True

class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if not (0 <= numero <= 10):
            print("Numero fuera de rango (0-10).")
            return False
        if numero % 2 == 0:
            print("Error: El numero no es impar.")
            return False
        return True

# Aplicación
if __name__ == "__main__":
    juegos = [
        JuegoAdivinaNumero(3),
        JuegoAdivinaPar(3),
        JuegoAdivinaImpar(3)
    ]
    
    nombres = ["Juego general", "Juego de pares", "Juego de impares"]
    for juego, nombre in zip(juegos, nombres):
        print(f"\n--- {nombre} ---")
        juego.juega()
