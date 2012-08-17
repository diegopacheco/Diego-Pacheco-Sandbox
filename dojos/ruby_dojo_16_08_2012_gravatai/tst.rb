require 'test/unit'
require './PepsiMachine'

class PepsiMachineTest < Test::Unit::TestCase
  
    def test_take_1_pepsi;   assert_equal("pepsi",PepsiMachine.new.pay(1).take("pepsi")); end
	
	def test_take_wrong_value; assert_equal("erro", PepsiMachine.new.pay(1).take("guarana")); end
	
	def test_take_guarana; assert_equal("guarana", PepsiMachine.new.pay(2).take("guarana")); end
	
	def test_take_guarana_and_change
		c = PepsiMachine.new.pay(5).take("guarana")
		assert_equals("guarana", c.product)
		assert_equals(3, c.change)
	end
  
end