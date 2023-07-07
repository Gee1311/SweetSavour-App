package com.delusional_bear.dessertmaniac.data.model

import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Continent
import com.delusional_bear.dessertmaniac.data.Country
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.Location

/**
 * [DataSource] object with the list of [Dessert] objects
 */

object DataSource {

    /**
     * [dessertList] represents a list of all desserts that are available
     */

    val dessertList = setOf(
        Dessert(
            1,
            R.string.chocolate_truffle_honeycomb_torte,
            "https://images.immediate.co.uk/production/volatile/sites/30/2022/10/Chocolate-truffle-and-honeycomb-torte-40ac4e3.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.honey,
                R.string.cornflakes,
                R.string.dark_chocolate,
                R.string.syrup,
                R.string.double_cream,
            ),
            4.0,
            4.99,
            124,
            R.string.chocolate_truffle_honeycomb_description,
        ),
        Dessert(
            2,
            R.string.peach_melba_pie,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/peach-melba-pie-6e76a2d.jpg?quality=90&webp=true&resize=375,341",
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
            6.99,
            259,
            R.string.peach_melba_pie_description,
        ),
        Dessert(
            3,
            R.string.treacle_tart,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/treacle-tart-6ed628f.jpg?quality=90&webp=true&resize=375,341",
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
            3.99,
            653,
            R.string.treacle_tart_description,
        ),
        Dessert(
            4,
            R.string.salted_chocolate_hazelnut_brownies,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/salted-chocolate-hazelnut-brownies-250693d.jpg?quality=90&webp=true&resize=375,341",
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
            7.99,
            421,
            R.string.salted_chocolate_hazelnut_brownies_description,
        ),
        Dessert(
            5,
            R.string.easy_cornflake_tart,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/cornflake-cake-f773778.jpg?quality=90&webp=true&resize=375,341",
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
            4.99,
            123,
            R.string.easy_cornflake_tart_description,
        ),
        Dessert(
            6,
            R.string.floating_islands,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/floating-island-3a8b98b.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.milk,
                R.string.vanilla,
                R.string.egg_yolks,
                R.string.eggs,
                R.string.milk,
            ),
            3.0,
            5.99,
            985,
            R.string.floating_islands_description,
        ),
        Dessert(
            7,
            R.string.blackberry_and_lemon_fool,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/fools-a48cee6.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.blackberry,
                R.string.icing_sugar,
                R.string.lemon,
                R.string.double_cream,
            ),
            4.0,
            4.49,
            321,
            R.string.blackberry_and_lemon_fool_description,
        ),
        Dessert(
            8,
            R.string.chocolate_tiffin,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chocolate-tiffin-0d5ad52.jpg?quality=90&webp=true&resize=375,341",
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
            8.99,
            190,
            R.string.chocolate_tiffin_description,
        ),
        Dessert(
            9,
            R.string.nanaimo_bars,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/nanaimo-bars-b65516e.jpg?quality=90&webp=true&resize=375,341",
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
            8.99,
            421,
            R.string.nanaimo_bars_description,
        ),
        Dessert(
            10,
            R.string.white_chocolate_cheesecake,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/white-chocolate-cheesecake-d0222c1.jpg?quality=90&webp=true&resize=375,341",
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
            5.49,
            665,
            R.string.white_chocolate_cheesecake_description,
        ),
        Dessert(
            11,
            R.string.vanilla_panna_cotta,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/panna-cotta-638cd76.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.gelatine,
                R.string.milk,
                R.string.caster_sugar,
                R.string.vanilla,
                R.string.strawberry,
                R.string.double_cream,
            ),
            5.0,
            3.49,
            123,
            R.string.vanilla_panna_cotta_description,
        ),
        Dessert(
            12,
            R.string.damson_crumble,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/damson_crumble-d2ab73c.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.damsons,
                R.string.brown_sugar,
                R.string.butter,
                R.string.sloe_gin,
                R.string.apples,
                R.string.flour,
                R.string.demerara_sugar,
                R.string.almonds,
            ),
            4.3,
            5.49,
            423,
            R.string.damson_crumble_description,
        ),
        Dessert(
            13,
            R.string.chocolate_and_malt_loaf_torte,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chocolate-malt-loaf-torte-c002064.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.butter,
                R.string.malt_loaf,
                R.string.hazelnut,
                R.string.dark_chocolate,
                R.string.caster_sugar,
                R.string.eggs,
                R.string.cream_cheese,
                R.string.cream_fraiche,
            ),
            4.8,
            6.49,
            853,
            R.string.chocolate_and_malt_loaf_torte_description,
        ),
        Dessert(
            14,
            R.string.raspberry_brulee,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/raspberry-brulee-4c54f2c.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.vanilla_pod,
                R.string.lemon,
                R.string.double_cream,
                R.string.raspberry,
                R.string.egg_yolks,
                R.string.caster_sugar,
                R.string.demerara_sugar,
            ),
            4.9,
            5.99,
            383,
            R.string.raspberry_brulee_description,
        ),
        Dessert(
            15,
            R.string.chocolate_hazelnut_ice_cream_cheesecake,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chocolate-hazelnut-ice-cream-cheesecake-97214da.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.cornflakes,
                R.string.chocolate_hazelnut,
                R.string.cream_cheese,
            ),
            5.0,
            10.49,
            1223,
            R.string.chocolate_hazelnut_ice_cream_cheesecake_description,
        ),
        Dessert(
            16,
            R.string.black_forest_tart,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/may-black-forest-tart-2b997fc-scaled.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.pastry,
                R.string.cocoa_powder,
                R.string.vanilla,
                R.string.flour,
                R.string.eggs,
                R.string.dark_chocolate,
                R.string.milk_chocolate,
                R.string.butter,
                R.string.jam,
                R.string.caster_sugar,
                R.string.cherry,
                R.string.icing_sugar,
                R.string.cream_fraiche,
            ),
            4.2,
            7.49,
            273,
            R.string.black_forest_tart_description,
        ),
        Dessert(
            17,
            R.string.raspberry_pistachio_parfait,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/raspberry-pistachip-parfait-4fa2ed5.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.raspberry,
                R.string.egg_yolks,
                R.string.caster_sugar,
                R.string.oil,
                R.string.double_cream,
                R.string.pistachios,
                R.string.raspberry,
            ),
            4.8,
            8.49,
            583,
            R.string.damson_crumble_description,
        ),
        Dessert(
            18,
            R.string.new_york_cheesecake,
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-1001487_11-f54704c.jpg?quality=90&webp=true&resize=375,341",
            listOf(
                R.string.butter,
                R.string.biscuits,
                R.string.sugar,
                R.string.philadelphia_cheese,
                R.string.caster_sugar,
                R.string.flour,
                R.string.vanilla,
                R.string.lemon,
                R.string.lemon_juice,
                R.string.eggs,
                R.string.soured_cream,
            ),
            4.8,
            4.49,
            799,
            R.string.new_york_cheesecake_description,
        ),
    ).toList().sortedByDescending { it.rating }

    /** [continentsList] is a list that holds [Continent] objects
     * that represent the continent and its countries(Europe, Asia, North America, etc.)
     */

    val continentsList = listOf(
        Continent(
            R.string.north_america,
            "https://images.unsplash.com/photo-1589871090211-7f2efeec05b6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
            setOf(
                R.string.united_states,
                R.string.canada,
                R.string.mexico,
            ),
            819,
        ),
        Continent(
            R.string.europe,
            "https://plus.unsplash.com/premium_photo-1680028256635-17e7f3ebbb23?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=869&q=80",
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
            "https://images.unsplash.com/photo-1513415564515-763d91423bdd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
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
            "https://images.unsplash.com/photo-1619546952812-520e98064a52?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
            setOf(
                R.string.argentina,
                R.string.columbia,
                R.string.peru,
                R.string.chile,
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
            "https://images.unsplash.com/photo-1561542320-9a18cd340469?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
        ),
        Country(
            R.string.europe,
            R.string.spain,
            "https://plus.unsplash.com/premium_photo-1672252617589-35d9a810c2d4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=465&q=80",
        ),
        Country(
            R.string.europe,
            R.string.switzerland,
            "https://images.unsplash.com/photo-1594069758873-e79e9075eb7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
        ),
        Country(
            R.string.europe,
            R.string.italy,
            "https://images.unsplash.com/photo-1516483638261-f4dbaf036963?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80",
        ),
        Country(
            R.string.europe,
            R.string.czech_republic,
            "https://images.unsplash.com/photo-1592906209472-a36b1f3782ef?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
        ),
        Country(
            R.string.europe,
            R.string.estonia,
            "https://images.unsplash.com/photo-1452868195396-89c1af3b1b2e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1169&q=80",
        ),
        Country(
            R.string.europe,
            R.string.germany,
            "https://images.unsplash.com/photo-1467269204594-9661b134dd2b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80",
        ),
        Country(
            R.string.europe,
            R.string.poland,
            "https://images.unsplash.com/photo-1573157268794-d13e94d325e6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
        ),
        Country(
            R.string.europe,
            R.string.france,
            "https://images.unsplash.com/photo-1503917988258-f87a78e3c995?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80",
        ),
        Country(
            R.string.north_america,
            R.string.united_states,
            "https://images.unsplash.com/photo-1519121785383-3229633bb75b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=464&q=80",
        ),
        Country(
            R.string.north_america,
            R.string.mexico,
            "https://images.unsplash.com/photo-1518105779142-d975f22f1b0a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
        ),
        Country(
            R.string.north_america,
            R.string.canada,
            "https://images.unsplash.com/photo-1517935706615-2717063c2225?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=465&q=80",
        ),
        Country(
            R.string.south_america,
            R.string.columbia,
            "https://images.unsplash.com/photo-1611148261486-4e315d904232?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
        ),
        Country(
            R.string.south_america,
            R.string.argentina,
            "https://images.unsplash.com/photo-1589909202802-8f4aadce1849?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
        ),
        Country(
            R.string.south_america,
            R.string.chile,
            "https://images.unsplash.com/photo-1591585101505-7b79ce4c6535?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=464&q=80",
        ),
        Country(
            R.string.south_america,
            R.string.peru,
            "https://images.unsplash.com/photo-1526697675318-89790adec369?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
        ),
        Country(
            R.string.asia,
            R.string.taiwan,
            "https://images.unsplash.com/photo-1552993873-0dd1110e025f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
        ),
        Country(
            R.string.asia,
            R.string.japan,
            "https://images.unsplash.com/photo-1542051841857-5f90071e7989?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
        ),
        Country(
            R.string.asia,
            R.string.india,
            "https://images.unsplash.com/photo-1514222134-b57cbb8ce073?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80",
        ),
        Country(
            R.string.asia,
            R.string.indonesia,
            "https://images.unsplash.com/photo-1555043722-4523972f07ee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80",
        ),
        Country(
            R.string.asia,
            R.string.south_korea,
            "https://images.unsplash.com/photo-1540483761890-a1f7be05d99f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400&q=80"
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
    ).toList()

    /**
     * [userSettingsOptions] is a list that holds [Triple] objects that contain
     * id, icon and title for user's option in settings
     */

    val userSettingsOptions = listOf(
        Triple(
            1,
            R.drawable.person_icon,
            R.string.personal_data,
        ),
        Triple(
            2,
            R.drawable.settings_icon,
            R.string.settings,
        ),
        Triple(
            3,
            R.drawable.heart_icon,
            R.string.refferal_code,
        ),
        Triple(
            4,
            R.drawable.faq_icon,
            R.string.faq,
        ),
        Triple(
            5,
            R.drawable.groups_icon,
            R.string.community,
        ),
    )

    val balanceOptionsAmountList = listOf("1", "5", "10", "25", "50", "100", "150", "175")
}