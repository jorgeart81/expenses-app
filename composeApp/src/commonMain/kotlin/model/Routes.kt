package model

sealed class Routes(val route: String, val name: String) {
    object Home : Routes("/home", TitleTopBarTypes.DASHBOARD.value)
    object AddExpenses : Routes("/addExpenses/{id}", TitleTopBarTypes.ADD.value) {
        fun createRoute(id: Long) = "/addExpenses/$id"
    }
}