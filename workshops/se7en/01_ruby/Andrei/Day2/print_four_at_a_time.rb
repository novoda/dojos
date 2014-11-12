#!/usr/bin/env ruby
def print_four_at_a_time_with_each
  $i = 0
  a=[]
  (1..16).each do |x|
    a << x
    $i+=1
    if ($i%4==0)
      p a
      a=[]
    end
  end
end

def print_four_at_a_time_with_each_slice
  (1..16).each_slice(4) {|x| p x}
end

print_four_at_a_time_with_each
puts
print_four_at_a_time_with_each_slice
