class Instrument:                
    def sound(self):             
        print("plunk");          
    def name(self):              
        print("instrument");     
                                 
class Wind:                      
    def sound(self):             
        print("woosh");          
    def name(self):              
        print("wind");           
                                 
class Clarinet(Wind, Instrument):
    def name(self):              
        print("wood")            
        Wind.name(self)          
                                 
c = Clarinet();                  
c.name()                         
c.sound()               
