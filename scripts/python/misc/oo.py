import sys

class Pai():
	def ola(self): print "Ola do Pai!"
	
class Mae():
	def ola(self): print "Ola da Mae!"
	
class OlaMundo(Pai,Mae):

	def __init__(self):		
		Pai.ola(self)
		Mae.ola(self)
		print "Criei o objeto OlaMundo"

imprime = OlaMundo()
nome = raw_input('Qual teu nome ? ')
print "Ola mundo Python %s " % nome

