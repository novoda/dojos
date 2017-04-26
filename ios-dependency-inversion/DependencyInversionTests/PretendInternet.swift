//
//  PretendInternet.swift
//  DependencyInversion
//
//  Created by Alex on 17/03/2017.
//  Copyright © 2017 novoda. All rights reserved.
//

import Foundation

private let fruitNames = ["Kiwi", "Banana", "Apple", "Orange"]

func randomFruitName() -> String {
	let randomIndex = Int(arc4random_uniform(UInt32(fruitNames.count)))
	return fruitNames[randomIndex]
}
