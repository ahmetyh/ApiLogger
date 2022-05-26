package com.ayh.apilogger.repository

import com.ayh.apilogger.model.Log
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LogRepository : MongoRepository<Log, String>


