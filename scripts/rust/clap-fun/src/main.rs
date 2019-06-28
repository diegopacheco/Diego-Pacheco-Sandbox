extern crate clap; 
use clap::App; 
 
fn main() { 
    App::new("clapfun")
       .version("1.0.0")
       .about("Does great rusty things!")
       .author("Diego Pacheco.")
       .get_matches(); 
}