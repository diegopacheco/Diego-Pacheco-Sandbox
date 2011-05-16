package com.github.diegopacheco.sandbox.scripts.scala.basic

import scala.actors._
import Actor._

object TopStock {

  def main(args: Array[String]) {

		val symbols = List("AAPL", "GOOG")
		val receiver = self
		val year = "snd1l1yr"
		
		symbols.foreach { symbol => 
			actor { receiver ! getYearEndClosing(symbol, year) }
		}
		
		val (topStock, highestPrice) = getTopStock(symbols.length)
		printf("Top stock of %d is %s closing at price %f\n", year, topStock, highestPrice)		
    }
  
  	def getYearEndClosing(symbol : String, year : String) = {		
		val url = "http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=" + year
		printf("%s\n", url)		   
		
		val data  = io.Source.fromURL(url).mkString
		val price = data.split("\n")(0).split(",")(3).toDouble
	}
		
	def getTopStock(count : Int) : (String, Double) = {
		(1 to count).foldLeft("", 0.0) { (previousHigh, index) =>
			receiveWithin(1000) {
				case (symbol : String, price : Double) =>
				   if (price > previousHigh._2) (symbol, price) else previousHigh
			}		
		}
	}
  
}