# language: ru
# encoding: utf-8

  Функция: Смартфон
    Я как посетитель сайта ДНС хочу просматривать раздел со смартфонами.
    Это позволит мне выбрать понравившийся смартфон и прочитать его характеристики.

  Сценарий: Просмотр страницы Смартфоны
    Дано Запущен браузер и открыта Главная страница ДНС
    Когда Выполнен переход на страницу Смартфоны
    Тогда Проверить: В заголовке страницы отображается текс Смартфоны