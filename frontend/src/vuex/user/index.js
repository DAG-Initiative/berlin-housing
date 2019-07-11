export default {
    state: {
        realEstateModalState: false,
    },
    mutations: {
        setRealEstateModalState(state, payload) {
            state.user = payload
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
