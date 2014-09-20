(def increment (map inc))

;; transreducers
(println (transduce increment + [1 2 3 4 5]))

;; sam as we do without transreducers:
(println (reduce + (map inc [1 2 3 4 5])))