(defstruct person :first-name :last-name)

(def d (struct person "Diego" "Pacheco"))

(println (:first-name d))