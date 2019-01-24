package com.novoda.workshop.contributors.fetcher

import com.novoda.workshop.contributors.data.Contributor
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ContributorAggregationTest {

    // TODO: Verify the implementation by running this test
    // Click on the green run button on the left side of the method declaration
    // In case the test fails you will see a the test output including a <Click to see difference> link.
    // Click it to see the difference between the expected and actual test result.

    @Test
    fun `aggregates and sorts contributors`() {
        val expectedAggregatedContributions = listOf(
                Contributor(name = "Michal", contributions = 5, avatarUrl = "michal url"),
                Contributor(name = "Berta", contributions = 4, avatarUrl = "berta url"),
                Contributor(name = "Alex", contributions = 3, avatarUrl = "alex url")
        )
        val aggregatedContributions = listOf(
                Contributor(name = "Berta", contributions = 2, avatarUrl = "berta url"),
                Contributor(name = "Alex", contributions = 2, avatarUrl = "alex url"),
                Contributor(name = "Michal", contributions = 3, avatarUrl = "michal url"),
                Contributor(name = "Alex", contributions = 1, avatarUrl = "alex url"),
                Contributor(name = "Berta", contributions = 1, avatarUrl = "berta url"),
                Contributor(name = "Berta", contributions = 1, avatarUrl = "berta url"),
                Contributor(name = "Michal", contributions = 2, avatarUrl = "michal url")
        )
        //.aggregate()
        // TODO: Remove the above comment once you've implemented the extension function to test it

        assertThat(aggregatedContributions).isEqualTo(expectedAggregatedContributions)
    }
}
