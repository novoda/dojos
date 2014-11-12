#!/usr/bin/env ruby
puts 'Guess my number (between 1 and 10)'
puts '----------------------------------'

def start_guess_game(number)
	guessed = false

	while not guessed
		try = gets.to_i
		if try == number
			guessed = true
		elsif number < try
			puts "The number is smaller than #{try}"
		elsif number > try
			puts "The number is bigger than #{try}"
		end
	end

	puts "You guessed it! The number is #{number}"
end

number = rand(10) + 1
start_guess_game(number)