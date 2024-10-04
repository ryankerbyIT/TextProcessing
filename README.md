# TextProcessing

**TextProcessing** is a collection of Java programs that perform various text processing tasks, ranging from string manipulations to data parsing and analysis. This project contains solutions to a variety of problems, demonstrating the use of Java for processing textual data, implementing algorithms, and reading from files. 

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [File Descriptions](#file-descriptions)
- [Technologies Used](#technologies-used)
- [How to Contribute](#how-to-contribute)
- [License](#license)

## Project Overview
This project includes solutions for different text processing tasks such as:
1. String manipulation (e.g., reversing strings, counting words)
2. Translating text into different formats (e.g., Morse code, Pig Latin)
3. Reading and processing data from files (e.g., lottery statistics, gas prices)
4. Various utility methods for handling and manipulating text in Java.

## Features
- **String Operations:** Implementations for word counting, character frequency analysis, and string conversions.
- **File Processing:** Reads and processes data from text files, performing statistical analyses.
- **Text Conversion:** Includes translators for Morse code, Pig Latin, and more.
- **Data Analysis:** Performs tasks like computing averages, finding extremes, and sorting data based on input from files.
  
## Prerequisites
- Java Development Kit (JDK) 8 or higher
- [Eclipse IDE](https://www.eclipse.org/downloads/) or any other Java IDE (optional, for editing and running the code)
- Git (for version control)
- A text editor (e.g., Visual Studio Code, Notepad++) for modifying the `README.md` and other text files.

## Usage
1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/ryankerbyIT/TextProcessing.git
    ```
2. Navigate to the project directory:
    ```bash
    cd TextProcessing
    ```
3. Compile and run the Java programs using the command line or an IDE:
    ```bash
    javac [FileName].java
    java [FileName]
    ```

## File Descriptions
Below is a brief description of the files included in this project:

- **`WordSeparator.java`**: Converts concatenated strings with uppercase word boundaries into a properly spaced sentence.
- **`PigLatinTranslator.java`**: Converts an English sentence into Pig Latin.
- **`MorseCodeConverter.java`**: Translates a string into Morse code using hyphens for dashes and periods for dots.
- **`LotteryStatistics.java`**: Reads lottery data from a file and performs statistical analysis, including finding the most common, least common, and most overdue numbers.
- **`GasPrices.java`**: Reads weekly gas price data from a file, calculates average prices per year and month, and finds the highest and lowest prices.
- **Other utility classes**: Various helper classes and methods for string operations, data conversions, and file processing.

## Technologies Used
- **Java**: The core programming language used for implementing the text processing solutions.
- **Git**: Version control for tracking changes in the project.
- **GitHub**: For hosting the project's repository.
- **Markdown**: Used for writing this `README.md`.

## How to Contribute
If you would like to contribute to this project, please follow these steps:
1. Fork the repository on GitHub.
2. Clone your fork to your local machine:
    ```bash
    git clone https://github.com/ryankerbyIT/TextProcessing.git
    ```
3. Create a new branch for your feature or bugfix:
    ```bash
    git checkout -b feature/your-feature-name
    ```
4. Make your changes and commit them with clear messages:
    ```bash
    git commit -m "Add a detailed description of your changes"
    ```
5. Push your changes to your forked repository:
    ```bash
    git push origin feature/your-feature-name
    ```
6. Open a pull request on the original repository and describe the changes you have made.

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute this project as you wish.

---

Thank you for checking out **TextProcessing**! Feel free to explore, contribute, and use the various utilities provided in this project.
