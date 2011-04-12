require "rubygems"
require "neo4j"
require "java"

class PathFinder
	def self.print_shortest_path(from,to)		
	    puts "Route from #{from[:name]} to #{to[:name]}:"
		it   = Neo4j::Algo.shortest_path(from,to).iterator
		last = from[:name]
		it.next
		while it.hasNext
			n = it.next
			if !n[:name].blank?
				puts "  #{last} -> #{n[:name]}"
				last = n[:name]
			end
		end
	end
end

Neo4j::Transaction.run do
	
	miami   = Neo4j::Node.new(:name => 'Miami'       , :state => "Florida"    , :ab => "FL")
	ny      = Neo4j::Node.new(:name => 'New York'    , :state => "New York"   , :ab => "NY")
	wichita = Neo4j::Node.new(:name => 'Wichita'     , :state => "Kansas"     , :ab => "KS")
	austin  = Neo4j::Node.new(:name => 'Austin'      , :state => "Texas"      , :ab => "TX")
	detroit = Neo4j::Node.new(:name => 'Detroit'     , :state => "Michigan"   , :ab => "MI")
	denver  = Neo4j::Node.new(:name => 'Denver'      , :state => "Colorado"   , :ab => "CO")	
	la      = Neo4j::Node.new(:name => 'Los Angeles' , :state => "California" , :ab => "CA")
	
	miami.outgoing(:to) << ny	
	miami.outgoing(:to) << austin
	ny.outgoing(:to) << miami
	ny.outgoing(:to) << detroit
	detroit.outgoing(:to) << ny
	detroit.outgoing(:to) << wichita
	wichita.outgoing(:to) << detroit
	wichita.outgoing(:to) << denver
	denver.outgoing(:to) << wichita
	denver.outgoing(:to) << la
	austin.outgoing(:to) << miami
	austin.outgoing(:to) << wichita
	la.outgoing(:to) << austin
	la.outgoing(:to) << denver

	PathFinder.print_shortest_path miami, wichita

end