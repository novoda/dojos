randomNumber = rand(8) 
puts "Try to guess the random number! (0-7)"

while randomNumber >= 0
    guess = gets.chomp.to_i
    
    puts "#{guess} was too high, try again!" if guess > randomNumber
    puts "#{guess} was too low, try again!" if guess < randomNumber
    
    if guess == randomNumber
        puts "#{guess} was correct, well done!" if guess == randomNumber
        randomNumber = -1
    end
end 
