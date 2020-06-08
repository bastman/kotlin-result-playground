package util.ktresult

import com.github.michaelbull.result.runCatching

typealias KtResult<V, E> = com.github.michaelbull.result.Result<out V, out E>

inline fun <V> runCatchingKT(block: () -> V): KtResult<V, Throwable> = runCatching(block)
inline fun <T, V> Try(block: () -> V): KtResult<V, Throwable> = runCatchingKT(block)
