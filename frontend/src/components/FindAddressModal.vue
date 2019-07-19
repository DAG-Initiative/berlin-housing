<template>
    <v-layout row justify-center>
        <v-dialog v-model="setFindAddressModalState"  max-width="600px">
            <v-card>
                <v-card-title>
                    <span class="headline">User Profile</span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12 sm6 md4>
                                <v-select
                                        :items="universities"
                                        box
                                        label="Universität"
                                ></v-select>
                            </v-flex>
                            <v-flex xs12 sm6 md4>
                                <v-text-field label="Legal middle name"
                                              hint="example of helper text only on focus"></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm6 md4>
                                <v-text-field
                                        label="Legal last name*"
                                        hint="example of persistent helper text"
                                        persistent-hint
                                        required
                                ></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Email*" required></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Password*" type="password" required></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm6>
                                <v-select
                                        :items="['0-17', '18-29', '30-54', '54+']"
                                        label="Age*"
                                        required
                                ></v-select>
                            </v-flex>
                            <v-flex xs12 sm6>
                                <v-autocomplete
                                        :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                                        label="Interests"
                                        multiple
                                ></v-autocomplete>
                            </v-flex>
                        </v-layout>
                    </v-container>
                    <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" flat @click="setFindAddressModalState = false">Close</v-btn>
                    <v-btn color="blue darken-1" flat @click="setFindAddressModalState = false">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-layout>
</template>
<script>
    import {mapGetters} from 'vuex'

    export default {
        props: ["setFindAddressModalState"],
        data: () => ({
            universities: [
                {
                   text: "Technische Universität", id: "tuBerlin"
                },
                {
                    text: "Humbold Universität", id: "huBerlin"
                },
                {
                    text: "Hochschule für Technik und Wirtschaft", id: "htwBerlin"
                },
                {
                    text: "Frei Universität Berlin", id: "fuBerlin"
                },
                {
                    text: "Hochschule für Recht und Wirtschaft Berlin", id: "hwrBerlin"
                },

            ]


        }),
        computed: {},
        watch: {}
    }
</script>
<style scoped>

</style>
