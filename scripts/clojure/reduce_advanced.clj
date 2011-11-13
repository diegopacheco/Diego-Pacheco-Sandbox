(defn advred[col]
  (reduce (fn[r n](prn "result " r " next " n) 
             (conj r (conj () n ))
          )
          col)
)

(def r (advred [() 1 1 2 1 1 1 3 3]))
(prn r)

(defn advred2[col]
  (reduce (fn[r n](prn "result " r " next " n) 
             (if (= (last (last r)) (last n))
			     (conj r (conj (last r) n))
				 (conj r n)
			 )
          )
          col)
)

(def r2 (advred2 r))
(prn r2)