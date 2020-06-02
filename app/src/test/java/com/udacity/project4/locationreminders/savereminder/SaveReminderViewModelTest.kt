package com.udacity.project4.locationreminders.savereminder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.udacity.project4.locationreminders.getOrAwaitValue
import com.udacity.project4.locationreminders.reminderslist.ReminderDataItem

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SaveReminderViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Other code…

    @Test
    fun validateAndSaveReminder() {

        // Given a fresh ViewModel
       // val saveReminderViewModel = SaveReminderViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
       // saveReminderViewModel.validateAndSaveReminder()

        // Then the new task event is triggered
        //val latvalue = saveReminderViewModel.latitude.value
//        val latvalue = saveReminderViewModel.latitude.value
//
//        val latvalue = saveReminderViewModel.latitude.value

        //newTaskEvent.getOrAwaitValue()
       // assertThat(latvalue, (not(nullValue()))
      //  )
    }


}