# Market Data Finance ETL Service (Work In Progress)

[![Build Status](https://img.shields.io/travis/username/repo.svg?style=flat-square)](https://travis-ci.org/spaade/market-data-finance-etl-svc)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://opensource.org/licenses/MIT)
[![Version](https://img.shields.io/badge/version-v1.0.0-green.svg?style=flat-square)](https://github.com/spaade/market-data-finance-etl-svc/releases)
[![GitHub Issues](https://img.shields.io/github/issues/username/repo.svg?style=flat-square)](https://github.com/spaade/market-data-finance-etl-svc/issues)

## Overview

The Market Data Finance ETL Service is an ongoing Extract, Transform, Load (ETL) system and service that allows users to fetch finance quotes using data from the Yahoo Finance API. It is built on top of Spring Web Flux, a reactive web framework, and utilizes PostgreSQL as the database to store the fetched data.

## Features

- Real-time data fetching from Yahoo Finance API.
- Store and manage finance quotes in a PostgreSQL database.
- Reactive service design using Spring Web Flux for better performance.
- User-friendly API for querying and accessing financial data.

## Getting Started

Follow these instructions to get the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- PostgreSQL database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/username/repo.git](https://github.com/spaade/market-data-finance-etl-svc.git)
   cd repo
   ```

2. Create the database schema by running the SQL script located at `./src/main/resources/schema/schema.sql`.

3. Configure the database connection in the `env variables`:

   ```properties
   DB_URL=jdbc:postgresql://localhost:5432/your_database_name
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

4. Build the Maven project:

   ```bash
   mvn clean package
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the JAR file generated during the build process:

   ```bash
   java -jar target/market-data-finance-etl-svc.jar
   ```

6. The service will be available at `http://localhost:8080`.

### API Endpoints

| Endpoint                 | Description                           |
| ------------------------ | ------------------------------------- |
| `/stocks`    | Get a list of all finance quotes.     |
| `/stocks` | Post a quote. |

## Contributing

Contributions are welcome! If you find any bugs or have new feature suggestions, please open an issue or submit a pull request. Before submitting a pull request, please ensure that your changes pass all tests and follow the coding style guidelines.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Yahoo Finance API](https://finance.yahoo.com/) for providing financial data.
- [Spring Web Flux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html) for the reactive web framework.
- [PostgreSQL](https://www.postgresql.org/) for the robust and efficient database.

## Contact

For any inquiries or feedback, please contact us at gusttaa00@gmail.com.

Happy coding! 🚀✨
