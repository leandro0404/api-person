package com.leandro.core.usecase;

public abstract class UseCase<TRequest, TResponse> extends UseCaseBaseTrace {


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
}


