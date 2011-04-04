;; In an article which convinced many people to have a look at LISP

;; http://www.paulgraham.com/avg.html

;; Paul Graham wrote about how nice it was to write a web application from an
;; environment where everything was controllable from the REPL.

;; Here's how to create a web server at the REPL


;; First we'll need a function to generate a simple web page
(defn yo [] "Hello")

;; Now we attach that to /
(use 'compojure.core)
(defroutes main-routes (GET "/" [] (yo)))

;; We should wrap our routing table in a handler (note the #')
(use 'compojure.handler)
(def app (site #'main-routes))

;; And then we can run it with jetty (again note the #')
(use 'ring.adapter.jetty)
(def server (run-jetty #'app {:port 8080 :join? false}))

;; So now we're serving web pages. Go look at http://localhost:8080/

;; The web browser of the gods:
;; $ watch -d -n 1 curl -sv http://localhost:8080/ 

;; We can stop the server
(.stop server)

;; And restart it:
(.start server)

;; We can redefine those functions, and the change takes effect immediately:
(defn yo [] "<h1>Hello<h1/>")

;; (you will need to refresh the page, unless you use twbotg)

;; HTML is a bit of a pain. We already have a syntax for tree-structured data:

(use 'hiccup.page-helpers)

(defn yo []      
  (html5 [:head
          [:title "Hello World"]]
         [:body
          [:h1 "Lisp is the future"]]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; I'm confused: see http://stackoverflow.com/questions/5398569/can-clojure-be-made-dynamic

;; The reason for the #' above is to make sure that we can redefine main-routes
;; and app at runtime. Without the indirection, the changes don't seem to get picked up.

;; And yet they do get picked up when you redefine yo.

;; I do not understand what is going on here. Any explanation would be welcome!