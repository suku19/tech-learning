package com.techlearn.lambda.functioninterface;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
