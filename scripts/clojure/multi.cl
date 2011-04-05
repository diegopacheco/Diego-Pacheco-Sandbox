(defmulti blank? class)
(defmethod blank? String [s] (every? #(Character/isWhitespace %) s))

(println (blank? "diego"))
(println (blank? "     "))