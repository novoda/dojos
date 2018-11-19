//
//  PresenterTests.swift
//  Testable codeTests
//
//  Created by Alex Curran on 16.11.18.
//  Copyright © 2018 Novoda. All rights reserved.
//

import XCTest

class PresenterTests: XCTestCase {

    override func setUp() {
        
    }

    override func tearDown() {
        
    }

    func testTheFirstTimeThePresenterPresentsItShowsTheFirstTimeExperience() {
        // UserDefaults.standard.removeEverything()
        // let mockView = MockView()
        // let presenter = Presenter(view: mockView)
        
        // presenter.beginPresenting()
        
        // XCTAssertTrue(mockView.hasShownFirstTimeExperience)
    }
    
    func testWhenThePresenterHasPresentedBeforeThenItShowsTheNormalText() {
        
    }
    
    func testWhenThePresenterHasPresentedBeforeAndTheApiLoadsDataItIsShownOnTheScreen() {
        
    }

}

//class MockView: View {
//
//    var hasShownFirstTimeExperience = false
//    var hasShownNormalText = false
//    var textFromApi: String?
//
//    func showFirstTimeExperience() {
//        shownFirstTimeExperience = true
//    }
//
//    func showNormalText() {
//        shownNormalText = true
//    }
//
//    func showText(fromApi apiText: String) {
//        textFromApi = api
//    }
//
//}

private extension UserDefaults {
    
    func removeEverything() {
        setPersistentDomain([:], forName: Bundle.main.bundleIdentifier!)
    }
    
}
