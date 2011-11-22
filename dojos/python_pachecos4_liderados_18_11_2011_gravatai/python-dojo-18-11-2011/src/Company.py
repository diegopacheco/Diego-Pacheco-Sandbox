class Advantage():
    
    def __init__(self, ad = 0):
        self.val = ad
        self
        
    name = "fuel"
    val  = 0

class Role():
    
    role = "Developer" 
    
    def __init__(self, role = "Developer"):
        self.role = role
        self

class Employee():
    
    adv = [Advantage(0),Advantage(0) ]
    role = Role("Developer")
    
    def __init__(self, adv = [Advantage(0), Advantage(0)], role = Role("Developer")):
        self.adv = adv
        self.role = role
        self
        
    def salary(self):
        return 100    

class Payment(): 
    
    def __init__(self): 
        self
     
    def __sumAdvantages(self, advs):
        if advs.__len__() == 1: return advs[0].val
        return reduce(lambda x, y: x.val + y.val, advs)
       
    def __applyTax(self, emp):
        return emp.salary() * 0.9
            
    def pay(self, emp):
        val = 0
        for e in emp:
            val += self.__applyTax(e) + self.__sumAdvantages(e.adv)
        return val
    
