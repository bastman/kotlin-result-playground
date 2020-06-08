/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package example.playground

import com.github.michaelbull.result.*

typealias KtResult<V,E> = com.github.michaelbull.result.Result<out V, out E>

private data class MyErr(val ex:Throwable)

class App {
    val items:MutableList<Item> = mutableListOf()


    fun run() {

        val item = runCatching { items.get(123) }
                .mapError { MyErr(it) }
                .onFailure { println("failed: $it") }
                .onSuccess { println("success: $it") }
                .andThen {
                    runCatching { items.get(123) }
                            .mapError { MyErr(it) }
                }
                //.and { runCatching { items.get(123) } }

        //println(item)
    }



}

data class Item(val id:Int)

fun main(args: Array<String>) {
    App().run()
}
