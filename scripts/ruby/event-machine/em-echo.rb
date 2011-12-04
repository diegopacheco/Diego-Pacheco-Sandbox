require 'rubygems'
require 'eventmachine'

module Echo
  def receive_data data
    send_data data + " hahaha"
  end
end

EM.run do
  EM.start_server "127.0.0.1", 10001, Echo
end

# $ telnet 127.0.0.1 10001
# d hahaha i hahaha e hahaha g hahaha o hahaha

