package com.udacity.project4.locationreminders.savereminder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.udacity.project4.locationreminders.data.ReminderDataSource
import com.udacity.project4.locationreminders.getOrAwaitValue
import com.udacity.project4.locationreminders.reminderslist.ReminderDataItem

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.ViewModelParameters
import org.koin.core.context.GlobalContext.get
import org.mockito.Mockito.mock
import org.robolectric.Robolectric

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SaveReminderViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Other code…

    @Test
    fun validateAndSaveReminder() {

        //val rem : ReminderDataSource = mock(ReminderDataSource)
        // Given a fresh ViewModel
        val saveReminderViewModel = get()

        // When adding a new task
        //saveReminderViewModel.validateAndSaveReminder()

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