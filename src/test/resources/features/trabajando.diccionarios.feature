
Feature: Trabajar con un diccionario

  Background:
    Given Que tengo un suministrador de diccionarios
       # When  solicito al suministrador un diccionario para el idioma "ES"
    And solicito al suministrador un diccionario para el idioma "ES"

  Scenario: Consultar el idioma de un diccionario
    When  pregunto al diccionario por su idioma
    Then  el diccionario debe devolver "ES"

  Scenario Outline: Consultar un término que existe en el diccionario
    When  pregunto al diccionario si existe el término "<palabra>"
    Then  el diccionario debe devolver que "SI" existe

    Examples:
      | palabra |
      | manzana |
      | MANZANA |
      | Manzana |
      | Hotel   |
      | mesa    |

  Scenario Outline: Consultar un término que NO existe en el diccionario
    When  pregunto al diccionario si existe el término "<palabra>"
    Then  el diccionario debe devolver que "NO" existe

    Examples:
      | palabra |
      | manana  |
      | MANANA  |
      | otel    |
      | messa   |

  Scenario Outline: Consultar definiciones de un término que existe en el diccionario
    When  pregunto al diccionario las definiciones del término "<palabra>"
    Then  el diccionario debe devolver una lista con <numero_definiciones> definiciones

    Examples:
      | palabra | numero_definiciones |
      | manzana | 2                   |
      | MANZANA | 2                   |
      | Manzana | 2                   |
      | Hotel   | 1                   |
      | mesa    | 4                   |

  Scenario Outline: Consultar definiciones de un término que NO existe en el diccionario
    When  prpregunto al diccionario las definiciones del término "<palabra>"
    Then  el diccionario no debe devolver definiciones

    Examples:
      | palabra |
      | manana  |
      | MANANA  |
      | otel    |
      | messa   |

  Scenario Outline: Consultar sugerencias de un término en el diccionario
    When  pregunto al diccionario por sugerencias del término "<palabra>"
    Then  el diccionario debe devolver una lista con al menos <numero> sugerencias
    And  entre ellas debe de estar la palabra "<sugerencia>"

    Examples:
      | palabra | numero | sugerencia  |
      | manana  | 5      | banana      |
      | melon   | 5      | melón       |

  Scenario Outline: Consultar sugerencias de un término muy raro en el diccionario
    When  pregunto al diccionario por sugerencias del término "<palabra>"
    Then  el diccionario debe devolver una lista sin sugerencias

    Examples:
      | palabra        |
      | estringlococo  |
      | 123456         |