package com.feature.auth.data

class InvalidUserException: Exception("Weak password")
class InvalidCredentialsException: Exception("Invalid email")
class SignInException: Exception("Error Logging In with Credentials")