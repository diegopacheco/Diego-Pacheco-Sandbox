require 'rubygems'
require 'test/unit'
require 'ut/calculator'

class CaclulatorTest < Test::Unit::TestCase
  
    def test_right_sum
      c = Caclculator.new
      result = c.sum(5,5)
      assert_equal(10,result)
    end
  
    def test_right_multiply
      c = Caclculator.new
      result = c.multiply(5,5)
      assert_equal(25,result)
    end
  
end