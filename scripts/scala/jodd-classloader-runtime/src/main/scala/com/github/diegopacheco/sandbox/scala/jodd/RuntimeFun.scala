package com.github.diegopacheco.sandbox.scala.jodd

import jodd.util.ClassLoaderUtil

/**
 * Created by diego on 2/24/2015.
 */
object RuntimeFun extends App{
  val addonClasspath:java.io.File  = new java.io.File("D:\\diego\\github\\diego.pacheco\\Diego-Pacheco-Sandbox\\scripts\\scala\\" +
                                                       "jodd-classloader-runtime\\lib\\commons-lang-2.6.jar")
  ClassLoaderUtil.addFileToClassPath(addonClasspath,this.getClass.getClassLoader)

  val clazz = Class.forName("org.apache.commons.lang.math.NumberUtils")
  println("Class loaded at runtime on the fly: " + clazz)

  val obj  = clazz.newInstance.asInstanceOf[{def toDouble(str:String,defaultValue:Double)():Double}]
  println(obj.toDouble("1.5",0.0))

}
