package com.example.calculator.usecase

class SumUseCase {

    fun execute(firstNumber: Int, secondNumber: Int): Result {
        return if (firstNumber > 0 && secondNumber > 0) {
            Result.Success(firstNumber + secondNumber)
        } else {
            Result.Failure("Both numbers must be greater than 0!!")
        }
    }

    sealed class Result {
        class Success(val result: Int) : Result()
        class Failure(val message: String) : Result()
    }

}