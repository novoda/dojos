import XCTest
import Foundation
@testable import DependencyInversion

class DependencyInversionTests: XCTestCase {
    
	func testWhenAFruitHasNotBeenCached_ItIsLoadedFromTheInternet() {
        _ = CachingFruitFetcher()
	}

	func testWhenAFruitHasBeenCached_ItIsLoadedFromTheCache() {

	}

	func testWhenAFruitHasNotBeenCached_ButLoadingFromTheInternetFails_NoFruitIsReturned() {

	}
    
}
