;; Using Clojure Sequences
;; The ( ' ) character creates a sequence 
;; rest in the second until the end of the sequence
(def l '(1 2 3 4 5))
(println (first l))
(println (rest l))
(println (cons 0 '(1 2 3 4 5 6 7)))
;;
;; Clojure works fine with vectors as sequences as well
;;
(println (first [3 4 5]))
;;
;; Clojure let you join seqs using into
;;
(println (into [1 2 3] [:a :b]))
;;
;; It's also works with maps
;;
(println (first {:x 1 :y 2 :z 3}))