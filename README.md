# Urnax application 📳🎮

# LaSalle – Programming paradigms 🎓🏭

# Content 📇

*
    1. Main Idea
*
    2. Requirements
*
    3. Folders and files
*
    4. Configuration
*
    5. How to build
*
    6. Run in local

# 1. Main idea 🤔💭

A company dedicated to electronic voting has been given the green light by the ministry to create and deploy an
electronic voting software for the next municipal elections.

They have asked for a software solution (Scala) that will help them to validate the identity of the voters and of course
they can only vote once. The software will also send on day of voting a message to the registered users giving the
location of the polling station where they are assigned to vote.

# 2. Requirements ✔️

The requirements for this application are:

* Correct implementation of the object-oriented paradigm, making proper use of the different entities that exist in the
  language of the different entities that exist in the language: object, class, case, class, etc.
* The use "whenever possible" of expressions in the code.
* Typical functional programming figures, such as:
    - HOF (Higher Order Functions)
    - Option (tipos nullables)
    - Pattern matching
    - Funciones anónimas
    - Programación asíncrona
    - Comentarios en código
    - Estructura limpia y legibilidad

# 3. Folders and files 📁
 * **Infraestructura Layer**
    * **Application Layer**
    * **Domain Layer**
      *  **Aggregator**: Group of domain objects (entities and VOs) that can be treated as a single unit.
      *  **Entities**: Unique identity Mutable .
      *  **Domain Services**: Encapsulate application behaviors not belonging to any entity. Input and output of domain objects.
      *  **Value Objects**: Objects of our application.

**DDD Layers:**  

<p align="center">
 <img style="text-align:center" src="images/ddd.PNG" width="25%" height="25%" alt="DDD">
</p>


# 4. Configuration ⚙️

## Requirements:

- First, make sure you have the Java 8 JDK (or Java 11 JDK) installed. ```java -version(Make sure you have version 1.8 or 11.)```
- Need SBT to install all dependecies. https://www.scala-sbt.org/download.html
- Then, install Scala: https://www.scala-lang.org/download/


# 5. Run in local 🏠

* Go to root path URNAX where you can find the build.sbt file and run the following command on CMD:
```sbt```  


* Inside sbt write the command "run":
```sbt:Votox> run ``` 



<p align="center">
 <img style="text-align:center" src="images/sbtRun.JPG" width="100%" height="100%" alt="DDD">
</p>


Now application is running on http://localhost:9001

# 6. End-points:

# POST Vote:

 <img style="text-align:center" src="images/postmanVoteSucces.JPG" width="50%" height="50%" alt="postmanVoteSucces">
 <img style="text-align:center" src="images/postmanVoteAlready.JPG" width="50%" height="50%" alt="postmanVoteAlready">
 <img style="text-align:center" src="images/postmanVoteIdNotExist.JPG" width="50%" height="50%" alt="postmanVoteIdNotExist">




