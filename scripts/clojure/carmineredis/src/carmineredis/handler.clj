(ns carmineredis.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [taoensso.carmine :as car :refer (wcar)]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def server1-conn {:pool {} :spec {:uri "redis://127.0.0.1:6379/"}})
(defmacro wcar* [& body] `(car/wcar server1-conn ~@body))

(def result (wcar*
 (car/ping)
 (car/set "mykey" "cojure and redis")
 (car/get "mykey")))

(defroutes app-routes
  (GET "/" [] (str result))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
