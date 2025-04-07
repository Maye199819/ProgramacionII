import random

class Juego:
    def __init__(self):
        self.numero_de_vidas = 3
        self.record = 0

    def reinicia_partida(self):
        self.numero_de_vidas = 3  # puedes ajustar el número inicial aquí

    def actualiza_record(self):
        self.record += 1
        print(f"¡Nuevo récord actualizado! Total: {self.record}")

    def quita_vida(self):
        self.numero_de_vidas -= 1
        print(f"Te quedan {self.numero_de_vidas} vidas.")
        return self.numero_de_vidas > 0


class JuegoAdivinaNumero(Juego):
    def __init__(self, vidas):
        super().__init__()
        self.numero_de_vidas = vidas
        self.numero_a_adivinar = 0

    def juega(self):
        self.reinicia_partida()
        self.numero_a_adivinar = random.randint(0, 10)

        print("Adivina un número entre 0 y 10:")

        while True:
            try:
                intento = int(input())

                if intento == self.numero_a_adivinar:
                    print("¡Acertaste!")
                    self.actualiza_record()
                    break
                else:
                    if self.quita_vida():
                        if intento < self.numero_a_adivinar:
                            print("El número a adivinar es mayor.")
                        else:
                            print("El número a adivinar es menor.")
                        print("Intenta de nuevo:")
                    else:
                        print(f"¡Te quedaste sin vidas! El número era: {self.numero_a_adivinar}")
                        break
            except ValueError:
                print("Por favor, ingresa un número válido.")


if __name__ == "__main__":
    juego = JuegoAdivinaNumero(3)
    juego.juega()
