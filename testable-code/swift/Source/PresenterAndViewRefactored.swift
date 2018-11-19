//
//  PresenterAndViewSolution.swift
//  Testable codeTests
//
//  Created by Alex Curran on 16.11.18.
//  Copyright © 2018 Novoda. All rights reserved.
//

import Foundation

// you should have something that looks like this, once you have finished part 1.
// If you didn't get this, copy this all into ViewController.swift,
// uncomment it, and then you can proceed with part 2

//class ViewController: UIViewController, View {
//
//    @IBOutlet weak var normalText: UILabel!
//    @IBOutlet weak var firstTimeText: UILabel!
//    @IBOutlet weak var loadedInfoText: UILabel!
//    private var presenter: Presenter!
//
//    override func viewDidLoad() {
//        super.viewDidLoad()
//        view.backgroundColor = .white
//
//        presenter = Presenter(view: self)
//        presenter.beginPresenting()
//    }
//
//    func showFirstTimeExperience() {
//        UserDefaults.standard.set(true, forKey: "hasShownFirstTime")
//        normalText.isHidden = true
//        firstTimeText.isHidden = false
//        firstTimeText.backgroundColor = UIColor.blue.withAlphaComponent(0.1)
//    }
//
//    func showNormalText() {
//        normalText.isHidden = false
//        firstTimeText.isHidden = true
//        normalText.backgroundColor = UIColor.red.withAlphaComponent(0.1)
//    }
//
//    func showText(fromApi apiText: String) {
//        loadedInfoText.text = apiText
//        loadedInfoText.isHidden = false
//    }
//
//}
//
//protocol View: NSObjectProtocol {
//    func showFirstTimeExperience()
//    func showNormalText()
//    func showText(fromApi apiText: String)
//}
////
//class Presenter {
//
//    private weak var view: View?
//
//    init(view: View) {
//        self.view = view
//    }
//
//    func beginPresenting() {
//        if UserDefaults.standard.bool(forKey: "hasShownFirstTime") {
//            view?.showNormalText()
//
//            let task = URLSession.shared.dataTask(with: apiEndpoint) { data, _, _ in
//                if let data = data, let string = String(data: data, encoding: .utf8) {
//                    DispatchQueue.main.async {
//                        self.view?.showText(fromApi: string)
//                    }
//                }
//            }
//            task.resume()
//        } else {
//            UserDefaults.standard.set(true, forKey: "hasShownFirstTime")
//            view?.showFirstTimeExperience()
//        }
//    }
//
//}
