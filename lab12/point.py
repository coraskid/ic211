class Point:
    def __init__(self, x, y):
        self._x = x;
        self._y = y;

    def dist_from_origin(self):
        return self._x*self._x + self._y*self._y
    
    def __str__(self):
        return "(" + str(self._x) + "," + str(self._y) + ")";

p1 = Point(5, 3)
p2 = Point(5.3, 3)
print(p1, p1.dist_from_origin())
print(p2, p2.dist_from_origin())
