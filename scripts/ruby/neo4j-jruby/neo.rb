require "rubygems"
require 'neo4j'

Neo4j::Transaction.run do
	node = Neo4j::Node.new(:name => 'diego_pacheco')
	node.outgoing(:friends) << Neo4j::Node.new(:name => 'poletto')
	node.outgoing(:friends) << Neo4j::Node.new(:name => 'christophe')
	node.outgoing(:friends).each {|node| puts "name #{node[:name]}"}
end