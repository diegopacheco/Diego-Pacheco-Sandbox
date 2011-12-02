def readAllFile  
  #
  # Approach 1
  #
  IO.foreach("./resources/simple.txt") { |line| 
    print "Read: ", line 
  }  
  #
  # Approach 2
  #  
  IO.readlines("./resources/simple.txt").each{
   |l| puts l
  }  
end

def writeStdErr
   file = IO.new(2,"w+")
   $stderr.puts "Error?"
   file.puts "World World Ruby IO"
end

def writeIOFile(buffer)
  file = File.new("./resources/test.txt", "w+")
  file.write "write: #{buffer}" 
  file.close  
end

def listDirs
  Dir.foreach("C:/") do |entry|
    puts entry
  end
end

listDirs