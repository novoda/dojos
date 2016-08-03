import XCTest
@testable import PaperScissorsStone

class PaperScissorsStoneTests: XCTestCase {

	let rules = [Rule(that: "rock", beats: "scissors"), Rule(that: "scissors", beats: "paper"), Rule(that:"paper", beats:"rock")]

    
	func testRockBeatsScissors() {
		XCTAssert(Game(mine: "rock", yours: "scissors", rules: rules).wins())
	}

	func testScissorsDontBeatRock() {
		XCTAssertFalse(Game(mine: "scissors", yours: "rock", rules: rules).wins())
	}

	func testScissorsBeatsPaper() {
		XCTAssert(Game(mine: "scissors", yours: "paper", rules: rules).wins())
	}

	func testPaperbeatsRock() {
		XCTAssert(Game(mine: "paper", yours: "rock", rules: rules).wins())
	}

}

struct Game {

	let mine: String
	let yours: String
	let rules: [Rule]

	func wins() -> Bool {
		for rule in rules {
			if (rule.matches(mine, yours: yours)) {
				return true
			}
		}
		return false
	}

}

struct Rule {

	let that: String
	let beats: String

	func matches(mine: String, yours: String) -> Bool {
		if mine == that && yours == beats {
			return true
		} else {
			return false
		}
	}

}


