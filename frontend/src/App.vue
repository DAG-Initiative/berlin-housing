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

                <v-listf
                        dense
                        class="grey lighten-4"
                >
                    <v-btn flat large @click="setRealEstateModalState = true">Wohnung suchen</v-btn>
                    <template v-for="(item, i) in items">
                        <v-layout
                                row
                                v-if="item.heading"
                                align-center
                                :key="i"
                        >

                            <v-flex xs6>
                                <v-subheader v-if="item.heading">
                                    {{ item.heading }}
                                </v-subheader>
                            </v-flex>
                            <v-flex xs6 class="text-xs-right">
                                <v-btn small flat>edit</v-btn>
                            </v-flex>
                        </v-layout>

                        <v-divider
                                dark
                                v-else-if="item.divider"
                                class="my-3"
                                :key="i"
                        ></v-divider>
                        <v-list-tile
                                :key="i"
                                v-else
                                @click=""
                        >

                            <v-list-tile-action>
                                <v-switch
                                        v-model="item.id"
                                        :label="item.text"
                                ></v-switch>

                            </v-list-tile-action>

                        </v-list-tile>
                    </template>
                </v-listf>
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

                <v-container fluid fill-height class="berlinMap" mt-1 ml-1 ma-0 pa-0>
                    <berlin-map ></berlin-map>
                </v-container>
            </v-content>
        </v-app>

    </div>
</template>

<script>
    import BerlinMap from './components/BerlinMap'
    import RealEstateModal from "./components/RealEstateModal";


    export default {
        name: 'App',
        components: {
            BerlinMap,
            RealEstateModal
        },
        data: () => ({
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
            ]
        }),
    }
</script>

<style>
    @import "../node_modules/leaflet/dist/leaflet.css";

    .realEstateModal {
        position:absolute;

        z-index: 100;
    }

    .berlinMap {
        z-index: 2;
        position:absolute;
    }

    .leaflet-fake-icon-image-2x {
        background-image: url(../node_modules/leaflet/dist/images/marker-icon-2x.png);
    }

    .leaflet-fake-icon-shadow {
        background-image: url(../node_modules/leaflet/dist/images/marker-shadow.png);
    }

    body {
        margin: 0px;
        font-family: Helvetica, Verdana, sans-serif;
    }

    #side {
        float: left;
        width: 208px;
    }

    #full_div {
        position: absolute;
        overflow-x: auto;
        top: 0;
        right: 0;
        left: 208px;
        bottom: 0;
        padding-left: 8px;
        border-left: 1px solid #ccc;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    li {
        font: 200 15px/1.5 Helvetica, Verdana, sans-serif;
        border-bottom: 1px solid #ccc;
    }

    li:last-child {
        border: none;
    }

    li a {
        font-size: 15px;
        padding-left: 8px;
        text-decoration: none;
        color: #000;
        display: block;

        -webkit-transition: font-size 0.3s ease, background-color 0.3s ease;
        -moz-transition: font-size 0.3s ease, background-color 0.3s ease;
        -o-transition: font-size 0.3s ease, background-color 0.3s ease;
        -ms-transition: font-size 0.3s ease, background-color 0.3s ease;
        transition: font-size 0.3s ease, background-color 0.3s ease;
    }

    li a:hover {
        font-size: 20px;
        background: #f6f6f6;
    }
</style>
