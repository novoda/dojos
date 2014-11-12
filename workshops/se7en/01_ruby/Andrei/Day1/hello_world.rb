#!/usr/bin/env ruby

def execute_methods
  hello_world
  index_of_ruby
  print_my_name_10_times
  sentence_number
end

def hello_world
  puts 'Hello, world'
end

def index_of_ruby
  hello='Hello, Ruby.'
  ruby='Ruby'
  puts "Index of #{ruby} is #{hello.index(ruby)}"
end

def print_my_name_10_times
  name='Andrei'
  10.times {puts name}
end

def sentence_number
  (1..10).each do |i|
    puts "This is sentence number #{i}"
  end
end

execute_methods





