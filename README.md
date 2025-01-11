# Projects

## Table of Contents
   1. SimBank-Project
      - Project Description
      - Installation

## SimBank-Project

### Project Description
 -  SimBank is an application that will simulate how a bank would send and recevie data to the client user and to the employees. The application will showcase the customer's recent transactions, balance, and accounts. For the employee's, they will have access to edit, update information, and control the user's accounts with admin privileges.
### Installation
 - VM Enviroment
   1. Set up VirtualBox
   2. Download OpenSUSE Leap 15.5
   3. Configure VM to your preferences
 - Softwares/Programs/Packages Needed
   - VueJS, Vuetify, VueX, Axios, Router
   - NodeJS
   - Preferred IDE
   - SpringBoot
   - PostgreSQL
   - Postman
   - NGINX
 - Installing NGINX (Web Server)
   1. ```sudo zypper install nginx```
   2. ```sudo systemctl start nginx``` or enable auto-start ```sudo systemctl enable```
   3. ```sudo systemctl restart nginx``` restart nginx each time the configuration file is edited
   4. Test if NGINX is running properly by visiting the URL the website is hosted on
 - Installing VueJS (Must have NodeJS Installed)
   - If Node is not installed
     - ```zypper install nodejs14``` (https://nodejs.org/en/download/package-manager/all)
   - If Node is installed
     1. ```node -v```
     2. ```npm -v```
     3. ```npm install -g @vue/cli``` or ```sudo npm install -g @vue/cli```
     4. ```vue -version```
     5. ```cd (Project Name)```
     6. ```npm run dev```
     7. ```vue add vuetify```
     8. ```npm i axios --save```
     9. ```vue add router```
     10. ```vue add vuex```
   - If some packages are not working or errors occur,
     - Update vue/cli files ```npm update -g @vue/cli```
 - SpringBoot/Java Backend
   - Spring Initializr (https://start.spring.io/)
   - Dependencies & Version
     - Version: Java 21, Maven, Spring Boot Version: 3.3.4 (Or most stable version)
     - Dependencies
       - Spring Data JPA
       - Lombok
       - Spring Boot DevTools
       - PostgreSQL Driver
   - If errors occur
     - Post the follow lines of code into ```../main/resources/application.properties``` file
     -         spring.datasource.url=jdbc:postgresql://localhost:5432/simbankdb
               spring.datasource.username=postgres
               spring.datasource.password=postgres

               spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

               spring.jpa.hibernate.ddl-auto=update
               spring.jpa.show-sql=true
   - Connecting VueJS Application and Springboot Application to NGINX
     1. Find where the 'NGINX.conf' is located in the VM, usually located in the ```../etc/nginx``` folder
     2. Use your prefered text editor to edit the ```nginx.conf``` file
     3. Under the 'server' section, change the server_name to your IP address, EX. ```server_name (my_ip_address)``` and then change listen to desired port number, EX. ```listen (port number);```
     4. Within the 'server' section, in the 'location' block, change the root to the VueJS folder destination,
        -       location / {
                      root (VueJS file location);
                      index index.html index.htm;
                }
     5. Add a new 'location' block for the APIs/SpringBoot backend
        -      location /(Name of API Endpoint)/{
                  proxy_pass (URL or IP Adress of API Endpoint)
                  (Add addition headers if needed)
               }  
     6. Save changes
     7. ```sudo systemctl restart nginx```
   - If Errors Occur
     - Check if file edits were saved
     - Update/Change permissions of firewall VM access
     - Add 'allow origin' web configuration file to SpringBoot
   - PostgreSQL Tables and ERD Diagram
   - ```
     CREATE TABLE IF NOT EXISTS public.account
      (
          customer_id integer,
          account_id serial NOT NULL,
          account_type character varying(255),
          balance double precision,
          created_at timestamp without time zone DEFAULT now(),
          updated_at timestamp without time zone,
          CONSTRAINT account_pkey PRIMARY KEY (account_id)
      );
      
      CREATE TABLE IF NOT EXISTS public.customers
      (
          customer_id serial NOT NULL,
          first_name character varying(255) NOT NULL,
          last_name character varying(255) NOT NULL,
          username character varying(255) NOT NULL,
          hash_password character varying(255) NOT NULL,
          street_name character varying(255) NOT NULL,
          city_name character varying(255) NOT NULL,
          state_name character varying(255) NOT NULL,
          phone_number character varying(255) NOT NULL,
          email character varying(255) COLLATE NOT NULL,
          created_at timestamp without time zone,
          updated_at timestamp without time zone,
          CONSTRAINT customers_pkey PRIMARY KEY (customer_id)
      );
      
      CREATE TABLE IF NOT EXISTS public.transaction
      (
          transaction_id serial NOT NULL,
          account_id integer,
          amount_changed double precision,
          transaction_type character varying(255),
          transaction_time timestamp without time zone DEFAULT now(),
          CONSTRAINT transaction_pkey PRIMARY KEY (transaction_id)
      );
   - ![image alt](https://github.com/VinceVanna/Projects/blob/6c903fa595054bd6ea275895ab3c9117f77baf6d/SimBankDB_ERD.png)
 - Python EXE File (THIS FILE IS NOT NEEDED)
   - This python file will execute CMD/terminal commands

