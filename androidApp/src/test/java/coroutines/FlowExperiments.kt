package coroutines

import com.loneoaktech.tests.nightdogsmp.utility.summary
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.IllegalStateException

import kotlin.test.Test

class FlowExperiments {

    @Test
    fun timedFlowTest() = runBlocking<Unit> {

        val source = flow<Int> {
            repeat(10) { ctr ->
                delay(100)
                emit(ctr)
            }
        }


        launch {
                source.takeUntilTimeout(500).collect {
                    println( "C=$it, t=${System.currentTimeMillis()%10_000}")
                }
        }
    }

    @Test
    fun timeFlowErrorTest() = runBlocking<Unit>{

        // a source w/ an error
        val source = flow<Int> {
            repeat(10) { ctr ->
                delay(100)
                if ( ctr == 5) throw IllegalStateException("Test error")
                emit(ctr)
            }
        }


        launch {
            try {
                source.takeUntilTimeout( 800 ).collect {
                    println( "C=$it, t=${System.currentTimeMillis()%10_000}")
                }
            } catch (t: Throwable ) {
                println("Caught exception: ${t.summary()}")
            }

        }

    }

    @Test
    fun threadSwitchingFlow() = runBlocking<Unit> {

        val source = flow<Int> {
                println("flow thread=${Thread.currentThread().name}")
                repeat(10) {
                    emit( it )
                }
        }


        launch( Dispatchers.Default ) {
            source.flowOn(Dispatchers.IO).collect {
                println( "resp=$it, thread=${Thread.currentThread().name}")
            }
        }



    }

    @Test
    fun sharedFlowTest() = runBlocking<Unit>{
        val source = flow<Int> {
            repeat(10) { ctr ->
                delay(100)
                emit(ctr)
            }
        }

        val sf = source.shareIn( this, started= SharingStarted.Eagerly )
        sf.collect {  }
    }

    private fun <T> Flow<T>.takeUntilTimeout(timeout: Long ): Flow<T> {
        return flow<T>{
            withTimeoutOrNull(timeout) {
                this@takeUntilTimeout.collect {
                    this@flow.emit( it )
                }
            }
        }
    }
}