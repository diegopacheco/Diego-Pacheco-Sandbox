require 'rubygems'
require 'eventmachine'

class RocksCallback
  include EM::Deferrable
  def say(str)
    puts "Rocks #{str} a lot !!!"
  end
end

EM.run do
  cb = RocksCallback.new
  cb.callback do |s|
    cb.say(s)
    EM.stop
  end	
  EM.add_timer(1) do
    cb.set_deferred_status :succeeded, "EventMachine"
  end
end

# $ ruby em-defer.rb
# Rocks EventMachine a lot !!!

