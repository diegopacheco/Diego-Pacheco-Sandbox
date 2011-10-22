(ns dojo.clojure.loan)

(defstruct result :loan-amount :tax)
(defstruct person :name :os :salary :civil-state :age)

(defn create-result[l t]
	(struct result l t)
)

(defn calc-salary [p]
	(* 0.8 (:salary p))
)

(defn calc-married[p]
    (if (= (:civil-state p) :married) 500 0)
)

(defn calc-age [p]
    (if (> (:age p) 25) 1000 0)
)

(defn calc-iof[x a]
	(float (* (* 0.018 a) x))
)

(defn calc-loan-amount [p]
	(+ (calc-married p) (calc-salary p) (calc-age p))
)

(defn loan [p x] 
    (if (or (= (:os p) :mac) (< (:age p) 21) ) 
		(create-result 0 0)
	    (create-result 
		  (calc-loan-amount p)
		  (calc-iof x (calc-loan-amount p)) 
		)
	)
)	

(def j  (struct person "Jeffi" :mac 500 :single 26))
(def f  (struct person "Frances" :linux 1000 :married 28))
(def p  (struct person "poletto" :linux 100 :single 28))
(def js (struct person "jeferson-souza" :win 120 :single 20))
(def jj (struct person "JaQuiSon" :linux 120 :single 24))

;;
;; Unit testing
;;
(use 'clojure.test)

(deftest test-loan
  (is (= ((loan j 0) :loan-amount) 0 ))
  (is (= ((loan f 2) :loan-amount) 2300))
)

(deftest test-loan-single
	(is (= ((loan p 0) :loan-amount) 1080))
)

(deftest test-loan-minor-21
    (is (= ((loan js 0) :loan-amount) 0))
)

(deftest test-tax-per-month
	(is (= ((loan jj 2) :tax) (float 3.456) ))
)

(run-tests 'dojo.clojure.loan)