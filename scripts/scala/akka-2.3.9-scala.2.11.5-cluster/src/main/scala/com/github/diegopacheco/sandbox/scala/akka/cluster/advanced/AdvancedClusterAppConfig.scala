package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

object AdvancedClusterAppConfig {
    
  import com.typesafe.config.ConfigFactory
  
  val conf = ConfigFactory.parseString("""
        akka {

          actor {
              provider = "akka.cluster.ClusterActorRefProvider"

              deployment {
                    /statsRouter = {
                          router = adaptive-group
                          metrics-selector = cpu
                          nr-of-instances = 10
                          routees.paths = ["/user/statsWorker"]
                          cluster {
                            enabled = on
                            use-role = backend
                            allow-local-routees = off
                          }
                    }  
                    /factorialFrontendRouter {
                          router = adaptive-group
                          metrics-selector = mix
                          nr-of-instances = 100
                          routees.paths = ["/user/factorialBackend"]
                          cluster {
                            enabled = on
                            use-role = backend
                            allow-local-routees = off
                          }
                    }
                    /factorialFrontendRouter/factorialBackendRouter = {
                          router = adaptive-group
                          metrics-selector = mix
                          nr-of-instances = 10
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
             auto-down-unreachable-after = 10s
          }
   }

   akka.cluster.metrics.enabled=off
   

  """)
  
  
}