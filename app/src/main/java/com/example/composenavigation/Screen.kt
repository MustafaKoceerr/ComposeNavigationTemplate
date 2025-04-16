package com.example.composenavigation

import androidx.compose.ui.input.pointer.PointerId

// argüman verme kısmında, id'nin birden fazla yerde tekrar ettiğini gördük. Bu tekrarda hata yaşamayalım diye const val kullanacağız.

const val DETAIL_ARGUMENT_KEY = "id"
// Artık argument Key'i değiştirmek istediğimizde bunu tek bir yerden yapabiliriz.

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail :
    // eğer required argüman olarak istiyorsan "/{}" içine yazmalısın.
        Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}") {
        // Burada basitçe object'in içinde bir fonksiyon tanımlıyoruz.
        // bu fonksiyon sayesinde detail screen'e gitmeye çalıştığımız yerde, bu fonksiyonu kullanmak yeterli olacak. id parametresini vererek bu işlemi basitçe yapabileceğiz.
        fun passId(id: Int): String {
//            return "detail_screen/$id" // her seferinde detail_screen yazmaktansa
            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
        }
    }
}
