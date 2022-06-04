package com.example.samplehilt.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplehilt.navigation.DestinationScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {

    val list = remember { mutableStateListOf(
        ButtonHomeModel("First Example", DestinationScreen.FirstExample.route),
        ButtonHomeModel("Second Example", DestinationScreen.SecondExample.route),
        ButtonHomeModel("Third Example", DestinationScreen.ThirdExample.route),
    )}
    Column(
        modifier = Modifier.fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.h3
        )
        list.forEach {
            ButtonHome(
                text = it.text,
                onClick = { onClick(it.route) },
                modifier = Modifier.fillMaxWidth(.8f)
            )
        }
    }

}

data class ButtonHomeModel(
    val text: String,
    val route: String
)

@Composable
fun ButtonHome(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "Button",
) {
    OutlinedButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
