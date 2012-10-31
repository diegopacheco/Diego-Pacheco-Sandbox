(ns avout-playground.core)

(use 'avout.core)
(def client (connect "127.0.0.1"))

(def r0 (zk-ref client "/r0" 0))
(def r1 (zk-ref client "/r1" []))

(defn inckz []
(dosync!! client
  (alter!! r0 inc)
  (alter!! r1 conj @r0)) )

(defn getr0 [] (prn @r0))
(defn getr1 [] (prn @r1))

