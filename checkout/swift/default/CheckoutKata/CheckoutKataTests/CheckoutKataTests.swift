//
//  CheckoutKataTests.swift
//  CheckoutKataTests
//
//  Created by Richard Tolley on 2019-02-18.
//  Copyright © 2019 Novoda. All rights reserved.
//

import XCTest
@testable import CheckoutKata

class CheckoutKataTests: XCTestCase {
    
    var checkout: ConcreteCheckout!

    override func setUp() {
        let rules = CheckoutRules()
        checkout = ConcreteCheckout(rules: rules)
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    func testExample() {
        XCTAssertEqual(checkout.process(items: [Sku]()), 0)
    }
}
