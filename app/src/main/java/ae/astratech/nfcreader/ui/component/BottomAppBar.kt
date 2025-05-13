package ae.astratech.nfcreader.ui.component

import ae.astratech.nfcreader.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.compose.material3.BottomAppBar as Material3BottomAppBar

@Composable
fun BottomAppBar(navController: NavController) {
    Material3BottomAppBar(
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
            ) {
                BottomBarItem(stringResource(R.string.bottom_bar_home)) {
                    IconButton(
                        onClick = {/* TODO*/ },
                        modifier = Modifier.background(Color.Red)
                        ) {
                        Icon(
                            Icons.Rounded.Home,

                            contentDescription = stringResource(R.string.bottom_bar_home)
                        )
                    }
                }
                BottomBarItem(stringResource(R.string.bottom_bar_history)) {
                    IconButton(onClick = {/* TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.history_24px),
                            contentDescription = stringResource(R.string.bottom_bar_history),
                        )
                    }
                }
                BottomBarItem(stringResource(R.string.bottom_bar_settings)) {
                    IconButton(onClick = {/* TODO*/ }) {
                        Icon(
                            Icons.Rounded.Settings,
                            contentDescription = stringResource(R.string.bottom_bar_settings)
                        )
                    }
                }
            }
        })
}
