require 'rubygems'
require 'mongo'

cnn  = Mongo::Connection.new("localhost").db("testMONGO")
coll = cnn.collection("testColl")

doc =  {
          "FullName" => "Diego Pacheco", 
          "DevType"  => "Software Architect", 
          "NumCount" => 1,
          "InfoDev"  => { 
                       "age"  => 26, 
                       "code" => '1'
                     }
        }
coll.insert(doc)
puts "Collection name: #{cnn.collection("testColl").name}"

coll = cnn.collection("testColl")
puts coll.inspect

coll.find().each { |docResult| puts docResult.inspect }
#coll.find("NumCount" => 1).each { |docResult| docResult.each{
#      |co| puts co
#  } 
#}