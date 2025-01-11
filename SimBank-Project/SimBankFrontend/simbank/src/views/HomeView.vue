<template>
  
   
    <Navbar />
    <v-spacer></v-spacer>
    <LoginCard />
    
</template>

<script>
// @ is an alias to /src
import Navbar from '@/components/base_components/NavBar.vue'
import LoginCard from '@/components/login_view_components/Login_card.vue'

export default {
  name: 'HomeView',
  components: {
    Navbar,
    LoginCard
  }
}
</script>
