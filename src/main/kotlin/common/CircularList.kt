package common

class CircularList <T>(private val inputList: ArrayList<T>): ArrayList<T>(inputList) {

    override fun get(index: Int): T {
        return if(index == inputList.size) inputList[0]
        else inputList[index]
    }

}