package com.novoda.workshop.contributors.fetcher

import com.novoda.workshop.contributors.data.Contributor
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ListExtensionsTest {
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
        ).aggregate()

        assertThat(aggregatedContributions).isEqualTo(expectedAggregatedContributions)
    }
}
