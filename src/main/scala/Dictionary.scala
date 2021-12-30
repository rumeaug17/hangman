package org.rg.hangman

object Dictionary:
  lazy val words : List[String] =
    List(
      "découverte",
      "aventure",
      "jouet",
      "histoire",
      "plusieurs",
      "inconnu",
      "traverser",
      "déversoir",
      "plus",
      "petit",
      "grand",
      "armoire",
      "tombe",
      "estragon",
      "escargot",
      "maison",
      "ristourne",
      "apparaître",
      "apprendre",
      "journée",
      "journal",
      "ordinateur",
      "lire",
      "terre",
      "soleil",
      "cheval",
      "chat",
      "chien",
      "asperge",
      "pruneaux",
      "zest",
      "vidange",
      "voiture",
      "fusée",
      "pluriel",
      "politique",
      "amours",
      "jeux"
    )

  lazy val hangmanStages = List(
    """
      #   --------
      #   |      |
      #   |
      #   |
      #   |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |
      #   |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |      |
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |     /
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |     / \
      #   -
      #""".stripMargin('#')
  )