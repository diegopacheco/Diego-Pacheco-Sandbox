package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.cluster.Cluster
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.Ask
import akka.routing.FromConfig

object AdvancedClusterApp extends App{

  import akka.actor.ActorSystem
  import akka.actor.ActorSystem
  import com.typesafe.config.ConfigFactory
  
  val customConf = ConfigFactory.parseString("""
        akka {

          actor {
              provider = "akka.cluster.ClusterActorRefProvider"

              deployment {
                  /factorialFrontendRouter {
                          router = adaptive-group
                          metrics-selector = mix
                          nr-of-instances = 100
                          routees.paths = ["/user/factorialBackend"]
                          cluster {
                            enabled = on
                            use-role = frontend
                            allow-local-routees = off
                          }
                  }
                  /factorialFrontendRouter/factorialBackendRouter = {
                      router = adaptive-group
                      # metrics-selector = heap
                      # metrics-selector = load
                      # metrics-selector = cpu
                      metrics-selector = mix
                      nr-of-instances = 100
                      routees.paths = ["/user/factorialBackend"]
                      cluster {
                          enabled = on
                          use-role = backend
                          allow-local-routees = off
                      }
                 }            
            }
          
            remote {
              log-remote-lifecycle-events = off
              transport = "akka.remote.netty.NettyRemoteTransport"
              netty {
                hostname = "127.0.0.1"
                port = 0
              }
            }
       }

       cluster {
        seed-nodes = [
          "akka.tcp://ClusterSystem@127.0.0.1:2556",
          "akka.tcp://ClusterSystem@127.0.0.1:2557"
        ]
        auto-down-unreachable-after = 60s
        min-nr-of-members = 1  
      }

   }

  """)
  
  System.setProperty("akka.remote.netty.tcp.port", "2556")
  val clusterSystem = ActorSystem("ClusterSystem", ConfigFactory.load(customConf))
  Cluster(clusterSystem)
  
//  Cluster(clusterSystem) registerOnMemberUp { 
//      val actor = clusterSystem.actorOf(FromConfig.props(Props(classOf[FactorialFrontend], 6, true).withRouter(FromConfig())),"factorialFrontendRouter")
//      println("Actor FrontEnd Path: " + actor.path)
//      
//      val factorial = Ask.get[BigInt](actor, 6)
//      println("Scala Akka Cluster: FrontEnd Actor - Factorial 6 => " + factorial)  
//  }

}
