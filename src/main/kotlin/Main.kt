fun main(){
    try {
        val light = Light(50)
        val light1 = Light(60)

        val subject = Subject("Стол", 4)
        val subject1 = Subject("Холодильник", 1)

        val room = Room("Комната № 1", 10, 2)
        val room1 = Room("Комната № 2", 2,1)

        val building = Building("Здание № 1")
        val building1 = Building("Здание № 2")

        room.addLight(light)
        room.addLight(light1)

        room1.addLight(light1)

        room.addSubject(subject)
        room.addSubject(subject1)

        room1.addSubject(subject1)

        building.addRoom(room)
        building1.addRoom(room1)


    } catch (e: IlluminanceTooMuchException) {
        println("IlluminanceTooMuchException" + e.message)
    } catch (e: SpaceUsageTooMuchException) {
        println("SpaceUsageTooMuchException" + e.message)
    }
}