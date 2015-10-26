package main




func saque(x int) int {
	var count100 = 0
	var count50 = 0
	if x / 100 > 0 {
		count100 = x / 100
		x = x % 100
		return 0
	}
	
	if x / 50 > 0 {
		count50 = x / 50
		return 0
	}
	
	count100 = count50
	count50 = count100
	
	if x % 20 == 0|| x % 10 == 0 { 
		return 0 
	} else { 
		return 1
	}
}

func main(){
	
}