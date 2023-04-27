class Vehicle:
    
    def __init__(self, type1, model, mpg):
        self._type = type1
        self._model = model
        self._mpg = mpg
        self.canfly = false
        self.numWheels = 4

    def doesItFly(self):
        return self.canfly

    def noise(self):
        return "hmmmm"

    def toString(self):
        x = self._model + " " + self.noise() + " does"
        if self.doesItFly():
            x += ""
        else:
            x+= " not"
        x += " fly with " + self.numWheels + " wheels."
        return x



class Car(Vehicle):
    def __init__(self, type1, model, mpg):
        super().__init__(type1, model, mpg)

    def noise(self):
        return "vroom"

class Truck(Vehicle):
    def __init__(self, type1, model, mpg):
        super().__init__(type1, model, mpg)

    def noise(self):
        return "bumbumbum"

class Plane(Vehicle):
    def __init__(self, type1, model, mpg):
        super().__init__(type1, model, mpg)
        self.numWheels = 3
        self.canfly = true

    def noise(self):
        return "woooosh"

class Motorcycle(Vehicle):
    def __init__(self, type1, model, mpg):
        super().__init__(type1, model, mpg)
        self.numWheels = 2;

    def noise(self):
        return "errrrrrm"
