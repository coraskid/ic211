from clock import Clock
from calendar import Calendar

class ClockCalendar(Clock, Calendar):
    def __init__(self, mo, d, y, h, mi, s):
        self.set_Calendar(d, mo, y);
        self.set_Clock(h, mi, s);

    def tick(self):
        if self.hours == 23 and self.minutes == 59 and self.seconds == 59:
            Calendar.advance(self)
        Clock.tick(self)

    def __str__(self):
        return Calendar.__str__(self) + "," + Clock.__str__(self)

c = ClockCalendar(4, 23, 2019, 9, 55, 0)
print(c.days)
print(c.months)
print(c.years)
print(c.hours)
print(c.minutes)
print(c.seconds)

x = ClockCalendar(12,31,2013,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,1900,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,2000,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,7,2013,13,55,40)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)
