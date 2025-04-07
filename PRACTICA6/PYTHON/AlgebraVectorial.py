import math

class AlgebraVectorial:
    def __init__(self, v=None):
        self.v = v if v else []

    def perpendicular(self, o):
        return self.producto_punto(o) == 0

    def producto_punto(self, o):
        if len(self.v) != len(o.v):
            return "Los vectores deben tener la misma longitud"
        return sum(self.v[i] * o.v[i] for i in range(len(self.v)))

    def paralela(self, o):
        if len(self.v) != 2 or len(o.v) != 2:
            return "Definido solo para vectores de dimensión 2"
        return self.producto_cruzado(o) == 0

    def producto_cruzado(self, o):
        if len(self.v) != 2 or len(o.v) != 2:
            return "Definido solo para vectores de dimensión 2"
        return self.v[0] * o.v[1] - self.v[1] * o.v[0]

    def proyeccion(self, o):
        producto_punto = self.producto_punto(o)
        modulo_cuadrado = o.producto_punto(o)
        if modulo_cuadrado == 0:
            return "No se puede proyectar sobre un vector nulo"
        escala = producto_punto / modulo_cuadrado
        return [escala * x for x in o.v]

    def componente(self, o):
        producto_punto = self.producto_punto(o)
        norma_o = math.sqrt(o.producto_punto(o))
        if norma_o == 0:
            return "No se puede calcular la componente sobre un vector nulo"
        return producto_punto / norma_o

    def __str__(self):
        return f"[{', '.join(map(str, self.v))}]"


# Test del código
if __name__ == "__main__":
    v1 = [3.2, 5.0]
    v2 = [7.3, -1.6]
    vector1 = AlgebraVectorial(v1)
    vector2 = AlgebraVectorial(v2)

    print("Son perpendiculares:", vector1.perpendicular(vector2))
    print("Son paralelos:", vector1.paralela(vector2))
    print("Proyección de v1 sobre v2:", vector1.proyeccion(vector2))
    print("Componente de v1 en la dirección de v2:", vector1.componente(vector2))
