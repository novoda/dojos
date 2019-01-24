package com.novoda.workshop.contributors.fetcher

import com.novoda.workshop.contributors.data.Contributor

internal fun List<Contributor>.aggregate(): List<Contributor> =
        groupingBy { it.name }
                .reduce { login, a, b ->
                    Contributor(login, a.contributions + b.contributions, a.avatarUrl)
                }
                .values
                .sortedByDescending { it.contributions }
