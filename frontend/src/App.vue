<template>
    <div id="app">

        <v-app id="inspire">
            <v-navigation-drawer
                    fixed
                    clipped
                    class="grey lighten-4"
                    app
                    v-model="drawer"
            >

                <v-list
                        dense
                        class="grey lighten-4"
                >
                    <v-list-tile>
                        <v-list-tile-action>
                            <v-icon>home</v-icon>
                        </v-list-tile-action>
                        <v-list-tile-title>Home</v-list-tile-title>
                    </v-list-tile>

                    <v-list-group
                            prepend-icon="account_circle"
                            value="true"
                    >
                        <template v-slot:activator>
                            <v-list-tile>
                                <v-list-tile-title>Infrastruktur</v-list-tile-title>
                            </v-list-tile>
                        </template>
                        <!-- buildings -->
                        <v-list-group
                                no-action
                                sub-group
                                value="true"
                        >
                            <template v-slot:activator>
                                <v-list-tile>
                                    <v-list-tile-title>Buildings</v-list-tile-title>
                                    <v-list-tile-action>
                                        <v-icon>domain</v-icon>
                                    </v-list-tile-action>
                                </v-list-tile>
                            </template>

                            <v-list-tile
                                    v-for="(building, i) in buildings"
                                    :key="i"
                            >
                                <v-list-tile-title v-text="building[0]"></v-list-tile-title>
                                <v-list-tile-action>
                                    <v-switch></v-switch>
                                </v-list-tile-action>
                            </v-list-tile>
                        </v-list-group>

                        <v-list-group
                                sub-group
                                no-action
                        >
                            <template v-slot:activator>
                                <v-list-tile>
                                    <v-list-tile-title>Umweltfaktoren</v-list-tile-title>
                                    <v-list-tile-action>
                                        <v-icon>nature_people</v-icon>
                                    </v-list-tile-action>
                                </v-list-tile>
                            </template>
                            <v-list-tile
                                    v-for="(environment, i) in environments"
                                    :key="i"
                            >
                                <v-list-tile-title v-text="environment[0]"></v-list-tile-title>
                                <v-list-tile-action>
                                    <v-switch></v-switch>
                                </v-list-tile-action>
                            </v-list-tile>
                        </v-list-group>
                    </v-list-group>
                    <v-flex justify-center>
                        <v-btn flat large @click="setRealEstateModalState = true">Wohnung suchen</v-btn>
                    </v-flex>
                </v-list>
            </v-navigation-drawer>
            <v-toolbar color="white" app absolute clipped-left>
                <v-toolbar-side-icon @click.native="drawer = !drawer"></v-toolbar-side-icon>
                <span class="title ml-3 mr-5">Berlin&nbsp;<span class="text">Housing</span></span>
                <v-text-field
                        solo-inverted
                        flat
                        label="Search"
                        prepend-icon="search"
                ></v-text-field>
                <v-spacer></v-spacer>
            </v-toolbar>
            <v-content>
                <real-estate-modal class="realEstateModal"
                                   :setRealEstateModalState="setRealEstateModalState"></real-estate-modal>
                <find-address-modal :setFindAddressModalState="setFindAddressModalState"></find-address-modal>
                <v-container fluid fill-height class="berlinMap" mt-1 ml-1 ma-0 pa-0>
                    <berlin-map></berlin-map>
                </v-container>
            </v-content>
        </v-app>

    </div>
</template>

<script>
    import BerlinMap from './components/BerlinMap'
    import RealEstateModal from "./components/RealEstateModal";
    import FindAddressModal from "./components/FindAddressModal";


    export default {
        name: 'App',
        components: {
            BerlinMap,
            FindAddressModal,
            RealEstateModal
        },
        data: () => ({
            setFindAddressModalState: false,
            setRealEstateModalState: false,
            drawer: null,
            switches: {
                criminalStatistic: true,
                rentingPrice: true,
                purchasePrice: true,
                floorValue: true
            },
            items: [
                {heading: 'Soziale Umgebung'},
                {icon: 'lightbulb_outline', text: 'Kriminalstatistik', id: 'criminalStatistic'},
                {divider: true},
                {heading: 'Marktlage'},
                {icon: 'add', text: 'Mietpreise', id: 'rentingPrice'},
                {icon: 'add', text: 'Kaufpreise', id: 'purchasePrice'},
                {icon: 'add', text: 'Bodenrichtwert', id: 'floorValue'},
            ],

            buildings: [
                ['Wohngebäude'],
                ['Geschäftsgebäude']
            ],


            environments: [
                ['Luftbelastung'],
                ['Read'],
                ['Update'],
                ['Delete']
            ]
        }),
    }
</script>

<style>
    @import "../node_modules/leaflet/dist/leaflet.css";

</style>
