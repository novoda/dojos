import XCTest
@testable import PrimeFactors

class PrimeFactorsTests: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testThatOneIsItsOwnPrime() {
        let primeFactors = PrimeFactors()

        let result = primeFactors.factorize(1)

        XCTAssertEqual(result, [1])
    }

    func testThatFourFactorizesToTwoAndTwo() {
        let primeFactos = PrimeFactors()

        let result: [Int] = primeFactos.factorize(4)

        XCTAssertEqual(result, [2, 2])
    }
}
