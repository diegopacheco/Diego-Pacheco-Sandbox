import unittest
import Calculator as calc

class TestCalculator(unittest.TestCase):

    def test_shuffle(self):
        c      = calc.Calculator()
        result = c.sum(5, 3)
        self.assertEqual(result, 8,"A Soma 5 + 3 deveria ser = 8 ! Resultado: %s" % result )

if __name__ == '__main__':
    unittest.main()