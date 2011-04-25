;; Throw Exception with message
;; Finally blocks run, like java and I do a println
;; BUT the exception is throwed :-)
;;
(try
  (throw  (Exception. "something failed"))
  (finally (println "We get to clean up"))
)