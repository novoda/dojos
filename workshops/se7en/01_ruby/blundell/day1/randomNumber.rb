x = 0
r = rand(10)
while x != 'quit' 
   puts 'Enter a number, or type quit'
   x = gets
   if x.to_i == r
     puts 'correct!'
     x = 'quit'
   end
   if x.to_i < r
    puts 'higher'
   else 
    puts 'lower'
   end
 end
