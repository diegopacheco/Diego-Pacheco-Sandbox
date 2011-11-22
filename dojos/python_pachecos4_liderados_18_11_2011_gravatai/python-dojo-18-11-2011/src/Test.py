import unittest
import Company as c

class CompanyTest(unittest.TestCase):

    def test_one_employee_100(self):
        emp = [c.Employee()]
        result = c.Payment().pay(emp)        
        self.assertEqual(result, 90)
        
    def test_multiple_employees_100(self):
        emps = [c.Employee(), c.Employee()]
        result = c.Payment().pay(emps)
        self.assertEqual(result, 180)  
        
    def test_advantage(self): 
        emp = [c.Employee([c.Advantage(50), c.Advantage(0)])]
        result = c.Payment().pay(emp)
        self.assertEqual(result, 140)
        
    def test_two_employees_different_advts(self):
        advs1 = [c.Advantage(50), c.Advantage(100)]
        advs2 = [c.Advantage(200)]
        emps = [c.Employee(advs1), c.Employee(advs2)]
        result = c.Payment().pay(emps)
        self.assertEquals(result, 530)
   
    def test_employee_role(self):
        emp = [c.Employee([c.Advantage(50)], c.Role("Developer"))]
        result = c.Payment().pay(emp)
        self.assertEqual(result, 140)
        
if __name__ == '__main__':
    unittest.main()