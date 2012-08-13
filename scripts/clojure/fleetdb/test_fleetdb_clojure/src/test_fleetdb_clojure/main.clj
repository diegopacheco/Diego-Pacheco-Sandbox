(ns  test_fleetdb_clojure.main)
(use 'fleetdb.client)

(defmacro ignore-errors
  "Returns the result of evaluating e, or nil if it throws an exception."
  [e]
  `(try ~e (catch java.lang.Exception _# nil)))

(defn fleetdb_pingpong "Ping-pong function to check if the DB is running." []
	 (do 
		  (def client (connect)) 
		  (query client ["ping"])
	 )
)

(defn fleetdb_insert "Insert data on FleetDB" []
	 (do 
		  (def client (connect)) 
		  (client ["insert" "elems" {"id" 1 "name" "Diego Pacheco" "db" "FleetDB"}])
	 )
)

(defn fleetdb_query "Query data on FleetDB" []
	 (do 
		  (def client (connect)) 
		  (client ["select" "elems"])
	 )
)

(defn -main "" [& args]
  (do 
	  (fleetdb_pingpong)
	  (ignore-errors fleetdb_insert)
	  (fleetdb_query)
  )
)

