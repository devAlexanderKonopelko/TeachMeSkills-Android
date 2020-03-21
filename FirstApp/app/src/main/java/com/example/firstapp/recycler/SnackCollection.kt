package com.example.firstapp.recycler

class SnackCollection {
    val snackCollection = ArrayList<Snack>()

    companion object {
        val instance = SnackCollection()
    }

    fun addSomeSnacks() {
        snackCollection.add(Snack("https://img07.rl0.ru/eda/c620x415i/s1.eda.ru/StaticContent/Photos/140408181639/140413115753/p_O.jpg","Сухарики",
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum", 10.0))
        snackCollection.add(Snack("https://www.maggi.ru/data/images/recept/img640x500/recept_6786_oye5.jpg","Огурчики",
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum", 15.0))
        snackCollection.add(Snack("https://storage.delikateska.ru/c/0/vyalenyi-200-g.png","Рыбка сушёная",
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum", 21.0))
        snackCollection.add(Snack("https://illustrators.ru/uploads/illustration/image/1123566/main_%D0%BD%D1%8F%D1%88%D0%BA%D0%B0.png","Хлебушек",
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum", 9.0))
        snackCollection.add(Snack("https://s1.webspoon.ru/receipts/2013/12/12041/orig_12041_0_xxl.jpg","Орешки",
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum", 17.0))
    }

    fun removeAllSnacks() {
        snackCollection.clear()
    }
}