import Foundation

class PrimeFactor {

    func factorize(integer: Int) -> Array<Int> {
        
        var number = integer
        var primeFactors = Array<Int>()
        
        repeat {
            let factor = primeFactor(number)
            primeFactors.append(factor)
            
            number = number / factor
           
        } while number > 1
        
        return primeFactors
    }
    
    func primeFactor(number: Int) -> Int {
        
        for index in 2...number {
            if number % index == 0 {
                return index
            }
        }
        return number
    }
}
