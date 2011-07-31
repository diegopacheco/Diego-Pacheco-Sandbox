class Tennis {
	
	def String player1 = "P1", player2 = "P2"
	def Integer scoreP1,scoreP2, advantage
	
	def void playGame(Integer scoreP1,Integer scoreP2,Integer advantage = 0){
		this.scoreP1 = scoreP1
		this.scoreP2 = scoreP2
		this.advantage  = advantage
	}
	
	def String playSet(Integer s1,Integer s2){
		"${player1}[${s1}] X ${player2}[${s2}]"
	}
	
	def String toString(){
		"${player1}[${resolve(1)}] ${resolveAdvantage(1)} X ${player2}[${resolve(2)}] ${resolveAdvantage(2)}"
	}

	def String resolve(Integer player){
		1 == player ? scoreP1 : scoreP2
	}	
	
	def String resolveAdvantage(Integer player){
		advantage == player ? "A" : " "
	}
}
