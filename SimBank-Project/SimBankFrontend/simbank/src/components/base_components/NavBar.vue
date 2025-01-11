<template>
    <nav>

      
      <router-link to="/">Home</router-link>
      <v-spacer></v-spacer>
      <div v-if="this.$store.getters.getStatus !== 'Logged In'"><router-link to="/"><v-btn height="25px" color="#0390fc" background-color="black">Login</v-btn></router-link></div>
      <router-link to="/" v-else-if="this.$store.getters.getStatus === 'Logged In'"><v-btn height="25px" color="#fc0000" background-color="black" @click="logout()">Logout</v-btn></router-link>
  </nav>
</template>

<style scoped>
nav {
  padding: 25px;
  background-color: #061A40;
  display: flex;
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
.v-btn:hover{
    color: #ff3a3a;
    background-color: black;
}
</style>

<script>
export default{
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
      console.log(this.$store.getters.getStatus);
                console.log(this.$store.getters.getUserId);
                console.log(this.$store.getters.getUsername);
                console.log(this.$store.getters.getEmail);
                console.log(this.$store.getters.getFirstName);
                console.log(this.$store.getters.getLastName);
                console.log(this.$store.getters.getStreetName);
                console.log(this.$store.getters.getCityName);
                console.log(this.$store.getters.getStateName);
                console.log(this.$store.getters.getPhoneNumber);
    }
  },
}

</script>