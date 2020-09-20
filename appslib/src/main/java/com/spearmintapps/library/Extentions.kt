package com.spearmintapps.library

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun <I,R> CoroutineScope.executeAsyncTask(
    input:I,
    onPreExecute: () -> Unit,
    doInBackground: (I) -> R,
    onPostExecute: (R) -> Unit
) = launch {
    onPreExecute() // runs in Main Thread
    val result = withContext(Dispatchers.IO) {
        doInBackground(input) // runs in background thread without blocking the Main Thread
    }
    onPostExecute(result) // runs in Main Thread
}