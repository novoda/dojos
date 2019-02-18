import Foundation

// (Stock Keeping Unit) - an item to be sold
struct Sku {

}

// The rules used to process items
class CheckoutRules {

}

protocol Checkout {
    init(rules: CheckoutRules)
    //This prototype is just a suggestion - some of the later questions (e.g. customer loyalty card) will need extra params, such as a date, or a representation of a customer loyalty card or cards
    func process(items: [Sku]) -> Double
}

class ConcreteCheckout {
    init(rules: CheckoutRules) {}
    func process(items: [Sku]) -> Double {
        return 0
    }
}
