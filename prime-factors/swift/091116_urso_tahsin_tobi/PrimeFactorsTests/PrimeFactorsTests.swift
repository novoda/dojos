import XCTest
@testable import PrimeFactors

class PrimeFactorsTests: XCTestCase {
    
    let primeFactor = PrimeFactor()
    
    func testThatShouldFactorizeTwo() {
        
        let primes = primeFactor.factorize(2)
        
        XCTAssertEqual(primes, [2])
    }
    
    func testThatShouldFactorizeThree() {
        
        let primes = primeFactor.factorize(3)
        
        XCTAssertEqual(primes, [3])
    }
    
    func testThatShouldFactorizeFour() {
        
        let primes = primeFactor.factorize(4)
        
        XCTAssertEqual(primes, [2, 2])
    }
    
    func testThatShouldFactorizeSix() {
        
        let primes = primeFactor.factorize(6)
        
        XCTAssertEqual(primes, [2, 3])
    }
    
    func testThatShouldFactorizeNine() {
        
        let primes = primeFactor.factorize(9)
        
        XCTAssertEqual(primes, [3, 3])
    }
    
    func testThatShouldFactorizeTwelve() {
        
        let primes = primeFactor.factorize(12)
        
        XCTAssertEqual(primes, [2, 2, 3])
    }
    
    func testThatShouldFactorizefifteen() {
        
        let primes = primeFactor.factorize(15)
        
        XCTAssertEqual(primes, [3, 5])
    }
}
