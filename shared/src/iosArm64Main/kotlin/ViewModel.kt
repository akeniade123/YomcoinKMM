import kotlinx.coroutines.CoroutineScope


/*
actual abstract class ViewModel actual constructor() {
    actual val viewModelScope: CoroutineScope
        get() = TODO("Not yet implemented")

    protected actual open fun onCleared() {
    }
}

 */

actual abstract class ViewModel {
    actual val viewModelScope = MainScope()

    protected actual open fun onCleared() {}

    fun clear() {
        onCleared()
        viewModelScope.cancel()
    }
}