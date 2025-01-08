import axios from 'axios'

//const BASE_URL = "http://192.168.1.25:8080/SimBank/";
const BASE_URL = "http://192.168.1.53:8080/SimBank/";
const CUSTOMER_URL = BASE_URL + "Customer/";
const ACCOUNT_URL = BASE_URL + "Account/";
//const TRANSACTION_URL = BASE_URL + "Transaction/";

const headers = {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
};

class userAPI{

    async login(username, password){
        const tempUser = {
            username: username,
            hashPassword: password
        }
        return await axios.post(CUSTOMER_URL + "login", tempUser, headers)
            .then(function (response){
                return response;
            })
            .catch(function (error){
                console.error("Error: ", error);
                
            })
    }

    async getAllCustomers(){

        return await axios.get(CUSTOMER_URL + "getAllCustomers")
            .then(function (response){
                return response;
            })
            .catch(function (error){
                console.error("Error: ", error);
            })

    }

    async getAllAccounts(){

        return await axios.get(ACCOUNT_URL + "getAllAccounts")
            .then(function(response){
                return response;
            })
            .catch(function (error){
                console.error("Error: ", error);
            })

    }
}

export default new userAPI()

