package ru.store.testapp.utils

fun validatePhoneNumber(text: String): Boolean {
    return text.matches(Regex("""^\+?[0-9]{3,15}$"""))
}