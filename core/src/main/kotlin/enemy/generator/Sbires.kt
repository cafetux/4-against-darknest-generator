package enemy

import treasure.TreasureType

fun getSbires(): Enemy {
    when (Dices.D6.roll()) {
        1 -> when (Dices.D6.roll() % 2) {
            1 -> return Enemy(
                type = EnemyType.SBIRES, number = Dices.D6.roll() + 2, level = 3,
                undead = true,
                bonusEcrasant = true,
                name = "Squelettes",
                details = listOf("attaques avec flèches à -1", "pas de test de moral"),
                treasure = TreasureType.NONE,
                reaction = "Se battre jusqu'à la mort"
            )
            0 -> return Enemy(
                EnemyType.SBIRES, Dices.D6.roll(), 3,
                undead = true,
                bonusEcrasant = false,
                name = "Zombies",
                details = listOf("attaques avec flèches à -1", "pas de test de moral"),
                treasure = TreasureType.NONE,
                reaction = "Se battre jusqu'à la mort"
            )
        }
        2 -> return Enemy(
            type = EnemyType.SBIRES,
            number = Dices.D6.roll() + 3,
            level = 3,
            undead = false,
            bonusEcrasant = false,
            name = "Gobelins",
            details = listOf("1 chance sur 6 de prendre le groupe par surprise. Si c'est le cas, effectuez un jet de réaction"),
            treasure = TreasureType(1,-1),
            reaction = reactionGobelinsSbires()
        )
        3 -> return Enemy(
            type = EnemyType.SBIRES,
            number = Dices.D6.roll(),
            level = 4,
            undead = false,
            bonusEcrasant = false,
            name = "Hobgobelins",
            details = listOf(""),
            treasure = TreasureType(1, +1),
            reaction = reactionHobgobelins()
        )
        4 -> return Enemy(
            type = EnemyType.SBIRES,
            number = Dices.D6.roll() + 1,
            level = 4,
            undead = false,
            bonusEcrasant = false,
            name = "Orcs",
            details = listOf("craignent la magie, doivent effectuer un jet de moral si l'un d'entre eux est tué par un sort","si en dessous de 50% suite à un sort, jet de moral à -1","Elfes attaquent (et lancent des sorts) à +1", "Les orcs n'ont pas d'objets magiques. Le cas échéant, à remplacer par d6xd6 PO"),
            treasure = TreasureType.NORMAL,
            reaction = reactionOrcs()
        )
        5 -> return Enemy(
            EnemyType.SBIRES, Dices.D3.roll(), 5,
            undead = false,
            bonusEcrasant = false,
            name = "Trolls",
            details = listOf("se régénèrent à moins d'être tué par un sort ou découpé en morceaux une fois mort (1 attaque). Lancez 1d6 pour chaque troll tué, si 5-6: le troll revient à la vie"),
            treasure = TreasureType.NORMAL,
            reaction = reactionTrolls()
        )
        6 -> return Enemy(
            EnemyType.SBIRES, Dices.DeuxD6.roll(),
            level = 3,
            undead = false,
            bonusEcrasant = false,
            name = "Champignhommes",
            details = listOf("tout personnage qui subit des dégâts du champignhommes doit effectuer un jet de sauvegarde contre un poison niveau 3 ou perdre 1 point de vie","les Halfelins ajoutent leur niveau à leur jet de sauvegarde"),
            treasure = TreasureType.NORMAL,
            reaction = reactionChampis()
        )
    }
    throw java.lang.IllegalArgumentException("invalid dic result")
}

fun reactionGobelinsSbires(): String {
    return when (Dices.D6.roll()) {
        1 -> "Fuir si en sous nombre"
        2,3 -> "Soudoyer (5 PO / gobelin)"
        else -> "Se battre"
    }
}

fun reactionHobgobelins(): String {
    return when (Dices.D6.roll()) {
        1 -> "Fuir si en sous nombre"
        2,3 -> "Soudoyer (10 PO / Hobgobelins)"
        4,5 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionOrcs(): String {
    return when (Dices.D6.roll()) {
        1, 2 -> "Soudoyer (10 PO / orc)"
        3,5 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionTrolls(): String {
    return when (Dices.D6.roll()) {
        1, 2 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionChampis(): String {
    return when (Dices.D6.roll()) {
        1, 2 -> "Soudoyer ("+ Dices.D6.roll()+" PO/champignhommes)"
        else -> "se battre"
    }
}

