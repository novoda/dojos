#---
# Excerpted from "Seven Languages in Seven Weeks",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material, 
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose. 
# Visit http://www.pragmaticprogrammer.com/titles/btlang for more book information.
#---
module ActsAsCsv
  def self.included(base)
    base.extend ClassMethods
  end
  
  module ClassMethods
    def acts_as_csv
      include InstanceMethods
    end
  end
  
  module InstanceMethods   
    def read
      @csv_contents = []
      filename = self.class.to_s.downcase + '.txt'
      file = File.new(filename)
      @headers = file.gets.chomp.split(', ')

      file.each do |row|
        @csv_contents << row.chomp.split(', ')
      end
    end
    
    attr_accessor :headers, :csv_contents
    def initialize
      read 
    end
    
    def each(&block)
      list = []
      csv_contents.each do |item|
      row = CsvRow.new()
      	headers.each_with_index do |header, index|
      		row[header] = item[index]
      	end
      	list.push row
      end
      list.each { |item| block.call item }
    end
  end
end

class CsvRow < Hash
	def method_missing name, *args
		heading = name.to_s
		self[heading]
	end
end

class RubyCsv  # no inheritance! You can mix it in
  include ActsAsCsv
  acts_as_csv
end

m = RubyCsv.new
#puts m.headers.inspect
#puts m.csv_contents.inspect
m.each {|row| puts row.race}
