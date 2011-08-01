(ns pacheco-diego-clojure-tests)
(use 'clojure.test)

(deftest addition
  (is (= 4 (+ 2 2)))
  (is (= 7 (+ 3 4)))
  (is (= 2 (+ 1 1)))
)

(deftest sub
  (is (= 3 (- 6 3)))
)

(run-tests 'pacheco-diego-clojure-tests)