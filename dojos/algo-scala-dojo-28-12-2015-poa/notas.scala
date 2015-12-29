var n = 150
var notas = scala.collection.mutable.LinkedHashMap(100->0,50->0,20->0,10->0) 

for (i <- notas.keys if n > 0 ){
    val g = n / i 
    n = n % i
    notas(i) = g
}

println(notas)