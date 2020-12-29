package com.example.websocketchattest.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/example/websocketchattest/api/ChatApi;", "", "createBaseChannel", "Lio/reactivex/Single;", "Lokhttp3/ResponseBody;", "channelRequest", "Lcom/example/websocketchattest/api/ChannelRequest;", "createClient", "Lcom/example/websocketchattest/api/model/ClientModel;", "createClientRequest", "Lcom/example/websocketchattest/api/request/CreateClientRequest;", "createConfig", "configModel", "Lcom/example/websocketchattest/api/model/ConfigModel;", "getConfig", "appName", "", "healthCheck", "Lcom/example/websocketchattest/api/response/StatusResponse;", "publishMessage", "publishRequest", "Lcom/example/websocketchattest/api/request/PublishRequest;", "app_debug"})
public abstract interface ChatApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "_healthcheck")
    public abstract io.reactivex.Single<com.example.websocketchattest.api.response.StatusResponse> healthCheck();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "X-AUTH-TOKEN: sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"})
    @retrofit2.http.POST(value = "api/config")
    public abstract io.reactivex.Single<okhttp3.ResponseBody> createConfig(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.websocketchattest.api.model.ConfigModel configModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "X-AUTH-TOKEN: sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"})
    @retrofit2.http.GET(value = "api/config/{app_name}")
    public abstract io.reactivex.Single<com.example.websocketchattest.api.model.ConfigModel> getConfig(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "app_name")
    java.lang.String appName);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "X-AUTH-TOKEN: sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"})
    @retrofit2.http.POST(value = "api/channel")
    public abstract io.reactivex.Single<okhttp3.ResponseBody> createBaseChannel(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.websocketchattest.api.ChannelRequest channelRequest);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "X-AUTH-TOKEN: sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"})
    @retrofit2.http.POST(value = "api/client")
    public abstract io.reactivex.Single<com.example.websocketchattest.api.model.ClientModel> createClient(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.websocketchattest.api.request.CreateClientRequest createClientRequest);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "X-AUTH-TOKEN: sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"})
    @retrofit2.http.POST(value = "api/publish")
    public abstract io.reactivex.Single<okhttp3.ResponseBody> publishMessage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.websocketchattest.api.request.PublishRequest publishRequest);
}