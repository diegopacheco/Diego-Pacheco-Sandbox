(def result (into [] (take 5 (iterate dec 5))))
(println result)

(def result2 (into [] (drop-last (reverse (range 6)))))
(println result2)

(def result3 (vec (reverse (rest (range 6)))))
(println result3)