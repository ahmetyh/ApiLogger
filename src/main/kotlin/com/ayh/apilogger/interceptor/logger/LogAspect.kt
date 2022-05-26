package com.ayh.apilogger.interceptor.logger

import com.ayh.apilogger.model.Log
import com.ayh.apilogger.repository.LogRepository
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant

@Aspect
@Component
class LogAspect(val logRepository: LogRepository) {

    @Around("within(com.ayh.apilogger.controller.*)")
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any {

        val start = Instant.now()

        val signature = joinPoint.signature.toShortString()

        val result = joinPoint.proceed()

        val finish = Instant.now()
        val duration: Long = Duration.between(start, finish).toMillis();

        logRepository.save(Log(type = "duration", data = "$duration ms", source = signature));

        return result;

    }

}