(defn tabuada [n]
   (loop [i 1 a 0]
      (if (<= i 10)
	     (recur (inc i) (println (format  "%d X %d == %d"  n i (* n i))) )
	  )
   )
)
(tabuada 2)
(tabuada 7)