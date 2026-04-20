package com.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.StateObject
import androidx.savedstate.SavedState
import androidx.savedstate.compose.serialization.serializers.SnapshotStateListSerializer
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.savedstate.serialization.decodeFromSavedState
import androidx.savedstate.serialization.encodeToSavedState
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Composable
fun rememberNavigator(
    vararg elements: NavKey,
    configuration: SavedStateConfiguration
): Navigator {
    return rememberSaveable(saver = Navigator.saver(configuration)) {
        Navigator(*elements)
    }
}

class Navigator(val base: SnapshotStateList<NavKey>) :
    MutableList<NavKey> by base, StateObject by base, RandomAccess by base {

    constructor(vararg elements: NavKey) : this(base = mutableStateListOf(*elements))

    fun goTo(destination: NavKey) {
        base.add(destination)
    }

    fun goBack() {
        base.removeLastOrNull()
    }

    companion object {
        internal fun saver(
            configuration: SavedStateConfiguration,
        ): Saver<Navigator, SavedState> {
            val serializer = NavigatorSerializer(PolymorphicSerializer(NavKey::class))
            return Saver(
                save = { original ->
                    encodeToSavedState(
                        serializer,
                        original,
                        configuration
                    )
                },
                restore = { savedState ->
                    decodeFromSavedState(
                        serializer,
                        savedState,
                        configuration
                    )
                },
            )
        }

    }
}

internal class NavigatorSerializer(
    elementSerializer: KSerializer<NavKey>
) : KSerializer<Navigator> {

    private val delegate = SnapshotStateListSerializer(elementSerializer)

    override val descriptor: SerialDescriptor =
        SerialDescriptor("Navigator", delegate.descriptor)

    override fun serialize(encoder: Encoder, value: Navigator) {
        encoder.encodeSerializableValue(serializer = delegate, value = value.base)
    }

    override fun deserialize(decoder: Decoder): Navigator {
        return Navigator(base = decoder.decodeSerializableValue(deserializer = delegate))
    }
}