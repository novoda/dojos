line_num=0
File.open('sixteen.rb').each do |line|
  line_num += 1
  print "#{line_num} #{line}" if line =~ /print/
end
