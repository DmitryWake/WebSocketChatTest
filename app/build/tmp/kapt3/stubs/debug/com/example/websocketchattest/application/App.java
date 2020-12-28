package com.example.websocketchattest.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/example/websocketchattest/application/App;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class App extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static com.example.websocketchattest.di.dagger.components.AppComponent appComponent;
    @org.jetbrains.annotations.NotNull()
    public static com.example.websocketchattest.api.Chat chat;
    public static final com.example.websocketchattest.application.App.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public App() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/example/websocketchattest/application/App$Companion;", "", "()V", "appComponent", "Lcom/example/websocketchattest/di/dagger/components/AppComponent;", "getAppComponent", "()Lcom/example/websocketchattest/di/dagger/components/AppComponent;", "setAppComponent", "(Lcom/example/websocketchattest/di/dagger/components/AppComponent;)V", "chat", "Lcom/example/websocketchattest/api/Chat;", "getChat", "()Lcom/example/websocketchattest/api/Chat;", "setChat", "(Lcom/example/websocketchattest/api/Chat;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.websocketchattest.di.dagger.components.AppComponent getAppComponent() {
            return null;
        }
        
        public final void setAppComponent(@org.jetbrains.annotations.NotNull()
        com.example.websocketchattest.di.dagger.components.AppComponent p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.websocketchattest.api.Chat getChat() {
            return null;
        }
        
        public final void setChat(@org.jetbrains.annotations.NotNull()
        com.example.websocketchattest.api.Chat p0) {
        }
        
        private Companion() {
            super();
        }
    }
}