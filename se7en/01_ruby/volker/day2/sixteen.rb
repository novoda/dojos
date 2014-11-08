def print_blocks(arr)
  (0..3).each do |line|
      index = 4*line
      print_line arr[index..index+3]
  end
end

def print_blocks_sliced(arr)
    arr.each_slice(4).each do |line|
        print_line line
    end
end

def print_line(arr)
    puts arr.to_s
end

a = (1..16).to_a

print_blocks(a)
print_blocks_sliced(a)
