package com.github.diegopacheco.sandbox.scala.jodd

import jodd.util.ClassLoaderUtil

import scala.collection.mutable

/**
 * Created by diego on 2/24/2015.
 */
object RuntimeFun extends App{
  val addonClasspath:java.io.File  = new java.io.File("D:\\diego\\github\\diego.pacheco\\Diego-Pacheco-Sandbox\\scripts\\scala\\" +
                                                       "jodd-classloader-runtime\\lib\\commons-lang-2.6.jar")
  ClassLoaderUtil.addFileToClassPath(addonClasspath,this.getClass.getClassLoader)

  val clazz:Class[_] = Class.forName("org.apache.commons.lang.math.NumberUtils")
  println("Class loaded at runtime on the fly: " + clazz)
  println("Instance: " + clazz.newInstance())

  val m:java.lang.reflect.Method = clazz.getDeclaredMethod("toDouble",classOf[String],classOf[Double])
  println("Method loaded at runtime on the fly: " + m )

  val o:java.lang.Object = clazz.newInstance().asInstanceOf[java.lang.Object]
  val params:mutable.MutableList[Object] = new mutable.MutableList[Object]()
  params += "2.0"
  params += 0.0.asInstanceOf[Object]
  val result = m.invoke(o,params:_*)
  println("Call NumberUtils.toDouble(2.0,0.0) = " + result)

  val obj  = clazz.newInstance.asInstanceOf[{def toDouble(str:String,defaultValue:Double)():Double}]
  println(obj.toDouble("1.5",0.0))

}
