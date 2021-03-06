package woogie.space.messenger.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import woogie.space.messenger.model.SearchUserHistory

@Dao
interface LoginDao {

    @Query("SELECT * FROM searchUserHistory")
    fun getAll(): LiveData<List<SearchUserHistory>>

    @Query("DELETE FROM searchUserHistory")
    fun clearAll()

    //해당 데이터를 추가합니다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg searchUserHistory: SearchUserHistory)

    //해당 데이터를 업데이트 합니다.
    @Update
    fun update(vararg searchUserHistory: SearchUserHistory)

    @Query("DELETE FROM searchUserHistory")
    suspend fun deleteAll()


    @Query("DELETE FROM searchUserHistory WHERE SearchText = :searchedText")
    suspend fun deleteBySearchText(searchedText: String)
}