require 'find'

class JavaMonster		
	
	@@annotations = {  "@Test"         => 0,
	                   "@Refactoring"  => 0,
                       "@DoubleCheck"  => 0,
                       "@Ignore"       => 0,
					   "@Deprecated"   => 0,
					   "@Warning"      => 0,
					   "@Design"       => 0,
					   "@TDD"          => 0}
					   
	@@exclusions  = [ ".svn",
	                  ".gitignore",
					  "ngs-ontology",
					  "ngs-autocomplete",
					  "no-jndi",
					  "/conf/",
					  "database",
					  "/.settings",
					  "/target/",
					  "/ngs-storage",
					  "src/developer/test" ]					  
		
	@@pattern            = /.+\.java$/
	@@last_printed 		 = ""
	@@total_java_classes = 0 
	@@total_loc_classes  = 0
					  
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
		puts "AVG LOC         => #{@@total_loc_classes / @@total_java_classes}"
		puts "\nTotal classes analyzed [#{@@total_java_classes}]"
		puts "This script run in [#{t}]"
	end
	
	private
	
	def scan(path,entry,silence)		
		name   = extract(entry)			
		lines  = search(entry,name,silence)
		score(lines,name)
	end
	
	def should_scan?(path,entry)	    
		@@exclusions.each { |e|
		   if (entry.include? e)
		      return false
		   end
		}
		return true
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
		count_annotations(name,javaClass)
		
		@@total_java_classes = @@total_java_classes + 1
		@@total_loc_classes  = @@total_loc_classes + lines
		lines
	end
	
	def debug_if_needed(silence)
		puts "#{lines.to_s.ljust(6)} - #{name}" unless silence	
	end
	
	def count_annotations(name,javaClass)	
	    @@annotations.each { |k,v|
		    count = javaClass.scan(k).size.to_i
			if count >= 1 
				@@annotations[k] = v + count
			end
		}
	end
	
	def print_annotations_count
	   puts "=== Annotations Sumary "
	   @@annotations.each { |k,v|
		   puts "#{k}".ljust(15, " ") + " => #{v}"
	   }
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
		    printstr  = ""
			printstr += " =============================================================== \n"
			printstr += " =============== TOP MONSTERS ================================== \n"
			printstr += " =============================================================== \n"
			printstr += " Project: #{path} \n"
			printstr += " =============================================================== \n"
			printstr += " 1 [Bieber     ] is #{@@hash_top[:first].size.to_s.ljust(6)} LOC  - #{@@hash_top[:first].name} \n"
			printstr += " 2 [Kutcher    ] is #{@@hash_top[:second].size.to_s.ljust(6)} LOC  - #{@@hash_top[:second].name} \n"
			printstr += " 3 [Timberlake ] is #{@@hash_top[:third].size.to_s.ljust(6)} LOC  - #{@@hash_top[:third].name} \n"
			printstr += " =============================================================== \n"
			if (printstr != @@last_printed)
			    puts printstr
			    @@last_printed = printstr
			end			
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

