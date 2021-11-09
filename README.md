<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">NYU APS Starter</h3>
  <br/>

<img src="https://i.loli.net/2021/11/10/w3ixQo7ZrjXOe56.png" >
  <br/>

A template for problem sets of NYU Algorithmic Problem Solving class (CSCI-UA 0480).  
Auto generate unit tests based on input and expected output files.

<!-- TABLE OF CONTENTS -->

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Comparing output](#comparing-output)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgement](#acknowledgement)

<!-- GETTING STARTED -->

## Getting Started

### Prerequisites

- Java 11
- IntelliJ IDEA

Currently, this project only supports Java 11, but it should work fine on other versions above Java 1.8.  
Also, it is assumed that you are using IntelliJ as the IDE in the tutorial part.

### Installation

1. Clone / Download the repo

   ```sh
   $ git clone https://github.com/dekunma/nyu-aps-starter-java.git
   ```

2. Open the project in IntelliJ IDEA

3. Start the app (sanity check)

- enter `src/test/java/q1/Test.java`
- Click either of the green arrows on the left to run an empty test case (`1.txt`)
  ![run_tests.png](https://i.loli.net/2021/11/10/nTbw1Mm5AB8sVOK.png)
  Note: the UI might be different on your machine since I'm using an IntelliJ theme

- The empty test case (`1.txt`) should pass without any error
  ![test_success.png](https://i.loli.net/2021/11/10/UlLFpPGhkRBjt5E.png)

### Usage

**Write solution code:**

- Write your solution code in `src/main/java/q*/Main.java`
- For example, write your solution for question 1 in `src/main/java/q1/Main.java`

**Add test cases:**

- Files for test cases are stored in `src/test/resources`
- Add test cases in the corresponding sub-directory for each question
- Add input in the `cases` directory
- Add expected output in `expected` directory
- **Input and expected output file must have the same name, and in txt format**.

For example, if you want to add a test case `2` to problem `1`, and the test case has
input as:

```
3
1 2 3
```

and output as:

```
6
```

Simply add a file named `2.txt` to `src/test/resources/q1/cases` with the content of input:

```
3
1 2 3
```

And add a file named `2.txt` to `src/test/resources/q2/expected` with the content of expected output:

```
6
```

Then go back to `src/test/java/q2/Test.java` and run the test, you will be able to see the result for the test case you just added.

## Comparing output

If a test failed, click on the test case to see the difference between your output and expected output.  
![test_failed.png](https://i.loli.net/2021/11/10/QOxwg6LCVMrSsU8.png)
![diff.png](https://i.loli.net/2021/11/10/CoPxH4arv9tiz3n.png)

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

This project is licensed under the **MIT license**.

This means that you are free to use, share, and modify this project for any purpose.

<!-- CONTACT -->

## Acknowledgement

This project used java reflection mechanism to generate test cases, which is not always
considered as a good practice.
