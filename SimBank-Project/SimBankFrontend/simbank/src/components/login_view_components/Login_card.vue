<template>
    <v-container class="my-12">
        <v-row>
            <v-col>
                <v-card
                width="500px"
                height="550px"
                class="mx-auto my-8"
                align="center"
                elevation="8"
                color="#003559">
                    <v-card-title
                    class="pt-12">Login</v-card-title>

                    <v-spacer></v-spacer>

                    <v-card-text>Username</v-card-text>
                    <v-text-field label="Username" width="250px" v-model="username"></v-text-field>
                    <v-card-text>Password</v-card-text>
                    <v-text-field label="Password" type="password" width="250px" v-model="password"></v-text-field>
                    <a href="" class="mb-n3" color="white" text-decoration="none">Forgot Password</a>
                    <v-spacer></v-spacer>
                    <v-btn width="250px" class="mt-3" @click="login(username, password)">Login</v-btn>
                    <v-spacer></v-spacer>
                    <v-btn width="250px" class="mt-3">Register</v-btn>
                    <div class="mt-5">{{ response_data }}</div>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
    
</template>

<style scoped>
.v-btn:hover{
    background-color: #006DAA;
    color: white;
}
</style>

<script>
import API from '@/service/api';
import router from '@/router/index';

export default {
    data(){
        return {
            username: '',
            password: '',
            response_data: ''
        }
    },
    methods: {
        login(username, password){

            API.login(username, password)
                .then(function(value){
                    this.$store.dispatch('setStatus', value.data);
                    
                    API.getAllCustomers()
                        .then(function (value){
                            for(var i = 0; i < value.data.length; i++){
                                if(username === value.data[i].username){
                                    this.$store.dispatch('setUserId', value.data[i].customerId);
                                    this.$store.dispatch('setUsername', value.data[i].username);
                                    this.$store.dispatch('setEmail', value.data[i].email);
                                    this.$store.dispatch('setFirstName', value.data[i].firstName);
                                    this.$store.dispatch('setLastName', value.data[i].lastName);
                                    this.$store.dispatch('setStreetName', value.data[i].streetName);
                                    this.$store.dispatch('setCityName', value.data[i].cityName);
                                    this.$store.dispatch('setStateName', value.data[i].stateName);
                                    this.$store.dispatch('setPhoneNumber', value.data[i].phoneNumber);
                                    this.authenticate();
                                }else{
                                    this.authenticate();
                                }
                            }
                        }.bind(this))
                        .catch(function (error){
                            console.log(error);
                        })
                }.bind(this))
                .catch(function(error){
                    console.log(error);
                });
        },
        authenticate(){
            if(this.$store.getters.getStatus === "Logged In"){
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
                router.push('/about')
            }else{
                this.response_data = this.$store.getters.getStatus;
            }
        }
    }
}
</script>
