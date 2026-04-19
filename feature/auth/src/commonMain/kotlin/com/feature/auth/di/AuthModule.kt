package com.feature.auth.di

import com.feature.auth.sources.AuthRepository
import com.feature.auth.sources.AuthService
import com.feature.auth.sources.FirebaseAuthService
import com.feature.auth.sources.RealAuthRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authModule = module {
    single<FirebaseAuth> { Firebase.auth }
    singleOf(::FirebaseAuthService) bind AuthService::class
    singleOf(::RealAuthRepository) bind AuthRepository::class
}