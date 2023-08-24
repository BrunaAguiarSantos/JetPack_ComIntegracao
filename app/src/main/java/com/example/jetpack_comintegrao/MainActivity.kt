@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.jetpack_comintegrao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_comintegrao.ui.theme.JetPack_ComIntegraçãoTheme

private val Icons.Outlined.CameraAlt: ImageVector
    get() {
        TODO("Not yet implemented")
    }
private val Icons.Outlined.Cancel: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun FormLayoutFilled() {
    val focusManager = LocalFocusManager.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    onClick = { /* TODO */ },
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.size(96.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.CameraAlt, //Renomear
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Text("Add photo")
            }
        }
        item {
            var imageUrl = remember { mutableStateOf<String?>(null) }
            Box(Modifier.fillMaxWidth()) {
                //criar um composable(?)
                Image( //Renomear ou criar uma classe Composable(?)
                    model = imageUrl,
                    contentDescription = null
                )
            }
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("First name") },
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )

        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Last name") },
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Phone number") },
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Email") },
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                },
                singleLine = true,
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Country") },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Street address") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("City") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Zip/postal code") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Cancel, "Clear")
                        }
                    }
                },
            )
        }
        item {
            Text(
                text = "Groups",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 24.dp,
                    bottom = 8.dp
                )
            )
        }
        item {
            var selected by remember { mutableStateOf<Int?>(null) }
            val options = listOf("Family", "Friends", "Work", "Other")
            Column {
                options.forEachIndexed { i, option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier
                            .clickable { selected = i }
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        RadioButton(
                            selected = selected == i,
                            onClick = null
                        )
                        Text(text = option)
                    }

                }
            }
        }
        item {
            Text(
                text = "Notification Options",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 24.dp,
                    bottom = 8.dp
                )
            )
        }
        item {
            var selected by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .clickable { selected = selected.not() }
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = selected,
                    onCheckedChange = null
                )
                Text(text = "Override 'Do not Disturb'")
            }
        }
        item {
            var selected by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .clickable { selected = selected.not() }
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = selected,
                    onCheckedChange = null
                )
                Text(text = "Block calls from this contact")
            }
        }
    }
}

fun Image(model: MutableState<String?>, contentDescription: Nothing?) {

}

fun Icon(cancel: Any, s: String) {

}

@Composable
fun AsyncImage(model: MutableState<String?>, contentDescription: Nothing?) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun FormLayoutFilledPreview() {
    FormLayoutFilled()
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun GreetingPreview() {
    JetPack_ComIntegraçãoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Android")
        }
    }
}