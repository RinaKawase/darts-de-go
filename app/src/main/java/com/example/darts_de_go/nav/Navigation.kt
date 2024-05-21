package com.example.darts_de_go.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.darts_de_go.view.HomeScreen
import com.example.darts_de_go.view.InitialSettingScreen
import com.example.darts_de_go.view.MapScreen
import com.example.darts_de_go.view.ResultScreen
import com.example.darts_de_go.view.SettingScreen

/**
 * Navigation
 * We control screen navigation with this function.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()

    // TODO: startDestinationを初期設定画面に変更する
    // TODO: ボタン押下での遷移先はあくまで仮
    NavHost(navController = navController, startDestination = Screen.HomeScreen.screenName) {
        composable(Screen.HomeScreen.screenName) {
            HomeScreen(onClickButton = { navController.navigate(Screen.MapScreen.screenName) })
        }
        composable(Screen.InitialSettingScreen.screenName) {
            InitialSettingScreen(onClickButton = { navController.navigate(Screen.HomeScreen.screenName) })
        }
        composable(Screen.MapScreen.screenName) {
            MapScreen(onClickButton = { navController.navigate(Screen.ResultScreen.screenName) })
        }
        composable(Screen.ResultScreen.screenName) {
            ResultScreen(onClickButton = { navController.navigate(Screen.MapScreen.screenName)})
        }
        composable(Screen.SettingScreen.screenName) {
            SettingScreen(onClickButton = { navController.navigate(Screen.MapScreen.screenName)})
        }
    }
}

/**
 * Screen
 * Manage the names and header titles of
 * each screen centrally with this function.
 * @param screenName Screen Name
 * @param headerTitle Header Title
 */
enum class Screen(
    val screenName: String,
    val headerTitle: String
) {
    HomeScreen("Home","ホーム画面"),
    InitialSettingScreen("InitialSetting","初期設定画面"),
    MapScreen("Map","地図画面"),
    ResultScreen("Result","結果画面"),
    SettingScreen("Setting","設定画面")
}