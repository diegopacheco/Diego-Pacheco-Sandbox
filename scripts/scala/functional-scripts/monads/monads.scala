/**
 *   "Tradictional" Monads  
 **/

def foo(bar: String) = {
  ({ () => println(bar) })()
  ({ () => bar.length })()
}
	
def foo2(bar: String) = {
    println(bar)
	bar.length
}

println(foo("Diego"))
println(foo2("Diego"))

/**
 *   Monads  
 **/

case class Thing[+A](value: A)

val a = Thing(1)
val b = Thing(2)

println(a)
println(b)
println( a == b)

/**
 *  Monads  
 **/
	
def foo(i: Int) = Thing(i + 1)
 
val x = Thing(1)
val y = foo(x.value)
println(x)
println(y)

/**
 *  Monads  
 **/
 
case class Thing2[+A](value: A) {
  def bind[B](f: A => Thing2[B]) = f(value)
}

def foo2(i: Int) = Thing2(i + 1)
 
val z = Thing2(1)
val w = z bind foo2

println(z)    
println(w)    