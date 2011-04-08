(defn carf []
  (let [arr (make-array String 3)]
       (aset  arr 0 "Diego")
	   (aset  arr 1 "Pacheco")
	   (aset  arr 2 "Clojure")
    arr
   )
)

(def a(carf))
(println (aget a 0))   
(println (aget a 1))
(println (aget a 2))