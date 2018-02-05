import Foundation

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