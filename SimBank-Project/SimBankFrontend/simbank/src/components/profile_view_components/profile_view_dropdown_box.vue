<template>
    
    <h1>This is your current information!</h1>
    <div>Username: {{ username }}</div>
    <div>Email: {{ email }}</div>
    <div>Name: {{ firstName }} {{ lastName }}</div>
    <div>Address: {{ streetName }}, {{ cityName }}, {{ stateName }}</div>
    <div>Phone Number: {{ phoneNumber }}</div>
</template>

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
        }
    }
}

</script>