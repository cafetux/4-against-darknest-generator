package enemy

import treasure.TreasureType

fun getNuisibles(): Enemy {
    when (Dices.D6.roll()) {
        1 -> return Enemy(
                EnemyType.NUISIBLES, Dices.TroisD6.roll(), 1,
                undead = true,
                bonusEcrasant = false,
                name = "Rats",
                details = listOf("Tout personnage blessé a 1 chance sur 6 d'avoir 1 pts de vie en moins supplémentaire (blessure infectée)"),
                treasure = TreasureType.NONE,
                reaction = reactionRats()
            )
        2 -> return Enemy(
            type = EnemyType.NUISIBLES,
            number = Dices.TroisD6.roll(),
            level = 1,
            undead = false,
            bonusEcrasant = false,
            name = "Chauve-souris vampires",
            details = listOf("Les sorts sont lancés à -1 à cause de leurs cris perturbants"),
            treasure = TreasureType.NONE,
            reaction = reactionChauveSouris()
        )
        3 -> return Enemy(
            type = EnemyType.NUISIBLES,
            number = Dices.DeuxD6.roll(),
            level = 3,
            undead = false,
            bonusEcrasant = false,
            name = "Gobelins de colonie",
            details = listOf("Les nains attaquent à +1","moral -1"),
            treasure = TreasureType(1 , -1),
            reaction = reactionGobelinsColonie()
        )
        4 -> return Enemy(
            type = EnemyType.NUISIBLES,
            number = Dices.D6.roll(),
            level = 3,
            undead = false,
            bonusEcrasant = false,
            name = "Mille-pattes géant",
            details = listOf("Tout personne blessé par un mille-pattes géant doit réussir un jet de sauvegarde contre un poison niveau 2 ou perdre 1pts de vie supplémentaire"),
            treasure = TreasureType.NONE,
            reaction = reactionMillePatte()
        )
        5 -> return Enemy(
            type = EnemyType.NUISIBLES,
            number = Dices.D6.roll(),
            level = 4,
            undead = false,
            bonusEcrasant = false,
            name = "Grenouilles vampires",
            details = listOf("ne sont pas des morts vivants"),
            treasure = TreasureType(1 , -1),
            reaction = reactionGrenouilles()
        )
        6 -> return Enemy(
            EnemyType.NUISIBLES, Dices.DeuxD6.roll(),
            level = 3,
            undead = true,
            bonusEcrasant = true,
            name = "rats squelettes",
            details = listOf("Ne peut être attaqué par des arcs ou des frondes","Les prêtres attaquent à +N"),
            treasure = TreasureType.NONE,
            reaction = reactionRatsSquelettes()
        )
    }
    throw java.lang.IllegalArgumentException("invalid dic result")
}

fun reactionRats(): String {
    return when(Dices.D6.roll()) {
        1,2,3 -> "Fuir"
        else -> "se battre"
    }

}

fun reactionChauveSouris(): String {
    return when(Dices.D6.roll()) {
        1,2,3 -> "Fuir"
        else -> "se battre"
    }
}

fun reactionGobelinsColonie(): String {
    return when(Dices.D6.roll()) {
        1 -> "Fuir"
        2,3 -> "Fuir en sous nombre"
        4 -> "Soudoyer (4PO/gobelins)"
        else -> "Se battre"
    }
}

fun reactionMillePatte(): String {
    return when(Dices.D6.roll()) {
        1 -> "Fuir"
        2,3 -> "Fuir en sous nombre"
        else -> "Se battre"
    }
}

fun reactionGrenouilles(): String {
    return when(Dices.D6.roll()) {
        1 -> "Fuir"
        2,3,4 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionRatsSquelettes(): String {
    return when(Dices.D6.roll()) {
        1,2 -> "Fuir"
        else -> "se battre"
    }
}

