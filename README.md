
# GastroGenie using Springboot/SpringAI

GastroGenie is a comprehensive language learning model for recipes developed using Springboot, aimed at providing users with an interactive ai model on recipe affairs, This README provides an overview of the system, installation instructions and other details about the project.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites Requirement](#prerequisites-requirement)
    - [Installation](#installation)
- [API Endpoints](#api-endpoints)


## Features

GastroGenie comes equipped with robust OpenAI model features to provide valuable insights into recipes, recipes by country and by the number of calories it contains:

- **Recipe**: A default recipe model, no interactions permitted
- **Smart Recipe**:An interactive recipe model  
- 
## Technologies Used

- **Java**: The core programming language for developing the application logic.
- **Spring Boot**: A powerful framework for building robust and scalable applications.
- **Spring Web**: Facilitates the creation of web APIs and interfaces.
- **SpringAI**: Provides a unified and developer-friendly way to integrate AI models and services into Spring Boot applications.
- **OpenAI**:  A creator of advanced AI models, most notably the GPT (Generative Pre-trained Transformer)
- **Git**: Version control for collaborative development.

## Getting Started

### Prerequisites Requirement

Before getting started, ensure you have the following components installed:

1. **This project was built using JDK 17, you would need JDK 17 installed on you local machine.**

- [Java Development Kit (JDK 17)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)


## Build and Run the Application:

Execute the following command to build and run the application:

````bash
mvn clean package install
mvn spring-boot:run
````


### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Greatnex1/GastroGenie.git
   cd Language Learning Model
   ```

2. **Configure OpenAPI:**

  

2. **OpenAI Key:**

   Modify the `src/main/resources/application.properties` file to include your OpenAi Key:

    ```properties   
   spring.ai.openai.api-key=your OpenAi Key
    ```

## API Endpoints

GastroGenie offers the following API endpoints:

- Recipe: `GET /api/v1/recipes/sea-food/suggest-recipe`
- Smart Recipe: `GET /api/v1/recipes/sugester/suggest-recipe`
- Recipe By Country: `GET /api/v1/recipes/sugester/country`
- Get Recipe By Country and The Number of Calories: `GET /api/v1/recipes/sugester/best-recipe`

