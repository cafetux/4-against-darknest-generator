package enemy.generator

import treasure.TreasureType
import enemy.Enemy
import enemy.EnemyType
import enemy.MajorEnemy

fun getStrangeMonsters(): Enemy {

    when (Dices.D6.roll()) {
        1 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 5,
            undead = false,
            bonusEcrasant = false,
            name = "Minotaure",
            details = listOf("Le premier jet de défense contre un Minotaure se fait à -1 (charge de taureau)","Les Halfelins ne peuvent utiliser 'chance' (les minotaures adorent les dévorer)","pas de test de moral"),
            treasure = TreasureType.NORMAL,
            reactions = listOf("1-2: soudoyer (60 PO)","3-4: se battre","5-6: se battre jusqu'à la mort"),
            lives = 4,
            2
        )
        2 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 3,
            undead = false,
            bonusEcrasant = false,
            name = "Dévoreur d'acier",
            details = listOf("Les bonus d'armure lourde ne s'appliquent pas sur les jets de défense","Si le monstre touche, le personnage ne prends pas de dégât mais perd son armure, son bouclier, son arme principale ou 3d6 PO, dans cet ordre"),
            treasure = TreasureType.NONE,
            reactions = listOf("1: fuir","2-3: Soudoyer (d6 PO pour distraire la créature, hors 'or des fous')","4-6: se battre"),
            lives = 4,
            3
        )
        3 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 5,
            undead = false,
            bonusEcrasant = false,
            name = "Chimère",
            details = listOf("D6 à chaque tour de la chimère: si 1 ou 2, la chimère crache du feu (au lieu d'attaquer) et les personnages doivent réussir un jet de sauvegarde contre un feu niveau 4 ou perdre 1PV"),
            treasure = TreasureType.NORMAL,
            reactions = listOf("1: Soudoyer (50 PO)","2-6: se battre"),
            lives = 6,
            3
        )
        4 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 4,
            undead = false,
            bonusEcrasant = false,
            name = "Catoblépas",
            details = listOf("Au début de la bataille, tous les personnages doivent réussir un jet de sauvegarde contre une attaque de regard niveau 4 ou perdre 1 PV"),
            treasure = TreasureType(1, +1),
            reactions = listOf("1: fuir","2-6: se battre"),
            lives = 4,
            1
        )
        5 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 5,
            undead = false,
            bonusEcrasant = false,
            name = "Araignée géante",
            details = listOf("Les personnages qui subissent une blessure doivent réussir un jet de sauvegarde contre un poison niveau 3 ou perdre 1pts de vie supplémentaire","à cause de la toile d'araignée, les personnages ne peuvent se désengager du combat, à moins de lancer le sort boule de feu pour bruler la toile"),
            treasure = TreasureType(2, 0),
            reactions = listOf("Toujours se battre"),
            lives = 3,
            2
        )
        6 -> return MajorEnemy(
            type = EnemyType.STRANGE,
            level = 0,
            undead = false,
            bonusEcrasant = false,
            name = "Gremlins invisibles",
            details = listOf("Un groupe de gremlins invisibles volent D6+3 objets au groupe, dans cet ordre de préférence: objets magiques, parchemins, potions, armes, gemmes et pièces (en paquets de 10po)","Si les gremlins volent TOUT votre équipement, ils vous laisseront un message de remerciement sous forme d'indice"," pas de jet de PX"),
            treasure = TreasureType.NONE,
            reactions = listOf("Toujours se battre"),
            lives = 0,
            0
        )
        else -> throw java.lang.IllegalArgumentException("invalid dice result")

    }
}

private fun pouvoirSpecialSeigneurDuChaos() : String {
    return when(Dices.D6.roll()) {
        4 -> "Pouvoir: Oeil maléfique (Les personnages lancent 1d6. Si <4, leurs jets de défense se font à -1)"
        5 -> "Pouvoir: Drain d'énergie (Tout personnage qui subit 1 blessure doit faire 4+ sur 1d6 ou perdre 1 niveau)"
        6 -> "Pouvoir: souffle de flammes infernales (Avant le combat, les personnages doivent obtenir 6+ sur un jet ou perdre 2 PV. Les prêtres ajoutent N/2 à ce jet)"
        else -> "aucun pouvoir"
    }
}
