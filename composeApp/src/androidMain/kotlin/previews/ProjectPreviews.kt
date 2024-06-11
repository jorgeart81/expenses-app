package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.ExpenseManger
import ui.AllExpensesHeader
import ui.ExpenseItem
import ui.ExpensesScreen
import ui.ExpensesTotalHeader
import kotlin.math.log

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
        ExpenseManger.fakeExpenseList[0]
    ) {}
}

@Preview(showBackground = true)
@Composable
private fun ExpenseScreenPrev() {
    ExpensesScreen {
    }
}

