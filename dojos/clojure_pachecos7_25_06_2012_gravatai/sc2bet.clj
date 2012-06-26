(defstruct bet :person :race :money)

(def poletti (struct bet "poletto" "toss" 4))
(def chris (struct bet "christopher" "zerg" 1))

(defn topbet [people] 
	(apply :person (filter #(= (% :money) (apply max (map :money people))) people))
)

(prn (topbet [poletti chris]))

