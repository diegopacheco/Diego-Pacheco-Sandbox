require 'rubygems'
require 'numero_to_letras'
require 'test/unit'

class NumeroToLetrasTest < Test::Unit::TestCase
  
  public
  
  def test_0
    generic_test(0, " ")
  end
  def test_1_abc
    generic_test(1, "ABC")
  end
  
  def test_2_def
    generic_test(2, "DEF")
  end
  
  def test_3_ghi
    generic_test(3, "GHI")
  end
  
  def test_4_jkl
    generic_test(4, "JKL")
  end
  
  def test_5_mno
    generic_test(5,"MNO")
  end
  
  def test_6_pqr
    generic_test(6,"PQR")
  end
  
  def test_7_stu
    generic_test(7, "STU")
  end
  
  def test_8_vwx
    generic_test(8, "VWX")
  end
  
  def test_9_yz
    generic_test(9,"YZ")
  end
  
  def test_10000_ERRO
    generic_test(10000,"ERRO: Numero invalido!")
  end
  
  private
   
  def generic_test(num,letra)
    assert_equal(letra, num.to_letra(num) )
  end  
    
end
