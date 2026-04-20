package com.feature.dashboard.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.buney.maps.CameraPosition
import eu.buney.maps.GoogleMap
import eu.buney.maps.LatLng
import eu.buney.maps.MapProperties
import eu.buney.maps.MapType
import eu.buney.maps.MapUiSettings
import eu.buney.maps.Marker
import eu.buney.maps.rememberCameraPositionState
import eu.buney.maps.rememberUpdatedMarkerState

@Composable
fun MapRoute(
    modifier: Modifier = Modifier,
) {
    MapScreen(
        modifier = modifier
    )
}

@Composable
private fun MapScreen(
    modifier: Modifier = Modifier,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(
            target = LatLng(37.7749, -122.4194), // San Francisco
            zoom = 12f
        )
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(mapType = MapType.NORMAL),
        uiSettings = MapUiSettings(zoomControlsEnabled = true),
        onMapClick = { latLng -> println("Clicked: $latLng") }
    ) {
        Marker(
            state = rememberUpdatedMarkerState(position = LatLng(37.7749, -122.4194)),
            title = "San Francisco",
            snippet = "Welcome!"
        )
    }
}