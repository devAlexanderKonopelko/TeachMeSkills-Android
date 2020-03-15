package com.example.firstapp.flowers

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    fun setFlowerTopFragment(fragmentTop: FragmentTop) {
        fragmentTop.setFlower(FlowersList.flowers.flowersList[0])
    }

    fun setFlowerBottomFragment(fragmentBottom: FragmentBottom) {
        fragmentBottom.setFlower(FlowersList.flowers.flowersList[1])
    }

}