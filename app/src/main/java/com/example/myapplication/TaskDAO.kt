package com.example.myapplication

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

// should be interface or abstract class
@Dao
interface TaskDAO {
    //what SQL queries do we need?
    //we need to get all the entreies and
    // all the task and store them by alphabetical order for no reason
    //insert a task into the database

    //defines functins that need to eb implremented in another places
    @Query("SELECT * FROM task_table ORDER BY task ASC")
    fun getAlphabeticalTasks(): Flow<List<Task>>

    //suspend allows you to do things concurrently
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    //I want to delete a task by task name
    @Query("DELETE FROM task_table WHERE task=:taskName")
    suspend fun delete(taskName:String)

}