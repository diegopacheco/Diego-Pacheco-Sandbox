package com.github.diegopacheco.sandbox.scripts.scala.colletions

object ListCollectionsFun extends App {
	
	val teams = List("Grêmio FC","São Paulo FC","Palmeiras FC","Inter FC")
	println(teams.head)
	println(teams(1))
	
	val moreTeams = "Curitiba" :: teams
	println(moreTeams.head)
	println(moreTeams)	
	
	val brasileirao = teams ::: (List("Curitiba FC"))
	println(brasileirao)
	
	println( brasileirao filter(_ contains "mio") )
	println( brasileirao forall(_ contains " FC") )
	println( brasileirao exists(_ contains "on") )
	println( brasileirao map(_ length) )
	
	// '/:' is foldLeft 
	val teamsSizes = (0 /: brasileirao){ (t,v) => t + v.length() }
	printf("Team sizes %d \n",teamsSizes)
	printf("Team sizes %d \n", (0 /: brasileirao){ _ + _.length() } )
	
	printf("Sizes %d \n", (0 /: ("ABC" :: "DE" :: "CC" :: Nil)){ _+_.length } )
	
}