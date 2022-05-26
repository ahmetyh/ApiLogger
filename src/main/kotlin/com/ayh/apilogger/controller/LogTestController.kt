package com.ayh.apilogger.controller

import com.ayh.apilogger.model.Log
import com.ayh.apilogger.repository.LogRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LogTestController(private val logRepository: LogRepository) {

    @GetMapping("/logs")
    fun getAllLogs(): List<Log> = logRepository.findAll()

    @GetMapping("/addLog")
    fun addLog(): String {
        logRepository.save(Log(type = "trace", data = "inside addLog", source = "LogController"));
        return "ok";
    }

}