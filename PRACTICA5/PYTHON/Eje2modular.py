import math

def promedio(numeros):
    return sum(numeros) / len(numeros)

def desviacion(numeros):
    prom = promedio(numeros)
    return math.sqrt(sum((x - prom) ** 2 for x in numeros) / (len(numeros) - 1))


numeros = list(map(float, input("Ingrese 10 números separados por espacio: ").split()))

print(f"El promedio es {promedio(numeros):.2f}")
print(f"La desviación estándar es {desviacion(numeros):.5f}")
