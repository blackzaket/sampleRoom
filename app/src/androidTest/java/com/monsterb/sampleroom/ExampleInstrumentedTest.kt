package com.monsterb.sampleroom

import android.widget.Toast
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.monsterb.sampleroom.db.MyDatabase
import com.monsterb.sampleroom.db.model.User
import kotlinx.coroutines.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.monsterb.sampleroom", appContext.packageName)
    }

    @Test
    fun dbTest() = runBlocking {

        val job = launch {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext

            val db = MyDatabase.getInstance(appContext)


            for (user in db!!.userDao().getUsers()) {
                db!!.userDao().delete(user)
            }

//            CoroutineScope(Dispatchers.IO).launch {

                val user = User("gildong", 23, "Seoul")
                db!!.userDao().insert(user)
                assertEquals(1, db!!.userDao().getUsers().size)
                print(" User cnt " + db!!.userDao().getUsers().size)
//            }

        }

        job.join()

//        assertEquals("com.monsterb.sampleroom", appContext.packageName)
    }
}