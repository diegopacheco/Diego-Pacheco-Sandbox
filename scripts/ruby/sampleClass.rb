class Pessoa
  
  attr_accessor :nome, :sobreNome

  def initialize(nome = "", sobreNome = "")
	@nome = nome
	@sobreNome = sobreNome
  end

  def to_s
    @sobreNome + ", " + @nome
  end
  
end

pessoa = Pessoa.new
pessoa.nome = "Diego"
pessoa.sobreNome = "Pacheco"

puts pessoa


require 'java'

frame = javax.swing.JFrame.new("Window")
label = javax.swing.JLabel.new("Hello")
 
frame.getContentPane.add(label) 
frame.setDefaultCloseOperation(javax.swing.JFrame::EXIT_ON_CLOSE)
frame.pack
frame.setVisible(true)