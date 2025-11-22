package org.sopt.soptackthon_app_3.presentation.juwan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonTextField
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookCostSection
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookEssential
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookInfoSection
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookServiceSelect
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookTopBar


@Composable
fun JuwanRoute(
    navigateToDoyeon: () -> Unit,
) {
    JuwanScreen(
        navigateToDoyeon = navigateToDoyeon
    )
}

@Composable
fun JuwanScreen(
    modifier: Modifier = Modifier,
    navigateToDoyeon: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            BookTopBar()
        }

        item {
            Text(
                text = "Selct service",
                style = SopkathonTheme.typography.title.titleSb16,
                color = SopkathonTheme.colors.primary900,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        items(count = 4, contentType = { it }) { index ->
            BookServiceSelect(
                serviceText = "Service $index",
                onBookServiceSelect = navigateToDoyeon,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                isSelected = index == 0
            )
        }

        item {
            BookEssential(
                title = "Locate",
            )
        }

        item {
            BookInfoSection(
                title = "Book Info",
                leftIcon = null,
                rightIcon = null,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            BookEssential(
                title = "Date",
            )
        }

        item {
            BookInfoSection(
                title = "Book Info",
                leftIcon = null,
                rightIcon = null,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            BookEssential(
                title = "Start time",
            )
        }

        item {
            BookInfoSection(
                title = "Book Info",
                leftIcon = null,
                rightIcon = null,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = "Special request",
                style = SopkathonTheme.typography.title.titleSb16,
                color = SopkathonTheme.colors.primary900,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            SopkathonTextField(
                value = "",
                placeholder = "Enter any special requests or notes for the heloper",
                onValueChanged = {},
                borderColor = SopkathonTheme.colors.primary500,
                backgroundColor = SopkathonTheme.colors.white,
                onFocusChanged = {},
                singleLine = false,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = "Cost",
                style = SopkathonTheme.typography.title.titleSb16,
                color = SopkathonTheme.colors.primary900,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            BookCostSection(
                rate = "$10/hour",
                duration = "2 hours",
                estimated = "$20 estimated",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewJuwanScreen() {
    SopkathonTheme {
        JuwanScreen()
    }
}