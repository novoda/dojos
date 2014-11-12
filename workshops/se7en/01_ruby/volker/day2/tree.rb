class Tree
    attr_accessor :children, :node_name

    def initialize(hash)
      @node_name, childHash = hash.first
      @children = []
      childHash.each { |k,v|
          children.push(Tree.new({k =>v}))
      }
    end

    def visit_all(&block)
        visit &block
        children.each {|c| c.visit_all &block}
    end

    def visit(&block)
        block.call self
    end
end

tree = Tree.new({"grandpa" => {
        "dad" => {"child 1" => {}, "child 2" => {} },
        "uncle" => {"child 3" => {}, "child 4" => {} }}})
tree.visit_all {|node| puts node.node_name}
