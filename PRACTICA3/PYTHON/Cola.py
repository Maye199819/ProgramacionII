class Cola:
    def __init__(self, n):
        self.arreglo = [0] * n
        self.inicio = 0
        self.fin = -1
        self.n = n
        self.cantidad = 0

    def insert(self, e):
        if not self.isFull():
            self.fin = (self.fin + 1) % self.n
            self.arreglo[self.fin] = e
            self.cantidad += 1
        else:
            raise OverflowError("La cola está llena")

    def remove(self):
        if not self.isEmpty():
            elemento = self.arreglo[self.inicio]
            self.inicio = (self.inicio + 1) % self.n
            self.cantidad -= 1
            return elemento
        raise IndexError("La cola está vacía")

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.inicio]
        raise IndexError("La cola está vacía")

    def isEmpty(self):
        return self.cantidad == 0

    def isFull(self):
        return self.cantidad == self.n

    def size(self):
        return self.cantidad


# Ejemplo de uso
cola = Cola(5)
cola.insert(10)
cola.insert(20)
print(cola.remove())  # 10
print(cola.peek())    # 20
