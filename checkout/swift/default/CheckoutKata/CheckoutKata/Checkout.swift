//
// Created by Richard Tolley on 2019-02-18.
// Copyright (c) 2019 Novoda. All rights reserved.

// Based on Pragmatic Dave's 'Back to the Checkout' kata (http://codekata.com/kata/kata09-back-to-the-checkout/)
// The task is to build a checkout system that can handle complex rules for items. I've added some

// Item     Unit Price      Special Price
// --------------------------------------
// A        50              3 for 130
// B        30              2 for 45
// C        20
// D        15              3 for 2
// E        10              3 for 2
// F        15              10 if after 5pm
// G        35              10 if after 6pm, 3 for 2

//(for part 7 only)
// H



//Tasks:

// 1. Basic functionality (simple pricing)

// 2. Multiple item discount for a single item (3 of x for 1.30)

// 3. Multiple item discount for a group of items (3 for 2, buy one, get another 1/2 price)

// 4. Discount after a specific time of day (happy hour)

// 5. Customer loyalty card 1 (£10 off for every £100 spent).

// 6. Customer loyalty card 2 (stamp card - £10 for every 10 stamps) The system should work with both loyalty cards

// 7. a) Multiple offer types can apply to the same item (can be part of a 3 for 2, and also 20
//    b) If multiple offers apply, only the one that gives the single greatest discount is applied).

import Foundation

// (Stock Keeping Unit) - an item to be sold
struct Sku {

}

// The rules used to process items
class CheckoutRules {

}

protocol Checkout {
    init(rules: CheckoutRules)
    //This prototype is just a suggestion - some of the later questions (e.g. customer loyalty card) will need extra params.
    func process(items: [Sku]) -> Double
}

class ConcreteCheckout {
    init(rules: CheckoutRules) {}
    func process(items: [Sku]) -> Double {
        return 0
    }
}
