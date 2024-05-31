package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.AllExpensesHeader
import ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
private fun ExpensesTotalHeaderPrev() {
    ExpensesTotalHeader(total = 10.0)
}

@Preview(showBackground = true)
@Composable
private fun AllExpensesHeaderPrev() {
    AllExpensesHeader()
}