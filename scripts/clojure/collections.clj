"Here i'm defining a SET"
(println "SET... ")
(def s #{1 2 3 4 5})
(println "size" (.size s))
(println "All Elements" s)
(println "Position 1 " (s 1))

"Here I'm defining a Vector"
(println "Vector... ")
(def v [6 7 8 9 10])
(println "size" (.size v))
(println "All Elements" v)
(println "Position 1" (v 1))

"Here I'm defining a Map"
(println "MAP... ")
(def m {:rs "Porto Alegre" :sp "Sao Paulo"})
(println "size" (.size m))
(println "All Elements" m)
(println "Position 1" (m 1))
(println ":rs " (m :rs))
(println "get :sp " (.get m :sp))