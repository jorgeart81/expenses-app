package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import model.Expense
import model.ExpenseCategory
import ui.AllExpensesHeader
import ui.ExpenseItem
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

@Preview(showBackground = true)
@Composable
private fun ExpenseItemPrev() {
    ExpenseItem(
        Expense(
            id = 1L,
            amount = 87.00,
            category = ExpenseCategory.PARTY,
            description = "Weekend party"
        )
    ) {}
}

