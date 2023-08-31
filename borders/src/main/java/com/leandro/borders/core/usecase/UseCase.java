package com.leandro.borders.core.usecase;

public interface UseCase<TRequest,TResponse> {
    TResponse execute(TRequest request);
}