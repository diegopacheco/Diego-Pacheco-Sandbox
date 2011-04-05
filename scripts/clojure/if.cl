(defn casa2 [number] 
	( if (<= number 99) 
	    true
		(do 
		   (println "Esse numero nao eh " number)
	        false			
		)
    ) 
)
(println "(casa2 11)  -> " (casa2 11))
(println "(casa2 111) -> " (casa2 111))