package treasure


fun generateTreasure(type : TreasureType) : List<Treasure> {
    return (1..type.nb)
        .map { Dices.D6.roll() + type.moderation }
        .map { pick(it) }
        .toList()
}

fun pick(diceResult: Int) : Treasure {
    return when {
        diceResult <= 0 -> Treasure("Rien", "juste de la poussière")
        diceResult == 1 -> Treasure("des pièces d'or", Dices.D6.roll().toString()+" PO")
        diceResult == 2 -> Treasure("des pièces d'or", Dices.DeuxD6.roll().toString()+" PO")
        diceResult == 3 -> Treasure("Un parchemin de sort", pickRandomSortilege(), true)
        diceResult == 4 -> Treasure("Une gemme", "Valeur: "+ Dices.DeuxD6.roll()*5+" PO", true)
        diceResult == 5 -> Treasure("Un bijoux", "Valeur: "+ Dices.TroisD6.roll()*10+" PO", true)
        else -> pickRandomMagicTreasure()
    }
}

fun pickRandomArme(): String {
    return when(Dices.D6.roll()) {
        1 -> "arme écrasante légère à 1 main"
        2 -> "arme tranchante légère à 1 main"
        3 -> "arme écrasante à 1 main"
        4,5 -> "arme tranchante à 1 main"
        else -> "arc"
    }
}

fun pickRandomMagicTreasure(): Treasure {
    return when(Dices.D6.roll()) {
        1 -> Treasure("Baguette de sommeil","Permet de lancer 3 fois sommeil. Seul les magiciens et les elfes peuvent l'utiliser. jet à +N", true)
        2 -> Treasure("Anneau de téléportation","Permet à l'utilisateur de réussir un jet de défense en se téléportant hors de la salle. Il ne peut plus participer au combat. une fois utilisé, vaut "+ Dices.D6.roll()+1+" PO", true)
        3 -> Treasure("Or des fous","Ces fausses pièces d'or (magiques) permet de soudoyer le prochain monstre qui demande un pot de vin, quelque soit la somme. usage unique", true)
        4 -> Treasure(pickRandomArme()+" magique","confère +1 aux jets d'attaque de l'utilisateur.", true)
        5 -> Treasure("Potion de soin","utilisable à n'importe quel moment. Soigne tous les points de vie d'un même personnage (sau le barbare)", true)
        else -> Treasure("Bâton de boule de feu","Permet de lancer le sort boule de feu 2 fois. Utilisable seulement par les magiciens. jet à +N", true)
    }
}

fun pickRandomSortilege(): String {
    return when(Dices.D6.roll()) {
        1 -> "Bénédiction"
        2 -> "Boule de feu"
        3 -> "Eclair"
        4 -> "Sommeil"
        5 -> "Fuir"
        6 -> "Protéger"
        else -> "Rien"
    }
}
