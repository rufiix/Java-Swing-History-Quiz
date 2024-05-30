
# Historia Quiz

Jest to aplikacja quizowa z zakresu historii, zaprojektowana do testowania wiedzy użytkowników na temat wydarzeń historycznych, postaci i ciekawostek. Aplikacja prezentuje pytania jednokrotnego wyboru i zapewnia informacje zwrotne na temat odpowiedzi użytkownika.




## Funkcjonalności

- Wyświetlanie listy pytań
- Wyświetlenie treści pytania po wybraniu go z listy
- Wyświetlanie statystyk użytkownika oraz jego miejsca w rankingu


## Pobieranie
Tu pobrać można plik **JAR**, służący do uruchomienia aplikacji.

[Download](https://drive.google.com/file/d/1Rt_vpveZxEOyrN1amq20GyqNzCznX__t/view?usp=sharing)

Wystarczy uruchomić plik aby aplikacja się otworzyła.


## Struktura kodu programu



```
└── HistoraQuiztest/
    ├── HistoriaQuiz.jar            # Plik wykonywalny
    └── src
        ├── ButtonTypeA.java        # Statystyki użytkownika
        ├── ButtonTypeB.java        # Miejsce w rankingu
        ├── ButtonTypeC.java        # Przycisk do statystyk oraz powrotu
        ├── GUI.java                # Całokształt interfejsu graficznego
        ├── Main.java               # Main
        ├── MyButton.java           # Przycisk odpowiadający za pytania
        ├── MyPanel.java            # Wyświetlanie panelu ucznia
        ├── addPanelTest.java       # Testy jednostkowe dodawania przyciku do panelu
        ├── getPytanieTest.java     # Testy jednostkowe dodawania pytań
        ├── funkcje_obliczające_statystyki.java     # Funkcje do statystyk
        └── testy_funkcji_statystyki.java           # Testy jednostkowe funkcji do statystyk
```
## Biblioteki oraz Wersje
* Swing
* JUnit (wersja 5.8.1)
* AWT

Kod był w całości napisany w **IntelliJ IDEA 2024.1.1** i jest oparty na **Java 17 (17.0.8)**
## Authors

- Kurzydłowski Maciej
- Domański Jan
- Koziara Kacper

