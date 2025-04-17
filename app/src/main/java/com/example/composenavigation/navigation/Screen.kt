package com.example.composenavigation.navigation

// argüman verme kısmında, id'nin birden fazla yerde tekrar ettiğini gördük. Bu tekrarda hata yaşamayalım diye const val kullanacağız.

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"
const val LIST_ARGUMENT_KEY = "id"
const val LIST_ARGUMENT_KEY2 = "name"

const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"


// Artık argument Key'i değiştirmek istediğimizde bunu tek bir yerden yapabiliriz.

/**
 * DetailScreen için required arguments'ler çalışıldı,
 * ListScreen için optional arguments'ler çalışıldı.
 * Required arguments için "/" kullanıldı, optional arguments için "?" kullanıldı.
 */
sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail :
    // eğer required argüman olarak istiyorsan "/{}" içine yazmalısın.
        Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
        // Burada basitçe object'in içinde bir fonksiyon tanımlıyoruz.
        // bu fonksiyon sayesinde detail screen'e gitmeye çalıştığımız yerde, bu fonksiyonu kullanmak yeterli olacak. id parametresini vererek bu işlemi basitçe yapabileceğiz.
        /**
         *         fun passId(id: Int): String {
         * //            return "detail_screen/$id" // her seferinde detail_screen yazmaktansa
         *             return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
         *         }
         *         Artık 2 argümana geçtiğimiz için bu fonksiyon işlevsiz.
         */

        fun passIdAndName(
            id: Int,
            name: String,
        ): String {
            return "detail_screen/$id/$name" // Burada curly braces eklenmediğine dikkat et.
//            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
        }
    }

    object List : Screen(route = "list_screen?$LIST_ARGUMENT_KEY={id}&$LIST_ARGUMENT_KEY2={name}") {

        fun passId(id: Int = 0): String {
            return "list_screen?$LIST_ARGUMENT_KEY=$id"
        }

        fun passIdAndName(id: Int = 0, name: String = "default_name"): String {
            return this.route.replace(oldValue = "{$LIST_ARGUMENT_KEY}", newValue = id.toString())
                .replace(oldValue = "{$LIST_ARGUMENT_KEY2}", newValue = name)

        }
    }

    object Login : Screen(route = "login_screen")
    object SignUp : Screen(route = "signup_screen")

}
