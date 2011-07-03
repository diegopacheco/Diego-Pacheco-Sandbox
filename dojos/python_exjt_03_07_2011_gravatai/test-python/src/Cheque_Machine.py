class Cheque_Machine():
    
    um_a_nove = {1:"Um", 2:"Dois", 3:"Tres",
                 4:"Quatro", 5:"Cinco", 6:"Seis",
                 7:"Sete", 8:"Oito", 9:"Nove"}
    
    dezenas = {1: "Dez", 2: "Vinte", 3: "Trinta",
               4: "Quarenta", 5: "Cinquenta", 6: "Sessenta",
               7: "Setenta", 8: "Oitenta", 9: "Noventa"}
    
    centenas = {1: "Cento", 2: "Duzentos", 3: "Trezentos",
                4: "Quatrocentos", 5: "Quinhentos",
                6: "Seiscentos", 7: "Setecentos",
                8: "Oitocentos", 9: "Novecentos"}
    
    def __init__(self): 
        self
    
    def write(self,valor):
        if valor == 1:
            return "Um Real"
        if valor == 10:
            return "Dez Reais"
        if valor == 100:
            return "Cem Reais"
        if valor == 1000:
            return "Mil Reais"
        
        h = Helper()
        h.controle = valor
        
        while h.controle != 0:
            if h.controle > 100:
                h = self.calc_valor(100, h.controle, h.resultado)   
            elif h.controle > 10:
                h = self.calc_valor(10, h.controle, h.resultado)
            elif h.controle < 10:
                h.resultado += self.um_a_nove[h.controle]  
                h.controle = 0     
        return h.resultado + " Reais"    


    def deve_colocar_e(self, controle):
        if controle == 0:
            return ""
        else:
            return " e "
        
    def calc_valor(self, modulo, controle, resultado):
            divisao = (controle//modulo)
            if(modulo == 10):
                resultado += self.dezenas[divisao]
            else:
                resultado += self.centenas[divisao]   
            
            controle -= modulo * divisao
            resultado += self.deve_colocar_e(controle)
            
            h = Helper()
            h.controle  = controle
            h.resultado = resultado
            
            return h
        
class Helper:
    
    controle  = -1
    resultado = "" 