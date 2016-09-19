import XCTest
@testable import PrimeFactors

class PrimeFactorsTests: XCTestCase {

    func testThat2Returns2() {
        let result = 2.primeFactors()
        XCTAssertEqual(result, [2])
    }

    func testThat3Returns3() {
        let result = 3.primeFactors()
        XCTAssertEqual(result, [3])
    }

    func testThat4Returns4() {
        let result = 4.primeFactors()
        XCTAssertEqual(result, [2, 2])
    }

    func testThat6Returns2And3() {
        let result = 6.primeFactors()
        XCTAssertEqual(result, [2, 3])
    }

    func testThat9Returns3And3() {
        let result = 9.primeFactors()
        XCTAssertEqual(result, [3, 3])
    }

    func testThat12Returns2And2And3() {
        let result = 12.primeFactors()
        XCTAssertEqual(result, [2, 2, 3])
    }

    func testThat15Returns3And5() {
        let result = 15.primeFactors()
        XCTAssertEqual(result, [3, 5])
    }

    func testThat1ReturnsNoPrimeFactors() {
        let result = 1.primeFactors()
        XCTAssertEqual(result, [])
    }
}
