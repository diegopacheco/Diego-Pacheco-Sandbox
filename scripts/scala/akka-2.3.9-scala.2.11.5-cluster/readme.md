How to make it work?
=====================

1. download from git
2. compile: $ sbt compile
3. generate the bootable kernel: $ stage

How to run and have fun with the cluster?
=========================================

open another 4 consoles:

#1 $ akka-2.3.9-scala.2.11.5-cluster\target\universal\stage\bin\akka-2-3-9-scala-2-11-5-cluster.bat

#2 $ sbt console 
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._
   $ ClusterUtils.join2(2557)

#3 $ sbt console 
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._
   $ ClusterUtils.join2(2558)   

#4 $ sbt console 
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._
   $ import  com.github.diegopacheco.sandbox.scala.akka.cluster.advanced._
   $ ClusterUtils.joinSimple(2559)   
   $ <ENTER>
   $ ClusterUtils.sendMessage("test cluster msg",classOf[DummyActorFrontend])


This is it. Have Fun!
Diego Pacheco   