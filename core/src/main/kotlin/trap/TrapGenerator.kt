package trap

fun generateTrap() : Trap {
    return when(Dices.D6.roll()) {
        1 -> Trap("Une fléchette",2, listOf("attaque un personnage au hasard","Jet de défense ou -1PV"))
        2 -> Trap("Un gaz empoissonné",3, listOf("attaque tous les personnages","Jet de défense sans bonus d'armure/bouclier ou -1PV"))
        3 -> Trap("Une trappe",4, listOf("s'ouvre sous les pieds d'un personnage qui marche devant","D6 contre le niveau du piège","-1 si armure légère (-2 si lourde)","+1 si elfe ou halfelin (+N si roublard)","Si vous êtes seuls, vous mourrez"))
        4 -> Trap("Un piège à ours",4, listOf("se referme sur la jambe d'un joueur devant","D6>niveau du piège","+1 si elfe ou halfelin (+N si roublard)","échec= -1PV + il boite tant que pas soigné","boiter: malus -1 sur attaque/défense. -2 sur pièges"))
        5 -> Trap("Des lances jaillissent des murs",5, listOf("Jaillissent des murs pour attaquer 2 personnages au hasard","jet de défense ou -1PV"))
        else -> Trap("Un bloc de pierre géant", 5, listOf("Tombe sur un personnage à l'arrière","jet de défense (or bouclier) ou -2PV"))
    }
}

data class Trap(val name: String, val level: Int, val description : List<String>) {

}
