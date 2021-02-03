package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import android.app.Application
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import dev.theuzfaleiro.maybetoday.database.MaybeTodayDatabase
import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.database.entity.Category
import io.kotlintest.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class HomeRepositoryTest {
    private lateinit var homeDAO: HomeDAO
    private lateinit var maybeTodayDatabase: MaybeTodayDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Application>()

        maybeTodayDatabase = Room.inMemoryDatabaseBuilder(context, MaybeTodayDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        homeDAO = maybeTodayDatabase.homeDAO()
    }

    @Test
    fun insertAndGetWord() = runBlocking {
        homeDAO.insertCategory(Category(0, "Test", "More Test"))

        homeDAO.getAllCategories().first() shouldBe Category(1, "Test", "More Test")
    }
}