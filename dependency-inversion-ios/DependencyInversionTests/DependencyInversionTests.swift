import XCTest
import Foundation

class DependencyInversionTests: XCTestCase {
    
	func testWhenAFruitHasNotBeenCached_ItIsLoadedFromTheInternet() {

	}

	func testWhenAFruitHasBeenCached_ItIsLoadedFromTheCache() {

	}

	func testWhenAFruitHasNotBeenCached_ButLoadingFromTheInternetFails_NoFruitIsReturned() {

	}
    
}

// Here are the implementations

class CachingFruitFetcher {

	func fetchFruit() -> Fruit? {
		if let name = UserDefaults.standard.string(forKey: "lastFruit") {
			return Fruit(name: name)
		} else {
			let maybeFruit = try? InternetFruitRepository.instance.loadFruitFromInternet()
			UserDefaults.standard.set(maybeFruit?.name, forKey: "lastFruit")
			return maybeFruit
		}
	}

}

struct Fruit {
	let name: String
}

// Don't change the implementation of this file! You can make the class implement a protocol though.
class InternetFruitRepository {

	static let instance = InternetFruitRepository()

	func loadFruitFromInternet() throws -> Fruit {
		// this acts like the internet, it's slow and then sometimes, it just fails!
		let shouldFail = Int(arc4random_uniform(3)) == 0
		Thread.sleep(forTimeInterval: 1)
		if shouldFail {
			throw NSError(domain: "BadInternet", code: 0)
		} else {
			return Fruit(name: "Banana")
		}
	}

}