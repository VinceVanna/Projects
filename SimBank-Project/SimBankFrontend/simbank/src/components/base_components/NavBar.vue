<template>
    <nav>

      
      <router-link to="/">Home</router-link>
      <v-spacer></v-spacer>
      <div v-if="this.$store.getters.getStatus === 'Logged In'" @mouseover="isDropdownOpen = true" @mouseleave="isDropdownOpen = false">
        
        <img src="@/assets/icons/profile.svg" alt="Profile Icon" padding-right="10px"/>
        <v-card v-if="isDropdownOpen">
          <v-card-title>{{ firstName }}, {{ lastName }}</v-card-title>
          <v-label></v-label>
        </v-card>
      </div>
      <div v-if="this.$store.getters.getStatus !== 'Logged In'"><router-link to="/"><v-btn height="25px" color="#0390fc" background-color="black">Login</v-btn></router-link></div>
      <router-link to="/" v-else-if="this.$store.getters.getStatus === 'Logged In'"><v-btn height="25px" color="#fc0000" background-color="black" @click="logout()">Logout</v-btn></router-link>
  </nav>
</template>

<style scoped>
nav {
  padding: 25px;
  background-color: #061A40;
  display: flex;
  height: 80px
}

nav a {
  font-weight: bold;
  color: white;
  text-decoration: none;
  padding-right: 5px;
  padding-left: 5px;
}

nav a.router-link-exact-active {
  color: #03fcfc;
}
.v-btn{
  color: white;
  background-color: #0390fc;
}
.v-btn:hover{
    color: #0390fc;
    background-color: white;
}
</style>

<script>

export default{

  data(){
        return{
            username: this.$store.getters.getUsername,
            email: this.$store.getters.getEmail,
            firstName: this.$store.getters.getFirstName,
            lastName: this.$store.getters.getLastName,
            streetName: this.$store.getters.getStreetName,
            cityName: this.$store.getters.getCityName,
            stateName: this.$store.getters.getStateName,
            phoneNumber: this.$store.getters.getPhoneNumber,

            isDropdownOpen: false
        }
    },
  methods:{
    logout(){
      this.$store.dispatch('setStatus', 'Logged Out')
      this.$store.dispatch('setUserId', -1);
      this.$store.dispatch('setUsername', '');
      this.$store.dispatch('setEmail', '');
      this.$store.dispatch('setFirstName', '');
      this.$store.dispatch('setLastName', '');
      this.$store.dispatch('setStreetName', '');
      this.$store.dispatch('setCityName', '');
      this.$store.dispatch('setStateName', '');
      this.$store.dispatch('setPhoneNumber', '');
    },
  },
}

</script>