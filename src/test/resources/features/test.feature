#language: en

  @TEST

  Feature: Test 1
    @1Step
    Scenario: 1.1 Заведение пользователя
      When Получаем данные
      When заводим пользователя

    @2Step
    Scenario: 2.1 Сравнение рас
      When Получаем персонаж
      When Получаем эпизод
      When Получаем последнего персонажа
      When Получаем расу Морти
      When Получаем расу последнего персонажа
      When Сравниваем расы

    @3Step
    Scenario: 2.2 Сравнение локации
      When Получаем персонаж
      When Получаем эпизод
      When Получаем последнего персонажа
      When Получаем локацию Морти
      When Получаем локацию последнего персонажа
      When Сравниваем локации