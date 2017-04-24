import Foundation

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
