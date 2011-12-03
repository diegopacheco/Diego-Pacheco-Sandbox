(ns pacheco-diego-clojure-tests)
(use 'clojure.test)

(defstruct sale :value :seller :customer)

(def sales [(struct sale 1000 "joao" "maria")
            (struct sale 500 "maria" "diego" ) 
            (struct sale 800 "cuervo" "maria")])

(defn- reduce-sale [f c]
  (reduce f (map :value c))
)


(defn best-sale[c]
  (reduce-sale max c)
)  

(defn worst-sale [c]
  (reduce-sale min c)
)

(defn best[c]
  (first (filter #(= (best-sale c) (:value %1)) c))
)

(defn best-salesman [c]
  (:seller (best c))
)

(defn best-customer [c]
  (:customer (best c))
)

(deftest best-sale-test
  (is (= 1000 (best-sale sales)))     
)

(deftest worst-sale-test
  (is (= 500 (worst-sale sales)))
)

(deftest best-salesman-test
  (is (= "joao" (best-salesman sales)))
)

(deftest best-customer-test
  (is (= "maria" (best-customer sales)))
)

(run-tests 'pacheco-diego-clojure-tests)
