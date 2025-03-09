<template>
    <Navbar />
    <Profile_dropdown />
</template>

<script>
import Navbar from '@/components/base_components/NavBar.vue'
import Profile_dropdown from '@/components/profile_view_components/profile_view_dropdown_box.vue'
export default {
    name: 'AboutPage',
    components:{
        Navbar,
        Profile_dropdown
    }
}
</script>
