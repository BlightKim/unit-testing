package chapter1

class Main {
    companion object {
        var wasLastStringLong: Boolean = false
            private set
        fun isStringLong(input: String): Boolean {
            val result = input.length > 5;
            wasLastStringLong = result;
            return result
        }
    }

}

