;;
;; Define Structures (like classes in OO)
;;
(defrecord Programmer [lang])
(defrecord NoSkillPerson [activity])

;;
;; Define 2 multi-methods - The first look for the class
;;
(defmulti relax class)
(defmethod relax Programmer [programmer]
    (println "I'm wrtiting code in " (:lang programmer))
)
(defmethod relax NoSkillPerson [person]		   
    (println "I don't have skills so I'm " (:activity person))
)

;;
;; Define 2 multi-methods - The seconf looks for a string
;;

(defmulti quip :lang)
(defmethod quip "Java" [programmer]
    (println "JVM Rulez")
)
(defmethod quip "Scala" [programmer]
    (println "Scala Rocks :-) ")
)

;;
;; Multi-method usage - multi-method 1
;;
(relax (Programmer. "Clojure"))		   
(relax (NoSkillPerson. "Looking at the Sum"))

;;
;; Multi-method usage - multi-method 2
;;
(quip (Programmer. "Java"))
(quip (Programmer. "Scala"))