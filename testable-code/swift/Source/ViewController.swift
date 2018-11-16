//
//  ViewController.swift
//  Testable code
//
//  Created by Alex Curran on 16.11.18.
//  Copyright © 2018 Novoda. All rights reserved.
//

import UIKit

let apiEndpoint = URL(string: "https://gist.githubusercontent.com/amlcurran/b624b77e50541e41a2b17e2f0bd5aa5a/raw/c5c7eca6afba21c4a9160fb301bd56b965c2c8ca/PretendAPI.txt")!

class ViewController: UIViewController {

    @IBOutlet weak var normalText: UILabel!
    @IBOutlet weak var firstTimeText: UILabel!
    @IBOutlet weak var loadedInfoText: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white

        if UserDefaults.standard.bool(forKey: "hasShownFirstTime") {
            normalText.isHidden = false
            firstTimeText.isHidden = true
            normalText.backgroundColor = UIColor.red.withAlphaComponent(0.1)
            
            let task = URLSession.shared.dataTask(with: apiEndpoint) { data, _, _ in
                if let data = data {
                    DispatchQueue.main.async {
                        self.loadedInfoText.text = String(data: data, encoding: .utf8)
                        self.loadedInfoText.isHidden = false
                    }
                }
            }
            task.resume()
        } else {
            UserDefaults.standard.set(true, forKey: "hasShownFirstTime")
            normalText.isHidden = true
            firstTimeText.isHidden = false
            firstTimeText.backgroundColor = UIColor.blue.withAlphaComponent(0.1)
        }
    }

}
