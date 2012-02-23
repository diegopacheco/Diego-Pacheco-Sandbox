require 'find'

class JavaMonster		
	
	@@pattern  = /.+\.java$/
	@@total_refactorings = 0
	@@total_doublecheck  = 0
	@@total_ignore       = 0
	
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
			if File.file?(entry) and entry[@@pattern] and should_scan?(path,entry)
			    scan(path,entry,silence)
				printMonsters(path)
			end	    			
  		end				
	end	
	
	def post_proccess(path,t)
		print_annotations_count
		puts "This script run in #{t}"
	end
	
	private
	
	def scan(path,entry,silence)		
		name   = extract(entry)			
		lines  = search(entry,name,silence)
		score(lines,name)
	end
	
	def should_scan?(path,entry)
		if (entry.include? ".svn" or 
		   entry.include? ".gitignore" or
		   entry.include? "ngs-ontology" or 
		   entry.include? "ngs-autocomplete" or
		   entry.include? "no-jndi" or
		   entry.include? "/conf/" or
		   entry.include? "database" or
		   entry.include? "/.settings" or 
		   entry.include? "/target/")
		   return false
		else
           return true
		end	
	end
	
	def print_annotations_count
	   puts "@Refactoring => #{@@total_refactorings}"
	   puts "@DoubleCheck => #{@@total_doublecheck}"
	   puts "@Ignore => #{@@total_ignore}"	   
	end
	
	def extract(entry)			
		File.basename(entry)
	end
	
	def search(entry,name,silence)
	    javaClass = ""
		lines = 0

		f = File.open(entry, "r")		
		f.each_line { |l|
			lines     = lines + 1 
			javaClass = javaClass + l
		}
		
		debug_if_needed(silence)
		count_refactoring(name,javaClass)
		count_doublecheck(name,javaClass)
		count_ignore(name,javaClass)
		
		lines
	end
	
	def debug_if_needed(silence)
		puts "#{lines.to_s.ljust(6)} - #{name}" unless silence	
	end
	
	def count_refactoring(name,javaClass)
		count = javaClass.scan("@Refactoring").size.to_i
		if count >= 1 
			@@total_refactorings = @@total_refactorings + count
		end	
	end
	
	def count_doublecheck(name,javaClass)
		count = javaClass.scan("@DoubleCheck").size.to_i
		if count >= 1 
			@@total_doublecheck = @@total_doublecheck + count
		end	
	end
	
	def count_ignore(name,javaClass)
		count = javaClass.scan("@Ignore").size.to_i
		if count >= 1 
			@@total_ignore = @@total_ignore + count
		end	
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
		size = @@hash_top[:first].size + @@hash_top[:second].size + @@hash_top[:third].size
		if (size>=1)
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
	end
	
	def clear_score
		@@hash_top = {   
		   :first  => MonsterFile.new,
		   :second => MonsterFile.new,
		   :third  => MonsterFile.new
		}
	end
	
end

start   = Time.now
monster = JavaMonster.new
path    = "D:/diego/svn-repos/wcsiLegra/cortellis/trunk/Services-SRC/services"
#path   = "D:/diego/svn-repos/wcsiLegra/cortellis/trunk/Architecture-SRC"

Dir.foreach(path) { |d|
   if !File.file?(d)
      if (d != "." and d != "..")
		 monster.top3 "#{path}/#{d}", true
	  end	 
   end 	
}
monster.post_proccess(path,(Time.now - start))

