;; Define a Structure like a Class
(defrecord Programmer [language])

;; Define a protocol like a Interface for functions
;; Links multiple functions to be bound togheter
(defprotocol Teacher
    (teach [p])
	(readn [p])
)

;; Extend the Programmer structure to implement the Teacher protocol
(extend-type Programmer
    Teacher
     (teach [p] (println "Teaching" (:language p)))
	 (readn [p] (println "Reading Hacker News about " (:language p)))      
)	

;; Call the functions teach and read with Programmer structure
(teach (Programmer. "Clojure"))
(readn (Programmer. "Clojure"))