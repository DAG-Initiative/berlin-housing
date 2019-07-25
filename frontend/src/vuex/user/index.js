export default {
    state: {
        realEstateModalState: false,
    },
    mutations: {
        setRealEstateModalState(state, payload) {
            state.realEstateModalState = payload
        },

    },

    actions: {

    },

    getters: {
        realEstateModalState(state) {
            return state.realEstateModalState
        },


    }

}