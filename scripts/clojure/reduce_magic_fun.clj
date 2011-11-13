(reduce (fn[r n](prn "result " r " next " n) (if (= n (last r)) r (conj r n))) (cons [] [1 1 2 3 3 2 2 3]))
;"result " [] " next " 1
;"result " [1] " next " 1
;"result " [1] " next " 2
;"result " [1 2] " next " 3
;"result " [1 2 3] " next " 3
;"result " [1 2 3] " next " 2
;"result " [1 2 3 2] " next " 2
;"result " [1 2 3 2] " next " 3
;[1 2 3 2 3]

