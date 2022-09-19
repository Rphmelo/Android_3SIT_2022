package br.com.fiap.progress

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object CoroutineFactory {
    private val listNumbers: List<Int> = listOf(1, 1, 2, 3, 5, 8, 13, 21)
    private val listDelays: List<Long> = listOf(2000L, 3000L, 1000L, 800L)

    suspend fun getRandomNumbers(): Int {
        return withContext(Dispatchers.Default) {
            this.async {
                listNumbers[(listNumbers.indices).random()].also {
                    Log.d("Valores", "Valores: $it")
                }
            }
        }.await()
    }

    suspend fun getRandomDelays(): Long {
        return withContext(Dispatchers.Default) {
            this.async {
                listDelays[(listDelays.indices).random()].also {
                    Log.d("Delays", "Delays: $it")
                }
            }
        }.await()
    }

    suspend fun getFibonacci() {
        return withContext(Dispatchers.Default) {
            fibonacci(100)
        }
    }

    //Função que vai bloquear a Main Thread
    private suspend fun fibonacci(x: Int): Int {
        delay(500)
        return if (x <= 1) x else fibonacci(x - 1) + fibonacci(x - 2)
    }

    tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
        when (n) {
            0 -> a
            1 -> b
            else -> fibonacci(n - 1, b, a + b)
        }

}