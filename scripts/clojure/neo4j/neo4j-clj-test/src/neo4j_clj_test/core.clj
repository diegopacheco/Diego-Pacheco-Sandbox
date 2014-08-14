(ns neo4j-clj-test.core
 (:require [clojurewerkz.neocons.rest :as nr]
 		   [clojurewerkz.neocons.rest.nodes :as nn]
 		   [clojurewerkz.neocons.rest.relationships :as nrl]
  		   [clojurewerkz.neocons.rest.cypher :as cy]
 ) (:gen-class) )
	
(defn -main
  "Neo4J Clojure fun with cypher and clojure"
  [& args]
  (let [conn (nr/connect "http://localhost:7474/db/data/")
        movie1  (nn/create conn {:title "Conan the Barb"   :categoty "Action"})
        movie2  (nn/create conn {:title "Conan the Barb 2" :categoty "Action"})
        blockbuster1  (nn/create conn {:name "Blockbuster"})
        rel1    (nrl/create conn blockbuster1 movie1 :movies {:source "BR"})
        rel2    (nrl/create conn blockbuster1 movie2 :movies {:source "BR"})
        res     (cy/tquery conn 
        			"START blockbuster1=node({sid}) MATCH movies-[:source]->movies RETURN movies" 
        			{:sid (:id blockbuster1)})
        ]
    (println blockbuster1)
  )
)