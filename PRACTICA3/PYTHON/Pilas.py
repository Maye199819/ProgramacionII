class Pila:
    def __init__(self):
        self.arreglo = []

    def push(self, e):
        self.arreglo.append(e)

    def pop(self):
        if not self.isEmpty():
            return self.arreglo.pop()
        else:
            print("Pila vacía")
            return None

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[-1]
        else:
            print("Pila vacía")
            return None

    def isEmpty(self):
        return len(self.arreglo) == 0

# Creación de pilas fuera de la clase
A = Pila()
A.push(13)
A.push(22)
A.push(7)

B = Pila()  # Pares
C = Pila()  # Impares

# Clasificación de números en B y C
while not A.isEmpty():
    e = A.pop()  # Extrae elemento
    if e % 2 == 0:
        B.push(e)
    else:
        C.push(e)

# Imprimir elementos de B
print("B....")
while not B.isEmpty():
    print(B.pop())

# Imprimir elementos de C
print("C....")
while not C.isEmpty():
    print(C.pop())
