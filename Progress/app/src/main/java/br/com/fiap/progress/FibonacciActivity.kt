package br.com.fiap.progress

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.fiap.progress.databinding.ActivityFibonacciBinding
import br.com.fiap.progress.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FibonacciActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFibonacciBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFibonacciBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
    }

    private fun setupButtons() {
        var countClick: Int = binding.labelFibonacciSequenceNumber.text.toString().toInt()
        binding.buttonIncrementFibonacci.setOnClickListener {
            countClick++
            incrementFibonacci(countClick)
            binding.labelFibonacciSequenceNumber.text = "Sequencia de fibonacci: $countClick"
        }
    }

    private fun incrementFibonacci(sequenceNumber: Int) {
        lifecycleScope.launch(Dispatchers.Main) {
            binding.buttonIncrementFibonacci.isEnabled = false
            val fibonacciNumber = CoroutineFactory.calculateFibonacciSuspend(sequenceNumber)
            binding.labelFibonacciNumber.text = "Valor do fibonacci: $fibonacciNumber"
            binding.buttonIncrementFibonacci.isEnabled = true
        }
    }

    companion object {
        fun buildIntent(context: Context) = Intent(
            context,
            FibonacciActivity::class.java
        )
    }
}