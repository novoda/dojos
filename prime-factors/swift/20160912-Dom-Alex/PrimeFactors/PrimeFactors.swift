import Foundation

extension Int {

    func primeFactors() -> [Int] {
        var temp = self
        var results: [Int] = []
        var divisor = 2

        while(temp != 1) {
            while(temp % divisor == 0 ) {
                results.append(divisor)
                temp = temp / divisor
            }
            divisor += 1
        }

        return results
    }

}
