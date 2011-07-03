import unittest
import Cheque_Machine as modulo_cheque

class TestCheque(unittest.TestCase):

    def test_um_real(self):
        result = modulo_cheque.Cheque_Machine().write(1)        
        self.assertEqual(result, "Um Real")
    
    def test_dez_reais(self):
        result = modulo_cheque.Cheque_Machine().write(10)
        self.assertEqual(result, "Dez Reais")
        
    def test_cem_reais(self):
        result = modulo_cheque.Cheque_Machine().write(100)
        self.assertEqual(result, "Cem Reais")
        
    def test_mil_reais(self):    
        result = modulo_cheque.Cheque_Machine().write(1000)
        self.assertEqual(result, "Mil Reais")
    
    def test_dois_reais(self):
        result = modulo_cheque.Cheque_Machine().write(2)    
        self.assertEqual(result,"Dois Reais")
    
    def test_cento_e_cinquenta_reais(self):
        result = modulo_cheque.Cheque_Machine().write(150)
        self.assertEqual(result, "Cento e Cinquenta Reais")
         
if __name__ == '__main__':
    unittest.main()