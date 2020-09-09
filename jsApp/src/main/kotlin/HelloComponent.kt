import com.loneoaktech.tests.nightdogsmp.di.ServiceLocatorImpl
import com.loneoaktech.tests.nightdogsmp.shared.Greeting
import com.loneoaktech.tests.nightdogsmp.ui.printSunRiseAndSet
import com.soywiz.klogger.Logger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.promise
import react.*
import react.dom.*
import kotlin.js.Promise

external interface HelloState : RState {
    var timeStr: String?
}

class HelloComponent : RComponent<RProps, HelloState>() {

    // There are many ways to launch the coroutine to get the time.
    // Overriding the React state init routine seemed the cleanest.
    override fun HelloState.init() {
        MainScope().launch {
            val str = printSunRiseAndSet( ServiceLocatorImpl)
            setState {
                timeStr = str
            }
        }
    }

//    init {

//        setState { this.timeStr = "" }

//        GlobalScope.launch {
//
//            val str = printSunRiseAndSet( ServiceLocatorImpl)
//            setState {
//                timeStr = str
//            }
//        }
//
//        asyncGetTimes().then { str ->
//            setState {
//                timeStr = str
//            }
//        }
//    }

//
//    private fun asyncGetTimes() : Promise<String> = GlobalScope.promise {
//        printSunRiseAndSet( ServiceLocatorImpl)
//    }

    override fun RBuilder.render() {

        h1 { + "Night Dogs MP" }
        div {
            h3 { +"Overview" }
            p {
                +"An small example using Kotlin/JS with React"
            }
            p{
                +"MP greeting: ${Greeting().greeting()}"
            }
        }

        div {
            h3 { + "Rise and Set Times"}
            p { + (state.timeStr ?: "-- not set --") }
        }
    }

}