package com.delusional_bear.dessertmaniac.model

import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Continent
import com.delusional_bear.dessertmaniac.data.Country
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.Location
import com.delusional_bear.dessertmaniac.data.MostOrderedDessert

/**
 * [DataSource] object with the list of [Dessert] objects
 */

object DataSource {
    /**
     * [dessertList] represents a list of all desserts that are available
     */
    val dessertList = listOf(
        Dessert(
            R.string.chocolate_truffle_honeycomb_torte,
            R.drawable.chocolate_truffle_and_honeycomb_torte,
            listOf(
                R.string.honey,
                R.string.cornflakes,
                R.string.dark_chocolate,
                R.string.syrup,
                R.string.double_cream,
            ),
            4.0,
        ),
        Dessert(
            R.string.peach_melba_pie,
            R.drawable.peach_melba_pie,
            listOf(
                R.string.gelatine,
                R.string.butter,
                R.string.strawberry,
                R.string.eggs,
                R.string.caster_sugar,
                R.string.milk,
                R.string.double_cream,
            ),
            5.0,
        ),
        Dessert(
            R.string.treacle_tart,
            R.drawable.treacle_tart,
            listOf(
                R.string.flour,
                R.string.butter,
                R.string.icing_sugar,
                R.string.salt,
                R.string.egg_yolks,
                R.string.water,
                R.string.syrup,
                R.string.ginger,
                R.string.lemon,
                R.string.eggs,
                R.string.breadcrumbs,
            ),
            4.0,
        ),
        Dessert(
            R.string.salted_chocolate_hazelnut_brownies,
            R.drawable.salted_chocolate_hazelnut_brownies,
            listOf(
                R.string.butter,
                R.string.dark_chocolate,
                R.string.chocolate,
                R.string.hazelnut,
                R.string.caster_sugar,
                R.string.flour,
                R.string.nuts,
                R.string.caramel_sauce,
                R.string.eggs,
            ),
            5.0,
        ),
        Dessert(
            R.string.easy_cornflake_tart,
            R.drawable.cornflake_cake,
            listOf(
                R.string.pastry,
                R.string.flour,
                R.string.butter,
                R.string.syrup,
                R.string.soft_sugar,
                R.string.cornflakes,
                R.string.jam,
                R.string.custard,
            ),
            5.0,
        ),
        Dessert(
            R.string.floating_islands,
            R.drawable.floating_island,
            listOf(
                R.string.milk,
                R.string.vanilla,
                R.string.egg_yolks,
                R.string.caster_sugar,
                R.string.eggs,
                R.string.caster_sugar,
                R.string.milk,
                R.string.caster_sugar,
            ),
            3.0,
        ),
        Dessert(
            R.string.blackberry_and_lemon_fool,
            R.drawable.blackberry_and_lemon_fool,
            listOf(
                R.string.blackberry,
                R.string.icing_sugar,
                R.string.lemon,
                R.string.double_cream,
            ),
            4.0,
        ),
        Dessert(
            R.string.chocolate_tiffin,
            R.drawable.chocolate_tiffin,
            listOf(
                R.string.butter,
                R.string.caster_sugar,
                R.string.syrup,
                R.string.cocoa_powder,
                R.string.biscuits,
                R.string.raisin,
                R.string.milk_chocolate,
                R.string.dark_chocolate,
            ),
            5.0,
        ),
        Dessert(
            R.string.nanaimo_bars,
            R.drawable.nanaimo_bars,
            listOf(
                R.string.softened_butter,
                R.string.caster_sugar,
                R.string.cocoa_powder,
                R.string.eggs,
                R.string.biscuits,
                R.string.desiccated_coconut,
                R.string.chopped_almonds,
                R.string.double_cream,
                R.string.custard_powder,
                R.string.icing_sugar,
                R.string.dark_chocolate,
                R.string.butter,
            ),
            4.0,
        ),
        Dessert(
            R.string.white_chocolate_cheesecake,
            R.drawable.white_chocolate_cheesecake,
            listOf(
                R.string.biscuits,
                R.string.butter,
                R.string.white_chocolate,
                R.string.cream_cheese,
                R.string.mascarpone,
                R.string.double_cream,
                R.string.strawberry,
            ),
            4.0,
        ),
        Dessert(
            R.string.vanilla_panna_cotta,
            R.drawable.vanilla_panna_cotta,
            listOf(
                R.string.gelatine,
                R.string.milk,
                R.string.caster_sugar,
                R.string.vanilla,
                R.string.strawberry,
                R.string.double_cream,
            ),
            5.0,
        ),
    ).toList().sortedByDescending { it.rating }

    /** [continentsList] is a list that holds [Continent] objects
     * that represent the continent and its countries(Europe, Asia, North America, etc.)
     * */

    val continentsList = listOf(
        Continent(
            R.string.north_america,
            setOf(
                R.string.united_states,
                R.string.canada,
                R.string.mexico,
            ),
            819,
        ),
        Continent(
            R.string.europe,
            setOf(
                R.string.ukraine,
                R.string.france,
                R.string.poland,
                R.string.czech_republic,
            ),
            740,
        ),
        Continent(
            R.string.asia,
            setOf(
                R.string.japan,
                R.string.south_korea,
                R.string.indonesia,
                R.string.taiwan,
                R.string.india,
            ),
            389,
        ),
        Continent(
            R.string.south_america,
            setOf(
                R.string.argentina,
                R.string.columbia,
                R.string.peru,
                R.string.chili,
            ),
            276,
        )
    )
    /**
     * [countryList] is a list that holds [Country] objects which represents countries where
     * SweetSavor's shops are available and customers can go and buy/order something
     */

    val countryList = setOf(
        Country(
            R.string.europe,
            R.string.ukraine,
            R.drawable.ukraine,
        ),
        Country(
            R.string.europe,
            R.string.spain,
            R.drawable.united_states,
        ),
        Country(
            R.string.europe,
            R.string.switzerland,
            R.drawable.ukraine,
        ),
        Country(
            R.string.europe,
            R.string.italy,
            R.drawable.united_states,
        ),
        Country(
            R.string.europe,
            R.string.czech_republic,
            R.drawable.ukraine,
        ),
        Country(
            R.string.europe,
            R.string.estonia,
            R.drawable.united_states,
        ),
        Country(
            R.string.europe,
            R.string.germany,
            R.drawable.ukraine,
        ),
        Country(
            R.string.europe,
            R.string.poland,
            R.drawable.ukraine,
        ),
        Country(
            R.string.europe,
            R.string.france,
            R.drawable.ukraine,
        ),
        Country(
            R.string.north_america,
            R.string.united_states,
            R.drawable.united_states,
        ),
        Country(
            R.string.north_america,
            R.string.mexico,
            R.drawable.ukraine,
        ),
        Country(
            R.string.north_america,
            R.string.canada,
            R.drawable.ukraine,
        ),
        Country(
            R.string.south_america,
            R.string.columbia,
            R.drawable.ukraine,
        ),
        Country(
            R.string.south_america,
            R.string.argentina,
            R.drawable.ukraine,
        ),
        Country(
            R.string.south_america,
            R.string.chili,
            R.drawable.ukraine,
        ),
        Country(
            R.string.south_america,
            R.string.peru,
            R.drawable.ukraine,
        ),
        Country(
            R.string.asia,
            R.string.taiwan,
            R.drawable.ukraine,
        ),
        Country(
            R.string.asia,
            R.string.japan,
            R.drawable.ukraine,
        ),
        Country(
            R.string.asia,
            R.string.india,
            R.drawable.ukraine,
        ),
        Country(
            R.string.asia,
            R.string.indonesia,
            R.drawable.ukraine,
        ),
        Country(
            R.string.asia,
            R.string.south_korea,
            R.drawable.ukraine,
        ),
    ).sortedBy { it.continentName }

    /**
     * [locationList] is a list that holds [Location] objects which represents the exact location
     * in the exact country where you can go and buy/order any kind of [Dessert]
     */

    /*val locationList = mutableListOf(
        Location(
            R.string.new_york,
            R.string.new_york_address,
            4.5,
            false,
            1103,
            "7:00 AM",
            "5:00 PM",
            Country(R.string.united_states),
            LatLng(40.763171768987995, -73.95919479615374),
        ),
        Location(
            R.string.orlando,
            R.string.orlando_address,
            3.9,
            false,
            114,
            "7:30 AM",
            "5:30 PM",
            Country(R.string.united_states),
            LatLng(28.52207655666546, -81.39265616603868),
        ),
        Location(
            R.string.kyiv_obolon,
            R.string.kyiv_address_1,
            4.1,
            false,
            542,
            "6:30 AM",
            "6:00 PM",
            Country(R.string.ukraine),
            LatLng(50.522564651888516, 30.499148659720614),
        ),
        Location(
            R.string.kyiv_obolon,
            R.string.kyiv_address_2,
            4.7,
            false,
            1039,
            "6:30 AM",
            "6:00 PM",
            Country(R.string.ukraine),
            LatLng(50.49489348389758, 30.507526049210878),
        ),
        Location(
            R.string.austin,
            R.string.austin_address,
            4.2,
            false,
            930,
            "6:00 AM",
            "6:00 PM",
            Country(R.string.united_states),
            LatLng(30.442748844200956, -97.79614727976275),
        ),
        Location(
            R.string.los_angeles,
            R.string.los_angeles_address,
            3.8,
            false,
            764,
            "6:00 AM",
            "6:30 PM",
            Country(R.string.united_states),
            LatLng(33.872950820109246, -118.37950223512051),
        ),
        Location(
            R.string.portland,
            R.string.portland_address,
            4.5,
            false,
            240,
            "5:30 AM",
            "5:00 PM",
            Country(R.string.united_states),
            LatLng(45.55041679568743, -122.62467159640424),
        ),
        Location(
            R.string.lviv_kleparow,
            R.string.lviv_address_2,
            5.0,
            false,
            492,
            "7:00 AM",
            "7:00 PM",
            Country(R.string.ukraine),
            LatLng(49.84488545550968, 24.020240977523013),
        ),
        Location(
            R.string.lviv_frankivskyi,
            R.string.lviv_address_1,
            4.2,
            false,
            1039,
            "6:30 AM",
            "7:00 PM",
            Country(R.string.ukraine),
            LatLng(49.810303442391785, 24.002925367608107),
        ),
    ).toList().sortedBy { it.country.countryName }
*/
    /**
     * [locationButtonContentList] is a list that holds [Pair] objects which contain titles of the
     * buttons and their icons respectively
     * @see Pair
     */

    val locationButtonContentList = mutableListOf(
        Pair(R.drawable.directions, R.string.directions),
        Pair(R.drawable.reserve, R.string.reserve),
        Pair(R.drawable.menu, R.string.menu),
        Pair(R.drawable.call, R.string.call),
        Pair(R.drawable.bookmark, R.string.save),
    ).toList()

    val mostOrderedDessertsList = mutableListOf(
        MostOrderedDessert(
            R.string.vanilla_panna_cotta,
            R.drawable.vanilla_panna_cotta,
            listOf(
                R.string.vanilla_panna_cotta_ingredient_1,
                R.string.vanilla_panna_cotta_ingredient_2,
                R.string.vanilla_panna_cotta_ingredient_3,
                R.string.vanilla_panna_cotta_ingredient_4,
                R.string.vanilla_panna_cotta_ingredient_5,
                R.string.vanilla_panna_cotta_ingredient_6,
                R.string.vanilla_panna_cotta_ingredient_7,
            ),
            4.3,
            1201,
        ),
        MostOrderedDessert(
            R.string.white_chocolate_cheesecake,
            R.drawable.white_chocolate_cheesecake,
            listOf(
                R.string.white_chocolate_cheesecake_ingredient_1,
                R.string.white_chocolate_cheesecake_ingredient_2,
                R.string.white_chocolate_cheesecake_ingredient_3,
                R.string.white_chocolate_cheesecake_ingredient_4,
                R.string.white_chocolate_cheesecake_ingredient_5,
                R.string.white_chocolate_cheesecake_ingredient_6,
                R.string.white_chocolate_cheesecake_ingredient_7,
            ),
            5.0,
            762,
        ),
        MostOrderedDessert(
            R.string.blackberry_and_lemon_fool,
            R.drawable.blackberry_and_lemon_fool,
            listOf(
                R.string.blackberry_and_lemon_fool_ingredient_1,
                R.string.blackberry_and_lemon_fool_ingredient_2,
                R.string.blackberry_and_lemon_fool_ingredient_3,
                R.string.blackberry_and_lemon_fool_ingredient_4,
            ),
            4.7,
            896,
        ),
        MostOrderedDessert(
            R.string.chocolate_truffle_honeycomb_torte,
            R.drawable.chocolate_truffle_and_honeycomb_torte,
            listOf(
                R.string.chocolate_truffle_honeycomb_ingredient_1,
                R.string.chocolate_truffle_honeycomb_ingredient_2,
                R.string.chocolate_truffle_honeycomb_ingredient_3,
                R.string.chocolate_truffle_honeycomb_ingredient_4,
                R.string.chocolate_truffle_honeycomb_ingredient_5,
            ),
            5.0,
            992,
        ),
        MostOrderedDessert(
            R.string.chocolate_tiffin,
            R.drawable.chocolate_tiffin,
            listOf(
                R.string.chocolate_tiffin_ingredient_1,
                R.string.chocolate_tiffin_ingredient_2,
                R.string.chocolate_tiffin_ingredient_3,
                R.string.chocolate_tiffin_ingredient_4,
                R.string.chocolate_tiffin_ingredient_5,
                R.string.chocolate_tiffin_ingredient_6,
                R.string.chocolate_tiffin_ingredient_7,
            ),
            5.0,
            1214,
        ),
    ).shuffled()
}