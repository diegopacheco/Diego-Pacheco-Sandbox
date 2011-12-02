require 'waves/views/cassy'
class Mywavesapp::Views::Css < Cassy
  
  include Waves::Views::Mixin
  
  def default
    body {
      font_family 'sans-serif'
      width '800px'
      margin '20px auto'
    }
  end
  
end