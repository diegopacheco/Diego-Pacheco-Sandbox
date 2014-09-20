(defn sumto [n]
  (loop [i 1 sum 0]
     (if (<= i n)
	    (recur (inc i) (+ i sum))
		sum
      )
   )
)
(println (sumto 3))   
(println (sumto 5))