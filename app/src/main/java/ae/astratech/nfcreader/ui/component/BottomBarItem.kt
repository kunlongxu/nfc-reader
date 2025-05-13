package ae.astratech.nfcreader.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomBarItem(label: String, icon: @Composable () -> Unit) {
    Column(
        modifier = Modifier.clickable { /* TODO */ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        Text(label)
    }
}


@Preview("BottomBarItem")
@Composable
fun BottomBarItemPreview() {
    BottomBarItem("Home") {
        Icon(
            Icons.Rounded.Home,
            contentDescription = "Home",
        )
    }
}