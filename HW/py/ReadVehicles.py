#### ReadVehicles.py ####
from vehicles import *
vehicles = []

f = open('vehicles.txt')
line = f.readline()
while(line):
    line_split = line.split(' ')
    if line_split[0] == 'truck':
        vehicles.append(Truck(line_split[0], line_split[1], line_split[2]))
    elif line_split[0] == 'car':
        vehicles.append(Car(line_split[0], line_split[1], line_split[2]))
    elif line_split[0] == 'motorcycle':
        vehicles.append(Motorcycle(line_split[0], line_split[1], line_split[2]))
    elif line_split[0] == 'plane':
        vehicles.append(Plane(line_split[0], line_split[1], line_split[2]))

    line = f.readline()


for vehicle in vehicles:
    print(vehicle.toString())

