(comment "Define a function with annonimous function")
(def square (fn [x] (* x x)) )
(println (square 4))

(comment Other way to define but with syntatic sugar)
(defn square2 [x] (* x x) )
(println (square2 3))

;;
;; apply a multiplication with the repetion on X for the number times(n)
;;
(defn exp [x n] 
	  (apply * (repeat n x) )
)
(println (exp 2 4))
