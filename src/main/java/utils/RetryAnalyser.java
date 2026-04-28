package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    private int retryCount = 0;
    private static int maxTryValue = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxTryValue) {
            retryCount++;
            return true;
        }
        return false;
    }
}
// RetryAnalyzer для TestNG: автоматически перезапускает упавший тест до 3 раз.
// Используется для нестабильных (flaky) тестов, чтобы уменьшить ложные падения.

// Интерфейс — это контракт: набор методов без реализации,
// который класс обязан реализовать (implements)

//IRetryAnalyzer содержит один метод:
//boolean retry(ITestResult result);

//👉 Что это значит:
//
/// / retry(...) — вызывается после падения теста
/// / return true  → тест перезапустить
/// / return false → тест окончательно FAILED