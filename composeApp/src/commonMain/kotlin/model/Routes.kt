package model

sealed class Routes(val route: String, val name: String) {
    object Home : Routes("/home", TitleTopBarTypes.DASHBOARD.value)
    object AddExpense : Routes("/addExpense", TitleTopBarTypes.ADD.value)
    object EditExpenses : Routes("/editExpense/{id}?", TitleTopBarTypes.EDIT.value) {
        fun createRoute(id: Long) = "/editExpense/$id"
    }
}