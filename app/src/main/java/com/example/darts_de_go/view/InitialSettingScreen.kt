package com.example.darts_de_go.view

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.darts_de_go.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.darts_de_go.model.state.InitialSettingState
import com.example.darts_de_go.viewModel.InitialSettingScreenViewModel
import timber.log.Timber

/**
 * InitialSettingScreen
 * Transition to this screen only on the first launch.
 * After accepting the user's input for residential area and nearest station,
 * pass those values to the next screen.
 * @param onClickButton
 */
@Composable
fun InitialSettingScreen(
    onClickButton: ()->Unit = {}
) {
    val viewModel: InitialSettingScreenViewModel = viewModel()
    // 読み取り用
    val initialSettingState by viewModel.state.collectAsState()

    Column {
        UserChoiceComponent(onClickButton, viewModel, initialSettingState)
        Spacer(modifier = Modifier.weight(1f))
        ButtonComponent(onClickButton, viewModel, initialSettingState)
    }
}

/**
 * UserChoiceComponent
 * User Selection Section.
 * @param onClickButton
 */
@Composable
fun UserChoiceComponent(
    onClickButton: ()->Unit = {},
    viewModel: InitialSettingScreenViewModel,
    initialSettingState: InitialSettingState
) {
    var expanded by remember { mutableStateOf(false)}
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    val selectedText by remember { mutableStateOf(coffeeDrinks[0]) }


    Column(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 居住区域
        Text(
            text = stringResource(R.string.initial_setting_info_residential_area),
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
        )
        // プルダウンメニュー
        Row {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(150.dp, 50.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { expanded = !expanded }
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = selectedText,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },  // When tapping outside the dropdown menu, close it.

                ) {
                    DropdownMenuItem(
                        text = { Text("Temp") }, // TODO: Use Overpass API
                        onClick = {
                            // クリックされたときの処理
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()  // TODO: 選択した都市名をStateへ保存する
                        },
                    )
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(250.dp, 50.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { expanded = !expanded }
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = selectedText,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },  // When tapping outside the dropdown menu, close it.

                ) {
                    DropdownMenuItem(
                        text = { Text("Temp") }, // TODO: Use Overpass API
                        onClick = {
                            // クリックされたときの処理
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()  // TODO: 選択した都市名をStateへ保存する
                        },
                    )
                }
            }
        }
        // 最寄り駅
        Text(
            text = stringResource(R.string.initial_setting_info_nearest_train_station),
            modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
        )
        // プルダウンメニュー
        Row {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(150.dp, 50.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { expanded = !expanded }
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = selectedText,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },  // When tapping outside the dropdown menu, close it.

                ) {
                    DropdownMenuItem(
                        text = { Text("Temp") }, // TODO: Use Overpass API
                        onClick = {
                            // クリックされたときの処理
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()  // TODO: 選択した都市名をStateへ保存する
                        },
                    )
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(250.dp, 50.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { expanded = !expanded }
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = selectedText,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },  // When tapping outside the dropdown menu, close it.

                ) {
                    DropdownMenuItem(
                        text = { Text("Temp") }, // TODO: Use Overpass API
                        onClick = {
                            // クリックされたときの処理
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()  // TODO: 選択した都市名をStateへ保存する
                        },
                    )
                }
            }
        }
    }
}

/**
 * ButtonComponent
 * ボタン
 * @param
 */
@Composable
fun ButtonComponent(
    onClickButton: ()->Unit = {},
    viewModel: InitialSettingScreenViewModel,
    initialSettingState: InitialSettingState
) {
    Button(
        //onClick = { onClickButton() },
        onClick = {
            viewModel.getCityNames()
            Timber.d("都市名: ${initialSettingState.cityName}")

                  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 30.dp,
                start = 10.dp,
                end = 10.dp
            ),
        shape = RoundedCornerShape(20.dp)
    ) {
        val offset = Offset(5.0f, 10.0f)
        Text(
            text = stringResource(R.string.initial_setting_info_main),
            fontSize = 30.sp,
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    offset = offset,
                    blurRadius = 3f
                )
            )
        )
    }
}