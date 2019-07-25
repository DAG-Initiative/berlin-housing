<template>
  <v-layout row justify-center>
    <v-dialog v-model="setRealEstateModalState" max-width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">Find Home</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 sm6>
                <v-select
                  :items="['Mieten', 'Kaufen', 'Bauen','Archiv-Miete', 'Archiv-Kauf']"
                  label="Suchart"
                  required
                ></v-select>
              </v-flex>
              <v-flex xs12 sm6>
                <v-select
                  :items="['Wohnung', 'Haus', 'Wohnen auf Zeit','WG-Zimmer', 'Büros/ Praxen']"
                  label="Objektart"
                  required
                ></v-select>
              </v-flex>
              <v-flex xs12 sm4>
                <v-text-field
                  value="1000"
                  hint="Preispanne bis"
                  suffix="€"
                  persistent-hint
                  required
                ></v-text-field>
              </v-flex>
              <v-flex xs12 sm4>
                <v-select
                  :items="['1', '2', '3','4', '5', '6','7', '8+']"
                  value="3"
                  persistent-hint
                  hint="Zimmeranzahl"
                  required
                ></v-select>
              </v-flex>
              <v-flex xs12 sm4>
                <v-text-field
                  hint="Quadratmeteranzahl"
                  suffix="m²"
                  value="100"
                  persistent-hint
                  required
                ></v-text-field>
              </v-flex>

              <v-flex xs12 sm6>
                <v-autocomplete
                  :items="['Berlin', 'Hamburg', 'Leipzig', 'Köln', 'München', 'Frankfurt']"
                  label="Stadt"
                ></v-autocomplete>
              </v-flex>
              <v-flex xs12 sm6>
                <v-select
                  :items="['1km', '2km', '10min','15min']"
                  label="Umkreis Fahrzeit"
                  required
                ></v-select>
              </v-flex>
              <!-- <v-flex xs12 sm6 md4>
                <v-text-field label="Legal middle name" hint="example of helper text only on focus"></v-text-field>
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
                <v-select :items="['0-17', '18-29', '30-54', '54+']" label="Age*" required></v-select>
              </v-flex>
              <v-flex xs12 sm6>
                <v-autocomplete
                  :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                  label="Interests"
                  multiple
                ></v-autocomplete>
              </v-flex>-->
            </v-layout>
          </v-container>
          <!-- <small>*indicates required field</small> -->
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="setRealEstateModalState = false">Close</v-btn>
          <v-btn color="blue darken-1" flat @click="setRealEstateModalState = false">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>
<script>
import { mapGetters } from "vuex";

export default {
  props: ["setRealEstateModalState"],
  data: () => ({}),
  computed: {},
  watch: {}
};
</script>
<style scoped>
</style>
