Feature: Recuperación de Diccionarios

  Background:
    Given Que tengo un suministrador de diccionarios
      And que la librería contiene el idioma "ELFICO"
      And que la librería no contiene el idioma "RUINA"

  Scenario: Consultar un diccionario que existe
    When  pregunto si tiene un diccionario para el idioma "ELFICO"
    Then  el suministrador debe devolver que "SI" lo tiene

  Scenario: Consultar un diccionario que NO existe
    When  pregunto si tiene un diccionario para el idioma "RUINA"
    Then  el suministrador debe devolver que "NO" lo tiene

  Scenario: Recuperar un diccionario que existe
    When  solicito al suministrador un diccionario para el idioma "ELFICO"
    Then  el suministrador debe devolver el diccionario de "ELFICO"

  Scenario: Recuperar un diccionario que NO existe
    When  solicito al suministrador un diccionario para el idioma "RUINA"
    Then  el suministrador no debe devolver un diccionario
