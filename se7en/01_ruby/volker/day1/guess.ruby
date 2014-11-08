toGuess = rand(10)
begin
    number = Integer(gets)
    puts "Bingo!  " if number == toGuess
    puts "too low " if number < toGuess
    puts "too high" if number > toGuess
end while number != toGuess
