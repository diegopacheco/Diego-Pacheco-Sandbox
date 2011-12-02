module Mywavesapp
  module Resources
    class Server < Mywavesapp::Resources::Default      
      def get
        view(:pages).welcome
      end
    end
  end
end