(ns noir-fun.views.welcome
  (:require [noir-fun.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to noir-fun"]))
