class FigurasGeometricas:

    def area(self, radio):
        return 3.1416 * radio * radio


    def area_rect(self, base, altura):
        return base * altura


    def area_tri(self, base, altura, divisor):
        return (base * altura) / divisor


    def area_trap(self, base_mayor, base_menor, altura, divisor):
        return ((base_mayor + base_menor) / divisor) * altura


    def area_pent(self, perimetro, apotema, lados, extra, divisor):
        return (perimetro * apotema) / divisor


# Uso de la clase
figuras = FigurasGeometricas()

print("Círculo:", figuras.area(5))
print("Rectángulo:", figuras.area_rect(4, 6))
print("Triángulo:", figuras.area_tri(4, 6, 2))
print("Trapecio:", figuras.area_trap(6, 4, 5, 2))
print("Pentágono:", figuras.area_pent(10, 5, 5, 0, 2))
