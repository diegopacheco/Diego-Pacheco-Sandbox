(require '(clojure [zip :as zip]))

(def v [ [1 2 3] [4 5 6] [[7] [8]]])

(def zp (zip/zipper vector? seq (fn [_ c] c) v))

(prn "vector: " v ", Zipper: " zp)

(prn (-> zp zip/down))
(prn (first (-> zp zip/down)))