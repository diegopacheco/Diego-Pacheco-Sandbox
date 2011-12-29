package com.github.diegopacheco.sandbox.scripts.scala.colletions

object SetCollectionFun extends App {
	
	val sites = Set("http://diego-pacheco.blogspot.com",
	    			"http://www.twitter.com/diego_pacheco",
	    			"http://www.slideshare.net/diego.pacheco",
	    			"https://github.com/diegopacheco")
	println(sites)    			
	
	val github = sites filter (_ contains "github")
	println(github)
	
	val otherSites = Set("http://vimeo.com/diegopacheco",
	    				 "http://www.twitter.com/diego_pacheco")
	val merged = sites ++ otherSites
	println(merged)
	
	val diff = sites ** otherSites
	println(diff)
	
}