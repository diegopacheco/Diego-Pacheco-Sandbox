(def f (future 10))
(println f)
(println @f)

(def p (promise))
(deliver p :done)
(println @p)