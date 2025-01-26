# Console Based ATM

### Description

This is a mini project which I have built for applying the 
basic concepts which I have learned in Java. This application
consists of basic features which ATMs usually have like 
deposit, withdrawal, balance enquiry etc.

I have built this mini project using basic java & sqlite.

### Structure

This project consists of five packages which are as 
following:

1. Banking
2. Database
3. Exceptions
4. GUI
5. Utils

#### 1. Banking

This package consists of classes for users, bank accounts,
operations like withdrawals, deposits etc. and for user
authentications

#### 2. Database

 This package contains the class for database which has a 
 method for connecting to it.
 
#### 3. Exceptions

This package contains the classes which has the custom
exceptions which is thrown by the classes & methods developed
by us. (It's work in progress)

#### 4. GUI

This package contains the Menu class that contains the set
of options which would be used by end user to interact with
our application.

#### 5. Utils

This package contains the class called Logger which would
be used instead of ```e.printStackTrace();``` as it is a 
console based application. So, You cannot expose the inner
workings or the error inside the application.

### Flow

```Main.java``` >> ```Menu.java``` >> ```Operations.java```

### Future Enhancements

1. I would re-structure the code as I have made a few mistakes which I realised
after completing the code.
2. I would add a GUI as it is a console based application. Try
to turn it into a GUI based application.
3. Write custom exceptions for the customs errors which are
being thrown
4. Writing Loggers for replacing ```e.printStackTrace();```