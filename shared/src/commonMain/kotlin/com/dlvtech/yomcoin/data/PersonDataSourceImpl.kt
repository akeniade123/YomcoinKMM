package com.dlvtech.yomcoin.data

import com.dlvtech.yomcoin.shared.cache.AppDatabase
import db.PersonEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class PersonDataSourceImpl(db: AppDatabase): PersonDataSource {

    private val queries = db.personEntityQueries

    override suspend fun getPersonById(id: Long): PersonEntity? {
        return withContext(Dispatchers.Default) {
            queries.getPersonById(id).executeAsOneOrNull()
        }
    }

    override fun getAllPersons(): Flow<List<PersonEntity>> {
        TODO("Not yet implemented")
      //  return queries.getAllPersons().mapper
       // return queries.getAllPersons().asFlow().mapToList()
    }

    override suspend fun deletePersonById(id: Long) {
        withContext(Dispatchers.Default) {
            queries.deletePersonById(id)
        }
    }

    override suspend fun insertPerson(firstName: String, lastName: String, id: Long?) {
        withContext(Dispatchers.Default) {
            queries.insertPerson(id, firstName, lastName)
        }
    }

}