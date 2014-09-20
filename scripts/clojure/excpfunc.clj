(defn class-avaliable? [class-name]
      (try
          (Class/forName class-name) true
          (catch ClassNotFoundException _ false)
       )
)
(println (class-avaliable? "org.test.hey.Class"))	   
(println (class-avaliable? "java.util.ArrayList"))