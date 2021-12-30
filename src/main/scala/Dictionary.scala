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
      "déversoir"
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