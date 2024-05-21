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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext

/**
 * HomeScreen
 * ホーム画面
 * @param onClickButton
 */
@Composable
fun HomeScreen(
    onClickButton: ()->Unit = {}
) {
    Column {
        TravelDestChoiceComponent()
        Spacer(modifier = Modifier.weight(1f))
        HomeButtonComponent(onClickButton)
    }
}

/**
 * TravelDestChoiceComponent
 * 旅行先選択箇所
 * @param onClickButton
 */
@Composable
fun TravelDestChoiceComponent(
    onClickButton: ()->Unit = {}
) {
    var expanded by remember { mutableStateOf(false)}
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    val selectedText by remember { mutableStateOf(coffeeDrinks[0]) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 居住区域
        Text(
            text = stringResource(R.string.home_info_main),
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
                    modifier = Modifier.focusRequester(focusRequester)
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
                    modifier = Modifier.focusRequester(focusRequester)
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
 * HomeButtonComponent
 * ボタン
 * @param
 */
@Composable
fun HomeButtonComponent(
    onClickButton: ()->Unit = {}
) {
    Button(
        onClick = { onClickButton() },
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