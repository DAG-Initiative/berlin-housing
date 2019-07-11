<template>
    <v-layout>

        <v-layout xl12 fill-height>

            <l-map :zoom="zoom" :center="center" style="height: 100%">
                <l-tile-layer :url="url" :attribution="attribution"/>
                <l-geo-json :geojson="geojson" :options="bus.options"/>
                <l-geo-json
                        :geojson="bicycleAndCampus.geojson"
                        :options="bicycleAndCampus.options"
                />
                <l-geo-json :geojson="coors.geojson" :options="coors.options"/>
            </l-map>
        </v-layout>
    </v-layout>
</template>

<script>
    import Vue from "vue";
    import {icon, marker, circleMarker} from "leaflet";
    import {LMap, LTileLayer, LGeoJson} from "vue2-leaflet";
    import axios from "axios";


    import PopupContent from "./GeoJson2Popup";

    import data from "../assets/geojson/sample-geojson";

    var baseballIcon = icon({
        iconUrl: "static/images/baseball-marker.png",
        iconSize: [32, 37],
        iconAnchor: [16, 37],
        popupAnchor: [0, -28]
    });

    function onEachFeature(feature, layer) {
        let PopupCont = Vue.extend(PopupContent);
        let popup = new PopupCont({
            propsData: {
                type: feature.geometry.type,
                text: feature.properties.popupContent
            }
        });
        layer.bindPopup(popup.$mount().$el);
    }

    export default {

        name: "Example",
        components: {
            LMap,
            LTileLayer,
            LGeoJson
        },
        data() {
            return {
                geojson: null,
                zoom: 6,
                center: [53, 13],
                url:
                    "https://api.tiles.mapbox.com/v4/mapbox.light/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWJvdWNoYXVkIiwiYSI6ImNpdTA5bWw1azAyZDIyeXBqOWkxOGJ1dnkifQ.qha33VjEDTqcHQbibgHw3w",
                attribution:
                    'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
                    '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                    'Imagery © <a href="http://mapbox.com">Mapbox</a>',
                bus: {
                    geojson: null,
                    options: {
                        filter: function (feature) {
                            if (feature.properties) {
                                return feature.properties.underConstruction !== undefined
                                    ? !feature.properties.underConstruction
                                    : true;
                            }
                            return false;
                        },
                        onEachFeature: onEachFeature
                    }
                },
                coors: {
                    geojson: data.coorsField,
                    options: {
                        pointToLayer: function (feature, latlng) {
                            return marker(latlng, {icon: baseballIcon});
                        },
                        onEachFeature: onEachFeature
                    }
                },
                bicycleAndCampus: {
                    geojson: [data.bicycleRental, data.campus],
                    options: {
                        style: function (feature) {
                            return feature.properties && feature.properties.style;
                        },
                        onEachFeature: onEachFeature,
                        pointToLayer: function (feature, latlng) {
                            return circleMarker(latlng, {
                                radius: 8,
                                fillColor: "#ff7800",
                                color: "#000",
                                weight: 1,
                                opacity: 1,
                                fillOpacity: 0.8
                            });
                        }
                    }
                }
            };
        },
        created() {
            axios
                .get(
                    "http://localhost:1992/testset"
                )
                .then(response => {
                    this.geojson = response.data;
                    console.log("Geojson kommt ", response.data)
                });
        }
    };
</script>