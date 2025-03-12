import tkinter as tk

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"({self.x:.2f}, {self.y:.2f})"

class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def dibuja_linea(self, canvas):
        canvas.create_line(self.p1.x, self.p1.y, self.p2.x, self.p2.y, fill="black", width=2)

class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def dibuja_circulo(self, canvas):
        x0 = self.centro.x - self.radio
        y0 = self.centro.y - self.radio
        x1 = self.centro.x + self.radio
        y1 = self.centro.y + self.radio
        canvas.create_oval(x0, y0, x1, y1, outline="black", width=2)

class Dibujo(tk.Canvas):
    def __init__(self, master, linea, circulo, width=400, height=400):
        super().__init__(master, width=width, height=height, bg="white")
        self.linea = linea
        self.circulo = circulo
        self.dibujar()

    def dibujar(self):
        self.linea.dibuja_linea(self)
        self.circulo.dibuja_circulo(self)

# Función principal
def main():
    root = tk.Tk()
    root.title("Dibujo de Línea y Círculo")

    p1 = Punto(50, 50)
    p2 = Punto(200, 200)
    linea = Linea(p1, p2)
    circulo = Circulo(Punto(150, 150), 50)

    dibujo = Dibujo(root, linea, circulo)
    dibujo.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
