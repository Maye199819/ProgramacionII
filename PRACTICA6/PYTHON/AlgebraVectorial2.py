import math

class Vector:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    def add(self, other):
        return Vector(self.x + other.x, self.y + other.y, self.z + other.z)

    def multiply(self, other):
        if isinstance(other, (int, float)):
            return Vector(self.x * other, self.y * other, self.z * other)
        elif isinstance(other, Vector):
            dot_product = self.x * other.x + self.y * other.y + self.z * other.z
            return "Un vector ortogonal" if dot_product == 0 else dot_product
        return None

    def cross(self, other):
        return Vector(
            self.y * other.z - self.z * other.y,
            self.z * other.x - self.x * other.z,
            self.x * other.y - self.y * other.x
        )

    def length(self):
        return math.sqrt(self.x ** 2 + self.y ** 2 + self.z ** 2)

    def normalize(self):
        len = self.length()
        return Vector() if len == 0 else Vector(self.x / len, self.y / len, self.z / len)

    def __str__(self):
        return f"(x={self.x:.2f}, y={self.y:.2f}, z={self.z:.2f})"

# Test
if __name__ == "__main__":
    v1 = Vector(5, 4, 2)
    v2 = Vector(-2, 3, -1)

    print(v1)
    print(v2)

    v3 = v1.add(v2)
    print("El vector suma es", v3)

    v4 = v1.multiply(3)
    print("El vector multiplicado por escalar es", v4)
