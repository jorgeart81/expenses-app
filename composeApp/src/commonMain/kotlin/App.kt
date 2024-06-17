import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Apps
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Routes
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        val navigator = rememberNavigator()
        val titleTopBar = getTitleTopAppBar(navigator)
        val isEditOrAddExpense = titleTopBar == Routes.AddExpenses.name

        AppTheme {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = titleTopBar, fontSize = 25.sp, color = colors.textColor
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navigator.popBackStack() }) {
                            var icon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack
                            var contentDescription = "Go back icon"
                            if (!isEditOrAddExpense) {
                                icon = Icons.Default.Apps
                                contentDescription = "Dashboard icon"
                            }
                            Icon(
                                imageVector = icon,
                                contentDescription = contentDescription,
                                modifier = Modifier.padding(16.dp),
                                tint = colors.textColor,
                            )
                        }
                    },
                    backgroundColor = colors.backgroundColor,
                    elevation = 0.dp,
                )
            }) { paddingValues -> }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    val routes = mapOf(
        Routes.Home.route to Routes.Home.name,
        Routes.AddExpenses.route to Routes.AddExpenses.name,
    )
    val currentRoute = navigator.currentEntry.collectAsState(null).value?.route?.route
    val title = routes[currentRoute]

    return title ?: Routes.Home.name
}