package room

import Dices

class Rooms {

    companion object {
        val rooms = listOf(
            Room(11, RoomType.CORRIDOR),
            Room(12, RoomType.CORRIDOR),
            Room(13, RoomType.CORRIDOR),
            Room(14, RoomType.CORRIDOR),
            Room(15, RoomType.LARGE_ROOM),
            Room(16, RoomType.LARGE_ROOM),
        Room(21, RoomType.LARGE_ROOM),
        Room(22, RoomType.LARGE_ROOM),
        Room(23, RoomType.LARGE_ROOM),
        Room(24, RoomType.LARGE_ROOM),
        Room(25, RoomType.LARGE_ROOM),
        Room(26, RoomType.CORRIDOR),
        Room(31, RoomType.LARGE_ROOM),
        Room(32, RoomType.CORRIDOR),
        Room(33, RoomType.CORRIDOR),
        Room(34, RoomType.LARGE_ROOM),
        Room(35, RoomType.LARGE_ROOM),
        Room(36, RoomType.LARGE_ROOM),
        Room(41, RoomType.LARGE_ROOM),
        Room(42, RoomType.CORRIDOR),
        Room(43, RoomType.LARGE_ROOM),
        Room(44, RoomType.LARGE_ROOM),
        Room(45, RoomType.CORRIDOR),
        Room(46, RoomType.LARGE_ROOM),
        Room(51, RoomType.CORRIDOR),
        Room(52, RoomType.LARGE_ROOM),
        Room(53, RoomType.CORRIDOR),
        Room(54, RoomType.LARGE_ROOM),
        Room(55, RoomType.CORRIDOR),
        Room(56, RoomType.LARGE_ROOM),
        Room(56, RoomType.LARGE_ROOM),
        Room(61, RoomType.LARGE_ROOM),
        Room(62, RoomType.CORRIDOR),
        Room(63, RoomType.CORRIDOR),
        Room(64, RoomType.LARGE_ROOM),
        Room(65, RoomType.CORRIDOR),
        Room(66, RoomType.LARGE_ROOM)
        )
    }

    fun generateRoom(): Room {
        val diceResult = Dices.D66.roll()
        return rooms.first { room -> room.id == diceResult };
    }

}