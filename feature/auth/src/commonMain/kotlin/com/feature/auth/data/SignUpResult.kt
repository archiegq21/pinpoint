package com.feature.auth.data

class WeakPasswordException: Exception("Weak password")
class InvalidEmailException: Exception("Invalid email")
class EmailAlreadyInUseException: Exception("Email already in use")