package com.example.websocketchattest.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/websocketchattest/api/Chat;", "", "()V", "api", "Lcom/example/websocketchattest/api/ChatApi;", "checkHealth", "Lio/reactivex/Single;", "", "Companion", "app_debug"})
public final class Chat {
    private final com.example.websocketchattest.api.ChatApi api = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://localhost:8080";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOKEN = "token";
    public static final com.example.websocketchattest.api.Chat.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.String> checkHealth() {
        return null;
    }
    
    public Chat() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/websocketchattest/api/Chat$Companion;", "", "()V", "BASE_URL", "", "TOKEN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}