package com.example.sendsimplerequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

// Creamos una función que llama a la clase, otra función.


   fun sendJson (view: View){
        val textView = findViewById<TextView>(R.id.textView)
// ...

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/comments"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}
