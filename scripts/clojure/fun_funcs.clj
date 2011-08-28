;;
;; use the ' operator to not invoke a function
;;
(println "'(1 2 3 4 5) = " '(1 2 3 4 5))
;;
;; The function repeat will repeat 10 - 5 times
;;
(println "(repeat 5 10) = " (repeat 5 10))
;;
;; Apply +(sum) for each element of the list until over - sum it all
;;
(println "(apply + '(1 2 3)) = " (apply + '(1 2 3)))
;;
;; take the very first element
;;
(println "(first '(1 2 3 4 5 6 7 8 9 10)) = " (first '(1 2 3 4 5 6 7 8 9 10)))
;;
;; take the rest
;;
(println "(next '(1 2 3 4 5 6 7 8 9 10)) = " (next '(1 2 3 4 5 6 7 8 9 10)))
;;
;; Some fun with Vectors
;;
(println "(defstruct keyvalue :k :v)")
(println "(def tweet (struct keyvalue 1 'First tweet using clojure'))")
(defstruct keyvalue :k :v)
(def tweet (struct keyvalue 1 "First tweet using clojure"))
(println "Tweet (:v tweet) = " (:v tweet))
;;
;; Fun with IFs and recursion(the onnly way todo loops in clojure) 
;;
(defn factorial [n]
      (if (= n 1)
         1
         (* n (factorial (dec n)) )
      )	   
)
(println "factorial 1   = " (factorial 1))
(println "factorial 2   = " (factorial 2))
(println "factorial 10  = " (factorial 10))
(println "factorial 100 = " (factorial 100))
;;
;; Map - Iterate a list(collection) and call all itens with the functions and return the list with results
;;
(println "(map factorial [1 2 3]) = " (map factorial [1 2 3]))
;;
;; Documentation of the funcion -
;;
(println "(doc -) = ")
(doc -) 