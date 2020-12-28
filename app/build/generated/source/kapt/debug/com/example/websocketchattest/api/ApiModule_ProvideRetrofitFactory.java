// Generated by Dagger (https://dagger.dev).
package com.example.websocketchattest.api;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final ApiModule module;

  public ApiModule_ProvideRetrofitFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module);
  }

  public static ApiModule_ProvideRetrofitFactory create(ApiModule module) {
    return new ApiModule_ProvideRetrofitFactory(module);
  }

  public static Retrofit provideRetrofit(ApiModule instance) {
    return Preconditions.checkNotNull(instance.provideRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }
}