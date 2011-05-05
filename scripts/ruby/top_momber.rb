require 'find'

class JavaMonster		
	@@pattern  = /.+\.java$/
	
    class MonsterFile	
    	  attr_accessor :name, :size	
    	  def initialize(namep = 'Unknown', sizep = 0)
    		  @name = namep		  
    		  @size = sizep
    	  end	  	  
    end  
   
    def top3(path, silence = false)	
		clear_score
  	    Find.find(path) do |entry|
    			if File.file?(entry) and entry[@@pattern]
                    name  = extract(entry)			
    				lines  = search(entry,name,silence)
    				score(lines,name)								
    			end
  		end
		printMonsters(path)
	end	
	
	private
	
	def extract(entry)			
		File.basename(entry)
	end
	
	def search(entry,name,silence)
		lines = 0
		f = File.open(entry, "r")		
		f.each_line { lines = lines + 1 }
		puts "#{lines.to_s.ljust(6)} - #{name}" unless silence
		lines
	end
	
	def score(lines,name)
		if lines > @@hash_top[:first].size		   
		   @@hash_top[:third].name  = @@hash_top[:second].name
           @@hash_top[:third].size  = @@hash_top[:second].size
       
		   @@hash_top[:second].name = @@hash_top[:first].name
		   @@hash_top[:second].size = @@hash_top[:first].size
       
		   @@hash_top[:first].name = name
		   @@hash_top[:first].size = lines
		elsif lines > @@hash_top[:second].size
		   @@hash_top[:third].name  = @@hash_top[:second].name
           @@hash_top[:third].size  = @@hash_top[:second].size
       
		   @@hash_top[:second].name = name
		   @@hash_top[:second].size = lines
		elsif lines > @@hash_top[:third].size
		   @@hash_top[:third].name = name
		   @@hash_top[:third].size = lines
        end 		   
	end
	
	def printMonsters(path)		
		puts " =============================================================== "
		puts " =============== TOP MONSTERS ================================== "
		puts " =============================================================== "
		puts " Project: #{path}"
		puts " =============================================================== "
		puts " 1 [Bieber     ] is #{@@hash_top[:first].size.to_s.ljust(6)} LOC  - #{@@hash_top[:first].name}"
		puts " 2 [Kutcher    ] is #{@@hash_top[:second].size.to_s.ljust(6)} LOC  - #{@@hash_top[:second].name}"
		puts " 3 [Timberlake ] is #{@@hash_top[:third].size.to_s.ljust(6)} LOC  - #{@@hash_top[:third].name}"
		puts " =============================================================== "
	end
	
	def clear_score
		@@hash_top = {   
		   :first  => MonsterFile.new,
		   :second => MonsterFile.new,
		   :third  => MonsterFile.new
		}
	end
	
end

start = Time.now
monster = JavaMonster.new
#path    = "D:/Diego/svn-repos/wcsiLegra/NextGenTR/Services-SRC"
path    = "D:/Diego/svn-repos/wcsiLegra/NextGenTR/Architecture-SRC"
Dir.foreach(path) { |d|
   if !File.file?(d)
	  monster.top3 "#{path}/#{d}", true
   end 	
}
puts "This script run in #{Time.now - start}"