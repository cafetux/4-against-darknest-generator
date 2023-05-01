package enemy.generator

import treasure.TreasureType
import enemy.Enemy
import enemy.EnemyType
import enemy.MajorEnemy

fun getBoss(): Enemy {
    return listOf<Enemy>(
        MajorEnemy(
            type = EnemyType.BOSS,
            level = 5,
            undead = true,
            bonusEcrasant = false,
            name = "Momie",
            details = listOf(
                "Un personnage tué par la momie devient une momie (doit être détruit par le groupe)",
                "attaques boule de feu se font à +2",
                "pas de test de moral"
            ),
            treasure = TreasureType(1 , +2),
            reaction = "Se battre",
            lives = 4,
            2
        ),
        MajorEnemy(
            type = EnemyType.BOSS,
            level = 5,
            undead = false,
            bonusEcrasant = false,
            name = "Brute Orque",
            details = listOf("jamais d'objets magiques (remplacé par 2d6 x d6 PO)"),
            treasure = TreasureType(1 , +1),
            reaction = reactionBruteOrque(),
            lives = 5,
            2
        ),
        MajorEnemy(
            type = EnemyType.BOSS,
            level = 5,
            undead = false,
            bonusEcrasant = false,
            name = "Ogre",
            details = listOf("Chaque coup infligé enlève 2 points de vie"),
            treasure = TreasureType.NORMAL,
            reaction = reactionOgre(),
            lives = 5,
            1
        ),
        MajorEnemy(
            type = EnemyType.BOSS,
            level = 4,
            undead = false,
            bonusEcrasant = false,
            name = "Méduse",
            details = listOf(
                "Au début du combat, tous les personnages doivent réussir un jet de sauvegarde contre une attaque de regard niveau 4 ou être pétrifié",
                "Les roublards ajoutent N/2 à ce jet de sauvegarde",
                "Benediction soigne les pétrifiés"
            ),
            treasure = TreasureType(1,+1),
            reaction = reactionMedusa(),
            lives = 4,
            1
        ),
        MajorEnemy(
            type = EnemyType.BOSS,
            level = 6,
            undead = false,
            bonusEcrasant = false,
            name = "Seigneur du chaos",
            details = listOf(
                pouvoirSpecialSeigneurDuChaos(),
                "A sa mort, sur 5 ou 6 sur un jet d6, un personnage trouve un indice"
            ),
            treasure = TreasureType(2, +1),
            reaction = reactionSeigneurChaos(),
            lives = 4,
            3
        )
    ).random()
}

fun reactionBruteOrque(): String {
    return when(Dices.D6.roll()) {
        1 -> "Soudoyer (50 PO)"
        2,3,4,5  -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }

}

fun reactionOgre(): String {
    return when(Dices.D6.roll()) {
        1 -> "Soudoyer (30 PO)"
        2,3 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionMedusa(): String {
    return when(Dices.D6.roll()) {
        1 -> "Soudoyer ("+Dices.SixD6+" PO)"
        2 -> "quête"
        3,4,5 -> "Se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun reactionSeigneurChaos(): String {
    return when(Dices.D6.roll()) {
        1 -> "fuir si en sous nombre"
        2 -> "se battre"
        else -> "Se battre jusqu'à la mort"
    }
}

fun getDragon(): Enemy {
    return MajorEnemy(
        type = EnemyType.BOSS,
        level = 6,
        undead = false,
        bonusEcrasant = false,
        name = "Petit dragon",
        details = listOf(
            "à chaque tour, déterminer l'action du dragon:1-2: souffle du feu (1PV à chaque personnage échouant à son jet de sauvegarde niveau 6 à +N/2). 3-6: mords 2 personnages au hasard",
            "jamais rencontrés comme montres aléatoires"
        ),
        treasure = TreasureType(3, +1),
        reaction = reactionDragon(),
        lives = 5,
        2
    )
}

fun reactionDragon(): String {
    return when(Dices.D6.roll()) {
        1 -> "Endormis (Les personnages attaquent à +2 lors de leur 1ere attaque)"
        2,3 -> "Soudoyer (tout l'or du groupe, 100 PO minimum) ou un objet magique"
        4,5 -> "Se battre"
        else -> "Quête"
    }
}


private fun pouvoirSpecialSeigneurDuChaos(): String {
    return when (Dices.D6.roll()) {
        4 -> "Pouvoir: Oeil maléfique (Les personnages lancent 1d6. Si <4, leurs jets de défense se font à -1)"
        5 -> "Pouvoir: Drain d'énergie (Tout personnage qui subit 1 blessure doit faire 4+ sur 1d6 ou perdre 1 niveau)"
        6 -> "Pouvoir: souffle de flammes infernales (Avant le combat, les personnages doivent obtenir 6+ sur un jet ou perdre 2 PV. Les prêtres ajoutent N/2 à ce jet)"
        else -> "aucun pouvoir"
    }
}
