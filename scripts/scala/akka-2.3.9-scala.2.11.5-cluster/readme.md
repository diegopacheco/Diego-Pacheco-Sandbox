Versions and Tools
===================

0. Java JDK 1.8.u25
1. Scala: 2.11.5
2. Akka / Cluster: 2.3.9
3. sbt: 0.13.7
4. eclipse + scala IDE: eclipse Luna SR1, Scala IDE 4.0
5. IntelliJ 14.0.3 + scala plugin 1.3

How to make it work?
=====================

1. download from git
2. compile: $ sbt compile
3. generate the bootable kernel: $ stage

How to run and have fun with the cluster?
=========================================

open another 4 consoles:

###(1) console 1  <BR>
   $ akka-2.3.9-scala.2.11.5-cluster\target\universal\stage\bin\akka-2-3-9-scala-2-11-5-cluster.bat

###(2) console 2  <BR>
   $ sbt console  <BR>
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._ <BR>
   $ ClusterUtils.join2(2557) <BR>

###(3) console 3  <BR>
   $ sbt console  <BR>
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._ <BR>
   $ ClusterUtils.join2(2558)    <BR>

###(4) console 4  <BR>
   $ sbt console  <BR>
   $ import  com.github.diegopacheco.sandbox.scala.akka.util._ <BR>
   $ import  com.github.diegopacheco.sandbox.scala.akka.cluster.advanced._ <BR>
   $ ClusterUtils.joinSimple(2559)   <BR>
   $ [PRESS ENTER] <BR>
   $ ClusterUtils.sendMessage("test cluster msg",classOf[DummyActorFrontend]) <BR>

This is it. Have Fun! <BR>
Diego Pacheco    <BR>