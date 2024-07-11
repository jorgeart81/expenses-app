package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.ExpenseManager
import presentation.ExpensesUiState
import ui.AllExpensesHeader
import ui.ExpenseItem
import ui.ExpensesScreen
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
        ExpenseManager.fakeExpenseList[0]
    ) {}
}

@Preview(showBackground = true)
@Composable
private fun ExpenseScreenPrev() {
    ExpensesScreen(uiState = ExpensesUiState(ExpenseManager.fakeExpenseList, 1052.2)) {
    }
}

