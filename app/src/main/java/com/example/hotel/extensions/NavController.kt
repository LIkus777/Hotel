package com.example.hotel.extensions

import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.navigateSafe(currentFragmentId: Int, directionId: Int) {
    if (currentDestination?.id == currentFragmentId) {
        navigate(directionId)
    }
}

fun NavController.navigateSafe(navDirection: NavDirections) {
    currentDestination?.getAction(navDirection.actionId)?.run {
        navigate(navDirection)
    }
}
