import math

class Estadisticas:
    def __init__(self, numeros):
        self.numeros = numeros

    def promedio(self):
        return sum(self.numeros) / len(self.numeros)

    def desviacion(self):
        prom = self.promedio()
        return math.sqrt(sum((x - prom) ** 2 for x in self.numeros) / (len(self.numeros) - 1))

numeros = list(map(float, input("Ingrese 10 números separados por espacio: ").split()))

estadisticas = Estadisticas(numeros)
print(f"El promedio es {estadisticas.promedio():.2f}")
print(f"La desviación estándar es {estadisticas.desviacion():.5f}")
