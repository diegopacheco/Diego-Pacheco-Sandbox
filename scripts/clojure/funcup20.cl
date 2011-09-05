;;
;; define the func structure
;;

(defstruct func :name :salary)
(def fa (struct func "Diego" 1000))
(def fb (struct func "John" 2000))
(def fc (struct func "Andreas" 800))
(def fs [fa fb fc])
(println fs)

;;
;; Simple IFS
;;
(defn sal20
      "Function that is lousy and just return fixed data" 
      [func]
	  (if  
		 (= "Diego" (:name func)) 
		 (+ (:salary func) (* 0.20 (:salary func)))
		 (if (= "John" (:name func))  
		     (+ (:salary func)(* 0.20 (:salary func)))
			 (+ (* 0.20 800) 800)
         )			 
	  )
)	  

(println "fa as simple IF Diego : "   (sal20 fa))
(println "fb as simple IF John : "    (sal20 fb))
(println "fc as simple IF Andreas : " (sal20 fc))

;;
;; update20sal that updates func :salary
;;

(defn update20sal 
	  "Function that receive a [func] structure and increse in 20% the :salary"	
	  [func]
	  (+ (:salary func) (* 0.20 (:salary func) ) )
)	  

(prn (update20sal fa))
(prn (update20sal fb))
(prn (update20sal fc))

;;
;; update20salVec that updates a vector of func
;;

(defn update20salVec 
      "Function that iterate the vector of [func] called [vfuncs] and call update20sal for each element"
	  [vfuncs]
	  (map update20sal vfuncs)
)

(prn (update20salVec [fa fb fc]))

;;
;; Lets change the real structure func
;;
(prn " ")
(prn " ")

(prn fa)
(def fa (assoc fa :salary (update20sal fa)))
(prn fa)

(prn fb)
(def fb (assoc fb :salary (update20sal fb)))
(prn fb)

(prn " ")
(prn " FINAL SOLUTION ")

;;
;; Function that does all in one 
;;

(defn upv 
      "Function that receive a [vector] of [func] and apply 20% updrade on salary"
	  [vector]
	  (map
        (fn [x] (+ (:salary x) (* 0.20 (:salary x)) ) )   	  	    
		vector
	  )
)

(prn [fa fb fc])
(prn (upv [fa fb fc]))
(prn [fa fb fc])

;;
;; Call the functions documentations
;;

(doc update20sal)
(doc update20salVec)