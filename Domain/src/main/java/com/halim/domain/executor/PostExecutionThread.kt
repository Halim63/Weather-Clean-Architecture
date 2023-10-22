package com.halim.domain.executor

import io.reactivex.rxjava3.core.Scheduler


interface PostExecutionThread   {
     val scheduler: Scheduler
}