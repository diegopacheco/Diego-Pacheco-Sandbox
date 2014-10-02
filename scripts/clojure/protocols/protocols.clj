(defprotocol tax-service 
	(toll-one-way[this] 0 ) )

(defrecord brazillian-service [car]  
  tax-service
    (toll-one-way [this] 6.95))

(defrecord argentinian-service [car]  
  tax-service
    (toll-one-way [this] 16.95))

(extend-protocol tax-service
  java.lang.String
    (toll-one-way [this] (toll-one-way (brazillian-service. this)) ))

(toll-one-way "uno")

(def uno-agr (argentinian-service. "uno mile"))
(toll-one-way uno-agr)

