package com.core.navigation.decorator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.MetadataScope
import androidx.navigation3.runtime.NavMetadataKey
import androidx.navigation3.runtime.get
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneDecoratorStrategy
import androidx.navigation3.scene.SceneDecoratorStrategyScope
import com.core.navigation.NavKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : NavKey> rememberMainTopBarAppSceneDecoratorStrategy(
    topBar: @Composable () -> Unit,
): MainTopBarAppSceneDecoratorStrategy<T> {
    val currentTopBar by rememberUpdatedState(topBar)
    val movableTopBar = remember { movableContentOf { currentTopBar() } }

    return remember {
        MainTopBarAppSceneDecoratorStrategy(
            topBarContent = movableTopBar,
        )
    }
}

class MainTopBarAppSceneDecoratorStrategy<T : NavKey>(
    private val topBarContent: @Composable () -> Unit,
) : SceneDecoratorStrategy<T> {

    override fun SceneDecoratorStrategyScope<T>.decorateScene(scene: Scene<T>): Scene<T> {
        val isMainView = scene.metadata[MainViewKey] == true
        return if (isMainView) {
            MainTopBarScene(scene, topBarContent)
        } else {
            scene
        }
    }

    object MainViewKey : NavMetadataKey<Boolean>

    companion object {
        fun MetadataScope.mainView() {
            put(MainViewKey, true)
        }
    }
}

private data class MainTopBarScene<T : NavKey>(
    private val scene: Scene<T>,
    private val topBarContent: @Composable (() -> Unit),
) : Scene<T> by scene {

    override val key = scene::class to scene.key

    @OptIn(ExperimentalMaterial3Api::class)
    override val content = @Composable {
        Column(modifier = Modifier.fillMaxWidth()) {
            topBarContent()
            scene.content()
        }
    }

}