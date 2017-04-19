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
			let maybeFruit = try? InternetFruitFetcher.instance.loadFruitFromInternet()
			UserDefaults.standard.set(maybeFruit?.name, forKey: "lastFruit")
			return maybeFruit
		}
	}

}

struct Fruit {
	let name: String
}

class InternetFruitFetcher {

	static let instance = InternetFruitFetcher()

	func loadFruitFromInternet() throws -> Fruit {
		// pretend this loads a fruit from some API
		return Fruit(name: "Banana")
	}

}
