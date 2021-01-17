# This Blog is a SPA project mainly uses Vue.js, SpringBoot, MySQL technology stack.

[Back-end](https://github.com/diandian2710/Library_Spring-Boot)

[Front-end](https://github.com/diandian2710/Library_Vue)


## how to install the project
### Back-end
1. clone repo
    ```
    git clone https://github.com/diandian2710/Blog_Spring-Boot.git
    ```
2. package

    ```
    mvn package
    ```

3. install
    ```
    java -jar target/blog-0.0.1-SNAPSHOT.jar
    ```
### Front-end
please enter the project path

1. clone repo
    ```
    git clone https://github.com/diandian2710/Library_Vue.git
    ```
2. install
    ```
    npm run dev
    ```


# The Overall Appearance

## Index Page
Show the main page
![main page](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/main%20page.png)


## Library

Provide book information display function
![library](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/library.png)





## Admin

Including dashboard, content management, user and permission management, etc.
![admin](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/role%20management.png)
# Architecture Diagram

- **Application Architecture**
![App_Arc](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/20201106212105469_1538190509.png)
- **Technology Architecture**
![Tec_Arc](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/20201106123909768_600040565.png)

# Database Schema 
- The database schema include three parts: Book, Article and Admin 
![Schema](https://raw.githubusercontent.com/diandian2710/markdown-photos/main/Blog/schema.png)
# Main Technology Stack

## Front-End

1.Vue.js  
2.ElementUI  
3.axios  

## Back-End

1.Spring Boot.  
2.Apache Shiro.  
3.Apache Log4j2.  
4.Spring MyBatis.  
5.Spring Data Redis.  

## Database

1.MySQL  
2.Redis  



# Update

## 2020
10/11/2020 Implement the article section  
5/11/2020 Deploy Shiro security framework  
27/10/2020 Refactored the project, completed the establishment of the basic background interface, realized loading the menu by role, and cancelled the front desk access restriction  
20/10/2020 Use the front-end interceptor, migrate the database to mysql 8.0.15, and initialize the background management page  
14/10/2020 Fuzzy query in search box  
13/10/2020 Complete the picture upload function  
11/10/2020 Complete the book classification function  
7/10/2020 Complete the book paging function  
6/10/2020 Complete the book query function  
5/10/2020 Complete the book modification function  
4/10/2020 Complete the book deletion function  
3/10/2020 Complete the new functions of the book  