#!/usr/bin/env ruby
def guess_number
  $min_number  = 0
  $max_number = 10
  random = rand($min_number..$max_number)
  puts "Guess a number between #{$min_number} and #{$max_number}:"

  loop do
    chosen_number = gets.chomp.to_i
    if(chosen_number == random)
      puts "Got it!"
      exit
    elsif(chosen_number < random)
      puts "Too low, guess again"
    else
      puts "Too high, guess again"
    end
  end
end

guess_number
