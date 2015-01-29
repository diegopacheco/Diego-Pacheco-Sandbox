package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

case class TransformationJob(text: String)
case class TransformationResult(text: String)
case class JobFailed(reason: String, job: TransformationJob = null)
case object BackendRegistration

case class StatsJob(text: String)
case class StatsResult(meanWordLength: Double)