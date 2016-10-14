import io.kotlintest.specs.ShouldSpec

class BowlingSpec : ShouldSpec() {
    init {
        "score" {
            should("be 0 for all gutters") {
                score(replicate(20, 0)) shouldBe 0
            }
            should("be summing score of every ball played") {
                score(replicate(20, 1)) shouldBe 20
                score(replicate(20, 3)) shouldBe 60
            }
            should("be adding next ball bonus if frame is spare") {
                score(listOf(5, 5, 3).plus(replicate(17, 0))) shouldBe 16
                score(listOf(5, 5).plus(replicate(18, 1))) shouldBe 29
            }
            should("be adding next two balls bonus if frame is strike") {
                score(listOf(10, 3, 4).plus(replicate(16, 0))) shouldBe 24
                score(listOf(10).plus(replicate(18, 1))) shouldBe 30
            }
            should("be 300 for a perfect game") {
                score(replicate(12, 10)) shouldBe 300
            }
            should("be 150 for all spares") {
                score(replicate(21, 5)) shouldBe 150
            }
            should("be accounting for strike followed by spare") {
                score(listOf(10, 5, 5).plus(replicate(16, 1))) shouldBe 47
            }
            should("be accounting for spare followed by strike") {
                score(listOf(5, 5, 10).plus(replicate(16, 1))) shouldBe 48
            }
        }
    }
}

fun replicate(times: Int, value: Int): List<Int> = 1.rangeTo(times).toList().map { value }
