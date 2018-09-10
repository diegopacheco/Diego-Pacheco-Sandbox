(defproject leinweb "1.0.0"
  :description "Generate static HTML for https://leiningen.org"
  :dependencies [[enlive "1.0.1"]
                 [cheshire "4.0.0"]
                 [compojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [environ "1.0.0"]
                 [org.markdownj/markdownj "0.3.0-1.0.2b4"]]
  :main leinweb.web)
