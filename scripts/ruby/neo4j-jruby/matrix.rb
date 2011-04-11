require "rubygems"
require "neo4j"

#
# Monkey Patch the Traverser to have second method :-)
#
class Neo4j::Traversal::Traverser
	def second
		self[1]
	end
end

#
# NEO4J code with Matrix Relationshio, it kicks Ass :D This code run in a transactional context
#
Neo4j::Transaction.run do
	
	#
	# I just create nodes with sumbol and put whatever you want
	#
	neo       = Neo4j::Node.new(:name => 'Neo', :realname => "Thomas Anderson", :rank => "The One")
	morpheus  = Neo4j::Node.new(:name => 'Morpheus', :rank => "Captain", :occupation => "total badass")
	trinity   = Neo4j::Node.new(:name => 'Trinity', :rank => "Girlfriend")
	smith     = Neo4j::Node.new(:name => 'Smith', :language => "C++", :version => "1.0b", :rank => "-1")
	architect = Neo4j::Node.new(:name => 'Architect', :rank => "0")
	cypher    = Neo4j::Node.new(:name => 'Cypher', :rank => "sucks")
	
	#
	# I'm defining a couple of relationships	 
	#
	neo.outgoing(:knows) << trinity
	neo.outgoing(:knows) << morpheus
	morpheus.outgoing(:knows) << trinity
	morpheus.outgoing(:knows) << cypher
	cypher.outgoing(:knows) << smith
	smith.outgoing(:knows) << architect
	
	#
	# Here we have relationship properties(and my monkey ptach)
	#
	neo.outgoing(:knows).first[:since]        = "3 days"
	neo.outgoing(:knows).second[:since]       = "1 day"	
	
	#
	# Finally, iterating the nodes looking for neo relationsip deep 1
	#
	i = 0
	puts "Neo knows "
	neo.outgoing(:knows).each { |node| 
		puts "\t#{node[:name]} rank: #{node[:rank]} for #{neo.outgoing(:knows)[i][:since]}"
		 
		node.outgoing(:knows).each { |known| 
			puts "\t || knows #{known[:name]}"
		}
		i = i + 1
	}
end