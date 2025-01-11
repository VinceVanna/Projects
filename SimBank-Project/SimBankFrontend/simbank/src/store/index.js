import { createStore } from 'vuex'

export default createStore({
  state: {
    userId: -1,
    username: '',
    email: '',
    firstName: '',
    lastName: '',
    streetName: '',
    cityName: '',
    stateName: '',
    phoneNumber: '',
    status: '',
  },
  getters: {
    getUserId(state){
      return state.userId;
    },
    getUsername(state){
      return state.username;
    },
    getEmail(state){
      return state.email;
    },
    getFirstName(state){
      return state.firstName;
    },
    getLastName(state){
      return state.lastName;
    },
    getStreetName(state){
      return state.streetName;
    },
    getCityName(state){
      return state.cityName;
    },
    getStateName(state){
      return state.stateName;
    },
    getPhoneNumber(state){
      return state.phoneNumber;
    },
    getStatus(state){
      return state.status;
    }
  },
  mutations: {
    setUserId(state, userId){
      state.userId = userId;
    },
    setUsername(state, username){
      state.username = username;
    },
    setEmail(state, email){
      state.email = email;
    },
    setFirstName(state, firstName){
      state.firstName = firstName;
    },
    setLastName(state, lastName){
      state.lastName = lastName;
    },
    setStreetName(state, streetName){
      state.streetName = streetName;
    },
    setCityName(state, cityName){
      state.cityName = cityName;
    },
    setStateName(state, stateName){
      state.stateName = stateName;
    },
    setPhoneNumber(state, phoneNumber){
      state.phoneNumber = phoneNumber;
    },
    setStatus(state, status){
      state.status = status;
    }
  },
  actions: {
    setUserId({commit}, userId){
      commit('setUserId', userId)
    },
    setUsername({commit}, username){
      commit('setUsername', username)
    },
    setEmail({commit}, email){
      commit('setEmail', email)
    },
    setFirstName({commit}, firstName){
      commit('setFirstName', firstName)
    },
    setLastName({commit}, lastName){
      commit('setLastName', lastName)
    },
    setStreetName({commit}, streetName){
      commit('setStreetName', streetName)
    },
    setCityName({commit}, cityName){
      commit('setCityName', cityName)
    },
    setStateName({commit}, stateName){
      commit('setStateName', stateName)
    },
    setPhoneNumber({commit}, phoneNumber){
      commit('setPhoneNumber', phoneNumber)
    },
    setStatus({commit}, status){
      commit('setStatus', status);
    }
  },
  modules: {
  }
})
