# Travel Package Management System

This project is a simple travel package management system implemented in Java. It allows the creation and management of travel packages, destinations, activities, and passengers.

## Project Structure

The project is divided into two main directories:

- `src/main/java/org/tpm`: Contains the source code for the application.
- `src/test/java/org/tpm`: Contains the unit tests for the application.

The main classes in the application are:

- `TravelPackage`: Represents a travel package.
- `Destination`: Represents a destination in a travel package.
- `Activity`: Represents an activity at a destination.
- `Passenger`: An abstract class that represents a passenger. It has three subclasses, `StandardPassenger`, `GoldPassenger` and `PremiumPassenger`.

## Running the Application

To run the application, you need to have Java installed on your machine. Navigate to the `src/main/java/org/tpm` directory and run the `Main.java` file.

## Running the Tests

The tests are written using JUnit. To run them, navigate to the `src/test/java/org/tpm` directory and run the test classes.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
