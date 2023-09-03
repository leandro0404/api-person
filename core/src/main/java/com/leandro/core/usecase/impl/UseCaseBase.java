package com.leandro.core.usecase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.leandro.borders.core.usecase.UseCase;

public abstract class UseCaseBase<TRequest, TResponse> extends UseCaseBaseTrace
        implements UseCase<TRequest, TResponse> {

    protected abstract TResponse onExecute(TRequest request);

    @Override
    public TResponse execute(TRequest request) {
        try {
            logStart();
            TResponse execute = onExecute(request);
            logEnd();
            return execute;
        } catch (Exception ex) {
            logError(ex);
            throw ex;
        }
    }

    public static <TFirst, TSecond, TKey> Map<TFirst, List<TSecond>> generateEntitiesForIds(
            List<TFirst> firstList,
            List<TSecond> secondList,
            Function<TFirst, TKey> firstKeyExtractor,
            Function<TSecond, TKey> secondKeyExtractor) {

        Map<TFirst, List<TSecond>> entitiesMap = new HashMap<>();
        firstList.forEach(first -> {
            TKey key = firstKeyExtractor.apply(first);
            List<TSecond> list = secondList.stream()
                    .filter(second -> secondKeyExtractor.apply(second).equals(key))
                    .collect(Collectors.toList());

            entitiesMap.put(first, list);
        });

        return entitiesMap;
    }
}
