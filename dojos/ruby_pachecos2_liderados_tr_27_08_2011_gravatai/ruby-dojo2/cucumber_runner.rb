require 'rubygems'
require 'cucumber/cli/main'
require 'spec'

Cucumber::Cli::Main.execute(['--format', 'pretty',"features"])