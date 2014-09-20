(def a(make-array String 5))
(println (seq a))

(aset a 0 "Diego")
(aset a 1 "Pacheco")
(aset a 2 "Clojure")
(println (seq a))
(println (aget a 0))
(println (alength a))

(println (seq (to-array ["HAHA", "Clojure", "Rulez"])))
(println (seq (into-array String ["HAHA", "Clojure", "Rulez"])))
