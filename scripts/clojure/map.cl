(defstruct book :author :title)

(def b (struct-map book :author "Stuart Halloway" :title "Programming Conjure"))

(println b)