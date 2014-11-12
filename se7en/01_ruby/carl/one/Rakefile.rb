
task :one do
	puts "Hello, world."
end

task :two do
	puts "Hello, Ruby".index("Ruby")
end 

task :three do
	(0..10).each { puts 'Carl' } 
end

task :four do
	(1..10).each do |n| 
		puts "this is sentence number #{n},"
	end
end

task :five do
	n = rand(10)
	begin
		guess = STDIN.gets
		g = guess.to_i
		if g > n 
			puts "to high"
		elsif g < n 
			puts "to low"
		elsif g == n
		 	puts "bingo"
		end
	end while g != n
end