(ns example.core
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes handler
  (GET "/" [] "Hello World!")
  (route/not-found "Page not found"))