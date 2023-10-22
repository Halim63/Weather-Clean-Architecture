package com.halim.presentation.base

data class Resource<out T> constructor(
    val state: ResourceState,
    val values: T? = null,
    val throwable: Throwable? = null
) {

    companion object {
        fun <T> success(t: T): Resource<T> {
            return Resource<T>(
                values = t,
                state = ResourceState.SUCCESS
            )
        }

        fun <T> error(throwable: Throwable? = null): Resource<T> {
            return Resource<T>(
                state = ResourceState.ERROR,
                throwable = throwable
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource<T>(
                state = ResourceState.LOADING
            )
        }
    }


}