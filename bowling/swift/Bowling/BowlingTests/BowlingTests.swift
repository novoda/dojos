import XCTest
@testable import Bowling

class BowlingTests: XCTestCase {

    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of
        // each test method in the class.
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of
        // each test method in the class.
        super.tearDown()
    }

    func testThatItIsSetUp() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        let bowling = Bowling()
        let isSetup = bowling.isSetup()
        XCTAssert(isSetup)
    }

}
