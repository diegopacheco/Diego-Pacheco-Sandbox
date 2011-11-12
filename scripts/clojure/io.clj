(use 'clojure.java.io)

(def txt (file "/data.txt"))
(def r (reader txt))

(prn (line-seq r))
(.close r)

